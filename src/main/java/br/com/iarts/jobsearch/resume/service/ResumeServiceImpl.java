package br.com.iarts.jobsearch.resume.service;

import br.com.iarts.jobsearch.resume.repository.ResumeRepository;
import br.com.iarts.jobsearch.resume.repository.ResumeRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.util.Date;
import java.util.UUID;


/**
 *  Implementation of Resume Service.
 *  @author Jean
 */
@Service
public class ResumeServiceImpl implements ResumeService{

    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepositoryImpl resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) throws Exception {
        String fileName = "";
        validateFileExtension(multipartFile);
        try {
            File file = convertMultiPartToFile(multipartFile);
            fileName = generateFileName(multipartFile);
            resumeRepository.uploadFile(file,fileName);
            file.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    private void validateFileExtension(MultipartFile file) throws Exception {
        if(file.getOriginalFilename().contains(".pdf") ||
                file.getOriginalFilename().contains(".doc") ||
                file.getOriginalFilename().contains(".docx")) {

        }else {
            throw new Exception("File with invalid extension.");
        }
    }

    @Override
    public byte[] getFile(String keyName) {
        return resumeRepository.getFile(keyName);
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }

    @Override
    public void deleteFile(String keyName) {
        resumeRepository.deleteFile(keyName);
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_")
                + UUID.randomUUID().toString();
    }
}

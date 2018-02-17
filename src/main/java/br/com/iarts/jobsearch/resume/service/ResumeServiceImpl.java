package br.com.iarts.jobsearch.resume.service;

import br.com.iarts.jobsearch.resume.repository.ResumeRepository;
import br.com.iarts.jobsearch.resume.repository.ResumeRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

@Service
public class ResumeServiceImpl implements ResumeService{

    private ResumeRepository resumeRepository;

    @Autowired
    public ResumeServiceImpl(ResumeRepositoryImpl resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) {
        String fileName = "";
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

    @Override
    public byte[] getFile() {
        return new byte[0];
    }

    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }
}

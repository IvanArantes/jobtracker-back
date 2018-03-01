package br.com.iarts.jobsearch.coverletter.service;

import br.com.iarts.jobsearch.coverletter.repository.CoverLetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Implementation of Cover Letter Service.
 * @author Jean
 */
@Service
public class CoverLetterServiceImpl implements CoverLetterService {

    private CoverLetterRepository coverLetterRepository;


    @Autowired
    public CoverLetterServiceImpl(CoverLetterRepository coverLetterRepository) {
        this.coverLetterRepository = coverLetterRepository;
    }

    @Override
    public String uploadFile(MultipartFile multipartFile) throws Exception {
        String fileName = "";
        validateFileExtension(multipartFile);
        try {
            File file = convertMultiPartToFile(multipartFile);
            fileName = generateFileName(multipartFile);
            coverLetterRepository.uploadFile(file,fileName);
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
        return coverLetterRepository.getFile(keyName);
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
        coverLetterRepository.deleteFile(keyName);
    }

    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_")
                + UUID.randomUUID().toString();
    }
}

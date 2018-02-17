package br.com.iarts.jobsearch.resume.service;

import org.springframework.web.multipart.MultipartFile;

public interface ResumeService {

    String uploadFile(MultipartFile file);
    byte[] getFile();
}

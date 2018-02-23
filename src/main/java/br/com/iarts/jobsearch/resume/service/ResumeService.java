package br.com.iarts.jobsearch.resume.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface ResumeService {

    String uploadFile(MultipartFile file) throws Exception;
    byte[] getFile(String keyName) throws IOException;
}

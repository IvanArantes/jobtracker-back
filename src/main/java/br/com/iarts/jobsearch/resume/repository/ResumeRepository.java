package br.com.iarts.jobsearch.resume.repository;

import java.io.File;

public interface ResumeRepository {
    void uploadFile(File file, String fileName);
    byte[] getFile(String keyName);
}

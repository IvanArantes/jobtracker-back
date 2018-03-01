package br.com.iarts.jobsearch.resume.repository;

import java.io.File;

/**
 * Resume Repository
 * @author Jean
 */
public interface ResumeRepository {
    /**
     * Upload file on S3.
     * @param file file.
     * @param fileName name of the file.
     */
    void uploadFile(File file, String fileName);

    /**
     * Download file.
     * @param keyName key of the file.
     * @return byte with file.
     */
    byte[] getFile(String keyName);


    void deleteFile(String keyName);
}

package br.com.iarts.jobsearch.coverletter.repository;

import java.io.File;

/**
 * Cover Letter Repository.
 * @author Jean
 */
public interface CoverLetterRepository {

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
}

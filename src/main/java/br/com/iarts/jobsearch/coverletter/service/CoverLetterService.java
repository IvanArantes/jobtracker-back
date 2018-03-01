package br.com.iarts.jobsearch.coverletter.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Cover Letter Service for uploading and download of the file.
 * @author Jean
 */
public interface CoverLetterService {

    /**
     * It uploads a coverLetter file.
     * @param file multipartFile
     * @return name of file saved on S3.
     * @throws Exception possible exception
     */
    String uploadFile(MultipartFile file) throws Exception;

    /**
     * Retrieves the coverLetter saved on S3.
     * @param keyName name of the file saved on s3
     * @return byte with file.
     */
    byte[] getFile(String keyName);

    /**
     * Delete file
     * @param keyName name of the file.
     */
    void deleteFile(String keyName);
}

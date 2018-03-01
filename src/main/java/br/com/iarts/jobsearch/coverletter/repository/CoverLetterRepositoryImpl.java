package br.com.iarts.jobsearch.coverletter.repository;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;

@Repository
@Slf4j
public class CoverLetterRepositoryImpl implements CoverLetterRepository{

    private AmazonS3 s3Client;

    @Value("${cover.letter.bucket.name}")
    private String coverLetterBucketName;

    @Autowired
    public CoverLetterRepositoryImpl(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public void uploadFile(File file, String fileName) {
        try {
            s3Client.putObject(coverLetterBucketName, fileName, file);
            log.debug("Salvando arquivo cover letter no S3: "+fileName);
        } catch (AmazonServiceException e) {
            log.error("Erro ao salvar cover letter no S3: "+ e);
        }
    }

    @Override
    public byte[] getFile(String keyName) {
        byte[] fileBytes = null;
        S3Object s3Object = s3Client.getObject(new GetObjectRequest(coverLetterBucketName, keyName));
        try {
            fileBytes = IOUtils.toByteArray(s3Object.getObjectContent());
        } catch (IOException e) {
            log.error("Erro ao converter arquivo: "+e);
        }
        return fileBytes;
    }
}

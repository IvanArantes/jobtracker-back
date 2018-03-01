package br.com.iarts.jobsearch.resume.repository;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.h2.store.fs.FileChannelOutputStream;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.util.UUID;

@Slf4j
@Repository
public class ResumeRepositoryImpl implements ResumeRepository{

    private AmazonS3 s3Client;

    @Value("${resume.bucket.name}")
    private String resumeBucketName;

    @Autowired
    public ResumeRepositoryImpl(AmazonS3 s3Client) {
        this.s3Client = s3Client;
    }

    @Override
    public void uploadFile(File file, String fileName) {
        try {
            s3Client.putObject(resumeBucketName, fileName, file);
            log.debug("Salvando arquivo resume no S3: "+fileName);
        } catch (AmazonServiceException  e) {
            log.error("Erro ao salvar resume no S3: "+ e);
            throw  new ServiceException("Erro ao salvar resume no S3: " +e);
        }
    }

    @Override
    public byte[] getFile(String keyName) {
        byte[] fileBytes = null;
        S3Object s3Object = s3Client.getObject(new GetObjectRequest(resumeBucketName, keyName));
        try {
             fileBytes = IOUtils.toByteArray(s3Object.getObjectContent());
        } catch (IOException e) {
            log.error("Erro ao converter arquivo: "+e);
            throw  new ServiceException("Erro ao converter arquivo: " +e);
        }
        return fileBytes;
    }

    @Override
    public void deleteFile(String keyName) {
        try {
            s3Client.deleteObject(new DeleteObjectRequest(resumeBucketName, keyName));
        } catch (AmazonServiceException ase) {
            log.error("Erro ao deleter arquivo: "+ase);
            throw  new ServiceException("Erro ao deleter arquivo: " +ase);
        }
    }
}

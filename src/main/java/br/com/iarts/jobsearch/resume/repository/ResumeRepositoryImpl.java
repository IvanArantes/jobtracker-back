package br.com.iarts.jobsearch.resume.repository;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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
        }
    }

    @Override
    public File getFile(String keyName) {
        S3Object s3Object = s3Client.getObject(new GetObjectRequest(resumeBucketName, keyName));
        try {
            byte[] fileBytes = IOUtils.toByteArray(s3Object.getObjectContent());
           // File file = new DiskFileItem();
        } catch (IOException e) {
            log.error("Erro ao converter arquivo: "+e);
        }
        return null;
    }

}

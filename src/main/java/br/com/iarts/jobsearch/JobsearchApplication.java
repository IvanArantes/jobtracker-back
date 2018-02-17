package br.com.iarts.jobsearch;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.iarts.jobsearch.vacancy.entity.Vacancy;
import br.com.iarts.jobsearch.vacancy.repository.VacancyRepository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class JobsearchApplication {

	@Value("${aws.access.key.id}")
	private String awsAccessId;

	@Value("${aws.secret.access.key}")
	private String awsSecretKey;

	@Value("${aws.bucket.region}")
	private String awsBucketRegion;

	@Bean
	public AmazonS3 s3Client() {
		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsAccessId, awsSecretKey);
		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
							.withRegion(Regions.fromName(awsBucketRegion))
							.withCredentials( new AWSStaticCredentialsProvider(awsCreds))
							.build();
		return s3Client;
	}

	public static void main(String[] args) {
		SpringApplication.run(JobsearchApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

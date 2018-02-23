package br.com.iarts.jobsearch.resume.controller;

import br.com.iarts.jobsearch.resume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/resume")
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping("/upload")
    public String uploadResume(@RequestPart(value = "file")MultipartFile file) throws Exception {
        return "Arquivo salvo com sucesso: "+ resumeService.uploadFile(file);
    }

    @GetMapping("/{name}")
    public byte[] getResume(@PathVariable String name) throws IOException {
        return resumeService.getFile(name);
    }
}

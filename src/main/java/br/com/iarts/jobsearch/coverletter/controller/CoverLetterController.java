package br.com.iarts.jobsearch.coverletter.controller;

import br.com.iarts.jobsearch.coverletter.service.CoverLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/cover-letter")
public class CoverLetterController {

    private CoverLetterService coverLetterService;

    @Autowired
    public CoverLetterController(CoverLetterService coverLetterService) {
        this.coverLetterService = coverLetterService;
    }

    @PostMapping("/upload")
    public String uploadCoverLetter(@RequestPart(value = "file")MultipartFile file) throws Exception {
        return "Arquivo salvo com sucesso: "+ coverLetterService.uploadFile(file);
    }

    @GetMapping("/{name}")
    public byte[] getCoverLetter(@PathVariable String name) {
        return coverLetterService.getFile(name);
    }
}

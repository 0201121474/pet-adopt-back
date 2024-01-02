package com.pet.controller;

import com.pet.entity.Result;
import com.pet.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin
@RestController
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;


    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) {
        Result result = fileUploadService.uploadFile(file);
        return result;
    }

    @PostMapping("/uploads")
    public Result uploadFiles(@RequestParam("files") MultipartFile[] files) {
        Result result = fileUploadService.uploadFiles(files);
        return result;
    }

}


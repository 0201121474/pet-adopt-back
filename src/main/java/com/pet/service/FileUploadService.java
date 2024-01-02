package com.pet.service;

import com.pet.entity.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {

    public Result uploadFile(MultipartFile file);

    public Result uploadFiles(MultipartFile[] files);


}

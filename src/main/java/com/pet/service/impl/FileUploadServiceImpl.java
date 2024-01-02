package com.pet.service.impl;

import com.pet.entity.Result;
import com.pet.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.websocket.server.ServerEndpoint;
import java.io.File;
import java.io.IOException;

/**
 *@Description:
 */

@Slf4j
@Service
public class FileUploadServiceImpl implements FileUploadService {


    private String imgString;
    // 设置保存地址（这里是转义字符）
    // todo: 文件
    private String filePath = "D:\\JavaProject\\pet-adoption-project\\files\\images\\";

    @Override
    public Result uploadFile(MultipartFile file) {
        // 判断文件是否为空
        if (file.isEmpty()) {
            return new Result(false, "上传文件不能为空");
        }
        // 获取传过来的文件名字
        String OriginalFilename = file.getOriginalFilename();
        // 判断文件类型: 截取文件后缀名
        String type = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));
        if (!type.equals(".jpg") && !type.equals(".png")) {
            return new Result(false, "不是jpg或png");
        }
        // 文件URL=系统时间戳+文件后缀名
        String fileName = System.currentTimeMillis() + OriginalFilename.substring(OriginalFilename.lastIndexOf("."));
        File dest = new File(filePath + fileName);
        imgString = "http://localhost:8081/myimg/" + fileName;
        // 判断: 目录是否存在, 不存在，则创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 上传
            file.transferTo(dest);
            return new Result(true, imgString);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "上传失败");
        }
    }

    @Override
    public Result uploadFiles(MultipartFile[] files) {
        String img = "";
        File fileDir = new File(filePath);
        if (!fileDir.exists() && !fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                String OriginalFilename = files[i].getOriginalFilename();
                System.out.println("文件名为:" + OriginalFilename);
                String fileName = System.currentTimeMillis() + "." + OriginalFilename.substring(OriginalFilename.lastIndexOf(".") + 1);
                File dest = new File(filePath + fileName);
                imgString = "http://localhost:8081/myimg/" + fileName;
                try {
                    files[i].transferTo(dest);
                    if (img.equals("")) {
                        img = imgString;
                    } else {
                        img = img + ";" + imgString;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return new Result(false, e.getMessage());
                }
            }
        } else {
            return new Result(false, "文件为0");
        }
        return new Result(true, img);
    }

}

package com.pet.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtil {
    // 把图片上传到的位置
    // todo: 文件位置
    private static final String BASE_PATH="D:\\JavaProject\\pet-adoption-project\\files\\images\\";

    // 访问图片的路径
    private static final String SERVER_PATH="";

    public static String upload(MultipartFile file) throws IOException {
        // 获取文件名
        String filename = file.getOriginalFilename();
        // 用uuid进行改写，来防止文件重名
        String uuid = UUID.randomUUID().toString().replace("-","");
        // 文件名: uuid - filename
        String newFileName = uuid + "-" + filename;
        // 创建一个实例对象
        File image = new File(BASE_PATH, newFileName);
        // 上传文件: 将 file 上传到本地指定位置 image
        try {
            file.transferTo(image);
        }catch (IOException e){
            e.printStackTrace();
        }
        return SERVER_PATH + newFileName;
    }

}

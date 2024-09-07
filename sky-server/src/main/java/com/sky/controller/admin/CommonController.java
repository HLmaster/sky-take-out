package com.sky.controller.admin;

import com.sky.result.Result;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/*
* 通用接口
* */
@RestController
@RequestMapping("/admin/common")
@Slf4j
public class CommonController {

    @Autowired
    AliOssUtil aliOssUtil;

    /**
     *文件上传
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file){
        try {
        log.info("开始上传文件{}",file);
        //原始文件名
        String fileName = file.getOriginalFilename();
        //截取原始文件名后缀
        String extension = fileName.substring(fileName.lastIndexOf("."));
        //利用UUID生成唯一文件名
        String UUIDFileName = UUID.randomUUID().toString()+extension;
        //文件请求路径
        String filePath = aliOssUtil.upload(file.getBytes(), UUIDFileName);
        return Result.success(filePath);
        } catch (IOException e) {
            log.info("文件上传失败{}",e.getMessage());
        }
        return Result.error("文件上传失败");

    }
}

package com.knomeda.mysite_backend.mysite.controller;

import com.knomeda.mysite_backend.mysite.entity.Tes;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.File;


@RestController
@RequestMapping("/resume")
public class ResumeController {

    @GetMapping
    public ResponseEntity<byte[]> downloadFile() throws IOException {
        System.out.println(1234455);
        // 读取文件
        File file = new File("file/简历.pdf");
        byte[] fileContent = FileUtils.readFileToByteArray(file);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", file.getName());
        headers.setContentLength(fileContent.length);

        // 返回文件内容和响应头
        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }

    @GetMapping("/tes")
    public Tes giveTers() {
        Tes tes = new Tes();
        tes.setName("yangsl");
        tes.setAge("22");
        return tes;
    }


}

package com.demos.springapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;


@RestController
@RequestMapping("")
public class ImageController {


    @Value("${build.version}")
    private String buildVersion;
    
    @Value("${application.name}")
    private String applicationName;

    Random random = new Random();
    int max = 1;
    int min = 1;
    
    // Return the image from the classpath location using ResponseEntity
    @GetMapping(value = "image")
    public ResponseEntity<byte[]> fromClasspathAsResEntity() throws IOException {
        int randomNum = random.nextInt((max - min) + 1) + min;
        ClassPathResource imageFile = new ClassPathResource("images/offices/redhatoffice" + randomNum+ ".jpg");
        byte[] imageBytes = StreamUtils.copyToByteArray(imageFile.getInputStream());

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }

    // Return the image from the classpath location using HttpServletResponse
    @GetMapping(value = "/", produces = MediaType.IMAGE_JPEG_VALUE)
    public void officeAsHttpResponse(HttpServletResponse response) throws IOException {
        int randomNum = random.nextInt((max - min) + 1) + min;
        ClassPathResource imageFile = new ClassPathResource("images/offices/redhatoffice" + randomNum+ ".jpg");
        StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
    }

    @GetMapping(value = "/hello" , produces = MediaType.IMAGE_JPEG_VALUE)
    public void welcomeAsHttpResponse(HttpServletResponse response) throws IOException {

        ClassPathResource imageFile = new ClassPathResource("images/welcome.jpg");

        StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
    }

    @GetMapping("/version")
    public String version(){
        return "App Name is " + applicationName + " & App Version is " + buildVersion ;
    }

    @GetMapping("/id/{id}")
    public String parrot(@PathVariable String id){
        return "Your Id is : " + id;
    }
    
}
package com.demos.springapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {


    @Value("${build.version}")
    private String buildVersion;
    
    @Value("${application.name}")
    private String applicationName;

    @RequestMapping("/version")
    public String version(){
        return "App Name is " + applicationName + " & App Version is " + buildVersion ;
    }
}

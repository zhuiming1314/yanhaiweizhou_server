package com.example.user.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.user.model.PublicTemplate;
import com.example.user.service.PublicTemplateService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/template/public")
public class PublicTemplateController{
    @Autowired
    PublicTemplateService publicTemplateService;

    @RequestMapping(value="querybycate")
    List<PublicTemplate> queryByCate(String category) throws IOException{
        List<PublicTemplate> publicTemplates = publicTemplateService.queryByCate(category);
        return publicTemplates;
    }
}
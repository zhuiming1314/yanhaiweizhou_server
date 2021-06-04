package com.example.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.IOException;
import java.util.List;

import com.example.user.model.DetailTemplate;
import com.example.user.service.DetailTemplateService;

@RestController
@RequestMapping("/api/template/detail")
public class DetailTemplateController{
    @Autowired
    DetailTemplateService detailTemplateService;

    @RequestMapping(value="/querybycateandindex")
    DetailTemplate queryByCateAndIndex(String category, int tindex){
        return detailTemplateService.queryByCateAndIndex(category, tindex);
    }
    @RequestMapping(value="/add")
    int add(String category, String tpid, int tindex, String objs, String element){
        DetailTemplate detailTemplate = new DetailTemplate();
        detailTemplate.setPid("1"); //测试暂设为1
        detailTemplate.setCategory(category);
        detailTemplate.setTpid(tpid);
        detailTemplate.setTindex(tindex);
        detailTemplate.setObjs(objs);
        detailTemplate.setElement(element);
        detailTemplate.setMd5("md5test");
        return detailTemplateService.add(detailTemplate);
    }

}
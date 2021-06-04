package com.example.user.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.user.service.UsedMaterialService;
import com.example.user.model.UsedMaterial;
@RestController
@RequestMapping("/api/material/used")
public class UsedMaterialController{
    @Autowired
    UsedMaterialService usedMaterialService;

    @RequestMapping(value="/querybyuid")
    List<UsedMaterial> queryByUid(String uname){
        return usedMaterialService.queryByUid(uname);
    }

    @RequestMapping(value="/add")
    int add(String uname, String materials){
        return usedMaterialService.add(uname, materials);
    }
}
package com.example.user.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import net.coobird.thumbnailator.Thumbnails;

import javax.imageio.ImageIO;

import com.example.user.mapper.DetailTemplateMapper;
import com.example.user.model.DetailTemplate;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class DetailTemplateService{
    @Autowired
    DetailTemplateMapper detailTemplateMapper;

    public DetailTemplate queryByCateAndIndex(String category, int tindex){
        return detailTemplateMapper.queryByCateAndIndex(category, tindex);

    }
    public int add(DetailTemplate detailTemplate){
        return detailTemplateMapper.add(detailTemplate);
    }
}
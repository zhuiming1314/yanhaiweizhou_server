package com.example.user.service;

import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.user.model.PublicTemplate;
import com.example.user.mapper.PublicTemplateMapper;
import org.springframework.stereotype.Service;
@Service
public class PublicTemplateService{
    @Autowired
    PublicTemplateMapper publicTemplateMapper;

    public List<PublicTemplate> queryByCate(String category) throws IOException {
        List<PublicTemplate> publicTemplates = publicTemplateMapper.queryByCate(category);
        PublicTemplate publicTemplate;
        List<PublicTemplate> resPublicTemplates = new ArrayList<>();
        for(int i=0; i<publicTemplates.size(); i++){
            PublicTemplate resPublicTemplate = new PublicTemplate();
            publicTemplate = publicTemplates.get(i);
            String pid = publicTemplate.getPid();
            resPublicTemplate.setPid(pid);
            resPublicTemplate.setTemplate_url(publicTemplate.getTemplate_url());
            resPublicTemplate.setCount(publicTemplate.getCount());
            resPublicTemplates.add(resPublicTemplate);

        }
        return resPublicTemplates;
    }
}
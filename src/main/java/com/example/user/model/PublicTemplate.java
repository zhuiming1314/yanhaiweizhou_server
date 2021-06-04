package com.example.user.model;

import lombok.Data;

@Data
public class PublicTemplate {
    private String template_url;
    private String pid;
    private String category;
    private int count;
    private String md5;

    public String getTemplate_url(){
        return template_url;
    }
    public void setTemplate_url(String template_url){
        this.template_url = template_url;
    }
    public String getPid(){
        return pid;
    }
    public void setPid(String pid){
        this.pid = pid;
    }
    public String getCategory(){
        return category;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }
    public String getMd5(){
        return md5;
    }
    public void setMd5(String md5){
        this.md5 = md5;
    }
}
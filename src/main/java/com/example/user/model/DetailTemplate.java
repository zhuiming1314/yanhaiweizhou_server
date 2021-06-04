package com.example.user.model;

import lombok.Data;

@Data
public class DetailTemplate{
    private String pid;
    private String category;
    private String tpid;
    private int tindex;
    private String objs;
    private String element;
    private String md5;

    public void setPid(String pid){
        this.pid  = pid;
    }
    public String getPid(){
        return pid;

    }
    public void setCategory(String category){
        this.category  = category;
    }
    public String getCategory(){
        return category;
        
    }
    public void setTpid(String tpid){
        this.tpid  = tpid;
    }
    public String getTpid(){
        return tpid;
        
    }
    public void setTindex(int tindex){
        this.tindex  = tindex;
    }
    public int getTindex(){
        return tindex;
        
    }
    public void setObjs(String objs){
        this.objs  = objs;
    }
    public String getObjs(){
        return objs;
        
    }
    public void setElement(String element){
        this.element  = element;
    }
    public String getElement(){
        return element;
        
    }
    public void setMd5(String md5){
        this.md5  = md5;
    }
    public String getMd5(){
        return md5;
        
    }
    

}
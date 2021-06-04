package com.example.user.model;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class UsedMaterial{
    private int id;
    private String uname;
    private String materials;
    private Timestamp time;

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setUname(String uname){
        this.uname = uname;
    }
    public String getUname(){
        return uname;
    }
    public void setMaterials(String materials){
        this.materials = materials;
    }
    public String getMaterials(){
        return materials;
    }
    public void setTime(Timestamp time){
        this.time = time;
    }
    public Timestamp getTime(){
        return time;
    }

}


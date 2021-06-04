package com.example.user.model;

import lombok.Data;

@Data
public class ResUserInfo extends Login {

    private int rescode;

    public void setRescode(int rescode){
        this.rescode = rescode;
    }
    
}
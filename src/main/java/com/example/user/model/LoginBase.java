package com.example.user.model;

import lombok.Data;

@Data
public class LoginBase {
    private String id;
    private String username;

    public void setId(String id){
        this.id = id;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getId() {
        return id;
    }
    public String getUsername(){
        return username;
    }
}
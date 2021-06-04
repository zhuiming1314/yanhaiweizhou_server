package com.example.user.service;

import com.example.user.model.Login;
import com.example.user.model.LoginBase;
import com.example.user.model.ResUserInfo;
import com.example.user.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    @Autowired
    LoginMapper loginMapper;

    public LoginBase queryById(String id){
        return loginMapper.queryById(id);
    }

    public List<LoginBase> queryAll() {
        return loginMapper.queryAll();
    }

    public LoginBase queryByUsername(String username, String password){
        return loginMapper.queryByUsername(username, password);
    }

    /*public LoginBase queryByTelephone(String telephone, String password) {
        return loginMapper.queryByTelephone(telephone, password);
    }*/
    public LoginBase queryByTelephone(String telephone, String vertificationcode) {
        return loginMapper.queryByTelephone(telephone);
    }

    

    public LoginBase add(Login login) {

        int count = loginMapper.add(login);
        ResUserInfo resUserInfo = new ResUserInfo();
        resUserInfo.setRescode(count);
        
        resUserInfo.setUsername(login.getUsername());

        resUserInfo.setTelephone(login.getTelephone());

        return resUserInfo;
        
    }

    public LoginBase updateById(Login login) {
        String id = login.getId();
        loginMapper.updateById(login);
        return loginMapper.queryById(id);
    }

    public int updateByTelephone(Login login) {
        return loginMapper.updateByTelephone(login);
    }

    public int delById(String id) {
        return loginMapper.delById(id);
    }

    public int delByTelephone(String telephone) {
        return loginMapper.delByTelephone(telephone);
    }

}

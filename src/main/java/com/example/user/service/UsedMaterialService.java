package com.example.user.service;

import java.sql.Timestamp;

import com.example.user.model.UsedMaterial;
import com.example.user.mapper.UsedMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UsedMaterialService{
    @Autowired
    UsedMaterialMapper usedMaterialMapper;

    //获得该用户最近使用的元素
    public List<UsedMaterial> queryByUid(String uname){
        return usedMaterialMapper.queryByUid(uname);
    }

    //插入最新最近使用的元素
    public int add(String uname, String materials){
        Timestamp time = new Timestamp(System.currentTimeMillis());
        if(usedMaterialMapper.queryByMidAndUid(uname, materials)!=null){
            return usedMaterialMapper.update(time, uname, materials);
        }else{
            //用户最近使用保存50个元素
            List<UsedMaterial> usedMaterials = usedMaterialMapper.queryByUid(uname);
            int len = usedMaterials.size();
            if(len<=50){
                UsedMaterial usedMaterial = new UsedMaterial();
                usedMaterial.setUname(uname);
                usedMaterial.setMaterials(materials);
                usedMaterial.setTime(time);
                return usedMaterialMapper.add(usedMaterial);
            }else{
                //超过50个，将列表中的最后一个元素
                return usedMaterialMapper.replace(time, materials, uname, usedMaterials.get(len-1).getId());
            }
            
        }

    }
}
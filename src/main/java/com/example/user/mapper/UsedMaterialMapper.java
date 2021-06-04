package com.example.user.mapper;

import com.example.user.model.UsedMaterial;
import org.apache.ibatis.annotations.*;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface UsedMaterialMapper{
    @Select("SELECT * FROM user_lib WHERE uname= #{uname} and materials= #{materials}")
    UsedMaterial queryByMidAndUid(@Param("uname") String uname, @Param("materials") String materials);

    @Select("SELECT id, materials FROM user_lib WHERE uname=#{uname} ORDER BY time DESC")
    List<UsedMaterial> queryByUid(@Param("uname") String uname);

    @Insert("INSERT INTO user_lib(uname, materials, time) VALUES (#{uname}, #{materials}, #{time})")
    int add(UsedMaterial usedMaterial);

    @Update("UPDATE user_lib SET time=#{time} WHERE uname=#{uname} AND materials=#{materials}")
    int update(@Param("time") Timestamp time, @Param("uname") String uname, @Param("materials") String materials);

    @Update("UPDATE user_lib SET time=#{time}, materials=#{materials} WHERE uname=#{uname} AND id=#{id}")
    int replace(@Param("time") Timestamp time, @Param("materials") String materials, @Param("uname") String uname, @Param("id") int id);
}
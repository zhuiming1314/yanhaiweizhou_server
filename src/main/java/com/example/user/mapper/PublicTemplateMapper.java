package com.example.user.mapper;
import com.example.user.model.PublicTemplate;
import java.util.List;

import org.apache.ibatis.annotations.*;
@Mapper
public interface PublicTemplateMapper{
    @Select("SELECT * FROM public_template WHERE category = #{category}")
    List<PublicTemplate> queryByCate(@Param("category") String category);
    
}
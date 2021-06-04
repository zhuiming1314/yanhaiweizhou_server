package com.example.user.mapper;

import com.example.user.model.DetailTemplate;
import org.apache.ibatis.annotations.*;

@Mapper
public interface DetailTemplateMapper{
    @Select("SELECT * FROM detail_template WHERE category= #{category} AND tindex=#{tindex}")
    DetailTemplate queryByCateAndIndex(@Param("category") String category, @Param("tindex") int tindex);

    @Insert({"INSERT INTO detail_template(pid, category, tpid, tindex, objs, element, md5)" +
        "VALUES (#{pid},#{category},#{tpid},#{tindex},#{objs},#{element},#{md5})"})
    int add(DetailTemplate detailTemplate);

}
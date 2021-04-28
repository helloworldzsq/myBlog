package com.dz.dao;

import com.dz.pojo.Article;
import com.dz.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TypeMapper {
    //添加文章
    int addType(Type type);
    //删除文章
    int deleteType(Integer id);
    //更新文章
    int updataType(Type type);
    //根据tid修改number
    int updateNum(int tid,int number);
    //根据id获取文章
    Type getTypeByid(Integer id);
    //获取全部文章
    List<Type> allTypes();
}

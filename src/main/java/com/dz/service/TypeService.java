package com.dz.service;

import com.dz.pojo.Type;

import java.util.List;

public interface TypeService {
    //添加文章
    int addType(Type type);
    //删除文章
    int deleteType(Integer id);
    //更新文章
    int updataType(Type type);
    //根据tid修改number
    int updateNum(int tid,int number);
    //获取全部文章
    List<Type> allTypes();
    Type getTypeByid(Integer id);
}

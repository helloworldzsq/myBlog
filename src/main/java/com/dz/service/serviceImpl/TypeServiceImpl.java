package com.dz.service.serviceImpl;

import com.dz.dao.TypeMapper;
import com.dz.pojo.Type;
import com.dz.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public int addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public int deleteType(Integer id) {
        return typeMapper.deleteType(id);
    }

    @Override
    public int updataType(Type type) {
        return typeMapper.updataType(type);
    }

    @Override
    public int updateNum(int tid, int number) {
        return typeMapper.updateNum(tid,number);
    }

    @Override
    public List<Type> allTypes() {
        return typeMapper.allTypes();
    }

    @Override
    public Type getTypeByid(Integer id) {
        return typeMapper.getTypeByid(id);
    }
}

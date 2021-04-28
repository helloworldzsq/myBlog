package com.dz.dao;

import com.dz.pojo.Flink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FlinkMapper {
    public int addFlink(Flink flink);

    public int deleteFlink(String name);

    public List<Flink> queryAllFlinks();

    //获取文章数量
    Long getFlinkCount();
}

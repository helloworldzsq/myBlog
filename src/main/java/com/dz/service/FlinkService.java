package com.dz.service;

import com.dz.pojo.Flink;

import java.util.List;

public interface FlinkService {
    public int addFlink(Flink flink);

    public int deleteFlink(String name);

    public List<Flink> queryAllFlinks();

    Long getFlinkCount();
}

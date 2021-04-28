package com.dz.service.serviceImpl;

import com.dz.dao.FlinkMapper;
import com.dz.pojo.Flink;
import com.dz.service.FlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlinkServiceImpl implements FlinkService {
    @Autowired
    private FlinkMapper flinkMapper;
    @Override
    public int addFlink(Flink flink) {
        return flinkMapper.addFlink(flink);
    }

    @Override
    public int deleteFlink(String name) {
        return flinkMapper.deleteFlink(name);
    }

    @Override
    public List<Flink> queryAllFlinks() {
        return flinkMapper.queryAllFlinks();
    }

    @Override
    public Long getFlinkCount() {
        return flinkMapper.getFlinkCount();
    }
}

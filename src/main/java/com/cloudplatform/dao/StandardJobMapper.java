package com.cloudplatform.dao;

import com.cloudplatform.pojo.StandardJob;
import java.util.List;

public interface StandardJobMapper {
    int deleteByPrimaryKey(String id);

    int insert(StandardJob record);

    StandardJob selectByPrimaryKey(String id);

    List<StandardJob> selectAll();

    int updateByPrimaryKey(StandardJob record);
}
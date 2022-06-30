package com.cloudplatform.dao;

import com.cloudplatform.pojo.IDE;
import java.util.List;

public interface IDEMapper {
    int deleteByPrimaryKey(String id);

    int insert(IDE record);

    IDE selectByPrimaryKey(String id);

    List<IDE> selectAll();

    int updateByPrimaryKey(IDE record);
}
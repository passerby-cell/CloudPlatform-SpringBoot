package com.cloudplatform.dao;

import com.cloudplatform.pojo.MyFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(MyFile record);

    MyFile selectByPrimaryKey(String id);

    List<MyFile> selectAll();

    int updateByPrimaryKey(MyFile record);

    List<MyFile> selectUserFile(@Param("userid") String userid,@Param("parentdirid") String parentdirid);

    MyFile selectDir(@Param("parentdirid") String parentdirid,@Param("dir") String dir,@Param("userid") String userid);
}
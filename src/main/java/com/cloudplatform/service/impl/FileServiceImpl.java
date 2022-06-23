package com.cloudplatform.service.impl;

import com.cloudplatform.dao.MyFileMapper;
import com.cloudplatform.pojo.MyFile;
import com.cloudplatform.service.file.FileService;
import com.cloudplatform.utils.IdWorker;
import com.cloudplatform.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/23/2:31 下午
 * @Description:
 */
@Service
public class FileServiceImpl implements FileService {
    @Value("${file}")
    private String filePath;
    @Resource
    private MyFileMapper fileMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 新建目录
     * @param userid
     * @param dirname
     * @param dirpath
     * @param parentdirid
     * @return
     */
    @Override
    public boolean mkDir(String userid, String dirname, String dirpath, String parentdirid) {
        if (null == dirname) {
            return false;
        } else {
            String path = filePath + userid + "/" + dirname;
            File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                    MyFile myFile = new MyFile();
                    myFile.setId(String.valueOf(idWorker.nextId()));
                    myFile.setCatalogueid(parentdirid);
                    myFile.setName(dirname);
                    myFile.setSize(0.0);
                    myFile.setIsfile("0");
                    myFile.setUploaddate(TimeUtil.getPartTime());
                    myFile.setUserid(userid);
                    fileMapper.insert(myFile);
                    return true;
                } else {
                    return false;
                }
            }
    }
}

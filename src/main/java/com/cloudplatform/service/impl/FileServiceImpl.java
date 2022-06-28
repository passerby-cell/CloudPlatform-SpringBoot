package com.cloudplatform.service.impl;

import com.cloudplatform.dao.MyFileMapper;
import com.cloudplatform.pojo.MyFile;
import com.cloudplatform.service.file.FileService;
import com.cloudplatform.utils.FileUtil;
import com.cloudplatform.utils.IdWorker;
import com.cloudplatform.utils.PageResult;
import com.cloudplatform.utils.TimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;

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
     *
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
            String path = filePath + dirpath + "/" + dirname;
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
                myFile.setIsshow("0");
                fileMapper.insert(myFile);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public PageResult<MyFile> getFileList(String userid, String parentdirid, int pagenum, int pagesize) {
        PageHelper.startPage(pagenum, pagesize);
        List<MyFile> fileList = fileMapper.selectUserFile(userid, parentdirid);
        PageInfo<MyFile> pageInfo = new PageInfo<>(fileList);
        return new PageResult<>(pageInfo.getTotal(), pagenum, pagesize, fileList);

    }

    @Override
    public synchronized boolean uploadFile(String userid, String dirpath, String parentdirid, MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return false;
            }
            String fileName = file.getOriginalFilename();
            String path = filePath + dirpath + "/" + fileName;
            File dest = new File(path);//dist为文件，有多级目录的文件   new File(path).getAbsolutePath()
            //计算文件大小
            double fileSizeMB = Math.floor(FileUtil.checkFileSize(file.getSize(), "M"));
            if (!dest.getParentFile().exists()) {//这里使用.getParentFile()，目的就是取文件前面目录的路径
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);// 文件写入
            if (fileName.indexOf("/") == -1) {
                MyFile myFile = new MyFile();
                myFile.setId(String.valueOf(idWorker.nextId()));
                myFile.setCatalogueid(parentdirid);
                myFile.setName(fileName);
                myFile.setSize(fileSizeMB);
                myFile.setIsfile("1");
                myFile.setUploaddate(TimeUtil.getPartTime());
                myFile.setUserid(userid);
                myFile.setIsshow("0");
                fileMapper.insert(myFile);
                return true;
            } else {
                String dir = fileName.substring(0, fileName.indexOf("/"));
                String filename = fileName.substring(fileName.indexOf("/")+1);
                MyFile dirList = fileMapper.selectDir(parentdirid, dir,userid);
                if (dirList == null) {
                    String id=String.valueOf(idWorker.nextId());
                    MyFile myFile = new MyFile();
                    myFile.setId(id);
                    myFile.setCatalogueid(parentdirid);
                    myFile.setName(dir);
                    myFile.setSize(0.0);
                    myFile.setIsfile("0");
                    myFile.setUploaddate(TimeUtil.getPartTime());
                    myFile.setUserid(userid);
                    myFile.setIsshow("0");
                    fileMapper.insert(myFile);
                    myFile.setId(String.valueOf(idWorker.nextId()));
                    myFile.setCatalogueid(id);
                    myFile.setName(filename);
                    myFile.setSize(fileSizeMB);
                    myFile.setIsfile("1");
                    myFile.setUploaddate(TimeUtil.getPartTime());
                    myFile.setUserid(userid);
                    myFile.setIsshow("0");
                    fileMapper.insert(myFile);
                    return true;
                } else {
                    MyFile myFile = new MyFile();
                    myFile.setId(String.valueOf(idWorker.nextId()));
                    myFile.setCatalogueid(dirList.getId());
                    myFile.setName(filename);
                    myFile.setSize(fileSizeMB);
                    myFile.setIsfile("1");
                    myFile.setUploaddate(TimeUtil.getPartTime());
                    myFile.setUserid(userid);
                    myFile.setIsshow("0");
                    fileMapper.insert(myFile);
                    return true;
                }
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateName(String userid, String newname,String oldname,  String id, String dirpath) {
        String oldpath = filePath + dirpath + "/"+oldname;
        String newpath = filePath + dirpath + "/"+newname;
        File oldFile = new File(oldpath);
        File newFile = new File(newpath);
        boolean flag = oldFile.renameTo(newFile);
        if (flag){
            fileMapper.updateFileName(id,newname);
        }
        return flag;
    }

}

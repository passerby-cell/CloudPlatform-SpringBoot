package com.cloudplatform.service.file;

import com.cloudplatform.pojo.MyFile;
import com.cloudplatform.utils.PageResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/23/2:31 下午
 * @Description:
 */
public interface FileService {
    boolean mkDir(String userid, String dirname, String dirpath, String parentdirid);

    PageResult<MyFile> getFileList(String userid, String parentdirid, int pagenum, int pagesize);

    boolean uploadFile(String userid, String dirpath, String parentdirid, MultipartFile file);

    boolean updateName(String userid, String newname, String oldname, String id, String dirpath);

    boolean downLoadFile(String name, String dirpath, HttpServletResponse response, HttpServletRequest request);

    boolean downLoadFiles(String[] name, String dirpath, HttpServletResponse response,HttpServletRequest request) throws FileNotFoundException;
}

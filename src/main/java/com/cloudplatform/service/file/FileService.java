package com.cloudplatform.service.file;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/23/2:31 下午
 * @Description:
 */
public interface FileService {
    boolean mkDir(String userid, String dirname, String dirpath, String parentdirid);
}

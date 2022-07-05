package com.cloudplatform.service.ide;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/30/12:28 下午
 * @Description:
 */
public interface IDEService {
    String startIDE(String userid);

    void stopIDE(String userid);
}

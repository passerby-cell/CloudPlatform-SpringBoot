package com.cloudplatform.service.impl;

import com.cloudplatform.dao.IDEMapper;
import com.cloudplatform.pojo.IDE;
import com.cloudplatform.service.ide.IDEService;
import com.cloudplatform.utils.DockerUtil;
import com.cloudplatform.utils.IdWorker;
import com.cloudplatform.utils.PortUtil;
import com.github.dockerjava.api.model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/30/12:28 下午
 * @Description:
 */
@Service
public class IDEServiceImpl implements IDEService {
    @Value("${docker.startport}")
    private int port;
    @Value("${IDE.path}")
    private String path;
    @Value("${IDE.ip}")
    private String ip;
    @Resource
    private IDEMapper ideMapper;
    @Autowired
    private IdWorker idWorker;

    /**
     * 开启ide
     *
     * @param userid
     */
    @Override
    public String startIDE(String userid) {
        int start = port;
        List<Container> namedContainerList = DockerUtil.getExitedNamedContainerList(userid);
        if (!namedContainerList.isEmpty()) {
            DockerUtil.getDockerConnect().startContainerCmd(namedContainerList.get(0).getId()).exec();
            return "http://" + ip + ":" + ideMapper.selectByUserid(userid).getPort() + path;
        } else {
            do {
                start = PortUtil.getFreePort(start+1);
            } while (ideMapper.selectByPort(start) != null);
            DockerUtil.createContainer("ide:latest", userid, start, userid);
            IDE ide = new IDE();
            ide.setId(String.valueOf(idWorker.nextId()));
            ide.setPort(start);
            ide.setUserid(userid);
            ideMapper.insert(ide);
            return "http://" + ip + ":" + start + path;
        }

    }

    /**
     * 关闭ide
     *
     * @param userid
     */
    @Override
    public void stopIDE(String userid) {
        List<Container> namedContainerList = DockerUtil.getNamedContainerList(userid);
        if (!namedContainerList.isEmpty()) {
            DockerUtil.getDockerConnect().stopContainerCmd(namedContainerList.get(0).getId()).exec();
        }
    }
}

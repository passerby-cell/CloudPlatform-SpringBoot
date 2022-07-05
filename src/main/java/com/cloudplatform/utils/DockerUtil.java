package com.cloudplatform.utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.async.ResultCallback;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.command.ExecCreateCmdResponse;
import com.github.dockerjava.api.command.ListContainersCmd;
import com.github.dockerjava.api.model.*;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/30/9:51 上午
 * @Description:
 */

public class DockerUtil {
    /**
     * 获取Docker连接
     *
     * @return DockerClient
     */
    public static DockerClient getDockerConnect() {
        // 连接docker服务器
        return DockerClientBuilder
                .getInstance("tcp://localhost:2375").build();
    }

    /**
     * 进入容器执行命令
     *
     * @param container
     * @param cmd
     */
    public static void ContainerCmd(Container container, String cmd) {
        DockerClient dockerClient = getDockerConnect();
        // 创建命令
        ExecCreateCmdResponse execCreateCmdResponse = dockerClient.execCreateCmd(container.getId())
                .withAttachStdout(true)
                .withAttachStderr(true)
                .withCmd("bash", "-c", cmd)
                .exec();
        // 执行命令
        dockerClient.execStartCmd(execCreateCmdResponse.getId()).exec(
                new ExecStartResultCallback(System.out, System.err));
    }

    /**
     * 获取docker上的所有镜像
     *
     * @return
     */
    public static List<Image> getImageList() {
        DockerClient dockerClient = getDockerConnect();
        List<Image> imageList = dockerClient.listImagesCmd().exec();
        return imageList;
    }

    /**
     * 删除指定镜像
     *
     * @param Image
     */
    public static void removeImage(String Image) {
        DockerClient dockerClient = getDockerConnect();
        dockerClient.removeImageCmd(Image).exec();
    }

    /**
     * 搜索镜像
     *
     * @param Image
     * @return
     */
    public static List<SearchItem> searchImageList(String Image) {
        DockerClient dockerClient = getDockerConnect();
        // 搜索镜像
        return dockerClient.searchImagesCmd(Image).exec();
    }

    /**
     * 获取docker内所有运行的容器
     *
     * @return
     */
    public static List<Container> getContainerList() {
        DockerClient dockerClient = getDockerConnect();
        return dockerClient.listContainersCmd().exec();
    }

    /**
     * 获取所有运行结束的容器
     *
     * @return
     */
    public static List<Container> getExitedContainerList() {
        DockerClient dockerClient = getDockerConnect();
        return dockerClient.listContainersCmd().withStatusFilter("exited").exec();
    }
    /**
     * 获取所有运行结束的容器
     *
     * @return
     */
    public static List<Container> getExitedNamedContainerList(String name) {
        DockerClient dockerClient = getDockerConnect();
        ListContainersCmd listContainersCmd = dockerClient.listContainersCmd();
        listContainersCmd.withStatusFilter("exited").getFilters().put("name", Arrays.asList(name));
        return listContainersCmd.exec();
    }
    /**
     * 获取指定名字的容器
     *
     * @param name
     * @return
     */
    public static List<Container> getNamedContainerList(String name) {
        //获取指定名字的容器
        ListContainersCmd listContainersCmd = getDockerConnect().listContainersCmd();
        listContainersCmd.getFilters().put("name", Arrays.asList(name));
        return listContainersCmd.exec();
    }

    /**
     * 下载镜像
     *
     * @param Image
     * @return
     */
    public static boolean pullImage(String Image) {
        DockerClient dockerClient = getDockerConnect();
        if ("".equals(Image)) {
            return false;
        }
        dockerClient.pullImageCmd(Image).exec(new ResultCallback<PullResponseItem>() {
            public void onStart(Closeable closeable) {
                System.out.println("开始下载!");
            }

            public void onNext(PullResponseItem object) {
                // 实时显示出下载信息
                System.out.println(object.getStatus());
            }

            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            public void onComplete() {
                System.out.println("下载完毕!");
            }

            public void close() throws IOException {

            }
        });
        return true;
    }

    public static void stopContainer(Container container) {
        // 停止容器
        getDockerConnect().stopContainerCmd(container.getId()).exec();
    }

    public static void restartContainer(Container container) {
        // 重启容器
        getDockerConnect().restartContainerCmd(container.getId()).exec();
    }

    public static void pauseContainer(Container container) {
        // 暂停容器
        getDockerConnect().pauseContainerCmd(container.getId()).exec();
    }

    public static void unpauseContainer(Container container) {
        // 恢复容器
        getDockerConnect().unpauseContainerCmd(container.getId()).exec();
    }

    public static void removeContainer(Container container) {
        // 删除容器
        getDockerConnect().removeContainerCmd(container.getId()).exec();
    }

    /**
     * 创建容器
     * @param Image
     * @param containerName
     * @param port
     * @param userid
     */
    public static void createContainer(String Image,String containerName,int port,String userid){
        //创建容器
        CreateContainerResponse container = getDockerConnect().createContainerCmd(Image)
                .withName(containerName) //给容器命名
                .withPortBindings(PortBinding.parse(port +":"+"8080")) //映射到容器内部的的8080端口
                .withBinds(Bind.parse("/Users/linhaiyang/Downloads/Misc/"+userid+"/"+":/home/coder/workspace/")) //目录挂载
                .exec();

        //运行容器
        getDockerConnect().startContainerCmd(container.getId()).exec();
    }
}

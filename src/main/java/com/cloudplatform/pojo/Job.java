package com.cloudplatform.pojo;

import java.util.Date;

public class Job {
    private String id;

    private String jobname;

    private Date starttime;

    private Date stoptime;

    private Integer workcount;

    private Integer workdonecount;

    private Integer workinlinecount;

    private String cpucount;

    private String memcount;

    private String status;

    private String userid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getStoptime() {
        return stoptime;
    }

    public void setStoptime(Date stoptime) {
        this.stoptime = stoptime;
    }

    public Integer getWorkcount() {
        return workcount;
    }

    public void setWorkcount(Integer workcount) {
        this.workcount = workcount;
    }

    public Integer getWorkdonecount() {
        return workdonecount;
    }

    public void setWorkdonecount(Integer workdonecount) {
        this.workdonecount = workdonecount;
    }

    public Integer getWorkinlinecount() {
        return workinlinecount;
    }

    public void setWorkinlinecount(Integer workinlinecount) {
        this.workinlinecount = workinlinecount;
    }

    public String getCpucount() {
        return cpucount;
    }

    public void setCpucount(String cpucount) {
        this.cpucount = cpucount == null ? null : cpucount.trim();
    }

    public String getMemcount() {
        return memcount;
    }

    public void setMemcount(String memcount) {
        this.memcount = memcount == null ? null : memcount.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }
}
package com.cloudplatform.pojo;

import lombok.Data;

@Data
public class Job {
    private String id;

    private String jobname;

    private String starttime;

    private String stoptime;

    private Integer workcount;

    private Integer workdonecount;

    private Integer workinlinecount;

    private String cpucount;

    private String memcount;

    private String status;

    private String userid;

   }
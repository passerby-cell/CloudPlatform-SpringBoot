package com.cloudplatform.pojo;

import lombok.Data;

import java.util.Date;
@Data
public class StandardJob {
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

   }
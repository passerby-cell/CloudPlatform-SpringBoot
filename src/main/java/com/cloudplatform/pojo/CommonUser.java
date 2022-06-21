package com.cloudplatform.pojo;

import lombok.Data;

@Data
public class CommonUser {
    private String id;

    private String username;

    private String password;

    private String isactive;//0表示未激活,1表示已激活

}
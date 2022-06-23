package com.cloudplatform.pojo;

public class MyFile {
    private String id;

    private String name;

    private String uploaddate;

    private Double size;

    private String userid;

    private String catalogueid;

    private String isfile;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUploaddate() {
        return uploaddate;
    }

    public void setUploaddate(String uploaddate) {
        this.uploaddate = uploaddate == null ? null : uploaddate.trim();
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getCatalogueid() {
        return catalogueid;
    }

    public void setCatalogueid(String catalogueid) {
        this.catalogueid = catalogueid == null ? null : catalogueid.trim();
    }

    public String getIsfile() {
        return isfile;
    }

    public void setIsfile(String isfile) {
        this.isfile = isfile == null ? null : isfile.trim();
    }
}
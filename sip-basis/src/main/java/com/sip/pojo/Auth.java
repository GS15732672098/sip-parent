package com.sip.pojo;

import java.io.Serializable;

/**
 * 权限pojo
 */
public class Auth implements Serializable {

    private Integer authid;
    private String authname;
    private Integer authpid;
    private String authdesc;
    private String authlevel;
    private String flag;
    private String createdate;
    private String createuser;
    private String updatedate;
    private String updateuser;

    public Integer getAuthid() {
        return authid;
    }

    public void setAuthid(Integer authid) {
        this.authid = authid;
    }

    public String getAuthname() {
        return authname;
    }

    public void setAuthname(String authname) {
        this.authname = authname;
    }

    public Integer getAuthpid() {
        return authpid;
    }

    public void setAuthpid(Integer authpid) {
        this.authpid = authpid;
    }

    public String getAuthdesc() {
        return authdesc;
    }

    public void setAuthdesc(String authdesc) {
        this.authdesc = authdesc;
    }

    public String getAuthlevel() {
        return authlevel;
    }

    public void setAuthlevel(String authlevel) {
        this.authlevel = authlevel;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }
}

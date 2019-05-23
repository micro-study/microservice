package com.hz.pojo;

import java.io.Serializable;

public class WechatInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 主键id
     */
    private Integer id;

    /**
     * VARCHAR(255)<br>
     * 
     */
    private String name;

    /**
     * VARCHAR(255)<br>
     * 
     */
    private String appid;

    /**
     * VARCHAR(255)<br>
     * 
     */
    private String secret;

    /**
     * VARCHAR(255)<br>
     * 
     */
    private String sessionKey;

    /**
     * VARCHAR(255)<br>
     * 
     */
    private String openid;

    /**
     * VARCHAR(255)<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(255)<br>
     * 备注
     */
    private String remark;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String createTime;

    /**
     * VARCHAR(32) 必填<br>
     * 
     */
    private String updateTime;

    /**
     * INTEGER(10) 必填<br>
     * 获得 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * INTEGER(10) 必填<br>
     * 设置 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * VARCHAR(255)<br>
     * 获得 
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 
     */
    public String getAppid() {
        return appid;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setAppid(String appid) {
        this.appid = appid == null ? null : appid.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 
     */
    public String getSecret() {
        return secret;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 
     */
    public String getSessionKey() {
        return sessionKey;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * VARCHAR(32) 必填<br>
     * 获得 
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * VARCHAR(32) 必填<br>
     * 设置 
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", appid=").append(appid);
        sb.append(", secret=").append(secret);
        sb.append(", sessionKey=").append(sessionKey);
        sb.append(", openid=").append(openid);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        WechatInfo other = (WechatInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAppid() == null ? other.getAppid() == null : this.getAppid().equals(other.getAppid()))
            && (this.getSecret() == null ? other.getSecret() == null : this.getSecret().equals(other.getSecret()))
            && (this.getSessionKey() == null ? other.getSessionKey() == null : this.getSessionKey().equals(other.getSessionKey()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAppid() == null) ? 0 : getAppid().hashCode());
        result = prime * result + ((getSecret() == null) ? 0 : getSecret().hashCode());
        result = prime * result + ((getSessionKey() == null) ? 0 : getSessionKey().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
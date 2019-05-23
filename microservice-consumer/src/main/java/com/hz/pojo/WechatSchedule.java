package com.hz.pojo;

import java.io.Serializable;

public class WechatSchedule implements Serializable {
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
    private String dayofweek;

    /**
     * VARCHAR(255)<br>
     * 
     */
    private String timeperiod;

    /**
     * VARCHAR(255)<br>
     * 
     */
    private String classid;

    /**
     * VARCHAR(32)<br>
     * 
     */
    private String createTime;

    /**
     * VARCHAR(32)<br>
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
    public String getDayofweek() {
        return dayofweek;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek == null ? null : dayofweek.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 
     */
    public String getTimeperiod() {
        return timeperiod;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setTimeperiod(String timeperiod) {
        this.timeperiod = timeperiod == null ? null : timeperiod.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 
     */
    public String getClassid() {
        return classid;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 
     */
    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * VARCHAR(32)<br>
     * 设置 
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * VARCHAR(32)<br>
     * 获得 
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * VARCHAR(32)<br>
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
        sb.append(", dayofweek=").append(dayofweek);
        sb.append(", timeperiod=").append(timeperiod);
        sb.append(", classid=").append(classid);
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
        WechatSchedule other = (WechatSchedule) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDayofweek() == null ? other.getDayofweek() == null : this.getDayofweek().equals(other.getDayofweek()))
            && (this.getTimeperiod() == null ? other.getTimeperiod() == null : this.getTimeperiod().equals(other.getTimeperiod()))
            && (this.getClassid() == null ? other.getClassid() == null : this.getClassid().equals(other.getClassid()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDayofweek() == null) ? 0 : getDayofweek().hashCode());
        result = prime * result + ((getTimeperiod() == null) ? 0 : getTimeperiod().hashCode());
        result = prime * result + ((getClassid() == null) ? 0 : getClassid().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
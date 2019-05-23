package com.hz.pojo;

import java.io.Serializable;

public class PointPosition implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * INTEGER(10) 必填<br>
     * 主键id
     */
    private Integer id;

    /**
     * VARCHAR(255)<br>
     * 点位名字
     */
    private String name;

    /**
     * VARCHAR(255)<br>
     * 方向
     */
    private String direction;

    /**
     * INTEGER(10)<br>
     * 长度
     */
    private Integer len;

    /**
     * VARCHAR(255)<br>
     * 经度
     */
    private String longitude;

    /**
     * VARCHAR(255)<br>
     * 纬度
     */
    private String latitude;

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
     * 获得 点位名字
     */
    public String getName() {
        return name;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 点位名字
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 方向
     */
    public String getDirection() {
        return direction;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 方向
     */
    public void setDirection(String direction) {
        this.direction = direction == null ? null : direction.trim();
    }

    /**
     * INTEGER(10)<br>
     * 获得 长度
     */
    public Integer getLen() {
        return len;
    }

    /**
     * INTEGER(10)<br>
     * 设置 长度
     */
    public void setLen(Integer len) {
        this.len = len;
    }

    /**
     * VARCHAR(255)<br>
     * 获得 经度
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 经度
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    /**
     * VARCHAR(255)<br>
     * 获得 纬度
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * VARCHAR(255)<br>
     * 设置 纬度
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", direction=").append(direction);
        sb.append(", len=").append(len);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
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
        PointPosition other = (PointPosition) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDirection() == null ? other.getDirection() == null : this.getDirection().equals(other.getDirection()))
            && (this.getLen() == null ? other.getLen() == null : this.getLen().equals(other.getLen()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDirection() == null) ? 0 : getDirection().hashCode());
        result = prime * result + ((getLen() == null) ? 0 : getLen().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}
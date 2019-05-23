package com.hz.pojo;

import java.io.Serializable;
import java.util.Date;

public class MkmRecommendPopupRecordsPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * BIGINT(19) 必填<br>
     * 主键id
     */
    private Long id;

    /**
     * VARCHAR(2) 必填<br>
     * 状态
     */
    private String status;

    /**
     * VARCHAR(255) 必填<br>
     * 渠道
     */
    private String channel;

    /**
     * VARCHAR(1000)<br>
     * 备注
     */
    private String remark;

    /**
     * VARCHAR(255) 必填<br>
     * 生效开始时间
     */
    private String effectBeginTime;

    /**
     * VARCHAR(255) 必填<br>
     * 生效结束时间
     */
    private String effectEndTime;

    /**
     * TIMESTAMP(19) 必填<br>
     * 创建时间
     */
    private Date createTime;

    /**
     * TIMESTAMP(19) 必填<br>
     * 更新时间
     */
    private Date updateTime;

    /**
     * BIGINT(19) 必填<br>
     * 获得 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * BIGINT(19) 必填<br>
     * 设置 主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * VARCHAR(2) 必填<br>
     * 获得 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * VARCHAR(2) 必填<br>
     * 设置 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * VARCHAR(255) 必填<br>
     * 获得 渠道
     */
    public String getChannel() {
        return channel;
    }

    /**
     * VARCHAR(255) 必填<br>
     * 设置 渠道
     */
    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    /**
     * VARCHAR(1000)<br>
     * 获得 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * VARCHAR(1000)<br>
     * 设置 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * VARCHAR(255) 必填<br>
     * 获得 生效开始时间
     */
    public String getEffectBeginTime() {
        return effectBeginTime;
    }

    /**
     * VARCHAR(255) 必填<br>
     * 设置 生效开始时间
     */
    public void setEffectBeginTime(String effectBeginTime) {
        this.effectBeginTime = effectBeginTime == null ? null : effectBeginTime.trim();
    }

    /**
     * VARCHAR(255) 必填<br>
     * 获得 生效结束时间
     */
    public String getEffectEndTime() {
        return effectEndTime;
    }

    /**
     * VARCHAR(255) 必填<br>
     * 设置 生效结束时间
     */
    public void setEffectEndTime(String effectEndTime) {
        this.effectEndTime = effectEndTime == null ? null : effectEndTime.trim();
    }

    /**
     * TIMESTAMP(19) 必填<br>
     * 获得 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * TIMESTAMP(19) 必填<br>
     * 设置 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * TIMESTAMP(19) 必填<br>
     * 获得 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * TIMESTAMP(19) 必填<br>
     * 设置 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", status=").append(status);
        sb.append(", channel=").append(channel);
        sb.append(", remark=").append(remark);
        sb.append(", effectBeginTime=").append(effectBeginTime);
        sb.append(", effectEndTime=").append(effectEndTime);
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
        MkmRecommendPopupRecordsPo other = (MkmRecommendPopupRecordsPo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getEffectBeginTime() == null ? other.getEffectBeginTime() == null : this.getEffectBeginTime().equals(other.getEffectBeginTime()))
            && (this.getEffectEndTime() == null ? other.getEffectEndTime() == null : this.getEffectEndTime().equals(other.getEffectEndTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getEffectBeginTime() == null) ? 0 : getEffectBeginTime().hashCode());
        result = prime * result + ((getEffectEndTime() == null) ? 0 : getEffectEndTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
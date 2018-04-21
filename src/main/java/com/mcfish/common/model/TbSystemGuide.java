package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_guide")
public class TbSystemGuide {
    private Integer id;

    /**
     * 图片地址
     */
    private String image;

    /**
     * 备注信息
     */
    private String comment;

    /**
     * 状态 0-上线 1-下线
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取图片地址
     *
     * @return image - 图片地址
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置图片地址
     *
     * @param image 图片地址
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取备注信息
     *
     * @return comment - 备注信息
     */
    public String getComment() {
        return comment;
    }

    /**
     * 设置备注信息
     *
     * @param comment 备注信息
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * 获取状态 0-上线 1-下线
     *
     * @return status - 状态 0-上线 1-下线
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态 0-上线 1-下线
     *
     * @param status 状态 0-上线 1-下线
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
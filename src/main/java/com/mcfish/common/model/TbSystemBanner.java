package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_system_banner")
public class TbSystemBanner {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 显示位置
     */
    private Byte pos;

    /**
     * 开始时间
     */
    private Date begin;

    /**
     * 结束时间
     */
    private Date end;

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
     * banner标题
     */
    private String title;

    /**
     * banner图片
     */
    private String image;

    /**
     * 跳转url
     */
    private String url;

    /**
     * 扩展字段
     */
    private String data;

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取显示位置
     *
     * @return pos - 显示位置
     */
    public Byte getPos() {
        return pos;
    }

    /**
     * 设置显示位置
     *
     * @param pos 显示位置
     */
    public void setPos(Byte pos) {
        this.pos = pos;
    }

    /**
     * 获取开始时间
     *
     * @return begin - 开始时间
     */
    public Date getBegin() {
        return begin;
    }

    /**
     * 设置开始时间
     *
     * @param begin 开始时间
     */
    public void setBegin(Date begin) {
        this.begin = begin;
    }

    /**
     * 获取结束时间
     *
     * @return end - 结束时间
     */
    public Date getEnd() {
        return end;
    }

    /**
     * 设置结束时间
     *
     * @param end 结束时间
     */
    public void setEnd(Date end) {
        this.end = end;
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

    /**
     * 获取banner标题
     *
     * @return title - banner标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置banner标题
     *
     * @param title banner标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取banner图片
     *
     * @return image - banner图片
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置banner图片
     *
     * @param image banner图片
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * 获取跳转url
     *
     * @return url - 跳转url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置跳转url
     *
     * @param url 跳转url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取扩展字段
     *
     * @return data - 扩展字段
     */
    public String getData() {
        return data;
    }

    /**
     * 设置扩展字段
     *
     * @param data 扩展字段
     */
    public void setData(String data) {
        this.data = data;
    }
}
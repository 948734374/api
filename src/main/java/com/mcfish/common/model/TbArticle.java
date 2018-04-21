package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_article")
public class TbArticle {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator="JDBC")
    private Integer id;

    /**
     * 帖子简述
     */
    private String title;

    /**
     * 帖子标签 多个用,分割
     */
    private String tag;

    /**
     * 帖子内容,json字符串 链接:类型 {"url":type}
     */
    private String content;

    /**
     * 帖子外部url
     */
    private String url;

    /**
     * 帖子类型 0-原创 1-转发
     */
    private Byte type;

    /**
     * 地址
     */
    private String address;

    /**
     * 经度
     */
    private Double lng;

    /**
     * 纬度
     */
    private Double lat;

    /**
     * 帖子状态  0-正常 1-否决（冻结）
     */
    private Byte status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * 获取帖子简述
     *
     * @return title - 帖子简述
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置帖子简述
     *
     * @param title 帖子简述
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取帖子标签 多个用,分割
     *
     * @return tag - 帖子标签 多个用,分割
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置帖子标签 多个用,分割
     *
     * @param tag 帖子标签 多个用,分割
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * 获取帖子内容,json字符串 链接:类型 {"url":type}
     *
     * @return content - 帖子内容,json字符串 链接:类型 {"url":type}
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置帖子内容,json字符串 链接:类型 {"url":type}
     *
     * @param content 帖子内容,json字符串 链接:类型 {"url":type}
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取帖子外部url
     *
     * @return url - 帖子外部url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置帖子外部url
     *
     * @param url 帖子外部url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取帖子类型 0-原创 1-转发
     *
     * @return type - 帖子类型 0-原创 1-转发
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置帖子类型 0-原创 1-转发
     *
     * @param type 帖子类型 0-原创 1-转发
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取经度
     *
     * @return lng - 经度
     */
    public Double getLng() {
        return lng;
    }

    /**
     * 设置经度
     *
     * @param lng 经度
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public Double getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     * 获取帖子状态  0-正常 1-否决（冻结）
     *
     * @return status - 帖子状态  0-正常 1-否决（冻结）
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置帖子状态  0-正常 1-否决（冻结）
     *
     * @param status 帖子状态  0-正常 1-否决（冻结）
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
    
	public TbArticle() {
		
	}
	
	
    
}
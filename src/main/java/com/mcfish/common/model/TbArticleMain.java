package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_article_main")
public class TbArticleMain {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 帖子id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 原创帖子id
     */
    @Column(name = "original_article_id")
    private Integer originalArticleId;

    /**
     * 类型 0-原创 1-转发
     */
    private Byte type;

    /**
     * 状态0-正常 1-冻结
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
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取帖子id
     *
     * @return article_id - 帖子id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     * 设置帖子id
     *
     * @param articleId 帖子id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * 获取原创帖子id
     *
     * @return original_article_id - 原创帖子id
     */
    public Integer getOriginalArticleId() {
        return originalArticleId;
    }

    /**
     * 设置原创帖子id
     *
     * @param originalArticleId 原创帖子id
     */
    public void setOriginalArticleId(Integer originalArticleId) {
        this.originalArticleId = originalArticleId;
    }

    /**
     * 获取类型 0-原创 1-转发
     *
     * @return type - 类型 0-原创 1-转发
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置类型 0-原创 1-转发
     *
     * @param type 类型 0-原创 1-转发
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取状态0-正常 1-冻结
     *
     * @return status - 状态0-正常 1-冻结
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态0-正常 1-冻结
     *
     * @param status 状态0-正常 1-冻结
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
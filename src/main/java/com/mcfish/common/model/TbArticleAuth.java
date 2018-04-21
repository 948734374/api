package com.mcfish.common.model;

import javax.persistence.*;

@Table(name = "tb_article_auth")
public class TbArticleAuth {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator="JDBC")
    private Integer id;

    /**
     * 帖子id
     */
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 帖子可见范围 0-公开 1-私密 2-部分
     */
    @Column(name = "`range`")
    private Byte range;

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
     * 获取帖子可见范围 0-公开 1-私密 2-部分
     *
     * @return range - 帖子可见范围 0-公开 1-私密 2-部分
     */
    public Byte getRange() {
        return range;
    }

    /**
     * 设置帖子可见范围 0-公开 1-私密 2-部分
     *
     * @param range 帖子可见范围 0-公开 1-私密 2-部分
     */
    public void setRange(Byte range) {
        this.range = range;
    }
}
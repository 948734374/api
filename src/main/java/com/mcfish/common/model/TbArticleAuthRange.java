package com.mcfish.common.model;

import javax.persistence.*;

@Table(name = "tb_article_auth_range")
public class TbArticleAuthRange {
    /**
     * 主键id
     */
    @Id
    private Integer id;

    /**
     * 权限id
     */
    @Column(name = "auth_id")
    private Integer authId;
    
    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户列表(多个用户直接yong,分割)
     */
    private String users;

    /**
     * 家庭id
     */
    private byte[] familys;

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
     * 获取权限id
     *
     * @return auth_id - 权限id
     */
    public Integer getAuthId() {
        return authId;
    }

    /**
     * 设置权限id
     *
     * @param authId 权限id
     */
    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    /**
     * 获取用户列表(多个用户直接yong,分割)
     *
     * @return users - 用户列表(多个用户直接yong,分割)
     */
    public String getUsers() {
        return users;
    }

    /**
     * 设置用户列表(多个用户直接yong,分割)
     *
     * @param users 用户列表(多个用户直接yong,分割)
     */
    public void setUsers(String users) {
        this.users = users;
    }

    /**
     * 获取家庭id
     *
     * @return familys - 家庭id
     */
    public byte[] getFamilys() {
        return familys;
    }

    /**
     * 设置家庭id
     *
     * @param familys 家庭id
     */
    public void setFamilys(byte[] familys) {
        this.familys = familys;
    }

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
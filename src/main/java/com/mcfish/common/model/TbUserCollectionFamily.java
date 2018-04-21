package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user_collection_family")
public class TbUserCollectionFamily {
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
     * 家庭id
     */
    @Column(name = "family_id")
    private Integer familyId;

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
     * 获取家庭id
     *
     * @return family_id - 家庭id
     */
    public Integer getFamilyId() {
        return familyId;
    }

    /**
     * 设置家庭id
     *
     * @param familyId 家庭id
     */
    public void setFamilyId(Integer familyId) {
        this.familyId = familyId;
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
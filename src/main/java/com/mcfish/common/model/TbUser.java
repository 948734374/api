package com.mcfish.common.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class TbUser {
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(generator="JDBC")
    private Integer id;

    /**
     * 用户对外ID(6位有效数字)
     */
    private String code;

    /**
     * 昵称
     */
    private String name;

    /**
     * 头像
     */
    private String head;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 微信授权码
     */
    @Column(name = "openid_wx")
    private String openidWx;

    /**
     * facebook授权码
     */
    @Column(name = "openid_facebook")
    private String openidFacebook;

    /**
     * 国家
     */
    private String country;

    /**
     * 地区
     */
    private String region;

    /**
     * 性别 0-男 1-女
     */
    private Byte gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 母语
     */
    @Column(name = "first_language")
    private String firstLanguage;

    /**
     * 第二语言
     */
    @Column(name = "second_language")
    private String secondLanguage;

    /**
     * 工作行业
     */
    private String industry;

    /**
     * 岗位类型
     */
    private String post;

    /**
     * 学历
     */
    private String education;

    /**
     * 宗教
     */
    private String religion;

    /**
     * 毕业学校
     */
    private String school;

    /**
     * 任职经历
     */
    private String word;

    /**
     * 教育经历
     */
    @Column(name = "education_experience")
    private String educationExperience;

    /**
     * 学历认证 0-未认证 1-已认证
     */
    private Byte ability;

    /**
     * 兴趣爱好
     */
    private String interests;

    /**
     * 交友宣言
     */
    private String declaration;

    /**
     * 是否需要开启好友验证 0-不需要 1-需要
     */
    @Column(name = "friend_verification")
    private Byte friendVerification;

    /**
     * 是否开启家庭验证  0-不需要 1-需要
     */
    @Column(name = "family_accpet")
    private Byte familyAccpet;

    /**
     * 状态  0-正常 1-冻结
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
     * 获取用户对外ID(6位有效数字)
     *
     * @return code - 用户对外ID(6位有效数字)
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置用户对外ID(6位有效数字)
     *
     * @param code 用户对外ID(6位有效数字)
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取昵称
     *
     * @return name - 昵称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置昵称
     *
     * @param name 昵称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取头像
     *
     * @return head - 头像
     */
    public String getHead() {
        return head;
    }

    /**
     * 设置头像
     *
     * @param head 头像
     */
    public void setHead(String head) {
        this.head = head;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取微信授权码
     *
     * @return openid_wx - 微信授权码
     */
    public String getOpenidWx() {
        return openidWx;
    }

    /**
     * 设置微信授权码
     *
     * @param openidWx 微信授权码
     */
    public void setOpenidWx(String openidWx) {
        this.openidWx = openidWx;
    }

    /**
     * 获取facebook授权码
     *
     * @return openid_facebook - facebook授权码
     */
    public String getOpenidFacebook() {
        return openidFacebook;
    }

    /**
     * 设置facebook授权码
     *
     * @param openidFacebook facebook授权码
     */
    public void setOpenidFacebook(String openidFacebook) {
        this.openidFacebook = openidFacebook;
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取地区
     *
     * @return region - 地区
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置地区
     *
     * @param region 地区
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取性别 0-男 1-女
     *
     * @return gender - 性别 0-男 1-女
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 设置性别 0-男 1-女
     *
     * @param gender 性别 0-男 1-女
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取母语
     *
     * @return first_language - 母语
     */
    public String getFirstLanguage() {
        return firstLanguage;
    }

    /**
     * 设置母语
     *
     * @param firstLanguage 母语
     */
    public void setFirstLanguage(String firstLanguage) {
        this.firstLanguage = firstLanguage;
    }

    /**
     * 获取第二语言
     *
     * @return second_language - 第二语言
     */
    public String getSecondLanguage() {
        return secondLanguage;
    }

    /**
     * 设置第二语言
     *
     * @param secondLanguage 第二语言
     */
    public void setSecondLanguage(String secondLanguage) {
        this.secondLanguage = secondLanguage;
    }

    /**
     * 获取工作行业
     *
     * @return industry - 工作行业
     */
    public String getIndustry() {
        return industry;
    }

    /**
     * 设置工作行业
     *
     * @param industry 工作行业
     */
    public void setIndustry(String industry) {
        this.industry = industry;
    }

    /**
     * 获取岗位类型
     *
     * @return post - 岗位类型
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置岗位类型
     *
     * @param post 岗位类型
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取宗教
     *
     * @return religion - 宗教
     */
    public String getReligion() {
        return religion;
    }

    /**
     * 设置宗教
     *
     * @param religion 宗教
     */
    public void setReligion(String religion) {
        this.religion = religion;
    }

    /**
     * 获取毕业学校
     *
     * @return school - 毕业学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置毕业学校
     *
     * @param school 毕业学校
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * 获取任职经历
     *
     * @return word - 任职经历
     */
    public String getWord() {
        return word;
    }

    /**
     * 设置任职经历
     *
     * @param word 任职经历
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * 获取教育经历
     *
     * @return education_experience - 教育经历
     */
    public String getEducationExperience() {
        return educationExperience;
    }

    /**
     * 设置教育经历
     *
     * @param educationExperience 教育经历
     */
    public void setEducationExperience(String educationExperience) {
        this.educationExperience = educationExperience;
    }

    /**
     * 获取学历认证 0-未认证 1-已认证
     *
     * @return ability - 学历认证 0-未认证 1-已认证
     */
    public Byte getAbility() {
        return ability;
    }

    /**
     * 设置学历认证 0-未认证 1-已认证
     *
     * @param ability 学历认证 0-未认证 1-已认证
     */
    public void setAbility(Byte ability) {
        this.ability = ability;
    }

    /**
     * 获取兴趣爱好
     *
     * @return interests - 兴趣爱好
     */
    public String getInterests() {
        return interests;
    }

    /**
     * 设置兴趣爱好
     *
     * @param interests 兴趣爱好
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }

    /**
     * 获取交友宣言
     *
     * @return declaration - 交友宣言
     */
    public String getDeclaration() {
        return declaration;
    }

    /**
     * 设置交友宣言
     *
     * @param declaration 交友宣言
     */
    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    /**
     * 获取是否需要开启好友验证 0-不需要 1-需要
     *
     * @return friend_verification - 是否需要开启好友验证 0-不需要 1-需要
     */
    public Byte getFriendVerification() {
        return friendVerification;
    }

    /**
     * 设置是否需要开启好友验证 0-不需要 1-需要
     *
     * @param friendVerification 是否需要开启好友验证 0-不需要 1-需要
     */
    public void setFriendVerification(Byte friendVerification) {
        this.friendVerification = friendVerification;
    }

    /**
     * 获取是否开启家庭验证  0-不需要 1-需要
     *
     * @return family_accpet - 是否开启家庭验证  0-不需要 1-需要
     */
    public Byte getFamilyAccpet() {
        return familyAccpet;
    }

    /**
     * 设置是否开启家庭验证  0-不需要 1-需要
     *
     * @param familyAccpet 是否开启家庭验证  0-不需要 1-需要
     */
    public void setFamilyAccpet(Byte familyAccpet) {
        this.familyAccpet = familyAccpet;
    }

    /**
     * 获取状态  0-正常 1-冻结
     *
     * @return status - 状态  0-正常 1-冻结
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态  0-正常 1-冻结
     *
     * @param status 状态  0-正常 1-冻结
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
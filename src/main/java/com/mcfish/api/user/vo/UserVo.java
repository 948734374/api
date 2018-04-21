package com.mcfish.api.user.vo;

import java.io.Serializable;

/**
 * 用户信息Vo
 * @TODO
 * @author Macro
 * @date 2018年3月24日上午10:27:44
 * @description
 *
 */
public class UserVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6566427583038353353L;
	
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
    private String openidWx;

    /**
     * facebook授权码
     */
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
    private String firstLanguage;

    /**
     * 第二语言
     */
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
    private Byte friendVerification;

    /**
     * 是否开启家庭验证  0-不需要 1-需要
     */
    private Byte familyAccpet;

    /**
     * 状态  0-正常 1-冻结
     */
    private Byte status;

    /**令牌**/
    private String  token;
    /**帖子数量**/
    private Integer articleTotal;
    /**好友数量**/
    private Integer friendTotal;
    /**粉丝数量**/
    private Integer fansTotal;
    /**家庭数量**/
    private Integer familyTotal;
    
    /**是否是好友**/
    private Integer isFriend;   
    /**是否是粉丝**/
    private Integer isFans;
    
	public UserVo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOpenidWx() {
		return openidWx;
	}

	public void setOpenidWx(String openidWx) {
		this.openidWx = openidWx;
	}

	public String getOpenidFacebook() {
		return openidFacebook;
	}

	public void setOpenidFacebook(String openidFacebook) {
		this.openidFacebook = openidFacebook;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Byte getGender() {
		return gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstLanguage() {
		return firstLanguage;
	}

	public void setFirstLanguage(String firstLanguage) {
		this.firstLanguage = firstLanguage;
	}

	public String getSecondLanguage() {
		return secondLanguage;
	}

	public void setSecondLanguage(String secondLanguage) {
		this.secondLanguage = secondLanguage;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getEducationExperience() {
		return educationExperience;
	}

	public void setEducationExperience(String educationExperience) {
		this.educationExperience = educationExperience;
	}

	public Byte getAbility() {
		return ability;
	}

	public void setAbility(Byte ability) {
		this.ability = ability;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	public Byte getFriendVerification() {
		return friendVerification;
	}

	public void setFriendVerification(Byte friendVerification) {
		this.friendVerification = friendVerification;
	}

	public Byte getFamilyAccpet() {
		return familyAccpet;
	}

	public void setFamilyAccpet(Byte familyAccpet) {
		this.familyAccpet = familyAccpet;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Integer getArticleTotal() {
		return articleTotal;
	}

	public void setArticleTotal(Integer articleTotal) {
		this.articleTotal = articleTotal;
	}

	public Integer getFriendTotal() {
		return friendTotal;
	}

	public void setFriendTotal(Integer friendTotal) {
		this.friendTotal = friendTotal;
	}

	public Integer getFansTotal() {
		return fansTotal;
	}

	public void setFansTotal(Integer fansTotal) {
		this.fansTotal = fansTotal;
	}

	public Integer getFamilyTotal() {
		return familyTotal;
	}

	public void setFamilyTotal(Integer familyTotal) {
		this.familyTotal = familyTotal;
	}

	public Integer getIsFriend() {
		return isFriend;
	}

	public void setIsFriend(Integer isFriend) {
		this.isFriend = isFriend;
	}

	public Integer getIsFans() {
		return isFans;
	}

	public void setIsFans(Integer isFans) {
		this.isFans = isFans;
	}
	
	
	
	
	
	
	
	
	
	

}

package com.entity.model;

import com.entity.JieyuebuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 借阅部领导
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JieyuebuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 借阅部领导姓名
     */
    private String jieyuebuName;


    /**
     * 借阅部领导手机号
     */
    private String jieyuebuPhone;


    /**
     * 借阅部领导身份证号
     */
    private String jieyuebuIdNumber;


    /**
     * 借阅部领导照片
     */
    private String jieyuebuPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：借阅部领导姓名
	 */
    public String getJieyuebuName() {
        return jieyuebuName;
    }


    /**
	 * 设置：借阅部领导姓名
	 */
    public void setJieyuebuName(String jieyuebuName) {
        this.jieyuebuName = jieyuebuName;
    }
    /**
	 * 获取：借阅部领导手机号
	 */
    public String getJieyuebuPhone() {
        return jieyuebuPhone;
    }


    /**
	 * 设置：借阅部领导手机号
	 */
    public void setJieyuebuPhone(String jieyuebuPhone) {
        this.jieyuebuPhone = jieyuebuPhone;
    }
    /**
	 * 获取：借阅部领导身份证号
	 */
    public String getJieyuebuIdNumber() {
        return jieyuebuIdNumber;
    }


    /**
	 * 设置：借阅部领导身份证号
	 */
    public void setJieyuebuIdNumber(String jieyuebuIdNumber) {
        this.jieyuebuIdNumber = jieyuebuIdNumber;
    }
    /**
	 * 获取：借阅部领导照片
	 */
    public String getJieyuebuPhoto() {
        return jieyuebuPhoto;
    }


    /**
	 * 设置：借阅部领导照片
	 */
    public void setJieyuebuPhoto(String jieyuebuPhoto) {
        this.jieyuebuPhoto = jieyuebuPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }

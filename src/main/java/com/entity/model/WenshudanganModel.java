package com.entity.model;

import com.entity.WenshudanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 文书档案专责人员
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class WenshudanganModel implements Serializable {
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
     * 专责人员姓名
     */
    private String wenshudanganName;


    /**
     * 专责人员手机号
     */
    private String wenshudanganPhone;


    /**
     * 专责人员身份证号
     */
    private String wenshudanganIdNumber;


    /**
     * 专责人员照片
     */
    private String wenshudanganPhoto;


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
	 * 获取：专责人员姓名
	 */
    public String getWenshudanganName() {
        return wenshudanganName;
    }


    /**
	 * 设置：专责人员姓名
	 */
    public void setWenshudanganName(String wenshudanganName) {
        this.wenshudanganName = wenshudanganName;
    }
    /**
	 * 获取：专责人员手机号
	 */
    public String getWenshudanganPhone() {
        return wenshudanganPhone;
    }


    /**
	 * 设置：专责人员手机号
	 */
    public void setWenshudanganPhone(String wenshudanganPhone) {
        this.wenshudanganPhone = wenshudanganPhone;
    }
    /**
	 * 获取：专责人员身份证号
	 */
    public String getWenshudanganIdNumber() {
        return wenshudanganIdNumber;
    }


    /**
	 * 设置：专责人员身份证号
	 */
    public void setWenshudanganIdNumber(String wenshudanganIdNumber) {
        this.wenshudanganIdNumber = wenshudanganIdNumber;
    }
    /**
	 * 获取：专责人员照片
	 */
    public String getWenshudanganPhoto() {
        return wenshudanganPhoto;
    }


    /**
	 * 设置：专责人员照片
	 */
    public void setWenshudanganPhoto(String wenshudanganPhoto) {
        this.wenshudanganPhoto = wenshudanganPhoto;
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

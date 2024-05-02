package com.entity.vo;

import com.entity.WenshudanganEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 文书档案专责人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("wenshudangan")
public class WenshudanganVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 专责人员姓名
     */

    @TableField(value = "wenshudangan_name")
    private String wenshudanganName;


    /**
     * 专责人员手机号
     */

    @TableField(value = "wenshudangan_phone")
    private String wenshudanganPhone;


    /**
     * 专责人员身份证号
     */

    @TableField(value = "wenshudangan_id_number")
    private String wenshudanganIdNumber;


    /**
     * 专责人员照片
     */

    @TableField(value = "wenshudangan_photo")
    private String wenshudanganPhoto;


    /**
     * 性别
     */

    @TableField(value = "sex_types")
    private Integer sexTypes;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：专责人员姓名
	 */
    public String getWenshudanganName() {
        return wenshudanganName;
    }


    /**
	 * 获取：专责人员姓名
	 */

    public void setWenshudanganName(String wenshudanganName) {
        this.wenshudanganName = wenshudanganName;
    }
    /**
	 * 设置：专责人员手机号
	 */
    public String getWenshudanganPhone() {
        return wenshudanganPhone;
    }


    /**
	 * 获取：专责人员手机号
	 */

    public void setWenshudanganPhone(String wenshudanganPhone) {
        this.wenshudanganPhone = wenshudanganPhone;
    }
    /**
	 * 设置：专责人员身份证号
	 */
    public String getWenshudanganIdNumber() {
        return wenshudanganIdNumber;
    }


    /**
	 * 获取：专责人员身份证号
	 */

    public void setWenshudanganIdNumber(String wenshudanganIdNumber) {
        this.wenshudanganIdNumber = wenshudanganIdNumber;
    }
    /**
	 * 设置：专责人员照片
	 */
    public String getWenshudanganPhoto() {
        return wenshudanganPhoto;
    }


    /**
	 * 获取：专责人员照片
	 */

    public void setWenshudanganPhoto(String wenshudanganPhoto) {
        this.wenshudanganPhoto = wenshudanganPhoto;
    }
    /**
	 * 设置：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 获取：性别
	 */

    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}

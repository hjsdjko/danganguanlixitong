package com.entity.vo;

import com.entity.ZhurenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 综合部主任
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhuren")
public class ZhurenVO implements Serializable {
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
     * 综合部主任姓名
     */

    @TableField(value = "zhuren_name")
    private String zhurenName;


    /**
     * 综合部主任手机号
     */

    @TableField(value = "zhuren_phone")
    private String zhurenPhone;


    /**
     * 综合部主任身份证号
     */

    @TableField(value = "zhuren_id_number")
    private String zhurenIdNumber;


    /**
     * 综合部主任照片
     */

    @TableField(value = "zhuren_photo")
    private String zhurenPhoto;


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
	 * 设置：综合部主任姓名
	 */
    public String getZhurenName() {
        return zhurenName;
    }


    /**
	 * 获取：综合部主任姓名
	 */

    public void setZhurenName(String zhurenName) {
        this.zhurenName = zhurenName;
    }
    /**
	 * 设置：综合部主任手机号
	 */
    public String getZhurenPhone() {
        return zhurenPhone;
    }


    /**
	 * 获取：综合部主任手机号
	 */

    public void setZhurenPhone(String zhurenPhone) {
        this.zhurenPhone = zhurenPhone;
    }
    /**
	 * 设置：综合部主任身份证号
	 */
    public String getZhurenIdNumber() {
        return zhurenIdNumber;
    }


    /**
	 * 获取：综合部主任身份证号
	 */

    public void setZhurenIdNumber(String zhurenIdNumber) {
        this.zhurenIdNumber = zhurenIdNumber;
    }
    /**
	 * 设置：综合部主任照片
	 */
    public String getZhurenPhoto() {
        return zhurenPhoto;
    }


    /**
	 * 获取：综合部主任照片
	 */

    public void setZhurenPhoto(String zhurenPhoto) {
        this.zhurenPhoto = zhurenPhoto;
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

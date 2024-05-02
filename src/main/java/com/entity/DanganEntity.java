package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 档案
 *
 * @author 
 * @email
 */
@TableName("dangan")
public class DanganEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DanganEntity() {

	}

	public DanganEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 档案编号
     */
    @TableField(value = "dangan_bianhao")

    private String danganBianhao;


    /**
     * 档案名称
     */
    @TableField(value = "dangan_name")

    private String danganName;


    /**
     * 档案类型
     */
    @TableField(value = "dangan_types")

    private Integer danganTypes;


    /**
     * 档案图片
     */
    @TableField(value = "dangan_photo")

    private String danganPhoto;


    /**
     * 档案详情
     */
    @TableField(value = "dangan_content")

    private String danganContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 设置：档案编号
	 */
    public String getDanganBianhao() {
        return danganBianhao;
    }


    /**
	 * 获取：档案编号
	 */

    public void setDanganBianhao(String danganBianhao) {
        this.danganBianhao = danganBianhao;
    }
    /**
	 * 设置：档案名称
	 */
    public String getDanganName() {
        return danganName;
    }


    /**
	 * 获取：档案名称
	 */

    public void setDanganName(String danganName) {
        this.danganName = danganName;
    }
    /**
	 * 设置：档案类型
	 */
    public Integer getDanganTypes() {
        return danganTypes;
    }


    /**
	 * 获取：档案类型
	 */

    public void setDanganTypes(Integer danganTypes) {
        this.danganTypes = danganTypes;
    }
    /**
	 * 设置：档案图片
	 */
    public String getDanganPhoto() {
        return danganPhoto;
    }


    /**
	 * 获取：档案图片
	 */

    public void setDanganPhoto(String danganPhoto) {
        this.danganPhoto = danganPhoto;
    }
    /**
	 * 设置：档案详情
	 */
    public String getDanganContent() {
        return danganContent;
    }


    /**
	 * 获取：档案详情
	 */

    public void setDanganContent(String danganContent) {
        this.danganContent = danganContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    @Override
    public String toString() {
        return "Dangan{" +
            "id=" + id +
            ", danganBianhao=" + danganBianhao +
            ", danganName=" + danganName +
            ", danganTypes=" + danganTypes +
            ", danganPhoto=" + danganPhoto +
            ", danganContent=" + danganContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}

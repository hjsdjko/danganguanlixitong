package com.entity.vo;

import com.entity.DanganEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("dangan")
public class DanganVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


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

}

package com.entity.vo;

import com.entity.JieyueshenqingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 借阅申请
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jieyueshenqing")
public class JieyueshenqingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 申请人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 档案
     */

    @TableField(value = "dangan_id")
    private Integer danganId;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 借阅用途
     */

    @TableField(value = "yongtu")
    private String yongtu;


    /**
     * 借阅部门
     */

    @TableField(value = "bumen_types")
    private Integer bumenTypes;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieyue_time")
    private Date jieyueTime;


    /**
     * 归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "guihuan_time")
    private Date guihuanTime;


    /**
     * 供电公司
     */

    @TableField(value = "gongdiangongsi")
    private String gongdiangongsi;


    /**
     * 借阅部领导
     */

    @TableField(value = "jieyuebu_id")
    private Integer jieyuebuId;


    /**
     * 借阅部领导审批类型
     */

    @TableField(value = "jieyuebu_types")
    private Integer jieyuebuTypes;


    /**
     * 借阅部领导审批意见
     */

    @TableField(value = "jieyuebu_content")
    private String jieyuebuContent;


    /**
     * 借阅部领导审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jieyuebu_time")
    private Date jieyuebuTime;


    /**
     * 主管领导
     */

    @TableField(value = "zhuguan_id")
    private Integer zhuguanId;


    /**
     * 主管领导审批类型
     */

    @TableField(value = "zhuguan_types")
    private Integer zhuguanTypes;


    /**
     * 主管领导审批意见
     */

    @TableField(value = "zhuguan_content")
    private String zhuguanContent;


    /**
     * 主管领导审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhuguan_time")
    private Date zhuguanTime;


    /**
     * 综合部主任
     */

    @TableField(value = "zhuren_id")
    private Integer zhurenId;


    /**
     * 综合部主任审批类型
     */

    @TableField(value = "zhuren_types")
    private Integer zhurenTypes;


    /**
     * 综合部主任审批意见
     */

    @TableField(value = "zhuren_content")
    private String zhurenContent;


    /**
     * 综合部主任审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "zhuren_time")
    private Date zhurenTime;


    /**
     * 文书档案专责人员
     */

    @TableField(value = "wenshudangan_id")
    private Integer wenshudanganId;


    /**
     * 文书档案专责人员审批类型
     */

    @TableField(value = "wenshudangan_types")
    private Integer wenshudanganTypes;


    /**
     * 文书档案专责人员审批意见
     */

    @TableField(value = "wenshudangan_content")
    private String wenshudanganContent;


    /**
     * 文书档案专责人员审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "wenshudangan_time")
    private Date wenshudanganTime;


    /**
     * 经办人
     */

    @TableField(value = "jingbanren")
    private String jingbanren;


    /**
     * 经办时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jingbanren_time")
    private Date jingbanrenTime;


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
	 * 设置：申请人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：申请人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：档案
	 */
    public Integer getDanganId() {
        return danganId;
    }


    /**
	 * 获取：档案
	 */

    public void setDanganId(Integer danganId) {
        this.danganId = danganId;
    }
    /**
	 * 设置：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：申请时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：借阅用途
	 */
    public String getYongtu() {
        return yongtu;
    }


    /**
	 * 获取：借阅用途
	 */

    public void setYongtu(String yongtu) {
        this.yongtu = yongtu;
    }
    /**
	 * 设置：借阅部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 获取：借阅部门
	 */

    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 设置：借阅时间
	 */
    public Date getJieyueTime() {
        return jieyueTime;
    }


    /**
	 * 获取：借阅时间
	 */

    public void setJieyueTime(Date jieyueTime) {
        this.jieyueTime = jieyueTime;
    }
    /**
	 * 设置：归还时间
	 */
    public Date getGuihuanTime() {
        return guihuanTime;
    }


    /**
	 * 获取：归还时间
	 */

    public void setGuihuanTime(Date guihuanTime) {
        this.guihuanTime = guihuanTime;
    }
    /**
	 * 设置：供电公司
	 */
    public String getGongdiangongsi() {
        return gongdiangongsi;
    }


    /**
	 * 获取：供电公司
	 */

    public void setGongdiangongsi(String gongdiangongsi) {
        this.gongdiangongsi = gongdiangongsi;
    }
    /**
	 * 设置：借阅部领导
	 */
    public Integer getJieyuebuId() {
        return jieyuebuId;
    }


    /**
	 * 获取：借阅部领导
	 */

    public void setJieyuebuId(Integer jieyuebuId) {
        this.jieyuebuId = jieyuebuId;
    }
    /**
	 * 设置：借阅部领导审批类型
	 */
    public Integer getJieyuebuTypes() {
        return jieyuebuTypes;
    }


    /**
	 * 获取：借阅部领导审批类型
	 */

    public void setJieyuebuTypes(Integer jieyuebuTypes) {
        this.jieyuebuTypes = jieyuebuTypes;
    }
    /**
	 * 设置：借阅部领导审批意见
	 */
    public String getJieyuebuContent() {
        return jieyuebuContent;
    }


    /**
	 * 获取：借阅部领导审批意见
	 */

    public void setJieyuebuContent(String jieyuebuContent) {
        this.jieyuebuContent = jieyuebuContent;
    }
    /**
	 * 设置：借阅部领导审批时间
	 */
    public Date getJieyuebuTime() {
        return jieyuebuTime;
    }


    /**
	 * 获取：借阅部领导审批时间
	 */

    public void setJieyuebuTime(Date jieyuebuTime) {
        this.jieyuebuTime = jieyuebuTime;
    }
    /**
	 * 设置：主管领导
	 */
    public Integer getZhuguanId() {
        return zhuguanId;
    }


    /**
	 * 获取：主管领导
	 */

    public void setZhuguanId(Integer zhuguanId) {
        this.zhuguanId = zhuguanId;
    }
    /**
	 * 设置：主管领导审批类型
	 */
    public Integer getZhuguanTypes() {
        return zhuguanTypes;
    }


    /**
	 * 获取：主管领导审批类型
	 */

    public void setZhuguanTypes(Integer zhuguanTypes) {
        this.zhuguanTypes = zhuguanTypes;
    }
    /**
	 * 设置：主管领导审批意见
	 */
    public String getZhuguanContent() {
        return zhuguanContent;
    }


    /**
	 * 获取：主管领导审批意见
	 */

    public void setZhuguanContent(String zhuguanContent) {
        this.zhuguanContent = zhuguanContent;
    }
    /**
	 * 设置：主管领导审批时间
	 */
    public Date getZhuguanTime() {
        return zhuguanTime;
    }


    /**
	 * 获取：主管领导审批时间
	 */

    public void setZhuguanTime(Date zhuguanTime) {
        this.zhuguanTime = zhuguanTime;
    }
    /**
	 * 设置：综合部主任
	 */
    public Integer getZhurenId() {
        return zhurenId;
    }


    /**
	 * 获取：综合部主任
	 */

    public void setZhurenId(Integer zhurenId) {
        this.zhurenId = zhurenId;
    }
    /**
	 * 设置：综合部主任审批类型
	 */
    public Integer getZhurenTypes() {
        return zhurenTypes;
    }


    /**
	 * 获取：综合部主任审批类型
	 */

    public void setZhurenTypes(Integer zhurenTypes) {
        this.zhurenTypes = zhurenTypes;
    }
    /**
	 * 设置：综合部主任审批意见
	 */
    public String getZhurenContent() {
        return zhurenContent;
    }


    /**
	 * 获取：综合部主任审批意见
	 */

    public void setZhurenContent(String zhurenContent) {
        this.zhurenContent = zhurenContent;
    }
    /**
	 * 设置：综合部主任审批时间
	 */
    public Date getZhurenTime() {
        return zhurenTime;
    }


    /**
	 * 获取：综合部主任审批时间
	 */

    public void setZhurenTime(Date zhurenTime) {
        this.zhurenTime = zhurenTime;
    }
    /**
	 * 设置：文书档案专责人员
	 */
    public Integer getWenshudanganId() {
        return wenshudanganId;
    }


    /**
	 * 获取：文书档案专责人员
	 */

    public void setWenshudanganId(Integer wenshudanganId) {
        this.wenshudanganId = wenshudanganId;
    }
    /**
	 * 设置：文书档案专责人员审批类型
	 */
    public Integer getWenshudanganTypes() {
        return wenshudanganTypes;
    }


    /**
	 * 获取：文书档案专责人员审批类型
	 */

    public void setWenshudanganTypes(Integer wenshudanganTypes) {
        this.wenshudanganTypes = wenshudanganTypes;
    }
    /**
	 * 设置：文书档案专责人员审批意见
	 */
    public String getWenshudanganContent() {
        return wenshudanganContent;
    }


    /**
	 * 获取：文书档案专责人员审批意见
	 */

    public void setWenshudanganContent(String wenshudanganContent) {
        this.wenshudanganContent = wenshudanganContent;
    }
    /**
	 * 设置：文书档案专责人员审批时间
	 */
    public Date getWenshudanganTime() {
        return wenshudanganTime;
    }


    /**
	 * 获取：文书档案专责人员审批时间
	 */

    public void setWenshudanganTime(Date wenshudanganTime) {
        this.wenshudanganTime = wenshudanganTime;
    }
    /**
	 * 设置：经办人
	 */
    public String getJingbanren() {
        return jingbanren;
    }


    /**
	 * 获取：经办人
	 */

    public void setJingbanren(String jingbanren) {
        this.jingbanren = jingbanren;
    }
    /**
	 * 设置：经办时间
	 */
    public Date getJingbanrenTime() {
        return jingbanrenTime;
    }


    /**
	 * 获取：经办时间
	 */

    public void setJingbanrenTime(Date jingbanrenTime) {
        this.jingbanrenTime = jingbanrenTime;
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

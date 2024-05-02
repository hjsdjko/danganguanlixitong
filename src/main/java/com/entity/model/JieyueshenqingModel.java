package com.entity.model;

import com.entity.JieyueshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 借阅申请
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JieyueshenqingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 申请人
     */
    private Integer yonghuId;


    /**
     * 档案
     */
    private Integer danganId;


    /**
     * 申请时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 借阅用途
     */
    private String yongtu;


    /**
     * 借阅部门
     */
    private Integer bumenTypes;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieyueTime;


    /**
     * 归还时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date guihuanTime;


    /**
     * 供电公司
     */
    private String gongdiangongsi;


    /**
     * 借阅部领导
     */
    private Integer jieyuebuId;


    /**
     * 借阅部领导审批类型
     */
    private Integer jieyuebuTypes;


    /**
     * 借阅部领导审批意见
     */
    private String jieyuebuContent;


    /**
     * 借阅部领导审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jieyuebuTime;


    /**
     * 主管领导
     */
    private Integer zhuguanId;


    /**
     * 主管领导审批类型
     */
    private Integer zhuguanTypes;


    /**
     * 主管领导审批意见
     */
    private String zhuguanContent;


    /**
     * 主管领导审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhuguanTime;


    /**
     * 综合部主任
     */
    private Integer zhurenId;


    /**
     * 综合部主任审批类型
     */
    private Integer zhurenTypes;


    /**
     * 综合部主任审批意见
     */
    private String zhurenContent;


    /**
     * 综合部主任审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date zhurenTime;


    /**
     * 文书档案专责人员
     */
    private Integer wenshudanganId;


    /**
     * 文书档案专责人员审批类型
     */
    private Integer wenshudanganTypes;


    /**
     * 文书档案专责人员审批意见
     */
    private String wenshudanganContent;


    /**
     * 文书档案专责人员审批时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date wenshudanganTime;


    /**
     * 经办人
     */
    private String jingbanren;


    /**
     * 经办时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jingbanrenTime;


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
	 * 获取：申请人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：申请人
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：档案
	 */
    public Integer getDanganId() {
        return danganId;
    }


    /**
	 * 设置：档案
	 */
    public void setDanganId(Integer danganId) {
        this.danganId = danganId;
    }
    /**
	 * 获取：申请时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：借阅用途
	 */
    public String getYongtu() {
        return yongtu;
    }


    /**
	 * 设置：借阅用途
	 */
    public void setYongtu(String yongtu) {
        this.yongtu = yongtu;
    }
    /**
	 * 获取：借阅部门
	 */
    public Integer getBumenTypes() {
        return bumenTypes;
    }


    /**
	 * 设置：借阅部门
	 */
    public void setBumenTypes(Integer bumenTypes) {
        this.bumenTypes = bumenTypes;
    }
    /**
	 * 获取：借阅时间
	 */
    public Date getJieyueTime() {
        return jieyueTime;
    }


    /**
	 * 设置：借阅时间
	 */
    public void setJieyueTime(Date jieyueTime) {
        this.jieyueTime = jieyueTime;
    }
    /**
	 * 获取：归还时间
	 */
    public Date getGuihuanTime() {
        return guihuanTime;
    }


    /**
	 * 设置：归还时间
	 */
    public void setGuihuanTime(Date guihuanTime) {
        this.guihuanTime = guihuanTime;
    }
    /**
	 * 获取：供电公司
	 */
    public String getGongdiangongsi() {
        return gongdiangongsi;
    }


    /**
	 * 设置：供电公司
	 */
    public void setGongdiangongsi(String gongdiangongsi) {
        this.gongdiangongsi = gongdiangongsi;
    }
    /**
	 * 获取：借阅部领导
	 */
    public Integer getJieyuebuId() {
        return jieyuebuId;
    }


    /**
	 * 设置：借阅部领导
	 */
    public void setJieyuebuId(Integer jieyuebuId) {
        this.jieyuebuId = jieyuebuId;
    }
    /**
	 * 获取：借阅部领导审批类型
	 */
    public Integer getJieyuebuTypes() {
        return jieyuebuTypes;
    }


    /**
	 * 设置：借阅部领导审批类型
	 */
    public void setJieyuebuTypes(Integer jieyuebuTypes) {
        this.jieyuebuTypes = jieyuebuTypes;
    }
    /**
	 * 获取：借阅部领导审批意见
	 */
    public String getJieyuebuContent() {
        return jieyuebuContent;
    }


    /**
	 * 设置：借阅部领导审批意见
	 */
    public void setJieyuebuContent(String jieyuebuContent) {
        this.jieyuebuContent = jieyuebuContent;
    }
    /**
	 * 获取：借阅部领导审批时间
	 */
    public Date getJieyuebuTime() {
        return jieyuebuTime;
    }


    /**
	 * 设置：借阅部领导审批时间
	 */
    public void setJieyuebuTime(Date jieyuebuTime) {
        this.jieyuebuTime = jieyuebuTime;
    }
    /**
	 * 获取：主管领导
	 */
    public Integer getZhuguanId() {
        return zhuguanId;
    }


    /**
	 * 设置：主管领导
	 */
    public void setZhuguanId(Integer zhuguanId) {
        this.zhuguanId = zhuguanId;
    }
    /**
	 * 获取：主管领导审批类型
	 */
    public Integer getZhuguanTypes() {
        return zhuguanTypes;
    }


    /**
	 * 设置：主管领导审批类型
	 */
    public void setZhuguanTypes(Integer zhuguanTypes) {
        this.zhuguanTypes = zhuguanTypes;
    }
    /**
	 * 获取：主管领导审批意见
	 */
    public String getZhuguanContent() {
        return zhuguanContent;
    }


    /**
	 * 设置：主管领导审批意见
	 */
    public void setZhuguanContent(String zhuguanContent) {
        this.zhuguanContent = zhuguanContent;
    }
    /**
	 * 获取：主管领导审批时间
	 */
    public Date getZhuguanTime() {
        return zhuguanTime;
    }


    /**
	 * 设置：主管领导审批时间
	 */
    public void setZhuguanTime(Date zhuguanTime) {
        this.zhuguanTime = zhuguanTime;
    }
    /**
	 * 获取：综合部主任
	 */
    public Integer getZhurenId() {
        return zhurenId;
    }


    /**
	 * 设置：综合部主任
	 */
    public void setZhurenId(Integer zhurenId) {
        this.zhurenId = zhurenId;
    }
    /**
	 * 获取：综合部主任审批类型
	 */
    public Integer getZhurenTypes() {
        return zhurenTypes;
    }


    /**
	 * 设置：综合部主任审批类型
	 */
    public void setZhurenTypes(Integer zhurenTypes) {
        this.zhurenTypes = zhurenTypes;
    }
    /**
	 * 获取：综合部主任审批意见
	 */
    public String getZhurenContent() {
        return zhurenContent;
    }


    /**
	 * 设置：综合部主任审批意见
	 */
    public void setZhurenContent(String zhurenContent) {
        this.zhurenContent = zhurenContent;
    }
    /**
	 * 获取：综合部主任审批时间
	 */
    public Date getZhurenTime() {
        return zhurenTime;
    }


    /**
	 * 设置：综合部主任审批时间
	 */
    public void setZhurenTime(Date zhurenTime) {
        this.zhurenTime = zhurenTime;
    }
    /**
	 * 获取：文书档案专责人员
	 */
    public Integer getWenshudanganId() {
        return wenshudanganId;
    }


    /**
	 * 设置：文书档案专责人员
	 */
    public void setWenshudanganId(Integer wenshudanganId) {
        this.wenshudanganId = wenshudanganId;
    }
    /**
	 * 获取：文书档案专责人员审批类型
	 */
    public Integer getWenshudanganTypes() {
        return wenshudanganTypes;
    }


    /**
	 * 设置：文书档案专责人员审批类型
	 */
    public void setWenshudanganTypes(Integer wenshudanganTypes) {
        this.wenshudanganTypes = wenshudanganTypes;
    }
    /**
	 * 获取：文书档案专责人员审批意见
	 */
    public String getWenshudanganContent() {
        return wenshudanganContent;
    }


    /**
	 * 设置：文书档案专责人员审批意见
	 */
    public void setWenshudanganContent(String wenshudanganContent) {
        this.wenshudanganContent = wenshudanganContent;
    }
    /**
	 * 获取：文书档案专责人员审批时间
	 */
    public Date getWenshudanganTime() {
        return wenshudanganTime;
    }


    /**
	 * 设置：文书档案专责人员审批时间
	 */
    public void setWenshudanganTime(Date wenshudanganTime) {
        this.wenshudanganTime = wenshudanganTime;
    }
    /**
	 * 获取：经办人
	 */
    public String getJingbanren() {
        return jingbanren;
    }


    /**
	 * 设置：经办人
	 */
    public void setJingbanren(String jingbanren) {
        this.jingbanren = jingbanren;
    }
    /**
	 * 获取：经办时间
	 */
    public Date getJingbanrenTime() {
        return jingbanrenTime;
    }


    /**
	 * 设置：经办时间
	 */
    public void setJingbanrenTime(Date jingbanrenTime) {
        this.jingbanrenTime = jingbanrenTime;
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

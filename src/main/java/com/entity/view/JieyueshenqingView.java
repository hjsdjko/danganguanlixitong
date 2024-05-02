package com.entity.view;

import com.entity.JieyueshenqingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 借阅申请
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jieyueshenqing")
public class JieyueshenqingView extends JieyueshenqingEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 借阅部门的值
		*/
		private String bumenValue;
		/**
		* 借阅部领导审批类型的值
		*/
		private String jieyuebuValue;
		/**
		* 主管领导审批类型的值
		*/
		private String zhuguanValue;
		/**
		* 综合部主任审批类型的值
		*/
		private String zhurenValue;
		/**
		* 文书档案专责人员审批类型的值
		*/
		private String wenshudanganValue;



		//级联表 dangan
			/**
			* 档案编号
			*/
			private String danganBianhao;
			/**
			* 档案名称
			*/
			private String danganName;
			/**
			* 档案类型
			*/
			private Integer danganTypes;
				/**
				* 档案类型的值
				*/
				private String danganValue;
			/**
			* 档案图片
			*/
			private String danganPhoto;
			/**
			* 档案详情
			*/
			private String danganContent;
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
			@DateTimeFormat
			/**
			* 添加时间
			*/
			private Date insertTime;

		//级联表 jieyuebu
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

		//级联表 wenshudangan
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

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 单位
			*/
			private String yonghuDanwei;
			/**
			* 用户照片
			*/
			private String yonghuPhoto;

		//级联表 zhuguan
			/**
			* 主管领导姓名
			*/
			private String zhuguanName;
			/**
			* 主管领导手机号
			*/
			private String zhuguanPhone;
			/**
			* 主管领导身份证号
			*/
			private String zhuguanIdNumber;
			/**
			* 主管领导照片
			*/
			private String zhuguanPhoto;

		//级联表 zhuren
			/**
			* 综合部主任姓名
			*/
			private String zhurenName;
			/**
			* 综合部主任手机号
			*/
			private String zhurenPhone;
			/**
			* 综合部主任身份证号
			*/
			private String zhurenIdNumber;
			/**
			* 综合部主任照片
			*/
			private String zhurenPhoto;

	public JieyueshenqingView() {

	}

	public JieyueshenqingView(JieyueshenqingEntity jieyueshenqingEntity) {
		try {
			BeanUtils.copyProperties(this, jieyueshenqingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 借阅部门的值
			*/
			public String getBumenValue() {
				return bumenValue;
			}
			/**
			* 设置： 借阅部门的值
			*/
			public void setBumenValue(String bumenValue) {
				this.bumenValue = bumenValue;
			}
			/**
			* 获取： 借阅部领导审批类型的值
			*/
			public String getJieyuebuValue() {
				return jieyuebuValue;
			}
			/**
			* 设置： 借阅部领导审批类型的值
			*/
			public void setJieyuebuValue(String jieyuebuValue) {
				this.jieyuebuValue = jieyuebuValue;
			}
			/**
			* 获取： 主管领导审批类型的值
			*/
			public String getZhuguanValue() {
				return zhuguanValue;
			}
			/**
			* 设置： 主管领导审批类型的值
			*/
			public void setZhuguanValue(String zhuguanValue) {
				this.zhuguanValue = zhuguanValue;
			}
			/**
			* 获取： 综合部主任审批类型的值
			*/
			public String getZhurenValue() {
				return zhurenValue;
			}
			/**
			* 设置： 综合部主任审批类型的值
			*/
			public void setZhurenValue(String zhurenValue) {
				this.zhurenValue = zhurenValue;
			}
			/**
			* 获取： 文书档案专责人员审批类型的值
			*/
			public String getWenshudanganValue() {
				return wenshudanganValue;
			}
			/**
			* 设置： 文书档案专责人员审批类型的值
			*/
			public void setWenshudanganValue(String wenshudanganValue) {
				this.wenshudanganValue = wenshudanganValue;
			}





				//级联表的get和set dangan
					/**
					* 获取： 档案编号
					*/
					public String getDanganBianhao() {
						return danganBianhao;
					}
					/**
					* 设置： 档案编号
					*/
					public void setDanganBianhao(String danganBianhao) {
						this.danganBianhao = danganBianhao;
					}
					/**
					* 获取： 档案名称
					*/
					public String getDanganName() {
						return danganName;
					}
					/**
					* 设置： 档案名称
					*/
					public void setDanganName(String danganName) {
						this.danganName = danganName;
					}
					/**
					* 获取： 档案类型
					*/
					public Integer getDanganTypes() {
						return danganTypes;
					}
					/**
					* 设置： 档案类型
					*/
					public void setDanganTypes(Integer danganTypes) {
						this.danganTypes = danganTypes;
					}


						/**
						* 获取： 档案类型的值
						*/
						public String getDanganValue() {
							return danganValue;
						}
						/**
						* 设置： 档案类型的值
						*/
						public void setDanganValue(String danganValue) {
							this.danganValue = danganValue;
						}
					/**
					* 获取： 档案图片
					*/
					public String getDanganPhoto() {
						return danganPhoto;
					}
					/**
					* 设置： 档案图片
					*/
					public void setDanganPhoto(String danganPhoto) {
						this.danganPhoto = danganPhoto;
					}
					/**
					* 获取： 档案详情
					*/
					public String getDanganContent() {
						return danganContent;
					}
					/**
					* 设置： 档案详情
					*/
					public void setDanganContent(String danganContent) {
						this.danganContent = danganContent;
					}
					/**
					* 获取： 添加时间
					*/
					public Date getInsertTime() {
						return insertTime;
					}
					/**
					* 设置： 添加时间
					*/
					public void setInsertTime(Date insertTime) {
						this.insertTime = insertTime;
					}






















				//级联表的get和set jieyuebu
					/**
					* 获取： 借阅部领导姓名
					*/
					public String getJieyuebuName() {
						return jieyuebuName;
					}
					/**
					* 设置： 借阅部领导姓名
					*/
					public void setJieyuebuName(String jieyuebuName) {
						this.jieyuebuName = jieyuebuName;
					}
					/**
					* 获取： 借阅部领导手机号
					*/
					public String getJieyuebuPhone() {
						return jieyuebuPhone;
					}
					/**
					* 设置： 借阅部领导手机号
					*/
					public void setJieyuebuPhone(String jieyuebuPhone) {
						this.jieyuebuPhone = jieyuebuPhone;
					}
					/**
					* 获取： 借阅部领导身份证号
					*/
					public String getJieyuebuIdNumber() {
						return jieyuebuIdNumber;
					}
					/**
					* 设置： 借阅部领导身份证号
					*/
					public void setJieyuebuIdNumber(String jieyuebuIdNumber) {
						this.jieyuebuIdNumber = jieyuebuIdNumber;
					}
					/**
					* 获取： 借阅部领导照片
					*/
					public String getJieyuebuPhoto() {
						return jieyuebuPhoto;
					}
					/**
					* 设置： 借阅部领导照片
					*/
					public void setJieyuebuPhoto(String jieyuebuPhoto) {
						this.jieyuebuPhoto = jieyuebuPhoto;
					}

















				//级联表的get和set wenshudangan
					/**
					* 获取： 专责人员姓名
					*/
					public String getWenshudanganName() {
						return wenshudanganName;
					}
					/**
					* 设置： 专责人员姓名
					*/
					public void setWenshudanganName(String wenshudanganName) {
						this.wenshudanganName = wenshudanganName;
					}
					/**
					* 获取： 专责人员手机号
					*/
					public String getWenshudanganPhone() {
						return wenshudanganPhone;
					}
					/**
					* 设置： 专责人员手机号
					*/
					public void setWenshudanganPhone(String wenshudanganPhone) {
						this.wenshudanganPhone = wenshudanganPhone;
					}
					/**
					* 获取： 专责人员身份证号
					*/
					public String getWenshudanganIdNumber() {
						return wenshudanganIdNumber;
					}
					/**
					* 设置： 专责人员身份证号
					*/
					public void setWenshudanganIdNumber(String wenshudanganIdNumber) {
						this.wenshudanganIdNumber = wenshudanganIdNumber;
					}
					/**
					* 获取： 专责人员照片
					*/
					public String getWenshudanganPhoto() {
						return wenshudanganPhoto;
					}
					/**
					* 设置： 专责人员照片
					*/
					public void setWenshudanganPhoto(String wenshudanganPhoto) {
						this.wenshudanganPhoto = wenshudanganPhoto;
					}


				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 单位
					*/
					public String getYonghuDanwei() {
						return yonghuDanwei;
					}
					/**
					* 设置： 单位
					*/
					public void setYonghuDanwei(String yonghuDanwei) {
						this.yonghuDanwei = yonghuDanwei;
					}
					/**
					* 获取： 用户照片
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 用户照片
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}










				//级联表的get和set zhuguan
					/**
					* 获取： 主管领导姓名
					*/
					public String getZhuguanName() {
						return zhuguanName;
					}
					/**
					* 设置： 主管领导姓名
					*/
					public void setZhuguanName(String zhuguanName) {
						this.zhuguanName = zhuguanName;
					}
					/**
					* 获取： 主管领导手机号
					*/
					public String getZhuguanPhone() {
						return zhuguanPhone;
					}
					/**
					* 设置： 主管领导手机号
					*/
					public void setZhuguanPhone(String zhuguanPhone) {
						this.zhuguanPhone = zhuguanPhone;
					}
					/**
					* 获取： 主管领导身份证号
					*/
					public String getZhuguanIdNumber() {
						return zhuguanIdNumber;
					}
					/**
					* 设置： 主管领导身份证号
					*/
					public void setZhuguanIdNumber(String zhuguanIdNumber) {
						this.zhuguanIdNumber = zhuguanIdNumber;
					}
					/**
					* 获取： 主管领导照片
					*/
					public String getZhuguanPhoto() {
						return zhuguanPhoto;
					}
					/**
					* 设置： 主管领导照片
					*/
					public void setZhuguanPhoto(String zhuguanPhoto) {
						this.zhuguanPhoto = zhuguanPhoto;
					}








				//级联表的get和set zhuren
					/**
					* 获取： 综合部主任姓名
					*/
					public String getZhurenName() {
						return zhurenName;
					}
					/**
					* 设置： 综合部主任姓名
					*/
					public void setZhurenName(String zhurenName) {
						this.zhurenName = zhurenName;
					}
					/**
					* 获取： 综合部主任手机号
					*/
					public String getZhurenPhone() {
						return zhurenPhone;
					}
					/**
					* 设置： 综合部主任手机号
					*/
					public void setZhurenPhone(String zhurenPhone) {
						this.zhurenPhone = zhurenPhone;
					}
					/**
					* 获取： 综合部主任身份证号
					*/
					public String getZhurenIdNumber() {
						return zhurenIdNumber;
					}
					/**
					* 设置： 综合部主任身份证号
					*/
					public void setZhurenIdNumber(String zhurenIdNumber) {
						this.zhurenIdNumber = zhurenIdNumber;
					}
					/**
					* 获取： 综合部主任照片
					*/
					public String getZhurenPhoto() {
						return zhurenPhoto;
					}
					/**
					* 设置： 综合部主任照片
					*/
					public void setZhurenPhoto(String zhurenPhoto) {
						this.zhurenPhoto = zhurenPhoto;
					}








}

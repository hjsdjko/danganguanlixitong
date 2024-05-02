package com.entity.view;

import com.entity.DanganEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 档案
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("dangan")
public class DanganView extends DanganEntity implements Serializable {
    private static final long serialVersionUID = 1L;
		/**
		* 档案类型的值
		*/
		private String danganValue;



	public DanganView() {

	}

	public DanganView(DanganEntity danganEntity) {
		try {
			BeanUtils.copyProperties(this, danganEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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












}

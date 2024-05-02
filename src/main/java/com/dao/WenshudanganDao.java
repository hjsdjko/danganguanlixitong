package com.dao;

import com.entity.WenshudanganEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.WenshudanganView;

/**
 * 文书档案专责人员 Dao 接口
 *
 * @author 
 */
public interface WenshudanganDao extends BaseMapper<WenshudanganEntity> {

   List<WenshudanganView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

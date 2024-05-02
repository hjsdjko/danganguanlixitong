package com.dao;

import com.entity.JieyuebuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JieyuebuView;

/**
 * 借阅部领导 Dao 接口
 *
 * @author 
 */
public interface JieyuebuDao extends BaseMapper<JieyuebuEntity> {

   List<JieyuebuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

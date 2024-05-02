package com.dao;

import com.entity.ZhurenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhurenView;

/**
 * 综合部主任 Dao 接口
 *
 * @author 
 */
public interface ZhurenDao extends BaseMapper<ZhurenEntity> {

   List<ZhurenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}

package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhuguanEntity;
import java.util.Map;

/**
 * 主管领导 服务类
 */
public interface ZhuguanService extends IService<ZhuguanEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
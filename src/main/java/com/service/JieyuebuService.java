package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JieyuebuEntity;
import java.util.Map;

/**
 * 借阅部领导 服务类
 */
public interface JieyuebuService extends IService<JieyuebuEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhurenEntity;
import java.util.Map;

/**
 * 综合部主任 服务类
 */
public interface ZhurenService extends IService<ZhurenEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
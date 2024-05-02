package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WenshudanganEntity;
import java.util.Map;

/**
 * 文书档案专责人员 服务类
 */
public interface WenshudanganService extends IService<WenshudanganEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}
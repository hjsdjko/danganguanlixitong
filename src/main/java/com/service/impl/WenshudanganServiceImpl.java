package com.service.impl;

import com.utils.StringUtil;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;

import com.dao.WenshudanganDao;
import com.entity.WenshudanganEntity;
import com.service.WenshudanganService;
import com.entity.view.WenshudanganView;

/**
 * 文书档案专责人员 服务实现类
 */
@Service("wenshudanganService")
@Transactional
public class WenshudanganServiceImpl extends ServiceImpl<WenshudanganDao, WenshudanganEntity> implements WenshudanganService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<WenshudanganView> page =new Query<WenshudanganView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}

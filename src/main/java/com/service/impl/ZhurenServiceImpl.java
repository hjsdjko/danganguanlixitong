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

import com.dao.ZhurenDao;
import com.entity.ZhurenEntity;
import com.service.ZhurenService;
import com.entity.view.ZhurenView;

/**
 * 综合部主任 服务实现类
 */
@Service("zhurenService")
@Transactional
public class ZhurenServiceImpl extends ServiceImpl<ZhurenDao, ZhurenEntity> implements ZhurenService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ZhurenView> page =new Query<ZhurenView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}

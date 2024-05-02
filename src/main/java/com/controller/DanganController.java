package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.DanganEntity;

import com.service.DanganService;
import com.entity.view.DanganView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 档案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/dangan")
public class DanganController {
    private static final Logger logger = LoggerFactory.getLogger(DanganController.class);

    @Autowired
    private DanganService danganService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
     
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isNotEmpty(role) && "用户".equals(role)){
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        }
        params.put("orderBy","id");
        PageUtils page = danganService.queryPage(params);

        //字典表数据转换
        List<DanganView> list =(List<DanganView>)page.getList();
        for(DanganView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        DanganEntity dangan = danganService.selectById(id);
        if(dangan !=null){
            //entity转view
            DanganView view = new DanganView();
            BeanUtils.copyProperties( dangan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody DanganEntity dangan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,dangan:{}",this.getClass().getName(),dangan.toString());
        Wrapper<DanganEntity> queryWrapper = new EntityWrapper<DanganEntity>()
            .eq("dangan_bianhao", dangan.getDanganBianhao())
            .eq("dangan_name", dangan.getDanganName())
            .eq("dangan_types", dangan.getDanganTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanganEntity danganEntity = danganService.selectOne(queryWrapper);
        if(danganEntity==null){
            dangan.setInsertTime(new Date());
            dangan.setCreateTime(new Date());
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      dangan.set
        //  }
            danganService.insert(dangan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody DanganEntity dangan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,dangan:{}",this.getClass().getName(),dangan.toString());
        //根据字段查询是否有相同数据
        Wrapper<DanganEntity> queryWrapper = new EntityWrapper<DanganEntity>()
            .notIn("id",dangan.getId())
            .andNew()
            .eq("dangan_bianhao", dangan.getDanganBianhao())
            .eq("dangan_name", dangan.getDanganName())
            .eq("dangan_types", dangan.getDanganTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        DanganEntity danganEntity = danganService.selectOne(queryWrapper);
        if("".equals(dangan.getDanganPhoto()) || "null".equals(dangan.getDanganPhoto())){
                dangan.setDanganPhoto(null);
        }
        if(danganEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      dangan.set
            //  }
            danganService.updateById(dangan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        danganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}


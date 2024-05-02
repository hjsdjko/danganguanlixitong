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

import com.entity.JieyueshenqingEntity;

import com.service.JieyueshenqingService;
import com.entity.view.JieyueshenqingView;
import com.service.DanganService;
import com.entity.DanganEntity;
import com.service.JieyuebuService;
import com.entity.JieyuebuEntity;
import com.service.WenshudanganService;
import com.entity.WenshudanganEntity;
import com.service.YonghuService;
import com.entity.YonghuEntity;
import com.service.ZhuguanService;
import com.entity.ZhuguanEntity;
import com.service.ZhurenService;
import com.entity.ZhurenEntity;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 借阅申请
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jieyueshenqing")
public class JieyueshenqingController {
    private static final Logger logger = LoggerFactory.getLogger(JieyueshenqingController.class);

    @Autowired
    private JieyueshenqingService jieyueshenqingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private DanganService danganService;
    @Autowired
    private JieyuebuService jieyuebuService;
    @Autowired
    private WenshudanganService wenshudanganService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ZhuguanService zhuguanService;
    @Autowired
    private ZhurenService zhurenService;


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
//        else if(StringUtil.isNotEmpty(role) && "借阅部领导".equals(role)){
//            params.put("jieyuebuTypes",1);
//        }else if(StringUtil.isNotEmpty(role) && "主管领导".equals(role)){
//            params.put("zhuguanTypes",1);
//        }else if(StringUtil.isNotEmpty(role) && "综合部主任".equals(role)){
//            params.put("zhurenTypes",1);
//        }else if(StringUtil.isNotEmpty(role) && "文书档案专责人员".equals(role)){
//            params.put("wenshudanganTypes",1);
//        }
        params.put("orderBy","id");
        PageUtils page = jieyueshenqingService.queryPage(params);

        //字典表数据转换
        List<JieyueshenqingView> list =(List<JieyueshenqingView>)page.getList();
        for(JieyueshenqingView c:list){
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
        JieyueshenqingEntity jieyueshenqing = jieyueshenqingService.selectById(id);
        if(jieyueshenqing !=null){
            //entity转view
            JieyueshenqingView view = new JieyueshenqingView();
            BeanUtils.copyProperties( jieyueshenqing , view );//把实体数据重构到view中

            //级联表
            DanganEntity dangan = danganService.selectById(jieyueshenqing.getDanganId());
            if(dangan != null){
                BeanUtils.copyProperties( dangan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setDanganId(dangan.getId());
            }
            //级联表
            JieyuebuEntity jieyuebu = jieyuebuService.selectById(jieyueshenqing.getJieyuebuId());
            if(jieyuebu != null){
                BeanUtils.copyProperties( jieyuebu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setJieyuebuId(jieyuebu.getId());
            }
            //级联表
            WenshudanganEntity wenshudangan = wenshudanganService.selectById(jieyueshenqing.getWenshudanganId());
            if(wenshudangan != null){
                BeanUtils.copyProperties( wenshudangan , view ,new String[]{ "id", "createDate", "setTypes"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setWenshudanganId(wenshudangan.getId());
            }
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jieyueshenqing.getYonghuId());
            if(yonghu != null){
                BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate", "setTypes"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYonghuId(yonghu.getId());
            }
            //级联表
            ZhuguanEntity zhuguan = zhuguanService.selectById(jieyueshenqing.getZhuguanId());
            if(zhuguan != null){
                BeanUtils.copyProperties( zhuguan , view ,new String[]{ "id", "createDate", "setTypes"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setZhuguanId(zhuguan.getId());
            }
            //级联表
            ZhurenEntity zhuren = zhurenService.selectById(jieyueshenqing.getZhurenId());
            if(zhuren != null){
                BeanUtils.copyProperties( zhuren , view ,new String[]{ "id", "createDate", "setTypes"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setZhurenId(zhuren.getId());
            }
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
    public R save(@RequestBody JieyueshenqingEntity jieyueshenqing, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jieyueshenqing:{}",this.getClass().getName(),jieyueshenqing.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            jieyueshenqing.setJieyuebuTypes(1);
            jieyueshenqing.setInsertTime(new Date());
            jieyueshenqing.setCreateTime(new Date());
            jieyueshenqing.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            jieyueshenqingService.insert(jieyueshenqing);
        }
        return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JieyueshenqingEntity jieyueshenqing, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jieyueshenqing:{}",this.getClass().getName(),jieyueshenqing.toString());
//        return R.ok();

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("借阅部领导".equals(role)){
            if(jieyueshenqing.getJieyuebuTypes() == 2){
                jieyueshenqing.setZhuguanTypes(1);
            }
            jieyueshenqing.setJieyuebuTime(new Date());
            jieyueshenqing.setJieyuebuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }else if("主管领导".equals(role)){
            if(jieyueshenqing.getZhuguanTypes() == 2){
                jieyueshenqing.setZhurenTypes(1);
            }
            jieyueshenqing.setZhuguanTime(new Date());
            jieyueshenqing.setZhuguanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }else if("综合部主任".equals(role)){
            if(jieyueshenqing.getZhurenTypes() == 2){
                jieyueshenqing.setWenshudanganTypes(1);
            }
            jieyueshenqing.setZhurenTime(new Date());
            jieyueshenqing.setZhurenId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }else if("文书档案专责人员".equals(role)){
            jieyueshenqing.setWenshudanganTime(new Date());
            jieyueshenqing.setWenshudanganId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        }
        jieyueshenqingService.updateById(jieyueshenqing);//根据id更新
        return R.ok();

    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jieyueshenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}


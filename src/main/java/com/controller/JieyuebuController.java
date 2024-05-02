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

import com.entity.JieyuebuEntity;

import com.service.JieyuebuService;
import com.entity.view.JieyuebuView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 借阅部领导
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jieyuebu")
public class JieyuebuController {
    private static final Logger logger = LoggerFactory.getLogger(JieyuebuController.class);

    @Autowired
    private JieyuebuService jieyuebuService;


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
        PageUtils page = jieyuebuService.queryPage(params);

        //字典表数据转换
        List<JieyuebuView> list =(List<JieyuebuView>)page.getList();
        for(JieyuebuView c:list){
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
        JieyuebuEntity jieyuebu = jieyuebuService.selectById(id);
        if(jieyuebu !=null){
            //entity转view
            JieyuebuView view = new JieyuebuView();
            BeanUtils.copyProperties( jieyuebu , view );//把实体数据重构到view中

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
    public R save(@RequestBody JieyuebuEntity jieyuebu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jieyuebu:{}",this.getClass().getName(),jieyuebu.toString());
        Wrapper<JieyuebuEntity> queryWrapper = new EntityWrapper<JieyuebuEntity>()
            .eq("username", jieyuebu.getUsername())
            .or()
            .eq("jieyuebu_phone", jieyuebu.getJieyuebuPhone())
            .or()
            .eq("jieyuebu_id_number", jieyuebu.getJieyuebuIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JieyuebuEntity jieyuebuEntity = jieyuebuService.selectOne(queryWrapper);
        if(jieyuebuEntity==null){
            jieyuebu.setCreateTime(new Date());
            jieyuebu.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      jieyuebu.set
        //  }
            jieyuebuService.insert(jieyuebu);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JieyuebuEntity jieyuebu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jieyuebu:{}",this.getClass().getName(),jieyuebu.toString());
        //根据字段查询是否有相同数据
        Wrapper<JieyuebuEntity> queryWrapper = new EntityWrapper<JieyuebuEntity>()
            .notIn("id",jieyuebu.getId())
            .andNew()
            .eq("username", jieyuebu.getUsername())
            .or()
            .eq("jieyuebu_phone", jieyuebu.getJieyuebuPhone())
            .or()
            .eq("jieyuebu_id_number", jieyuebu.getJieyuebuIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JieyuebuEntity jieyuebuEntity = jieyuebuService.selectOne(queryWrapper);
        if("".equals(jieyuebu.getJieyuebuPhoto()) || "null".equals(jieyuebu.getJieyuebuPhoto())){
                jieyuebu.setJieyuebuPhoto(null);
        }
        if(jieyuebuEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      jieyuebu.set
            //  }
            jieyuebuService.updateById(jieyuebu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        jieyuebuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JieyuebuEntity jieyuebu = jieyuebuService.selectOne(new EntityWrapper<JieyuebuEntity>().eq("username", username));
        if(jieyuebu==null || !jieyuebu.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(jieyuebu.getId(),username, "jieyuebu", "借阅部领导");
        R r = R.ok();
        r.put("token", token);
        r.put("role","借阅部领导");
        r.put("username",jieyuebu.getJieyuebuName());
        r.put("tableName","jieyuebu");
        r.put("userId",jieyuebu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JieyuebuEntity jieyuebu){
    //    	ValidatorUtils.validateEntity(user);
        if(jieyuebuService.selectOne(new EntityWrapper<JieyuebuEntity>().eq("username", jieyuebu.getUsername()).orNew().eq("jieyuebu_phone",jieyuebu.getJieyuebuPhone()).orNew().eq("jieyuebu_id_number",jieyuebu.getJieyuebuIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        jieyuebu.setCreateTime(new Date());
        jieyuebuService.insert(jieyuebu);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JieyuebuEntity jieyuebu = new JieyuebuEntity();
        jieyuebu.setPassword("123456");
        jieyuebu.setId(id);
        jieyuebuService.updateById(jieyuebu);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJieyuebu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JieyuebuEntity jieyuebu = jieyuebuService.selectById(id);
        return R.ok().put("data", jieyuebu);
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}


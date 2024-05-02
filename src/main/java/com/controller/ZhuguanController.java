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

import com.entity.ZhuguanEntity;

import com.service.ZhuguanService;
import com.entity.view.ZhuguanView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 主管领导
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhuguan")
public class ZhuguanController {
    private static final Logger logger = LoggerFactory.getLogger(ZhuguanController.class);

    @Autowired
    private ZhuguanService zhuguanService;


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
        PageUtils page = zhuguanService.queryPage(params);

        //字典表数据转换
        List<ZhuguanView> list =(List<ZhuguanView>)page.getList();
        for(ZhuguanView c:list){
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
        ZhuguanEntity zhuguan = zhuguanService.selectById(id);
        if(zhuguan !=null){
            //entity转view
            ZhuguanView view = new ZhuguanView();
            BeanUtils.copyProperties( zhuguan , view );//把实体数据重构到view中

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
    public R save(@RequestBody ZhuguanEntity zhuguan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuguan:{}",this.getClass().getName(),zhuguan.toString());
        Wrapper<ZhuguanEntity> queryWrapper = new EntityWrapper<ZhuguanEntity>()
            .eq("username", zhuguan.getUsername())
            .or()
            .eq("zhuguan_phone", zhuguan.getZhuguanPhone())
            .or()
            .eq("zhuguan_id_number", zhuguan.getZhuguanIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuguanEntity zhuguanEntity = zhuguanService.selectOne(queryWrapper);
        if(zhuguanEntity==null){
            zhuguan.setCreateTime(new Date());
            zhuguan.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zhuguan.set
        //  }
            zhuguanService.insert(zhuguan);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhuguanEntity zhuguan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhuguan:{}",this.getClass().getName(),zhuguan.toString());
        //根据字段查询是否有相同数据
        Wrapper<ZhuguanEntity> queryWrapper = new EntityWrapper<ZhuguanEntity>()
            .notIn("id",zhuguan.getId())
            .andNew()
            .eq("username", zhuguan.getUsername())
            .or()
            .eq("zhuguan_phone", zhuguan.getZhuguanPhone())
            .or()
            .eq("zhuguan_id_number", zhuguan.getZhuguanIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhuguanEntity zhuguanEntity = zhuguanService.selectOne(queryWrapper);
        if("".equals(zhuguan.getZhuguanPhoto()) || "null".equals(zhuguan.getZhuguanPhoto())){
                zhuguan.setZhuguanPhoto(null);
        }
        if(zhuguanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zhuguan.set
            //  }
            zhuguanService.updateById(zhuguan);//根据id更新
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
        zhuguanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhuguanEntity zhuguan = zhuguanService.selectOne(new EntityWrapper<ZhuguanEntity>().eq("username", username));
        if(zhuguan==null || !zhuguan.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(zhuguan.getId(),username, "zhuguan", "主管领导");
        R r = R.ok();
        r.put("token", token);
        r.put("role","主管领导");
        r.put("username",zhuguan.getZhuguanName());
        r.put("tableName","zhuguan");
        r.put("userId",zhuguan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhuguanEntity zhuguan){
    //    	ValidatorUtils.validateEntity(user);
        if(zhuguanService.selectOne(new EntityWrapper<ZhuguanEntity>().eq("username", zhuguan.getUsername()).orNew().eq("zhuguan_phone",zhuguan.getZhuguanPhone()).orNew().eq("zhuguan_id_number",zhuguan.getZhuguanIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        zhuguan.setCreateTime(new Date());
        zhuguanService.insert(zhuguan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ZhuguanEntity zhuguan = new ZhuguanEntity();
        zhuguan.setPassword("123456");
        zhuguan.setId(id);
        zhuguanService.updateById(zhuguan);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhuguan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhuguanEntity zhuguan = zhuguanService.selectById(id);
        return R.ok().put("data", zhuguan);
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


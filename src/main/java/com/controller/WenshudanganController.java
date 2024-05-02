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

import com.entity.WenshudanganEntity;

import com.service.WenshudanganService;
import com.entity.view.WenshudanganView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 文书档案专责人员
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/wenshudangan")
public class WenshudanganController {
    private static final Logger logger = LoggerFactory.getLogger(WenshudanganController.class);

    @Autowired
    private WenshudanganService wenshudanganService;


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
        PageUtils page = wenshudanganService.queryPage(params);

        //字典表数据转换
        List<WenshudanganView> list =(List<WenshudanganView>)page.getList();
        for(WenshudanganView c:list){
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
        WenshudanganEntity wenshudangan = wenshudanganService.selectById(id);
        if(wenshudangan !=null){
            //entity转view
            WenshudanganView view = new WenshudanganView();
            BeanUtils.copyProperties( wenshudangan , view );//把实体数据重构到view中

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
    public R save(@RequestBody WenshudanganEntity wenshudangan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,wenshudangan:{}",this.getClass().getName(),wenshudangan.toString());
        Wrapper<WenshudanganEntity> queryWrapper = new EntityWrapper<WenshudanganEntity>()
            .eq("username", wenshudangan.getUsername())
            .or()
            .eq("wenshudangan_phone", wenshudangan.getWenshudanganPhone())
            .or()
            .eq("wenshudangan_id_number", wenshudangan.getWenshudanganIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenshudanganEntity wenshudanganEntity = wenshudanganService.selectOne(queryWrapper);
        if(wenshudanganEntity==null){
            wenshudangan.setCreateTime(new Date());
            wenshudangan.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      wenshudangan.set
        //  }
            wenshudanganService.insert(wenshudangan);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody WenshudanganEntity wenshudangan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,wenshudangan:{}",this.getClass().getName(),wenshudangan.toString());
        //根据字段查询是否有相同数据
        Wrapper<WenshudanganEntity> queryWrapper = new EntityWrapper<WenshudanganEntity>()
            .notIn("id",wenshudangan.getId())
            .andNew()
            .eq("username", wenshudangan.getUsername())
            .or()
            .eq("wenshudangan_phone", wenshudangan.getWenshudanganPhone())
            .or()
            .eq("wenshudangan_id_number", wenshudangan.getWenshudanganIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        WenshudanganEntity wenshudanganEntity = wenshudanganService.selectOne(queryWrapper);
        if("".equals(wenshudangan.getWenshudanganPhoto()) || "null".equals(wenshudangan.getWenshudanganPhoto())){
                wenshudangan.setWenshudanganPhoto(null);
        }
        if(wenshudanganEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      wenshudangan.set
            //  }
            wenshudanganService.updateById(wenshudangan);//根据id更新
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
        wenshudanganService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        WenshudanganEntity wenshudangan = wenshudanganService.selectOne(new EntityWrapper<WenshudanganEntity>().eq("username", username));
        if(wenshudangan==null || !wenshudangan.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(wenshudangan.getId(),username, "wenshudangan", "文书档案专责人员");
        R r = R.ok();
        r.put("token", token);
        r.put("role","文书档案专责人员");
        r.put("username",wenshudangan.getWenshudanganName());
        r.put("tableName","wenshudangan");
        r.put("userId",wenshudangan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody WenshudanganEntity wenshudangan){
    //    	ValidatorUtils.validateEntity(user);
        if(wenshudanganService.selectOne(new EntityWrapper<WenshudanganEntity>().eq("username", wenshudangan.getUsername()).orNew().eq("wenshudangan_phone",wenshudangan.getWenshudanganPhone()).orNew().eq("wenshudangan_id_number",wenshudangan.getWenshudanganIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        wenshudangan.setCreateTime(new Date());
        wenshudanganService.insert(wenshudangan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        WenshudanganEntity wenshudangan = new WenshudanganEntity();
        wenshudangan.setPassword("123456");
        wenshudangan.setId(id);
        wenshudanganService.updateById(wenshudangan);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrWenshudangan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        WenshudanganEntity wenshudangan = wenshudanganService.selectById(id);
        return R.ok().put("data", wenshudangan);
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


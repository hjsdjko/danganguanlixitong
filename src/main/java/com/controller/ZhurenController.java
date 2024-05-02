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

import com.entity.ZhurenEntity;

import com.service.ZhurenService;
import com.entity.view.ZhurenView;

import com.utils.PageUtils;
import com.utils.R;

/**
 * 综合部主任
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhuren")
public class ZhurenController {
    private static final Logger logger = LoggerFactory.getLogger(ZhurenController.class);

    @Autowired
    private ZhurenService zhurenService;


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
        PageUtils page = zhurenService.queryPage(params);

        //字典表数据转换
        List<ZhurenView> list =(List<ZhurenView>)page.getList();
        for(ZhurenView c:list){
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
        ZhurenEntity zhuren = zhurenService.selectById(id);
        if(zhuren !=null){
            //entity转view
            ZhurenView view = new ZhurenView();
            BeanUtils.copyProperties( zhuren , view );//把实体数据重构到view中

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
    public R save(@RequestBody ZhurenEntity zhuren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhuren:{}",this.getClass().getName(),zhuren.toString());
        Wrapper<ZhurenEntity> queryWrapper = new EntityWrapper<ZhurenEntity>()
            .eq("username", zhuren.getUsername())
            .or()
            .eq("zhuren_phone", zhuren.getZhurenPhone())
            .or()
            .eq("zhuren_id_number", zhuren.getZhurenIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhurenEntity zhurenEntity = zhurenService.selectOne(queryWrapper);
        if(zhurenEntity==null){
            zhuren.setCreateTime(new Date());
            zhuren.setPassword("123456");
        //  String role = String.valueOf(request.getSession().getAttribute("role"));
        //  if("".equals(role)){
        //      zhuren.set
        //  }
            zhurenService.insert(zhuren);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhurenEntity zhuren, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhuren:{}",this.getClass().getName(),zhuren.toString());
        //根据字段查询是否有相同数据
        Wrapper<ZhurenEntity> queryWrapper = new EntityWrapper<ZhurenEntity>()
            .notIn("id",zhuren.getId())
            .andNew()
            .eq("username", zhuren.getUsername())
            .or()
            .eq("zhuren_phone", zhuren.getZhurenPhone())
            .or()
            .eq("zhuren_id_number", zhuren.getZhurenIdNumber());
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhurenEntity zhurenEntity = zhurenService.selectOne(queryWrapper);
        if("".equals(zhuren.getZhurenPhoto()) || "null".equals(zhuren.getZhurenPhoto())){
                zhuren.setZhurenPhoto(null);
        }
        if(zhurenEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      zhuren.set
            //  }
            zhurenService.updateById(zhuren);//根据id更新
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
        zhurenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        ZhurenEntity zhuren = zhurenService.selectOne(new EntityWrapper<ZhurenEntity>().eq("username", username));
        if(zhuren==null || !zhuren.getPassword().equals(password)) {
            return R.error("账号或密码不正确");
        }
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(zhuren.getId(),username, "zhuren", "综合部主任");
        R r = R.ok();
        r.put("token", token);
        r.put("role","综合部主任");
        r.put("username",zhuren.getZhurenName());
        r.put("tableName","zhuren");
        r.put("userId",zhuren.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody ZhurenEntity zhuren){
    //    	ValidatorUtils.validateEntity(user);
        if(zhurenService.selectOne(new EntityWrapper<ZhurenEntity>().eq("username", zhuren.getUsername()).orNew().eq("zhuren_phone",zhuren.getZhurenPhone()).orNew().eq("zhuren_id_number",zhuren.getZhurenIdNumber())) !=null) {
            return R.error("账户已存在或手机号或身份证号已经被使用");
        }
        zhuren.setCreateTime(new Date());
        zhurenService.insert(zhuren);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        ZhurenEntity zhuren = new ZhurenEntity();
        zhuren.setPassword("123456");
        zhuren.setId(id);
        zhurenService.updateById(zhuren);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrZhuren(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        ZhurenEntity zhuren = zhurenService.selectById(id);
        return R.ok().put("data", zhuren);
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


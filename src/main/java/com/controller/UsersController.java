package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.*;
import com.service.*;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UsersController
 * @Description 用户模块控制层
 */
@RequestMapping("users")
@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    //前台-根据条件获取用户列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Users> manaQian(Users req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Users> usersList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(usersList);
    }

    //前台-根据条件获取我的用户列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Users> manaMyQian(Users req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Users> usersList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(usersList);
    }

    //前台-根据条件获取用户图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Users> manaQianTp(Users req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Users> usersList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(usersList);
    }

    //前台-用户详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Users> detail(@PathVariable("id") Integer id) {
        Users info = usersService.findById(id);
        return ApiResponse.success(info);
    }

    //前台-用户添加接口
    @IgnoreAuth
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Users req) {
        if (null == req.getLoginname() || req.getLoginname().equals("")) {
            return ApiResponse.failed("用户名loginname不能为空！");
        }
        //判断用户名loginname是否已存在
        Users instance = new Users();
        instance.setLoginname(req.getLoginname());
        instance = usersService.findOneByEqualTo(instance);
        if (null != instance && (null == req.getId() || req.getId() == 0) || (null != instance && !instance.getId().equals(req.getId()))) {
            return ApiResponse.failed("用户名" + req.getLoginname() + "已存在");
        }
        if (null != req.getLoginpw() && !req.getLoginpw().equals("")) {
            req.setLoginpw(Md5Util.strToMd5(req.getLoginpw()));
        } else {
            req.setLoginpw(null);
        }
        int result = usersService.saveOrUpdate(req);

        return ApiResponse.success(result);
    }

    //后台-根据条件获取用户管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Users> mana(Users req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Users> usersList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(usersList);
    }

    //后台-根据条件获取用户管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Users> manaMy(Users req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Users> usersList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(usersList);
    }

    //后台-根据条件获取用户查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Users> chakan(Users req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Users> usersList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(usersList);
    }

    //后台-根据条件获取用户查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Users> chakanMy(Users req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Users> usersList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(usersList);
    }

    //后台-用户详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Users> info(@PathVariable("id") Integer id) {
        Users info = usersService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-用户添加接口
    @IgnoreAuth
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Users req) {
        if (null == req.getLoginname() || req.getLoginname().equals("")) {
            return ApiResponse.failed("用户名loginname不能为空！");
        }
        //判断用户名是否已存在
        Users instance = new Users();
        instance.setLoginname(req.getLoginname());
        instance = usersService.findOneByEqualTo(instance);
        if (null != instance && (null == req.getId() || req.getId() == 0) || (null != instance && !instance.getId().equals(req.getId()))) {
            return ApiResponse.failed("用户名" + req.getLoginname() + "已存在");
        }
        if (null != req.getLoginpw() && !req.getLoginpw().equals("")) {
            req.setLoginpw(Md5Util.strToMd5(req.getLoginpw()));
        } else {
            req.setLoginpw(null);
        }
        int result = usersService.saveOrUpdate(req);

        return ApiResponse.success(result);
    }

    //用户删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = usersService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //用户修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Users req) {
//        if (null == req.getLoginname() || req.getLoginname().equals("")) {
//            return ApiResponse.failed("用户名loginname不能为空！");
//        }
        //判断用户名是否已存在
//        Users instance = new Users();
//        instance.setLoginname(req.getLoginname());
//        instance = usersService.findOneByEqualTo(instance);
//        if (null != instance && (null == req.getId() || req.getId() == 0) || (null != instance && !instance.getId().equals(req.getId()))) {
//            return ApiResponse.failed("用户名" + req.getLoginname() + "已存在");
//        }
//        if (null != req.getLoginpw() && !req.getLoginpw().equals("")) {
//            req.setLoginpw(Md5Util.strToMd5(req.getLoginpw()));
//        } else {
//            req.setLoginpw(null);
//        }
        int result = usersService.saveOrUpdate(req);

        return ApiResponse.success(result);
    }

    //获取当前登陆用户的个人信息
    @RequestMapping("/session")
    public ApiResponse<Users> getCurrUser(HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute("usersId");
        Users info = usersService.findById(id);
        return ApiResponse.success(info);
    }

    //用户重置密码接口
    @IgnoreAuth
    @RequestMapping("/resetPw")
    public ApiResponse<String> usersResetPw(@RequestBody Users req) {
        Users info = usersService.findOneByEqualTo(req);
        if (null == info || info.getId() == 0) {
            return ApiResponse.failed("请确认您的用户名、姓名和电话是否正确！");
        }
        info.setLoginpw(Md5Util.strToMd5("000000"));
        usersService.saveOrUpdate(info);
        return ApiResponse.success("您的密码已被重置为000000，如需修改，请登陆个人中心操作!");
    }

    //获取所有用户数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Users> usersAll() {
        List<Users> usersList = usersService.findAll();
        return ApiResponse.success(usersList);
    }

    //根据条件（字符类型模糊匹配查询）获取用户数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Users> usersSearch(Users req) {
        List<Users> usersList = usersService.find(req);
        return ApiResponse.success(usersList);
    }

    //根据条件（字符类型完全匹配查询）获取用户数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Users> usersSearchByEqualTo(Users req) {
        List<Users> usersList = usersService.findByEqualTo(req);
        return ApiResponse.success(usersList);
    }


    //按条件查询用户分页数据方法(模糊匹配查询)
    private PageData<Users> getPageList(Users req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Users> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Users> usersList = usersService.findPage(pageWrap);
        return usersList;
    }

    //按条件查询用户分页数据方法(完全匹配查询)
    private PageData<Users> getPageListByEqualTo(Users req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Users> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Users> usersList = usersService.findPageByEqualTo(pageWrap);
        return usersList;
    }

    //获取用户查询数据搜索条件
    private PageWrap<Users> getPageWrap(Users req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Users> pageWrap = new PageWrap<>();
        pageWrap.setModel(req);
        pageWrap.setPageNum(pageNo);
        pageWrap.setPageSize(pageSize);
        PageWrap.SortData sortData = new PageWrap.SortData();
        sortData.setDirection("DESC");
        sortData.setProperty(sortProperty);
        List<PageWrap.SortData> sorts = new ArrayList<>();
        sorts.add(sortData);
        pageWrap.setSorts(sorts);
        return pageWrap;
    }

}

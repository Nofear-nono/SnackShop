package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.*;
import com.service.*;
import com.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GouwucheController
 * @Description 购物车模块控制层
 */
@RequestMapping("gouwuche")
@RestController
public class GouwucheController {

    @Autowired
    private GouwucheService gouwucheService;

    @Autowired
    private ShangpinService shangpinService;

    //前台-根据条件获取购物车列表分页数据接口
    @RequestMapping("/manaqian")
    public ApiResponse<Gouwuche> manaQian(Gouwuche req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gouwuche> gouwucheList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gouwucheList);
    }

    //前台-根据条件获取我的购物车列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Gouwuche> manaMyQian(Gouwuche req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gouwuche> gouwucheList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gouwucheList);
    }

    //前台-根据条件获取购物车图片列表分页数据接口
    @RequestMapping("/manaqiantp")
    public ApiResponse<Gouwuche> manaQianTp(Gouwuche req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gouwuche> gouwucheList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gouwucheList);
    }

    //前台-购物车详情
    @RequestMapping("/detail/{id}")
    public ApiResponse<Gouwuche> detail(@PathVariable("id") Integer id) {
        Gouwuche info = gouwucheService.findById(id);
        return ApiResponse.success(info);
    }

    //前台-购物车添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Gouwuche req, HttpSession session) {
        //判断商品是否已存在购物车
        Users users = (Users) session.getAttribute("users");
        if (null != req && null != req.getShangpinid() && null != users && null != users.getId()) {
            Gouwuche instance = new Gouwuche();
            instance.setUsersid(users.getId());
            instance.setShangpinid(req.getShangpinid());
            List<Gouwuche> gouwucheList = gouwucheService.find(instance);
            if (gouwucheList.size() > 0) {
                //我的购物车已有此商品，则增加数量
                Gouwuche gouwuche = gouwucheList.get(0);
                Integer ishuliang = gouwuche.getGoumaishuliang();
                Integer ishuliangadd = req.getGoumaishuliang();
                req.setId(gouwuche.getId());
                req.setGoumaishuliang((ishuliang + ishuliangadd));
            }
        } else {
            return ApiResponse.failed("数据不存在");
        }
        int result = gouwucheService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取购物车管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Gouwuche> mana(Gouwuche req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gouwuche> gouwucheList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gouwucheList);
    }

    //后台-根据条件获取购物车管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Gouwuche> manaMy(Gouwuche req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gouwuche> gouwucheList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gouwucheList);
    }

    //后台-根据条件获取购物车查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Gouwuche> chakan(Gouwuche req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gouwuche> gouwucheList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gouwucheList);
    }

    //后台-根据条件获取购物车查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Gouwuche> chakanMy(Gouwuche req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gouwuche> gouwucheList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gouwucheList);
    }

    //后台-购物车详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Gouwuche> info(@PathVariable("id") Integer id) {
        Gouwuche info = gouwucheService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-购物车添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Gouwuche req, HttpSession session) {
        //判断商品是否已存在购物车
        Users users = (Users) session.getAttribute("users");
        if (null != req && null != req.getShangpinid() && null != users && null != users.getId()) {
            Gouwuche instance = new Gouwuche();
            instance.setUsersid(users.getId());
            instance.setShangpinid(req.getShangpinid());
            List<Gouwuche> gouwucheList = gouwucheService.find(instance);
            if (gouwucheList.size() > 0) {
                //我的购物车已有此商品，则增加数量
                Gouwuche gouwuche = gouwucheList.get(0);
                Integer ishuliang = gouwuche.getGoumaishuliang();
                Integer ishuliangadd = req.getGoumaishuliang();
                req.setId(gouwuche.getId());
                req.setGoumaishuliang((ishuliang + ishuliangadd));
            }
        } else {
            return ApiResponse.failed("数据不存在");
        }
        int result = gouwucheService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //购物车删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = gouwucheService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //购物车修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Gouwuche req) {
        int result = gouwucheService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有购物车数据接口
    @RequestMapping("/all")
    public ApiResponse<Gouwuche> gouwucheAll() {
        List<Gouwuche> gouwucheList = gouwucheService.findAll();
        return ApiResponse.success(gouwucheList);
    }

    //根据条件获取订单总金额接口
    @RequestMapping("/totalamount")
    public ApiResponse<Integer> getTotalamount(Gouwuche req) {
        //计算购物车总金额
        Integer totalAmount = 0;
        List<Gouwuche> gouwucheList = gouwucheService.find(req);
        for (Gouwuche gouwuche : gouwucheList) {
            Integer shangpinid = gouwuche.getShangpinid();
            if (null != shangpinid && shangpinid > 0) {
                Shangpin shangpin = shangpinService.findById(shangpinid);
                if (null != shangpin) {
                    totalAmount += gouwuche.getGoumaishuliang() * shangpin.getJiage();
                }
            }
        }
        return ApiResponse.success(totalAmount);
    }

    //购物车提交订单
    @PostMapping("/submitdingdan")
    @ResponseBody
    public ApiResponse<Integer> submitDingdan(@RequestBody(required = false) List<Gouwuche> gouwucheList, HttpSession session) {
        Users users = (Users) session.getAttribute("users");
        if (null != gouwucheList && gouwucheList.size() > 0 && null != users && null != users.getId()) {
            for (Gouwuche gouwuche : gouwucheList) {
                if (null != gouwuche.getId()) {
                    gouwucheService.saveOrUpdate(gouwuche);
                }
            }
        } else {
            return ApiResponse.failed("数据不存在");
        }

        return ApiResponse.success(1);
    }

    //根据条件（字符类型模糊匹配查询）获取购物车数据接口
    @RequestMapping("/search")
    public ApiResponse<Gouwuche> gouwucheSearch(Gouwuche req) {
        List<Gouwuche> gouwucheList = gouwucheService.find(req);
        return ApiResponse.success(gouwucheList);
    }

    //根据条件（字符类型完全匹配查询）获取购物车数据接口
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Gouwuche> gouwucheSearchByEqualTo(Gouwuche req) {
        List<Gouwuche> gouwucheList = gouwucheService.findByEqualTo(req);
        return ApiResponse.success(gouwucheList);
    }

    //按条件查询购物车分页数据方法(模糊匹配查询)
    private PageData<Gouwuche> getPageList(Gouwuche req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Gouwuche> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Gouwuche> gouwucheList = gouwucheService.findPage(pageWrap);
        return gouwucheList;
    }

    //按条件查询购物车分页数据方法(完全匹配查询)
    private PageData<Gouwuche> getPageListByEqualTo(Gouwuche req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Gouwuche> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Gouwuche> gouwucheList = gouwucheService.findPageByEqualTo(pageWrap);
        return gouwucheList;
    }

    //获取购物车查询数据搜索条件
    private PageWrap<Gouwuche> getPageWrap(Gouwuche req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Gouwuche> pageWrap = new PageWrap<>();
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

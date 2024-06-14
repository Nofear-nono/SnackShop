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
 * @ClassName PingjiaController
 * @Description 评论模块控制层
 */
@RequestMapping("pingjia")
@RestController
public class PingjiaController {

    @Autowired
    private PingjiaService pingjiaService;

    //前台-根据条件获取评论列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Pingjia> manaQian(Pingjia req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pingjia> pingjiaList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pingjiaList);
    }

    //前台-根据条件获取我的评论列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Pingjia> manaMyQian(Pingjia req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pingjia> pingjiaList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pingjiaList);
    }

    //前台-根据条件获取评论图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Pingjia> manaQianTp(Pingjia req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pingjia> pingjiaList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pingjiaList);
    }

    //前台-评论详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Pingjia> detail(@PathVariable("id") Integer id) {
        Pingjia info = pingjiaService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-评论添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Pingjia req) {
        int result = pingjiaService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取评论管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Pingjia> mana(Pingjia req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pingjia> pingjiaList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pingjiaList);
    }

    //后台-根据条件获取评论管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Pingjia> manaMy(Pingjia req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pingjia> pingjiaList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pingjiaList);
    }

    //后台-根据条件获取评论查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Pingjia> chakan(Pingjia req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pingjia> pingjiaList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pingjiaList);
    }

    //后台-根据条件获取评论查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Pingjia> chakanMy(Pingjia req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pingjia> pingjiaList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pingjiaList);
    }

    //后台-评论详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Pingjia> info(@PathVariable("id") Integer id) {
        Pingjia info = pingjiaService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-评论添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Pingjia req) {
        int result = pingjiaService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //评论删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = pingjiaService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //评论修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Pingjia req) {
        int result = pingjiaService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有评论数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Pingjia> pingjiaAll() {
        List<Pingjia> pingjiaList = pingjiaService.findAll();
        return ApiResponse.success(pingjiaList);
    }

    //根据条件（字符类型模糊匹配查询）获取评论数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Pingjia> pingjiaSearch(Pingjia req) {
        List<Pingjia> pingjiaList = pingjiaService.find(req);
        return ApiResponse.success(pingjiaList);
    }

    //根据条件（字符类型完全匹配查询）获取评论数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Pingjia> pingjiaSearchByEqualTo(Pingjia req) {
        List<Pingjia> pingjiaList = pingjiaService.findByEqualTo(req);
        return ApiResponse.success(pingjiaList);
    }



    //按条件查询评论分页数据方法(模糊匹配查询)
    private PageData<Pingjia> getPageList(Pingjia req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Pingjia> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Pingjia> pingjiaList = pingjiaService.findPage(pageWrap);
        return pingjiaList;
    }

    //按条件查询评论分页数据方法(完全匹配查询)
    private PageData<Pingjia> getPageListByEqualTo(Pingjia req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Pingjia> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Pingjia> pingjiaList = pingjiaService.findPageByEqualTo(pageWrap);
        return pingjiaList;
    }

    //获取评论查询数据搜索条件
    private PageWrap<Pingjia> getPageWrap(Pingjia req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Pingjia> pageWrap = new PageWrap<>();
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

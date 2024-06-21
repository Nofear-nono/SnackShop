package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.*;
import com.service.*;
import com.util.*;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DxController
 * @Description 信息介绍模块控制层
 */
@RequestMapping("dx")
@RestController
public class DxController {

    @Autowired
    private DxService dxService;

    //前台-根据条件获取信息介绍列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Dx> manaQian(Dx req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dx> dxList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dxList);
    }

    //前台-根据条件获取我的信息介绍列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Dx> manaMyQian(Dx req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dx> dxList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dxList);
    }

    //前台-根据条件获取信息介绍图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Dx> manaQianTp(Dx req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dx> dxList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dxList);
    }

    //前台-信息介绍详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Dx> detail(@PathVariable("id") Integer id) {
        Dx info = dxService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-信息介绍添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Dx req) {
        int result = dxService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取信息介绍管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Dx> mana(Dx req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dx> dxList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dxList);
    }

    //后台-根据条件获取信息介绍管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Dx> manaMy(Dx req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dx> dxList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dxList);
    }

    //后台-根据条件获取信息介绍查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Dx> chakan(Dx req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dx> dxList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dxList);
    }

    //后台-根据条件获取信息介绍查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Dx> chakanMy(Dx req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dx> dxList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dxList);
    }

    //后台-信息介绍详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Dx> info(@PathVariable("id") Integer id) {
        Dx info = dxService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-信息介绍添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Dx req) {
        int result = dxService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //信息介绍删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = dxService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //信息介绍修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Dx req) {
        int result = dxService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有信息介绍数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Dx> dxAll() {
        List<Dx> dxList = dxService.findAll();
        return ApiResponse.success(dxList);
    }

    //根据条件（字符类型模糊匹配查询）获取信息介绍数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Dx> dxSearch(Dx req) {
        List<Dx> dxList = dxService.find(req);
        return ApiResponse.success(dxList);
    }

    //根据条件（字符类型完全匹配查询）获取信息介绍数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Dx> dxSearchByEqualTo(Dx req) {
        List<Dx> dxList = dxService.findByEqualTo(req);
        return ApiResponse.success(dxList);
    }



    //按条件查询信息介绍分页数据方法(模糊匹配查询)
    private PageData<Dx> getPageList(Dx req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dx> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Dx> dxList = dxService.findPage(pageWrap);
        return dxList;
    }

    //按条件查询信息介绍分页数据方法(完全匹配查询)
    private PageData<Dx> getPageListByEqualTo(Dx req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dx> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Dx> dxList = dxService.findPageByEqualTo(pageWrap);
        return dxList;
    }

    //获取信息介绍查询数据搜索条件
    private PageWrap<Dx> getPageWrap(Dx req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dx> pageWrap = new PageWrap<>();
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

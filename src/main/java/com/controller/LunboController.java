package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Lunbo;
import com.service.LunboService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LunboController
 * @Description 轮播图模块控制层
 */
@RequestMapping("lunbo")
@RestController
public class LunboController {

    @Autowired
    private LunboService lunboService;

    //前台-根据条件获取轮播图列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Lunbo> manaQian(Lunbo req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lunbo> lunboList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lunboList);
    }

    //前台-根据条件获取我的轮播图列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Lunbo> manaMyQian(Lunbo req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lunbo> lunboList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lunboList);
    }

    //前台-根据条件获取轮播图图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Lunbo> manaQianTp(Lunbo req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lunbo> lunboList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lunboList);
    }

    //前台-轮播图详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Lunbo> detail(@PathVariable("id") Integer id) {
        Lunbo info = lunboService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-轮播图添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Lunbo req) {
        int result = lunboService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取轮播图管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Lunbo> mana(Lunbo req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lunbo> lunboList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lunboList);
    }

    //后台-根据条件获取轮播图管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Lunbo> manaMy(Lunbo req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lunbo> lunboList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lunboList);
    }

    //后台-根据条件获取轮播图查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Lunbo> chakan(Lunbo req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lunbo> lunboList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lunboList);
    }

    //后台-根据条件获取轮播图查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Lunbo> chakanMy(Lunbo req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lunbo> lunboList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lunboList);
    }

    //后台-轮播图详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Lunbo> info(@PathVariable("id") Integer id) {
        Lunbo info = lunboService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-轮播图添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Lunbo req) {
        int result = lunboService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //轮播图删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = lunboService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //轮播图修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Lunbo req) {
        int result = lunboService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有轮播图数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Lunbo> lunboAll() {
        List<Lunbo> lunboList = lunboService.findAll();
        return ApiResponse.success(lunboList);
    }

    //根据条件（字符类型模糊匹配查询）获取轮播图数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Lunbo> lunboSearch(Lunbo req) {
        List<Lunbo> lunboList = lunboService.find(req);
        return ApiResponse.success(lunboList);
    }

    //根据条件（字符类型完全匹配查询）获取轮播图数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Lunbo> lunboSearchByEqualTo(Lunbo req) {
        List<Lunbo> lunboList = lunboService.findByEqualTo(req);
        return ApiResponse.success(lunboList);
    }



    //按条件查询轮播图分页数据方法(模糊匹配查询)
    private PageData<Lunbo> getPageList(Lunbo req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Lunbo> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Lunbo> lunboList = lunboService.findPage(pageWrap);
        return lunboList;
    }

    //按条件查询轮播图分页数据方法(完全匹配查询)
    private PageData<Lunbo> getPageListByEqualTo(Lunbo req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Lunbo> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Lunbo> lunboList = lunboService.findPageByEqualTo(pageWrap);
        return lunboList;
    }

    //获取轮播图查询数据搜索条件
    private PageWrap<Lunbo> getPageWrap(Lunbo req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Lunbo> pageWrap = new PageWrap<>();
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

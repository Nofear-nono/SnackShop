package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Shenqing;
import com.service.ShenqingService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShenqingController
 * @Description 售后申请模块控制层
 */
@RequestMapping("shenqing")
@RestController
public class ShenqingController {

    @Autowired
    private ShenqingService shenqingService;

    //前台-根据条件获取售后申请列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Shenqing> manaQian(Shenqing req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shenqing> shenqingList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shenqingList);
    }

    //前台-根据条件获取我的售后申请列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Shenqing> manaMyQian(Shenqing req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shenqing> shenqingList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shenqingList);
    }

    //前台-根据条件获取售后申请图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Shenqing> manaQianTp(Shenqing req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shenqing> shenqingList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shenqingList);
    }

    //前台-售后申请详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Shenqing> detail(@PathVariable("id") Integer id) {
        Shenqing info = shenqingService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-售后申请添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Shenqing req) {
        int result = shenqingService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取售后申请管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Shenqing> mana(Shenqing req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shenqing> shenqingList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shenqingList);
    }

    //后台-根据条件获取售后申请管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Shenqing> manaMy(Shenqing req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shenqing> shenqingList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shenqingList);
    }

    //后台-根据条件获取售后申请查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Shenqing> chakan(Shenqing req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shenqing> shenqingList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shenqingList);
    }

    //后台-根据条件获取售后申请查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Shenqing> chakanMy(Shenqing req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shenqing> shenqingList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shenqingList);
    }

    //后台-售后申请详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Shenqing> info(@PathVariable("id") Integer id) {
        Shenqing info = shenqingService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-售后申请添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Shenqing req) {
        int result = shenqingService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //售后申请删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = shenqingService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //售后申请修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Shenqing req) {
        int result = shenqingService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有售后申请数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Shenqing> shenqingAll() {
        List<Shenqing> shenqingList = shenqingService.findAll();
        return ApiResponse.success(shenqingList);
    }

    //根据条件（字符类型模糊匹配查询）获取售后申请数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Shenqing> shenqingSearch(Shenqing req) {
        List<Shenqing> shenqingList = shenqingService.find(req);
        return ApiResponse.success(shenqingList);
    }

    //根据条件（字符类型完全匹配查询）获取售后申请数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Shenqing> shenqingSearchByEqualTo(Shenqing req) {
        List<Shenqing> shenqingList = shenqingService.findByEqualTo(req);
        return ApiResponse.success(shenqingList);
    }



    //按条件查询售后申请分页数据方法(模糊匹配查询)
    private PageData<Shenqing> getPageList(Shenqing req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shenqing> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Shenqing> shenqingList = shenqingService.findPage(pageWrap);
        return shenqingList;
    }

    //按条件查询售后申请分页数据方法(完全匹配查询)
    private PageData<Shenqing> getPageListByEqualTo(Shenqing req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shenqing> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Shenqing> shenqingList = shenqingService.findPageByEqualTo(pageWrap);
        return shenqingList;
    }

    //获取售后申请查询数据搜索条件
    private PageWrap<Shenqing> getPageWrap(Shenqing req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shenqing> pageWrap = new PageWrap<>();
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

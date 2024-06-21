package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Pinlei;
import com.service.PinleiService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PinleiController
 * @Description 分类模块控制层
 */

@RequestMapping("pinlei")
@RestController
public class PinleiController {
    @Autowired
    private PinleiService pinleiService;

    //前台-根据条件获取分类列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Pinlei> manaQian(Pinlei req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pinlei> pinleiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pinleiList);
    }

    //前台-根据条件获取我的分类列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Pinlei> manaMyQian(Pinlei req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pinlei> pinleiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pinleiList);
    }

    //前台-根据条件获取分类图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Pinlei> manaQianTp(Pinlei req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pinlei> pinleiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pinleiList);
    }

    //前台-分类详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Pinlei> detail(@PathVariable("id") Integer id) {
        Pinlei info = pinleiService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-分类添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Pinlei req) {
        int result = pinleiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取分类管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Pinlei> mana(Pinlei req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pinlei> pinleiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pinleiList);
    }

    //后台-根据条件获取分类管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Pinlei> manaMy(Pinlei req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pinlei> pinleiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pinleiList);
    }

    //后台-根据条件获取分类查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Pinlei> chakan(Pinlei req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pinlei> pinleiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pinleiList);
    }

    //后台-根据条件获取分类查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Pinlei> chakanMy(Pinlei req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Pinlei> pinleiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(pinleiList);
    }

    //后台-分类详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Pinlei> info(@PathVariable("id") Integer id) {
        Pinlei info = pinleiService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-分类添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Pinlei req) {
        int result = pinleiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //分类删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = pinleiService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //分类修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Pinlei req) {
        int result = pinleiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有分类数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Pinlei> pinleiAll() {
        List<Pinlei> pinleiList = pinleiService.findAll();
        return ApiResponse.success(pinleiList);
    }

    //根据条件（字符类型模糊匹配查询）获取分类数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Pinlei> pinleiSearch(Pinlei req) {
        List<Pinlei> pinleiList = pinleiService.find(req);
        return ApiResponse.success(pinleiList);
    }

    //根据条件（字符类型完全匹配查询）获取分类数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Pinlei> pinleiSearchByEqualTo(Pinlei req) {
        List<Pinlei> pinleiList = pinleiService.findByEqualTo(req);
        return ApiResponse.success(pinleiList);
    }



    //按条件查询分类分页数据方法(模糊匹配查询)
    private PageData<Pinlei> getPageList(Pinlei req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Pinlei> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Pinlei> pinleiList = pinleiService.findPage(pageWrap);
        return pinleiList;
    }

    //按条件查询分类分页数据方法(完全匹配查询)
    private PageData<Pinlei> getPageListByEqualTo(Pinlei req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Pinlei> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Pinlei> pinleiList = pinleiService.findPageByEqualTo(pageWrap);
        return pinleiList;
    }

    //获取分类查询数据搜索条件
    private PageWrap<Pinlei> getPageWrap(Pinlei req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Pinlei> pageWrap = new PageWrap<>();
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

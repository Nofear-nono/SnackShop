package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Gonggao;
import com.service.GonggaoService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName GonggaoController
 * @Description 公告模块控制层
 */
@RequestMapping("gonggao")
@RestController
public class GonggaoController {

    @Autowired
    private GonggaoService gonggaoService;

    //前台-根据条件获取公告列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Gonggao> manaQian(Gonggao req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gonggao> gonggaoList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gonggaoList);
    }

    //前台-根据条件获取我的公告列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Gonggao> manaMyQian(Gonggao req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gonggao> gonggaoList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gonggaoList);
    }

    //前台-根据条件获取公告图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Gonggao> manaQianTp(Gonggao req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gonggao> gonggaoList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gonggaoList);
    }

    //前台-公告详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Gonggao> detail(@PathVariable("id") Integer id) {
        Gonggao info = gonggaoService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-公告添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Gonggao req) {
        int result = gonggaoService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取公告管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Gonggao> mana(Gonggao req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gonggao> gonggaoList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gonggaoList);
    }

    //后台-根据条件获取公告管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Gonggao> manaMy(Gonggao req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gonggao> gonggaoList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gonggaoList);
    }

    //后台-根据条件获取公告查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Gonggao> chakan(Gonggao req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gonggao> gonggaoList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gonggaoList);
    }

    //后台-根据条件获取公告查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Gonggao> chakanMy(Gonggao req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Gonggao> gonggaoList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(gonggaoList);
    }

    //后台-公告详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Gonggao> info(@PathVariable("id") Integer id) {
        Gonggao info = gonggaoService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-公告添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Gonggao req) {
        int result = gonggaoService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //公告删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = gonggaoService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //公告修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Gonggao req) {
        int result = gonggaoService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有公告数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Gonggao> gonggaoAll() {
        List<Gonggao> gonggaoList = gonggaoService.findAll();
        return ApiResponse.success(gonggaoList);
    }

    //根据条件（字符类型模糊匹配查询）获取公告数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Gonggao> gonggaoSearch(Gonggao req) {
        List<Gonggao> gonggaoList = gonggaoService.find(req);
        return ApiResponse.success(gonggaoList);
    }

    //根据条件（字符类型完全匹配查询）获取公告数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Gonggao> gonggaoSearchByEqualTo(Gonggao req) {
        List<Gonggao> gonggaoList = gonggaoService.findByEqualTo(req);
        return ApiResponse.success(gonggaoList);
    }



    //按条件查询公告分页数据方法(模糊匹配查询)
    private PageData<Gonggao> getPageList(Gonggao req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Gonggao> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Gonggao> gonggaoList = gonggaoService.findPage(pageWrap);
        return gonggaoList;
    }

    //按条件查询公告分页数据方法(完全匹配查询)
    private PageData<Gonggao> getPageListByEqualTo(Gonggao req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Gonggao> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Gonggao> gonggaoList = gonggaoService.findPageByEqualTo(pageWrap);
        return gonggaoList;
    }

    //获取公告查询数据搜索条件
    private PageWrap<Gonggao> getPageWrap(Gonggao req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Gonggao> pageWrap = new PageWrap<>();
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

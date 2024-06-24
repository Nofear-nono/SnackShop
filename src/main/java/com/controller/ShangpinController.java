package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Shangpin;
import com.service.ShangpinService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShangpinController
 * @Description 零食模块控制层
 */

@RequestMapping("shangpin")
@RestController
public class ShangpinController {
    @Autowired
    private ShangpinService shangpinService;

    //前台-根据条件获取零食列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Shangpin> manaQian(Shangpin req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shangpin> shangpinList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shangpinList);
    }

    //前台-根据条件获取我的零食列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Shangpin> manaMyQian(Shangpin req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shangpin> shangpinList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shangpinList);
    }

    //前台-根据条件获取零食图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Shangpin> manaQianTp(Shangpin req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shangpin> shangpinList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shangpinList);
    }

    //前台-零食详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Shangpin> detail(@PathVariable("id") Integer id) {
        Shangpin info = shangpinService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-零食添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Shangpin req) {
        int result = shangpinService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取零食管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Shangpin> mana(Shangpin req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shangpin> shangpinList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shangpinList);
    }

    //后台-根据条件获取零食管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Shangpin> manaMy(Shangpin req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shangpin> shangpinList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shangpinList);
    }

    //后台-根据条件获取零食查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Shangpin> chakan(Shangpin req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shangpin> shangpinList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shangpinList);
    }

    //后台-根据条件获取零食查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Shangpin> chakanMy(Shangpin req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shangpin> shangpinList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shangpinList);
    }

    //后台-零食详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Shangpin> info(@PathVariable("id") Integer id) {
        Shangpin info = shangpinService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-零食添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Shangpin req) {
        int result = shangpinService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //零食删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = shangpinService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //零食修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Shangpin req) {
        int result = shangpinService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有零食数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Shangpin> shangpinAll() {
        List<Shangpin> shangpinList = shangpinService.findAll();
        return ApiResponse.success(shangpinList);
    }

    //根据条件（字符类型模糊匹配查询）获取零食数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Shangpin> shangpinSearch(Shangpin req) {
        List<Shangpin> shangpinList = shangpinService.find(req);
        return ApiResponse.success(shangpinList);
    }

    //根据条件（字符类型完全匹配查询）获取零食数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Shangpin> shangpinSearchByEqualTo(Shangpin req) {
        List<Shangpin> shangpinList = shangpinService.findByEqualTo(req);
        return ApiResponse.success(shangpinList);
    }



    //按条件查询零食分页数据方法(模糊匹配查询)
    private PageData<Shangpin> getPageList(Shangpin req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shangpin> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Shangpin> shangpinList = shangpinService.findPage(pageWrap);
        return shangpinList;
    }

    //按条件查询零食分页数据方法(完全匹配查询)
    private PageData<Shangpin> getPageListByEqualTo(Shangpin req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shangpin> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Shangpin> shangpinList = shangpinService.findPageByEqualTo(pageWrap);
        return shangpinList;
    }

    //获取零食查询数据搜索条件
    private PageWrap<Shangpin> getPageWrap(Shangpin req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shangpin> pageWrap = new PageWrap<>();
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

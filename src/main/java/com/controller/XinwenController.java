package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Xinwen;
import com.service.XinwenService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName XinwenController
 * @Description 新闻模块控制层
 */
@RequestMapping("xinwen")
@RestController
public class XinwenController {

    @Autowired
    private XinwenService xinwenService;

    //前台-根据条件获取新闻列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Xinwen> manaQian(Xinwen req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Xinwen> xinwenList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(xinwenList);
    }

    //前台-根据条件获取我的新闻列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Xinwen> manaMyQian(Xinwen req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Xinwen> xinwenList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(xinwenList);
    }

    //前台-根据条件获取新闻图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Xinwen> manaQianTp(Xinwen req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Xinwen> xinwenList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(xinwenList);
    }

    //前台-新闻详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Xinwen> detail(@PathVariable("id") Integer id) {
        Xinwen info = xinwenService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-新闻添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Xinwen req) {
        int result = xinwenService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取新闻管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Xinwen> mana(Xinwen req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Xinwen> xinwenList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(xinwenList);
    }

    //后台-根据条件获取新闻管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Xinwen> manaMy(Xinwen req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Xinwen> xinwenList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(xinwenList);
    }

    //后台-根据条件获取新闻查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Xinwen> chakan(Xinwen req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Xinwen> xinwenList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(xinwenList);
    }

    //后台-根据条件获取新闻查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Xinwen> chakanMy(Xinwen req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Xinwen> xinwenList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(xinwenList);
    }

    //后台-新闻详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Xinwen> info(@PathVariable("id") Integer id) {
        Xinwen info = xinwenService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-新闻添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Xinwen req) {
        int result = xinwenService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //新闻删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = xinwenService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //新闻修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Xinwen req) {
        int result = xinwenService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有新闻数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Xinwen> xinwenAll() {
        List<Xinwen> xinwenList = xinwenService.findAll();
        return ApiResponse.success(xinwenList);
    }

    //根据条件（字符类型模糊匹配查询）获取新闻数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Xinwen> xinwenSearch(Xinwen req) {
        List<Xinwen> xinwenList = xinwenService.find(req);
        return ApiResponse.success(xinwenList);
    }

    //根据条件（字符类型完全匹配查询）获取新闻数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Xinwen> xinwenSearchByEqualTo(Xinwen req) {
        List<Xinwen> xinwenList = xinwenService.findByEqualTo(req);
        return ApiResponse.success(xinwenList);
    }



    //按条件查询新闻分页数据方法(模糊匹配查询)
    private PageData<Xinwen> getPageList(Xinwen req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Xinwen> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Xinwen> xinwenList = xinwenService.findPage(pageWrap);
        return xinwenList;
    }

    //按条件查询新闻分页数据方法(完全匹配查询)
    private PageData<Xinwen> getPageListByEqualTo(Xinwen req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Xinwen> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Xinwen> xinwenList = xinwenService.findPageByEqualTo(pageWrap);
        return xinwenList;
    }

    //获取新闻查询数据搜索条件
    private PageWrap<Xinwen> getPageWrap(Xinwen req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Xinwen> pageWrap = new PageWrap<>();
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

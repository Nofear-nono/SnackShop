package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Lianjie;
import com.service.LianjieService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LianjieController
 * @Description 友情链接模块控制层
 */
@RequestMapping("lianjie")
@RestController
public class LianjieController {

    @Autowired
    private LianjieService lianjieService;

    //前台-根据条件获取友情链接列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Lianjie> manaQian(Lianjie req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lianjie> lianjieList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lianjieList);
    }

    //前台-根据条件获取我的友情链接列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Lianjie> manaMyQian(Lianjie req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lianjie> lianjieList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lianjieList);
    }

    //前台-根据条件获取友情链接图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Lianjie> manaQianTp(Lianjie req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lianjie> lianjieList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lianjieList);
    }

    //前台-友情链接详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Lianjie> detail(@PathVariable("id") Integer id) {
        Lianjie info = lianjieService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-友情链接添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Lianjie req) {
        int result = lianjieService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取友情链接管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Lianjie> mana(Lianjie req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lianjie> lianjieList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lianjieList);
    }

    //后台-根据条件获取友情链接管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Lianjie> manaMy(Lianjie req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lianjie> lianjieList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lianjieList);
    }

    //后台-根据条件获取友情链接查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Lianjie> chakan(Lianjie req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lianjie> lianjieList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lianjieList);
    }

    //后台-根据条件获取友情链接查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Lianjie> chakanMy(Lianjie req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Lianjie> lianjieList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(lianjieList);
    }

    //后台-友情链接详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Lianjie> info(@PathVariable("id") Integer id) {
        Lianjie info = lianjieService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-友情链接添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Lianjie req) {
        int result = lianjieService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //友情链接删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = lianjieService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //友情链接修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Lianjie req) {
        int result = lianjieService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有友情链接数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Lianjie> lianjieAll() {
        List<Lianjie> lianjieList = lianjieService.findAll();
        return ApiResponse.success(lianjieList);
    }

    //根据条件（字符类型模糊匹配查询）获取友情链接数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Lianjie> lianjieSearch(Lianjie req) {
        List<Lianjie> lianjieList = lianjieService.find(req);
        return ApiResponse.success(lianjieList);
    }

    //根据条件（字符类型完全匹配查询）获取友情链接数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Lianjie> lianjieSearchByEqualTo(Lianjie req) {
        List<Lianjie> lianjieList = lianjieService.findByEqualTo(req);
        return ApiResponse.success(lianjieList);
    }



    //按条件查询友情链接分页数据方法(模糊匹配查询)
    private PageData<Lianjie> getPageList(Lianjie req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Lianjie> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Lianjie> lianjieList = lianjieService.findPage(pageWrap);
        return lianjieList;
    }

    //按条件查询友情链接分页数据方法(完全匹配查询)
    private PageData<Lianjie> getPageListByEqualTo(Lianjie req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Lianjie> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Lianjie> lianjieList = lianjieService.findPageByEqualTo(pageWrap);
        return lianjieList;
    }

    //获取友情链接查询数据搜索条件
    private PageWrap<Lianjie> getPageWrap(Lianjie req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Lianjie> pageWrap = new PageWrap<>();
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

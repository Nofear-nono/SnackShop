package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Shoucang;
import com.service.ShoucangService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ShoucangController
 * @Description 收藏模块控制层
 */
@RequestMapping("shoucang")
@RestController
public class ShoucangController {

    @Autowired
    private ShoucangService shoucangService;

    //前台-根据条件获取收藏列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Shoucang> manaQian(Shoucang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shoucang> shoucangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shoucangList);
    }

    //前台-根据条件获取我的收藏列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Shoucang> manaMyQian(Shoucang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shoucang> shoucangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shoucangList);
    }

    //前台-根据条件获取收藏图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Shoucang> manaQianTp(Shoucang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shoucang> shoucangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shoucangList);
    }

    //前台-收藏详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Shoucang> detail(@PathVariable("id") Integer id) {
        Shoucang info = shoucangService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-收藏添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Shoucang req) {
        int result = shoucangService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取收藏管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Shoucang> mana(Shoucang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shoucang> shoucangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shoucangList);
    }

    //后台-根据条件获取收藏管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Shoucang> manaMy(Shoucang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shoucang> shoucangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shoucangList);
    }

    //后台-根据条件获取收藏查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Shoucang> chakan(Shoucang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shoucang> shoucangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shoucangList);
    }

    //后台-根据条件获取收藏查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Shoucang> chakanMy(Shoucang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Shoucang> shoucangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(shoucangList);
    }

    //后台-收藏详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Shoucang> info(@PathVariable("id") Integer id) {
        Shoucang info = shoucangService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-收藏添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Shoucang req) {
        int result = shoucangService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //收藏删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = shoucangService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //收藏修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Shoucang req) {
        int result = shoucangService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有收藏数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Shoucang> shoucangAll() {
        List<Shoucang> shoucangList = shoucangService.findAll();
        return ApiResponse.success(shoucangList);
    }

    //根据条件（字符类型模糊匹配查询）获取收藏数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Shoucang> shoucangSearch(Shoucang req) {
        List<Shoucang> shoucangList = shoucangService.find(req);
        return ApiResponse.success(shoucangList);
    }

    //根据条件（字符类型完全匹配查询）获取收藏数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Shoucang> shoucangSearchByEqualTo(Shoucang req) {
        List<Shoucang> shoucangList = shoucangService.findByEqualTo(req);
        return ApiResponse.success(shoucangList);
    }



    //按条件查询收藏分页数据方法(模糊匹配查询)
    private PageData<Shoucang> getPageList(Shoucang req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shoucang> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Shoucang> shoucangList = shoucangService.findPage(pageWrap);
        return shoucangList;
    }

    //按条件查询收藏分页数据方法(完全匹配查询)
    private PageData<Shoucang> getPageListByEqualTo(Shoucang req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shoucang> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Shoucang> shoucangList = shoucangService.findPageByEqualTo(pageWrap);
        return shoucangList;
    }

    //获取收藏查询数据搜索条件
    private PageWrap<Shoucang> getPageWrap(Shoucang req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Shoucang> pageWrap = new PageWrap<>();
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

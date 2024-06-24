package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Dingdanxiang;
import com.service.DingdanxiangService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DingdanxiangController
 * @Description 订单项模块控制层
 */
@RequestMapping("dingdanxiang")
@RestController
public class DingdanxiangController {

    @Autowired
    private DingdanxiangService dingdanxiangService;

    //前台-根据条件获取订单项列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Dingdanxiang> manaQian(Dingdanxiang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdanxiang> dingdanxiangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanxiangList);
    }

    //前台-根据条件获取我的订单项列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Dingdanxiang> manaMyQian(Dingdanxiang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdanxiang> dingdanxiangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanxiangList);
    }

    //前台-根据条件获取订单项图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Dingdanxiang> manaQianTp(Dingdanxiang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdanxiang> dingdanxiangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanxiangList);
    }

    //前台-订单项详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Dingdanxiang> detail(@PathVariable("id") Integer id) {
        Dingdanxiang info = dingdanxiangService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-订单项添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Dingdanxiang req) {
        int result = dingdanxiangService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取订单项管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Dingdanxiang> mana(Dingdanxiang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdanxiang> dingdanxiangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanxiangList);
    }

    //后台-根据条件获取订单项管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Dingdanxiang> manaMy(Dingdanxiang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdanxiang> dingdanxiangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanxiangList);
    }

    //后台-根据条件获取订单项查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Dingdanxiang> chakan(Dingdanxiang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdanxiang> dingdanxiangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanxiangList);
    }

    //后台-根据条件获取订单项查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Dingdanxiang> chakanMy(Dingdanxiang req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdanxiang> dingdanxiangList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanxiangList);
    }

    //后台-订单项详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Dingdanxiang> info(@PathVariable("id") Integer id) {
        Dingdanxiang info = dingdanxiangService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-订单项添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Dingdanxiang req) {
        int result = dingdanxiangService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //订单项删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = dingdanxiangService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //订单项修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Dingdanxiang req) {
        int result = dingdanxiangService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有订单项数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Dingdanxiang> dingdanxiangAll() {
        List<Dingdanxiang> dingdanxiangList = dingdanxiangService.findAll();
        return ApiResponse.success(dingdanxiangList);
    }

    //根据条件（字符类型模糊匹配查询）获取订单项数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Dingdanxiang> dingdanxiangSearch(Dingdanxiang req) {
        List<Dingdanxiang> dingdanxiangList = dingdanxiangService.find(req);
        return ApiResponse.success(dingdanxiangList);
    }

    //根据条件（字符类型完全匹配查询）获取订单项数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Dingdanxiang> dingdanxiangSearchByEqualTo(Dingdanxiang req) {
        List<Dingdanxiang> dingdanxiangList = dingdanxiangService.findByEqualTo(req);
        return ApiResponse.success(dingdanxiangList);
    }



    //按条件查询订单项分页数据方法(模糊匹配查询)
    private PageData<Dingdanxiang> getPageList(Dingdanxiang req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dingdanxiang> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Dingdanxiang> dingdanxiangList = dingdanxiangService.findPage(pageWrap);
        return dingdanxiangList;
    }

    //按条件查询订单项分页数据方法(完全匹配查询)
    private PageData<Dingdanxiang> getPageListByEqualTo(Dingdanxiang req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dingdanxiang> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Dingdanxiang> dingdanxiangList = dingdanxiangService.findPageByEqualTo(pageWrap);
        return dingdanxiangList;
    }

    //获取订单项查询数据搜索条件
    private PageWrap<Dingdanxiang> getPageWrap(Dingdanxiang req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dingdanxiang> pageWrap = new PageWrap<>();
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

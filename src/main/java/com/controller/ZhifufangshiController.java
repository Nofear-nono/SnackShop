package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Zhifufangshi;
import com.service.ZhifufangshiService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ZhifufangshiController
 * @Description 支付方式模块控制层
 */

@RequestMapping("zhifufangshi")
@RestController
public class ZhifufangshiController {
    @Autowired
    private ZhifufangshiService zhifufangshiService;

    //前台-根据条件获取支付方式列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Zhifufangshi> manaQian(Zhifufangshi req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Zhifufangshi> zhifufangshiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(zhifufangshiList);
    }

    //前台-根据条件获取我的支付方式列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Zhifufangshi> manaMyQian(Zhifufangshi req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Zhifufangshi> zhifufangshiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(zhifufangshiList);
    }

    //前台-根据条件获取支付方式图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Zhifufangshi> manaQianTp(Zhifufangshi req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Zhifufangshi> zhifufangshiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(zhifufangshiList);
    }

    //前台-支付方式详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Zhifufangshi> detail(@PathVariable("id") Integer id) {
        Zhifufangshi info = zhifufangshiService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-支付方式添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Zhifufangshi req) {
        int result = zhifufangshiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取支付方式管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Zhifufangshi> mana(Zhifufangshi req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Zhifufangshi> zhifufangshiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(zhifufangshiList);
    }

    //后台-根据条件获取支付方式管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Zhifufangshi> manaMy(Zhifufangshi req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Zhifufangshi> zhifufangshiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(zhifufangshiList);
    }

    //后台-根据条件获取支付方式查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Zhifufangshi> chakan(Zhifufangshi req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Zhifufangshi> zhifufangshiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(zhifufangshiList);
    }

    //后台-根据条件获取支付方式查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Zhifufangshi> chakanMy(Zhifufangshi req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Zhifufangshi> zhifufangshiList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(zhifufangshiList);
    }

    //后台-支付方式详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Zhifufangshi> info(@PathVariable("id") Integer id) {
        Zhifufangshi info = zhifufangshiService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-支付方式添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Zhifufangshi req) {
        int result = zhifufangshiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //支付方式删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = zhifufangshiService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //支付方式修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Zhifufangshi req) {
        int result = zhifufangshiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有支付方式数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Zhifufangshi> zhifufangshiAll() {
        List<Zhifufangshi> zhifufangshiList = zhifufangshiService.findAll();
        return ApiResponse.success(zhifufangshiList);
    }

    //根据条件（字符类型模糊匹配查询）获取支付方式数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Zhifufangshi> zhifufangshiSearch(Zhifufangshi req) {
        List<Zhifufangshi> zhifufangshiList = zhifufangshiService.find(req);
        return ApiResponse.success(zhifufangshiList);
    }

    //根据条件（字符类型完全匹配查询）获取支付方式数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Zhifufangshi> zhifufangshiSearchByEqualTo(Zhifufangshi req) {
        List<Zhifufangshi> zhifufangshiList = zhifufangshiService.findByEqualTo(req);
        return ApiResponse.success(zhifufangshiList);
    }



    //按条件查询支付方式分页数据方法(模糊匹配查询)
    private PageData<Zhifufangshi> getPageList(Zhifufangshi req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Zhifufangshi> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Zhifufangshi> zhifufangshiList = zhifufangshiService.findPage(pageWrap);
        return zhifufangshiList;
    }

    //按条件查询支付方式分页数据方法(完全匹配查询)
    private PageData<Zhifufangshi> getPageListByEqualTo(Zhifufangshi req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Zhifufangshi> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Zhifufangshi> zhifufangshiList = zhifufangshiService.findPageByEqualTo(pageWrap);
        return zhifufangshiList;
    }

    //获取支付方式查询数据搜索条件
    private PageWrap<Zhifufangshi> getPageWrap(Zhifufangshi req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Zhifufangshi> pageWrap = new PageWrap<>();
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
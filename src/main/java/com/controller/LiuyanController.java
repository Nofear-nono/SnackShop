package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Liuyan;
import com.service.LiuyanService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LiuyanController
 * @Description 留言反馈模块控制层
 */
@RequestMapping("liuyan")
@RestController
public class LiuyanController {

    @Autowired
    private LiuyanService liuyanService;

    //前台-根据条件获取留言反馈列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqian")
    public ApiResponse<Liuyan> manaQian(Liuyan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Liuyan> liuyanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(liuyanList);
    }

    //前台-根据条件获取我的留言反馈列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Liuyan> manaMyQian(Liuyan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Liuyan> liuyanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(liuyanList);
    }

    //前台-根据条件获取留言反馈图片列表分页数据接口
    @IgnoreAuth
    @RequestMapping("/manaqiantp")
    public ApiResponse<Liuyan> manaQianTp(Liuyan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Liuyan> liuyanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(liuyanList);
    }

    //前台-留言反馈详情
    @IgnoreAuth
    @RequestMapping("/detail/{id}")
    public ApiResponse<Liuyan> detail(@PathVariable("id") Integer id) {
        Liuyan info = liuyanService.findById(id);

        return ApiResponse.success(info);
    }

    //前台-留言反馈添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Liuyan req) {
        int result = liuyanService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //后台-根据条件获取留言反馈管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Liuyan> mana(Liuyan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Liuyan> liuyanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(liuyanList);
    }

    //后台-根据条件获取留言反馈管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Liuyan> manaMy(Liuyan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Liuyan> liuyanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(liuyanList);
    }

    //后台-根据条件获取留言反馈查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Liuyan> chakan(Liuyan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Liuyan> liuyanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(liuyanList);
    }

    //后台-根据条件获取留言反馈查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Liuyan> chakanMy(Liuyan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Liuyan> liuyanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(liuyanList);
    }

    //后台-留言反馈详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Liuyan> info(@PathVariable("id") Integer id) {
        Liuyan info = liuyanService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-留言反馈添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Liuyan req) {
        int result = liuyanService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //留言反馈删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = liuyanService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //留言反馈修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Liuyan req) {
        int result = liuyanService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //获取所有留言反馈数据接口
    @IgnoreAuth
    @RequestMapping("/all")
    public ApiResponse<Liuyan> liuyanAll() {
        List<Liuyan> liuyanList = liuyanService.findAll();
        return ApiResponse.success(liuyanList);
    }

    //根据条件（字符类型模糊匹配查询）获取留言反馈数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Liuyan> liuyanSearch(Liuyan req) {
        List<Liuyan> liuyanList = liuyanService.find(req);
        return ApiResponse.success(liuyanList);
    }

    //根据条件（字符类型完全匹配查询）获取留言反馈数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Liuyan> liuyanSearchByEqualTo(Liuyan req) {
        List<Liuyan> liuyanList = liuyanService.findByEqualTo(req);
        return ApiResponse.success(liuyanList);
    }



    //按条件查询留言反馈分页数据方法(模糊匹配查询)
    private PageData<Liuyan> getPageList(Liuyan req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Liuyan> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Liuyan> liuyanList = liuyanService.findPage(pageWrap);
        return liuyanList;
    }

    //按条件查询留言反馈分页数据方法(完全匹配查询)
    private PageData<Liuyan> getPageListByEqualTo(Liuyan req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Liuyan> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Liuyan> liuyanList = liuyanService.findPageByEqualTo(pageWrap);
        return liuyanList;
    }

    //获取留言反馈查询数据搜索条件
    private PageWrap<Liuyan> getPageWrap(Liuyan req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Liuyan> pageWrap = new PageWrap<>();
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

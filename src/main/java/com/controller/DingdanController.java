package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.*;
import com.service.DingdanService;
import com.service.DingdanxiangService;
import com.service.GouwucheService;
import com.service.ShangpinService;
import com.util.ApiResponse;
import com.util.PageData;
import com.util.PageWrap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName DingdanController
 * @Description 订单模块控制层
 */
@RequestMapping("dingdan")
@RestController
public class DingdanController {

    @Autowired
    private DingdanService dingdanService;

    @Autowired
    private GouwucheService gouwucheService;

    @Autowired
    private ShangpinService shangpinService;

    @Autowired
    private DingdanxiangService dingdanxiangService;

    //前台-根据条件获取订单列表分页数据接口
    @RequestMapping("/manaqian")
    public ApiResponse<Dingdan> manaQian(Dingdan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdan> dingdanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanList);
    }

    //前台-根据条件获取我的订单列表分页数据接口
    @RequestMapping("/manamyqian")
    public ApiResponse<Dingdan> manaMyQian(Dingdan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdan> dingdanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanList);
    }

    //前台-根据条件获取订单图片列表分页数据接口
    @RequestMapping("/manaqiantp")
    public ApiResponse<Dingdan> manaQianTp(Dingdan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdan> dingdanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanList);
    }

    //前台-订单详情
    @RequestMapping("/detail/{id}")
    public ApiResponse<Dingdan> detail(@PathVariable("id") Integer id) {
        Dingdan info = dingdanService.findById(id);
        return ApiResponse.success(info);
    }

    //前台-订单添加接口
    @PostMapping("/add")
    public ApiResponse<Integer> add(@RequestBody Dingdan req, HttpSession session, String shangPinId) {
        Users users = (Users) session.getAttribute("users");
        List<Gouwuche> gouwucheList = new ArrayList<>();
        if (null != users && null != users.getId()) {
            if (null == shangPinId || shangPinId.equals("0")) {
                //从购物车里提交订单下单
                Gouwuche gouwuche = new Gouwuche();
                gouwuche.setUsersid(users.getId());
                gouwucheList = gouwucheService.find(gouwuche);
            }else {
                //商品详情页里直接购买下单
                Integer shangpinid = cn.hutool.core.convert.Convert.toInt(shangPinId);
                Gouwuche gouwuche = new Gouwuche();
                gouwuche.setShangpinid(shangpinid);
                gouwuche.setId(0);
                //直接购买时购买数量为1
                gouwuche.setGoumaishuliang(1);
                gouwucheList.add(gouwuche);
            }
            if (gouwucheList.size() == 0) {
                return ApiResponse.failed("请先将商品添加到购物车再提交订单！");
            } else {
                for (Gouwuche info : gouwucheList) {
                    Integer shangpinid = info.getShangpinid();
                    if (null == shangpinid || shangpinid == 0) {
                        return ApiResponse.failed("购物车里的商品数据异常！");
                    }
                    Integer goumaishuliang = info.getGoumaishuliang();
                    //库存判断
                    Shangpin shangpin = shangpinService.findById(shangpinid);
                    if (null != shangpin) {
                        Integer kucunshuliang = shangpin.getKucunshuliang();
                        //判断库存是否大于或等于订单数量
                        if (kucunshuliang < goumaishuliang) {
                            return ApiResponse.failed("购物车里的商品库存不足，请修正后再提交！");
                        }
                    } else {
                        return ApiResponse.failed("购物车里的商品不存在！");
                    }
                }
            }
        } else {
            return ApiResponse.failed("请登陆后再操作！");
        }
        int result = dingdanService.saveOrUpdate(req);
        //保存订单项数据、更新商品表数据以及删除购物车数据
        for (Gouwuche info : gouwucheList) {
            Integer shangpinid = info.getShangpinid();
            Integer goumaishuliang = info.getGoumaishuliang();

            //保存订单项数据
            Dingdanxiang dingdanxiang = new Dingdanxiang();
            dingdanxiang.setShangpinid(shangpinid);
            dingdanxiang.setGoumaishuliang(goumaishuliang);
            dingdanxiang.setUsersid(users.getId());
            dingdanxiang.setDingdanid(result);
            dingdanxiangService.saveOrUpdate(dingdanxiang);

            //更新商品表数据
            Shangpin shangpin = shangpinService.findById(shangpinid);
            Integer kucunshuliang = shangpin.getKucunshuliang();
            Integer xiaoshoushuliang = shangpin.getXiaoshoushuliang();
            //商品库存数量减去购买数量
            shangpin.setKucunshuliang(kucunshuliang - goumaishuliang);
            //商品销售数量加上购买数量
            shangpin.setXiaoshoushuliang(xiaoshoushuliang + goumaishuliang);
            shangpinService.saveOrUpdate(shangpin);

            //删除购物车数据
            gouwucheService.deleteById(info.getId());
        }
        return ApiResponse.success(result);
    }

    //后台-根据条件获取订单管理列表分页数据接口
    @RequestMapping("/mana")
    public ApiResponse<Dingdan> mana(Dingdan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdan> dingdanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanList);
    }

    //后台-根据条件获取订单管理我的列表分页数据接口
    @RequestMapping("/manamy")
    public ApiResponse<Dingdan> manaMy(Dingdan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdan> dingdanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanList);
    }

    //后台-根据条件获取订单查看列表分页数据接口
    @RequestMapping("/chakan")
    public ApiResponse<Dingdan> chakan(Dingdan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdan> dingdanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanList);
    }

    //后台-根据条件获取订单查看我的列表分页数据接口
    @RequestMapping("/chakanmy")
    public ApiResponse<Dingdan> chakanMy(Dingdan req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo, @RequestParam(defaultValue = "10", value = "pageSize") int pageSize, @RequestParam(defaultValue = "id", value = "sortProperty") String sortProperty) {
        PageData<Dingdan> dingdanList = getPageList(req, pageNo, pageSize, sortProperty);
        return ApiResponse.success(dingdanList);
    }

    //后台-订单详情
    @RequestMapping("/info/{id}")
    public ApiResponse<Dingdan> info(@PathVariable("id") Integer id) {
        Dingdan info = dingdanService.findById(id);
        return ApiResponse.success(info);
    }

    //后台-订单添加接口
    @PostMapping("/save")
    public ApiResponse<Integer> save(@RequestBody Dingdan req, HttpSession session, String shangPinId) {
        Users users = (Users) session.getAttribute("users");
        List<Gouwuche> gouwucheList = new ArrayList<>();
        if (null != users && null != users.getId()) {
            if (null == shangPinId || shangPinId.equals("0")) {
                //从购物车里提交订单下单
                Gouwuche gouwuche = new Gouwuche();
                gouwuche.setUsersid(users.getId());
                gouwucheList = gouwucheService.find(gouwuche);
                }else {
                //商品详情页里直接购买下单
                Integer shangpinid = cn.hutool.core.convert.Convert.toInt(shangPinId);
                Gouwuche gouwuche = new Gouwuche();
                gouwuche.setShangpinid(shangpinid);
                gouwuche.setId(0);
                //直接购买时购买数量为1
                gouwuche.setGoumaishuliang(1);
                gouwucheList.add(gouwuche);
            }
            if (gouwucheList.size() == 0) {
                return ApiResponse.failed("请先将商品添加到购物车再提交订单！");
            } else {
                for (Gouwuche info : gouwucheList) {
                    Integer shangpinid = info.getShangpinid();
                    if (null == shangpinid || shangpinid == 0) {
                        return ApiResponse.failed("购物车里的商品数据异常！");
                    }
                    Integer goumaishuliang = info.getGoumaishuliang();
                    //库存判断
                    Shangpin shangpin = shangpinService.findById(shangpinid);
                    if (null != shangpin) {
                        Integer kucunshuliang = shangpin.getKucunshuliang();
                        //判断库存是否大于或等于订单数量
                        if (kucunshuliang < goumaishuliang) {
                            return ApiResponse.failed("购物车里的商品库存不足，请修正后再提交！");
                        }
                    } else {
                        return ApiResponse.failed("购物车里的商品不存在！");
                    }
                }
            }
        } else {
            return ApiResponse.failed("请登陆后再操作！");
        }
        int result = dingdanService.saveOrUpdate(req);
        //保存订单项数据、更新商品表数据以及删除购物车数据
        for (Gouwuche info : gouwucheList) {
            Integer shangpinid = info.getShangpinid();
            Integer goumaishuliang = info.getGoumaishuliang();

            //保存订单项数据
            Dingdanxiang dingdanxiang = new Dingdanxiang();
            dingdanxiang.setShangpinid(shangpinid);
            dingdanxiang.setGoumaishuliang(goumaishuliang);
            dingdanxiang.setUsersid(users.getId());
            dingdanxiang.setDingdanid(result);
            dingdanxiangService.saveOrUpdate(dingdanxiang);

            //更新商品表数据
            Shangpin shangpin = shangpinService.findById(shangpinid);
            Integer kucunshuliang = shangpin.getKucunshuliang();
            Integer xiaoshoushuliang = shangpin.getXiaoshoushuliang();
            //商品库存数量减去购买数量
            shangpin.setKucunshuliang(kucunshuliang - goumaishuliang);
            //商品销售数量加上购买数量
            shangpin.setXiaoshoushuliang(xiaoshoushuliang + goumaishuliang);
            shangpinService.saveOrUpdate(shangpin);

            //删除购物车数据
            gouwucheService.deleteById(info.getId());
        }
        return ApiResponse.success(result);
    }

    //订单删除(含批量删除)接口
    @RequestMapping("/delete")
    public ApiResponse<Integer> delete(@RequestBody Integer[] ids) {
        int result = 0;
        for (Integer id : ids) {
            result = dingdanService.deleteById(id);
        }
        return ApiResponse.success(result);
    }

    //订单修改接口
    @PostMapping("/set")
    public ApiResponse<Integer> set(@RequestBody Dingdan req) {
        int result = dingdanService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }

    //根据条件获取订单总金额接口
    @RequestMapping("/totalamount")
    public ApiResponse<Integer> getTotalamount(Dingdan req) {
        //计算订单总金额
        Integer totalAmount = 0;
        List<Dingdan> dingdanList = dingdanService.find(req);
        for (Dingdan dingdan : dingdanList) {
            totalAmount += dingdan.getJine();
        }
        return ApiResponse.success(totalAmount);
    }

    //获取所有订单数据接口
    @RequestMapping("/all")
    public ApiResponse<Dingdan> dingdanAll() {
        List<Dingdan> dingdanList = dingdanService.findAll();
        return ApiResponse.success(dingdanList);
    }

    //根据条件（字符类型模糊匹配查询）获取订单数据接口
    @IgnoreAuth
    @RequestMapping("/search")
    public ApiResponse<Dingdan> dingdanSearch(Dingdan req) {
        List<Dingdan> dingdanList = dingdanService.find(req);
        return ApiResponse.success(dingdanList);
    }

    //根据条件（字符类型完全匹配查询）获取订单数据接口
    @IgnoreAuth
    @RequestMapping("/searchByEqualTo")
    public ApiResponse<Dingdan> dingdanSearchByEqualTo(Dingdan req) {
        List<Dingdan> dingdanList = dingdanService.findByEqualTo(req);
        return ApiResponse.success(dingdanList);
    }

    //按条件查询订单分页数据方法(模糊匹配查询)
    private PageData<Dingdan> getPageList(Dingdan req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dingdan> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Dingdan> dingdanList = dingdanService.findPage(pageWrap);
        return dingdanList;
    }

    //按条件查询订单分页数据方法(完全匹配查询)
    private PageData<Dingdan> getPageListByEqualTo(Dingdan req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dingdan> pageWrap = getPageWrap(req, pageNo, pageSize, sortProperty);
        PageData<Dingdan> dingdanList = dingdanService.findPageByEqualTo(pageWrap);
        return dingdanList;
    }

    //获取订单查询用户数据搜索条件
    private PageWrap<Dingdan> getPageWrap(Dingdan req, int pageNo, int pageSize, String sortProperty) {
        PageWrap<Dingdan> pageWrap = new PageWrap<>();
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

package com.controller;

import com.annotation.IgnoreAuth;
import com.entity.Users;
import com.service.UsersService;
import com.util.ApiResponse;
import com.util.CommonUtil;
import com.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @ClassName LoginController
 * @Description 用户登陆模块控制层
 */
@RestController
public class LoginController {

    @Autowired
    private UsersService usersService;

    //登陆验证
    @IgnoreAuth
    @RequestMapping("/login")
    @ResponseBody
    public ApiResponse verify(HttpServletRequest request, String loginpw, String type, String loginname) {
        String result = "";
        Users users = new Users();
        users.setLoginname(loginname);
        users.setLoginpw(Md5Util.strToMd5(loginpw));
        if (null != type && !type.equals("")) {
            users.setType(type);
        }
        users = usersService.findOneByEqualTo(users);

        if (null == users || null == users.getId() || users.getId() == 0) {
            //返回登录失败
            result = "用户名或密码错误";
            return ApiResponse.failed(result);
        } else {
//            if (null == users.getShenhe() || (!users.getShenhe().toLowerCase().equals("yes") && !users.getShenhe().equals("是"))) {
//                //未审核返回登录失败
//                result = "用户未通过审核，请及时联系管理员处理";
//                return ApiResponse.failed(result);
//            }
            //返回登录成功
            String token = CommonUtil.getRandomString(32);
            System.out.println("生成token:" + token);
            HttpSession session = request.getSession();
            session.setAttribute("usersType", users.getType());
            session.setAttribute("usersId", users.getId());
            session.setAttribute("users", users);
            session.setAttribute("token", token);
            //session有效时间，单位为秒，-1表示当前会话内一直有效
            session.setMaxInactiveInterval(-1);
            HashMap<String,String> loginSuccess=new HashMap<>();
            loginSuccess.put("token",token);
            loginSuccess.put("usersId",users.getId().toString());
            return ApiResponse.success(loginSuccess);
        }
    }
}

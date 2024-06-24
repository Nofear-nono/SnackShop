package com.controller;

import com.annotation.IgnoreAuth;
import com.util.ApiResponse;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.Date;

/**
 * @ClassName CommonController
 * @Description 通用方法模块控制层
 */
@RestController
@RequestMapping("/common")
public class CommonController {

    /**
     * 上传文件
     */
    @IgnoreAuth
    @RequestMapping("/uploadfile")
    public ApiResponse<String> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        if (file.isEmpty()) {
            return ApiResponse.failed(400, "文件不能为空");
        }
        String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1);
        File path = new File(ResourceUtils.getURL("classpath:static").getPath());
        if (!path.exists()) {
            path = new File("");
        }
        File upload = new File(path.getAbsolutePath(), "/upload/");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        String fileName = new Date().getTime() + "." + fileExt;
        File dest = new File(upload.getAbsolutePath() + "/" + fileName);
        file.transferTo(dest);

        return ApiResponse.success(fileName);
    }


    /**
     * 文件下载
     *
     * @throws IOException
     */
    @IgnoreAuth
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam(value = "filename") String filename,
                         HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        //需要下载的文件
        String path = ResourceUtils.getURL("classpath:static").getPath() + "/" + filename;
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename, "UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
    }
}

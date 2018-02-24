package com.sx.common.controller;


import com.sx.common.service.LinkageService;
import com.sx.common.util.AjaxJsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZR on 2016/12/3.
 */
@RequestMapping("linkage")
@Controller
public class LinkageController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private LinkageService linkageService;


    /**
     * 固定类别二级联动
     * @param request httpRequest的请求对象
     * @param response response的响应类
     */
    @RequestMapping("ajax-sel")
    public void ajax_sel(HttpServletRequest request,
                         HttpServletResponse response) {
        AjaxJsonResult ajaxJsonResult = new AjaxJsonResult();
        try {
                String lb = request.getParameter("lb");
                String param = request.getParameter("param");
                String sel = request.getParameter("sel");
                String html = linkageService.ajax_sel(lb, param, sel, "cdg_regioncode");// table
                Map map = new HashMap();
                map.put("html", html);
                ajaxJsonResult.setReturnData(map);
        } catch (Exception e) {
            logger.error("errorMessage :{}", e.getMessage());
            ajaxJsonResult.setSysException(e);
        } finally {
            try {
                response.setContentType("text/html;charset=utf-8");
                String res = AjaxJsonResult.getJson(ajaxJsonResult);
                PrintWriter pw = response.getWriter();
                pw.write(res);
                pw.flush();
                pw.close();
            } catch (Exception e) {
            }
        }
    }
}

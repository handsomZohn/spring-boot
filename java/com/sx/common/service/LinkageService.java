package com.sx.common.service;

import com.sx.common.dao.LinkageDao;

import com.sx.common.helper.StringHelper;
import com.sx.support.dba.dbSQLResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ZR on 2016/12/3.
 */
@Service
public class LinkageService {

    @Resource
    private LinkageDao linkageDao;


    /**
     * 二级联动
     * @param lb 列表
     * @param param 参数
     * @param sel 选中的
     * @param table 表明
     * @return 返回处理后的html数据
     * @throws Exception 未知异常
     */
    public String ajax_sel(String lb, String param, String sel, String table) throws Exception {
        if (StringHelper.isEmpty(param)) {
            return "";
        }
        String html = "";
        String Default = "0000";
        if ("1".equals(lb)) {// 二级类别
            dbSQLResult rs = linkageDao.getQ(param, table);
            if (rs == null || rs.getReturnCode() != 0 || rs.getRows() == 0) {
                return "<option value=\"" + Default + "\">" + "请选择" + "</option>";
            }
            StringBuffer str = new StringBuffer();
            str.append("<option value=\"" + Default + "\">" + "请选择" + "</option>");
            for (int i = 0; i < rs.getRows(); i++) {
                if (rs.getData()[i][0].equals(sel)) {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\" selected>"
                            + rs.getData()[i][1] + "</option>");
                } else {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\">" + rs.getData()[i][1]
                            + "</option>");
                }
            }
            html = str.toString();
        } else if ("2".equals(lb)) {// 点击二级类别，查询三级类别
            dbSQLResult rs = linkageDao.getJd(param, table);
            if (rs == null || rs.getReturnCode() != 0 || rs.getRows() == 0) {
                return "<option value=\"" + Default.substring(0, 3) + "\">" + "请选择" + "</option>";
            }
            StringBuffer str = new StringBuffer();
            str.append("<option value=\"" + Default.substring(0, 3) + "\">" + "请选择" + "</option>");
            for (int i = 0; i < rs.getRows(); i++) {
                if (rs.getData()[i][0].equals(sel)) {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\" selected>"
                            + rs.getData()[i][1] + "</option>");
                } else {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\">" + rs.getData()[i][1]
                            + "</option>");
                }
            }
            html = str.toString();
        } else if ("3".equals(lb)) {// 点击三级类别，查询四级类别
            dbSQLResult rs = linkageDao.getC(param, table);
            if (rs == null || rs.getReturnCode() != 0 || rs.getRows() == 0) {
                return "<option value=\"" + Default.substring(0, 3) + "\">" + "请选择" + "</option>";
            }
            StringBuffer str = new StringBuffer();
            str.append("<option value=\"" + Default.substring(0, 3) + "\">" + "请选择" + "</option>");
            for (int i = 0; i < rs.getRows(); i++) {
                if (rs.getData()[i][0].equals(sel)) {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\" selected>"
                            + rs.getData()[i][1] + "</option>");
                } else {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\">" + rs.getData()[i][1]
                            + "</option>");
                }
            }
            html = str.toString();
        } else {// 一级类别
            dbSQLResult rs = linkageDao.getS(param, table);
            if (rs == null || rs.getReturnCode() != 0 || rs.getRows() == 0) {
                return "";
            }
            StringBuffer str = new StringBuffer();
            str.append("<option value=\"00\">" + "请选择" + "</option>");
            for (int i = 0; i < rs.getRows(); i++) {
                if (rs.getData()[i][0].equals(sel)) {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\" selected>"
                            + rs.getData()[i][1] + "</option>");
                } else {
                    str.append("<option value=\"" + rs.getData()[i][0] + "\">" + rs.getData()[i][1]
                            + "</option>");
                }
            }
            html = str.toString();
        }
        return html;
    }

}

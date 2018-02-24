package com.sx.common.entity;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

/**
 * Created by Administrator on 2017/5/5.
 */
@ExcelTarget("cdgRegioncodeVo")
public class CdgRegioncodeVo {

    @Excel(name = "ID")
    private String cdId;

    @Excel(name = "NAME")
    private String cdName;

    public String getCdId() {
        return cdId;
    }

    public void setCdId(String cdId) {
        this.cdId = cdId;
    }

    public String getCdName() {
        return cdName;
    }

    public void setCdName(String cdName) {
        this.cdName = cdName;
    }

    @Override
    public String toString() {
        return "CdgRegioncodeVo{" +
                "cdId='" + cdId + '\'' +
                ", cdName='" + cdName + '\'' +
                '}';
    }

    public CdgRegioncodeVo(String cdId, String cdName) {
        this.cdId = cdId;
        this.cdName = cdName;
    }

    public CdgRegioncodeVo() {
    }
}

package com.sx.common.service;


import com.sx.common.dao.ExportExcelDao;
import com.sx.common.entity.CdgRegioncodeVo;
import com.sx.exception.DbException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/4/26.
 */
@Service
public class ExportExcelService {

    @Autowired
    private ExportExcelDao exportExcelDao;

    public List<CdgRegioncodeVo> getAll(String num) throws DbException {
        List<CdgRegioncodeVo> cdgregioncodes = exportExcelDao.getAll(num);
        return cdgregioncodes;
    }
}

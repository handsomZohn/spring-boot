package com.sx.common.dao;

import com.sx.common.entity.CdgRegioncodeVo;
import com.sx.db.AbsDaoSupport;
import com.sx.exception.DbException;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/27.
 */
@Repository
public class ExportExcelDao extends AbsDaoSupport{

    public List<CdgRegioncodeVo> getAll(String num){
        List<CdgRegioncodeVo> cdgregioncodes = new ArrayList<>();
        String sql = "SELECT CD_ID as cdId,CD_NAME as cdName from (SELECT CD_ID,CD_NAME,rownum n from CDG_REGIONCODE) t\n" +
                "where t.n<= ?";
        String [] param = {num};
        try {
            cdgregioncodes = this.querySqlForList(sql,param,CdgRegioncodeVo.class);
        } catch (DbException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cdgregioncodes;
    }

}

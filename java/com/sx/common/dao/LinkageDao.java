package com.sx.common.dao;

import com.sx.db.AbsDaoSupport;
import com.sx.exception.DbException;
import com.sx.support.dba.dbSQLResult;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZR on 2016/12/3.
 */
@Repository
public class LinkageDao  extends AbsDaoSupport {
    /**
     * 市
     * @param param 参数
     * @param table 表名称
     * @return dbsql结果集
     * @throws DbException 数据库dba组件异常
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public dbSQLResult getS(String param, String table) throws DbException {
        List list = new ArrayList();
        String sql = "select substr(cd_id,1,2), cd_name from " + table
                + " where substr(cd_id,3,10) = ? ";
        list.add("0000000000");
        if ("11".equals(param)) {
            sql += " and substr(cd_id,1,2)=?";
            list.add(param);
        }
        sql += " order by cd_id";
        String[] condition = new String[list.size()];
        list.toArray(condition);
        list.clear();
        dbSQLResult dbr = this.query(sql, condition);
        return dbr;
    }

    /**
     * 区
     * @param param 参数
     * @return dbsql结果集
     * @throws DbException 数据库dba组件异常
     * @return dbsql数据结果集
     */
    public dbSQLResult getQ(String param, String table) throws DbException {
        String sql = "select substr(cd_id,3,4), cd_name from "
                + table
                + " where "
                + "substr(cd_id,1,2)=? and substr(cd_id,3,4)<>? and  substr(cd_id,7,12)=? order by cd_id";
        dbSQLResult dbr = this.query(sql, new String[] { param, "0000", "000000" });
        return dbr;
    }

    /**
     * 街道
     * @param param 参数
     * @return dbsql结果集
     * @throws DbException 数据库dba组件异常
     * @return dbsql数据结果集
     */
    public dbSQLResult getJd(String param, String table) throws DbException {
        String sql = "select substr(cd_id,7,3),cd_name from " + table + " where"
                + " substr(cd_id,1,6)=? and substr(cd_id,7,3)<>? "
                + " and substr(cd_id, 10, 3) = ? order by cd_id ";
        dbSQLResult dbr = this.query(sql, new String[] { param, "000", "000" });
        return dbr;
    }

    /**
     * 村
     * @param param 参数
     * @param table 表名称
     * @return dbsql结果集
     * @throws DbException 数据库dba组件异常
     * @return dbsql数据结果集
     */
    public dbSQLResult getC(String param, String table) throws DbException {
        String sql = "select substr(cd_id,10,3), cd_name from " + table + " where"
                + " substr(cd_id, 1, 9) =? and substr(cd_id, 10, 3) <>? order by cd_id ";
        dbSQLResult dbr = this.query(sql, new String[] { param, "000" });
        return dbr;
    }
}

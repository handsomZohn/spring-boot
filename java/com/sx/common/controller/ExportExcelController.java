package com.sx.common.controller;


import com.sx.common.entity.CdgRegioncodeVo;
import com.sx.common.entity.RequestBean;
import com.sx.common.service.ExportExcelService;
import com.sx.exception.DbException;
import com.sx.utility.DateTools;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelStyleType;
import org.jeecgframework.poi.word.WordExportUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/26.
 */
@Controller
@RequestMapping("/export")
public class ExportExcelController {

    private Logger logger = LoggerFactory.getLogger(ExportExcelController.class);

    @Autowired
    private ExportExcelService exportExcelService;


    @PostMapping("/import")
    public String importExcel(@RequestParam(value = "file", required = false) MultipartFile file,HttpServletRequest request) throws Exception {

        //设置导入参数
        ImportParams params = new ImportParams();
        //设置导入第几个表格
        params.setSheetNum(1);
        //设置表头行
        params.setTitleRows(0);
        //设置标题行
        params.setHeadRows(1);
        params.setNeedSave(true);

        //导入数据
        List<CdgRegioncodeVo> cdgregioncodes =ExcelImportUtil.importExcel(file.getInputStream(),CdgRegioncodeVo.class,params);

       return "success";
    }


    @GetMapping("/cx")
    public String cx(RequestBean requestBean,HttpServletRequest request){
        try {

            List<CdgRegioncodeVo> cdgregioncodes = exportExcelService.getAll(requestBean.getNum());
            request.setAttribute("param",requestBean.getNum());
            request.setAttribute("cdgregioncodes", cdgregioncodes);
            request.getSession().setAttribute("us", cdgregioncodes);
            //throw new DbException("error");
        } catch (DbException e) {
            logger.error("errorMessage :{}",e.getMsg());
        }
        return "list";
    }




    @PostMapping(value = "/export")
    public void exportXls(RequestBean requestBean, HttpServletResponse response) throws Exception {
        //设置文件名
        String codedFileName = "excel.xlsx";
        //模板路径
        String pathname = "export/";
        String excelTemplateUrl = pathname+"ceshi.xlsx";



        //获取需要的数据集合
        List<CdgRegioncodeVo> data = exportExcelService.getAll(requestBean.getNum());

        //设置导出参数
        TemplateExportParams params = new TemplateExportParams(
                excelTemplateUrl,true);

        params.setStyle(ExcelStyleType.BORDER.getClazz());

        //设置表格的Map
        Map<Integer,Map<String,Object>> sheetMap = new HashMap<Integer, Map<String,Object>>();
        Map<String, Object> map = new HashMap<String, Object>();

        //放入数据
        map.put("cdgregioncodes",data);
        //设置数据在第几个表
        sheetMap.put(0,map);

        //导出的book
        Workbook book = ExcelExportUtil.exportExcel(sheetMap,params);


        response.setContentType("application/vnd.ms-excel");
        response.setHeader("content-disposition", "attachment;filename="+codedFileName);

        //导出
       OutputStream outputStream = response.getOutputStream();
        book.write(outputStream);
       outputStream.flush();
       /* ByteArrayOutputStream os = new ByteArrayOutputStream();
        book.write(os);
        byte[] books = os.toByteArray();
        return  books;*/
    }

    @GetMapping(value = "/exportword")
    public void exportWord(HttpServletResponse response) throws Exception {
        //模板路径
        String pathname = "export/";
        String wordTemplateUrl = pathname+"ceshi.docx";

        //获取需要导出的数据
        List<CdgRegioncodeVo> cdgregioncodes = exportExcelService.getAll("5");

        //设置导出名字
        String codedFileName = "word.docx";

        //设置模板中的数据
        String time = new DateTools().getDate("yyyy-MM-dd");
        String[] times = time.split("-");
        String year = times[0];
        String month = times[1];
        String day = times[2];
        Map<String,Object> data = new HashedMap();
        data.put("year",year);
        data.put("month",month);
        data.put("day",day);

        data.put("cdgregioncodes", cdgregioncodes);


        response.setContentType("application/msword");
        response.setHeader("content-disposition", "attachment;filename="+codedFileName);
        //导出的doc文件
        XWPFDocument document = WordExportUtil.exportWord07(wordTemplateUrl,data);


        //导出
        OutputStream out = response.getOutputStream();
        document.write(out);
        out.flush();

    }


}

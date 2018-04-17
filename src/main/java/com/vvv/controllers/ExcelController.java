package com.vvv.controllers;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class ExcelController {

    private Logger logger = Logger.getLogger(ExcelController.class);

    @RequestMapping("/excelUpLoad")
    public String excelUpLoad(MultipartFile file){
        try {
            InputStream is = file.getInputStream();
            Workbook wb;
            if (file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")).equals("xls")){
                wb = new HSSFWorkbook(is);

            }else {
                wb = new XSSFWorkbook(is);
            }
            logger.info(wb.getNumberOfSheets());
            wb.getNumberOfSheets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fileUpLoadSuccess";
    }

}

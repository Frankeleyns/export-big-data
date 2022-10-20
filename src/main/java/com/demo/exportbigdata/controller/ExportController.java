package com.demo.exportbigdata.controller;

import com.demo.exportbigdata.util.ExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 导出控制器
 *
 * @author frankeleyn
 * @email lvjian@qhdswl.com
 * @date 2022/9/5 9:06
 */
@RestController
@RequestMapping("/export")
public class ExportController {

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ExportService exportService;

    @GetMapping("/test")
    public String test() {
        return "测试导出";
    }

    /**
     * 测试 poi 导出
     * @return
     */
    @GetMapping("/poi")
    public String poiExport() {
        try {
            String titles[] = {"序号", "商户订单编号", "商户号", "商户名称", "门店编号", "门店名称", "平台名称", "购买人姓名", "购买人身份证", "收货人姓名", "收货人地址"};
            return exportService.poiExport(response, titles);
        } catch (Exception e) {
            e.printStackTrace();
            return "导出失败";
        }
    }


}

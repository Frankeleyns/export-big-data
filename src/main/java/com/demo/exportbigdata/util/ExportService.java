package com.demo.exportbigdata.util;

import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.exportbigdata.mapper.CbecOrderMapper;
import com.demo.exportbigdata.model.CbecOrder;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 导出工具类
 *
 * @author frankeleyn
 * @email lvjian@qhdswl.com
 * @date 2022/9/14 16:58
 */
@Service
@Slf4j
public class ExportService {

    @Resource
    private CbecOrderMapper mapper;

    /**
     * poi 导出
     * @return
     */
    public String poiExport(HttpServletResponse response, String[] titles) {
        long startTime = System.currentTimeMillis();
        List<CbecOrder> orderList = getData();

        // 创建 workbook
        HSSFWorkbook wb = new HSSFWorkbook();

        // 拆分list, 每个sheet 六万行
        List<List<CbecOrder>> splitList = ListUtil.split(orderList, 60000);

        for (int j = 0; j < splitList.size(); j++) {
            // 获取拆分的 list
            List<CbecOrder> cbecOrders = splitList.get(j);

            // 添加一个 sheet
            HSSFSheet sheet = wb.createSheet("订单数据" + j+1);
            // 添加表头
            HSSFRow row = sheet.createRow(0);
            for (int i = 0; i < titles.length; i++) {
                sheet.setColumnWidth(i, 5000);
                row.createCell(i).setCellValue(titles[i]);
            }
            // 写入实体数据
            for (int i = 0; i < cbecOrders.size(); i++) {
                row = sheet.createRow(i + 1);
                CbecOrder order = cbecOrders.get(i);
                // 创建单元格设置值
                row.createCell(0).setCellValue(order.getOrderSn());
                row.createCell(1).setCellValue(order.getMerchOrderSn());
                row.createCell(2).setCellValue(order.getMerchSn());
                row.createCell(3).setCellValue(order.getMerchName());
                row.createCell(4).setCellValue(order.getShopSn());
                row.createCell(5).setCellValue(order.getShopName());
                row.createCell(6).setCellValue(order.getPlatName());
                row.createCell(7).setCellValue(order.getBuyerName());
                row.createCell(8).setCellValue(order.getBuyerIdCode());
                row.createCell(9).setCellValue(order.getConsigneeName());
                row.createCell(10).setCellValue(order.getConsigneeAddress());
            }

        }

        try (ByteArrayOutputStream os = new ByteArrayOutputStream();){
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String("poi订单导出.xlsx".getBytes("UTF-8"), "ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

            wb.write(os);
            byte[] content = os.toByteArray();
            InputStream is = new ByteArrayInputStream(content);
            // 获取响应输出流
            ServletOutputStream out = response.getOutputStream();
            // 使用缓冲流导出
            try(BufferedInputStream bis = new BufferedInputStream(is);
                BufferedOutputStream bos = new BufferedOutputStream(out);) {
                byte[] buff = new byte[2048];
                int bytesRead;
                while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                    bos.write(buff, 0, bytesRead);
                }
            }

        }catch (Exception e) {
            log.error("poi导出失败 => {}", e);
        }

        long endTime = System.currentTimeMillis();
        log.info("POI 导出耗时 =====》 ：" + (endTime - startTime) + "ms");
        return "导出成功";
    }



    // 获取导出数据
    private List<CbecOrder> getData() {
        Page<CbecOrder> page = new Page<>(1L, 10L);
        IPage<CbecOrder> orderPage = mapper.selectPage(page, null);
        //List<CbecOrder> orderList = orderPage.getRecords();
        List<CbecOrder> orderList = mapper.selectList(null);
        return orderList;
    }

}

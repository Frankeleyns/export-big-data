package com.demo.exportbigdata;

import cn.hutool.core.collection.ListUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.demo.exportbigdata.mapper.CbecOrderMapper;
import com.demo.exportbigdata.model.CbecOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ExportBigDataApplicationTests {

    @Resource
    private CbecOrderMapper cbecOrderMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testMapper() {

        CompletableFuture<Void> task1 = CompletableFuture.runAsync(() -> {
            for (int i = 0; i <= 50000; i++) {
                insert(i);
            }
            System.out.println("task1 完成");
        });

        CompletableFuture<Void> task2 = CompletableFuture.runAsync(() -> {
            for (int i = 50001; i <= 100000; i++) {
                insert(i);
            }
            System.out.println("task2 完成");
        });

        CompletableFuture<Void> task3 = CompletableFuture.runAsync(() -> {
            for (int i = 100001; i <= 150000; i++) {
                insert(i);
            }
            System.out.println("task3 完成");
        });

        CompletableFuture<Void> task4 = CompletableFuture.runAsync(() -> {
            for (int i = 150001; i <= 200000; i++) {
                insert(i);
            }
            System.out.println("task4 完成");
        });

        CompletableFuture<Void> task5 = CompletableFuture.runAsync(() -> {
            for (int i = 200001; i <= 250000; i++) {
                insert(i);
            }
            System.out.println("task4 完成");
        });

        CompletableFuture.allOf(task1, task2, task3, task4).join();
    }


    public void insert(int i) {
        CbecOrder cbecOrder =
                CbecOrder.builder()
                        .orderSn("odxxxxxx" + i)
                        .merchOrderSn("Zxxxxx" + i)
                        .merchSn("mhbsxxxxxxxxx")
                        .merchName("xxx科技")
                        .shopSn("wbxxxxxxxxxxx")
                        .shopName("xxxxxxx门店")
                        .platSn("mxxxxxx")
                        .platName("xxxxxx商城")
                        .thirdPartyMerchCode("xxxxxx")
                        .thirdPartyMerchName("xxxxxxxx")
                        .eBizType("10")
                        .eClearType("10")
                        .cusCode("06")
                        .bondedCode("xxxxxxxx")
                        .wareSn("xxxxxxxx")
                        .orderStatus("xxx")
                        .placeOrderlTime(new Date())
                        .buyerBillTime(new Date())
                        .buyerIdType("1")
                        .buyerIdCode("4xxxxxxxxxx")
                        .buyerName("xx辉")
                        .buyerMob("131xxxxxxxx")
                        .createTime(new Date())
                        .modTime(new Date())
                        .build();
        cbecOrderMapper.insert(cbecOrder);
    }

    @Test
    public void testListUtil() {
        Page<CbecOrder> page = new Page<>(1L, 10L);
        IPage<CbecOrder> orderPage = cbecOrderMapper.selectPage(page, null);
        List<CbecOrder> orderList = orderPage.getRecords();
        List<List<CbecOrder>> lists = ListUtil.split(orderList, 3);
        lists.stream().forEach(o -> System.out.println(o.size()));
    }

}

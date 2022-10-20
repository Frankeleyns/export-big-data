package com.demo.exportbigdata.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MybatisPlus配置
 *
 * @author frankeleyn
 * @email lvjian@qhdswl.com
 * @date 2022/9/14 17:08
 */
@Configuration
public class MyBatisPlusConfig {

    @Bean
    public PaginationInterceptor mybatisPlusInterceptor() {
        return new PaginationInterceptor();
    }

}

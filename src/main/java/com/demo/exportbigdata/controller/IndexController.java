package com.demo.exportbigdata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 主页控制器
 *
 * @author frankeleyn
 * @email lvjian@qhdswl.com
 * @date 2022/10/19 14:45
 */
@Controller
public class IndexController {

    @GetMapping({"/","/index"})
    public String index() {
        return "index";
    }
}

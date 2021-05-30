package com.cu.test.controller;

import com.cu.test.service.GrpcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@Controller
public class TestController {

    @Autowired
    GrpcService grpcService;


    @GetMapping("/test")
    public String test(String test, String message, ModelMap model){
        log.debug("test["+test+"]");
//


        String str = grpcService.sampleCall(test, message);
        model.addAttribute("test", str);
        return "jsonView";
    }
}

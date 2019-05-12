package com.Lang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class productController {

   @RequestMapping("product_list")
    public String getProduct_list(){

       return "product_list";
   }

}

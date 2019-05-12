package com.Lang.controller;

import com.Lang.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;

import java.util.List;

//商品分类管理

@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam (value = "parentId",defaultValue = "0") int parentId){
        List<EasyUITree> easyUITrees = productCategoryService.findProductCategoryListByPatentId(parentId);

        return easyUITrees;
    }


}

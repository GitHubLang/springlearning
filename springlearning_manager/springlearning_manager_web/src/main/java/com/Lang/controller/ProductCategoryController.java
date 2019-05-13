package com.Lang.controller;

import com.Lang.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

//商品分类管理

@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam (value = "id",defaultValue = "0") int parentId){
        List<EasyUITree> easyUITrees = productCategoryService.findProductCategoryListByPatentId(parentId);

        return easyUITrees;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCaegory(int parentId,String name){
        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId,name);
        return responseJsonResult;
    }

    @RequestMapping("/rename")
    @ResponseBody
    public ResponseJsonResult renameCategory(int id ,String name)
    {
        ResponseJsonResult responseJsonResult = productCategoryService.renameCategory(id,name);
        return responseJsonResult;
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseJsonResult removeCategory(int parentId, int id)
    {
        ResponseJsonResult responseJsonResult = productCategoryService.removeCategory(parentId,id);
        return responseJsonResult;
    }


}

package com.Lang.service.impl;

import com.Lang.mapper.ProductCategoryMapper;
import com.Lang.pojo.ProductCategory;
import com.Lang.pojo.ProductCategoryExample;
import com.Lang.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Override
    public List<EasyUITree> findProductCategoryListByPatentId(int parentid) {

        ProductCategoryExample productCategoryExample =  new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentid);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);

        List<EasyUITree> easyUITrees = new ArrayList<>(productCategoryList.size());

        for(ProductCategory productCategory : productCategoryList){

            EasyUITree easyUITree = new EasyUITree();
            easyUITree.setId(productCategory.getCatid());
            easyUITree.setState(productCategory.getParentId()==0? "closed":"open" );
            easyUITree.setText(productCategory.getName());
            easyUITree.setAttributes(productCategory.getParentId()+"");

            easyUITrees.add(easyUITree);

        }
        return easyUITrees;
    }

    @Override
    public ResponseJsonResult addCategory(int parenetid, String name) {
        ProductCategory productCategory = new ProductCategory();

        productCategory.setParentId(parenetid);
        productCategory.setName(name);

        productCategoryMapper.insert(productCategory);
        ResponseJsonResult responseJsonResult =new ResponseJsonResult();

        responseJsonResult.setMsg(productCategory.getCatid()+"");

        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult removeCategory(int parentid, int catId) {

       ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        if(parentid==0){

            criteria.andCatidEqualTo(catId);
            ProductCategoryExample.Criteria criteria1 = productCategoryExample.createCriteria();

            criteria1.andParentIdEqualTo(catId);
            productCategoryExample.or(criteria1);

        }
        else{

            criteria.andCatidEqualTo(catId);
        }

        productCategoryMapper.deleteByExample(productCategoryExample);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg("success");
        responseJsonResult.setStatus(200);

        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult renameCategory(int catId,String name) {

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        criteria.andCatidEqualTo(catId);

       List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);

        ProductCategory productCategory = productCategoryList.get(0);
        productCategory.setName(name);

        productCategoryMapper.updateByExample(productCategory,productCategoryExample);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg("success");
        responseJsonResult.setStatus(200);

        return responseJsonResult;
    }
}

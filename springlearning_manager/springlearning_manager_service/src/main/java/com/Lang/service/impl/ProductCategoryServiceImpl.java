package com.Lang.service.impl;

import com.Lang.mapper.ProductCategoryMapper;
import com.Lang.pojo.ProductCategory;
import com.Lang.pojo.ProductCategoryExample;
import com.Lang.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITree;

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

            easyUITrees.add(easyUITree);

        }
        return easyUITrees;
    }
}

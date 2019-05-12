package com.Lang.service;

import pojo.EasyUITree;

import java.util.List;

public interface ProductCategoryService {

    List<EasyUITree> findProductCategoryListByPatentId(int parentid);
}

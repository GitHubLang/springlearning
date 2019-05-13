package com.Lang.service;

import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

public interface ProductCategoryService {

    List<EasyUITree> findProductCategoryListByPatentId(int parentid);
    ResponseJsonResult addCategory(int parenetid,String name);
    ResponseJsonResult removeCategory(int parentid, int catId);
    ResponseJsonResult renameCategory(int catId,String name);
}

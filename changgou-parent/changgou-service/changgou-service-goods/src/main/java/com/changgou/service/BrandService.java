package com.changgou.service;

import com.changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface BrandService {
    List<Brand> findAll();

    Brand findById(Integer id);

    /**
     * 条件查询
     */
    List<Brand> findList(Brand brand);

    /**
     * 分页搜索
     * @param page:当前页
     * @param size:每页条数
     */
    PageInfo<Brand> findPage(Integer page,Integer size);

    /**
     * 条件分页搜索
     * @param page:当前页
     * @param size:每页条数
     */
    PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);

    /**
     * 增加品牌
     */
    void add(Brand brand);

    /**
     * 修改品牌
     */
    void update(Brand brand);

    /**
     * 根据id删除品牌
     */
    void delete(Integer id);

    /***
     * 根据分类ID查询品牌集合
     * @param categoryid:分类ID
     */
    List<Brand> findByCategory(Integer categoryid);

}

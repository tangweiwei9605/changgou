package com.changgou.controller;

import com.changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    /*
    * 查询所有品牌
    *
    */
    @GetMapping
    public Result<List<Brand>> findAllBrand(){
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询所有品牌成功",brands);
    }

    /**
     * 分页查询
     */
    @PostMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(brand,page,size);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK,"分页查询成功",pageInfo);
    }

    /**
     * 条件分页查询
     */
    @GetMapping(value = "/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value = "page")Integer page,@PathVariable(value = "size")Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(page,size);
        return new Result<PageInfo<Brand>>(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /**
     * 根据id查询品牌
     */

    @GetMapping(value = "/{id}")
    public Result<Brand> findById(@PathVariable(value = "id")Integer id){
        Brand brand = brandService.findById(id);

        return new Result<Brand>(true, StatusCode.OK,"查询品牌成功",brand);
    }

    /**
     * 条件查询
     */
    @PostMapping(value = "search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        brandService.findList(brand);
        return new Result<List<Brand>>(true, StatusCode.OK,"查询品牌成功",brand);
    }


    /**
     * 增加品牌
     */
    @PostMapping
    public Result add(@RequestBody Brand brand){

        brandService.add(brand);
        return new Result(true,StatusCode.OK,"增加品牌成功");
    }

    /**
     * 修改品牌
     */

    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value = "id")Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"修改品牌成功");
    }

    /**
     * 根据id删除品牌
     */

    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable(value = "id")Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"删除品牌成功");
    }
}

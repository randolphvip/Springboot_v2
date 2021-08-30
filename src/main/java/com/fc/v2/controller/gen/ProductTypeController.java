package com.fc.v2.controller.gen;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResuTree;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.auto.ProductType;
import com.fc.v2.model.auto.ProductTypeExample;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.service.ProductTypeService;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品分类Controller
 * @ClassName: ProductTypeController
 * @author fuce
 * @date 2021-06-26 14:52:52
 */
@Api(value = "产品分类")
@Controller
@RequestMapping("/ProductTypeController")
public class ProductTypeController extends BaseController{
	
	private String prefix = "gen/productType";
	
	@Autowired
	private ProductTypeService productTypeService;
//	@Autowired
//	private RedisService redis;
	
	/**
	 * 产品分类页面展示
	 * @param model
	 * @return String
	 * @author fuce
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:productType:view")
    public String view(ModelMap model)
    {
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	//@Log(title = "产品分类", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:productType:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ProductType productType){
		PageInfo<ProductType> page=productTypeService.list(tablepar,productType) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
 
	 
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
//	System.out.println(redis.getCacheObject("sss")+"-----------------------------------------------------------------------Redis:");
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "产品分类新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:productType:add")
	@ResponseBody
	public AjaxResult add(ProductType productType){
		int b=productTypeService.insertSelective(productType);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
    @GetMapping("/selectParent")
	@ResponseBody
    public ResuTree selectParent(){
        List<ProductType> list = productTypeService.selectByExample(new ProductTypeExample());
        return dataTree(list);
    }

	
	
	/**
	 * 产品分类删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "产品分类删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:productType:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=productTypeService.deleteByPrimaryKey(ids);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	
	/**
	 * 修改跳转
	 * @param id
	 * @param mmap
	 * @return
	 */
	@ApiOperation(value = "修改跳转", notes = "修改跳转")
	@GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap map)
    {
        map.put("ProductType", productTypeService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "产品分类修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:productType:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ProductType productType)
    {
        return toAjax(productTypeService.updateByPrimaryKeySelective(productType));
    }

    
	
	/**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody ProductType record){
		int i=productTypeService.updateVisible(record);
		 return toAjax(i);
	}
    

	
}

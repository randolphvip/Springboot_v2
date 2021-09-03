package com.myprice.controller.gen;

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
import com.fc.v2.common.log.Log;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import com.myprice.model.auto.Category;
import com.myprice.model.auto.CategoryExample;
import com.myprice.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 产品分类Controller
 * @ClassName: CategoryController
 * 
 * @date 2021-06-26 14:52:52
 */
@Api(value = "产品分类")
@Controller
@RequestMapping("/CategoryController")
public class CategoryController extends BaseController{
	
	private String prefix = "gen/category";
	
	@Autowired
	private CategoryService categoryService;
//	@Autowired
//	private RedisService redis;
	
	/**
	 * 产品分类页面展示
	 * @param model
	 * @return String
	 * 
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:category:view")
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
	@RequiresPermissions("gen:category:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,Category category){
		PageInfo<Category> page=categoryService.list(tablepar,category) ; 
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
	@Log(title = "Create a new category", action = "Add")
	@ApiOperation(value = "Add", notes = "Add")
	@PostMapping("/add")
	@RequiresPermissions("gen:category:add")
	@ResponseBody
	public AjaxResult add(Category category){
		int b=categoryService.insertSelective(category);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
    @GetMapping("/selectParent")
	@ResponseBody
    public ResuTree selectParent(){
        List<Category> list = categoryService.selectByExample(new CategoryExample());
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
	@RequiresPermissions("gen:category:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=categoryService.deleteByPrimaryKey(ids);
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
        map.put("Category", categoryService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "产品分类修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:category:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Category category)
    {
        return toAjax(categoryService.updateByPrimaryKeySelective(category));
    }

    
	
	/**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody Category record){
		int i=categoryService.updateVisible(record);
		 return toAjax(i);
	}
    

	
}

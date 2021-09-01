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
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import com.myprice.model.auto.Commodity;
import com.myprice.model.auto.Shop;
import com.myprice.model.auto.ShopBranch;
import com.myprice.service.ShopBranchService;
import com.myprice.service.ShopService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Shop BranchController
 * @ClassName: ShopBranchController
 * @author Cong
 * @date 2021-09-01 23:13:10
 */
@Api(value = "Shop Branch")
@Controller
@RequestMapping("/ShopBranchController")
public class ShopBranchController extends BaseController{
	
	private String prefix = "gen/shopBranch";
	
	@Autowired
	private ShopBranchService shopBranchService;
	@Autowired
	private ShopService	shopservice;
	
	/**
	 * Shop Branch页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:shopBranch:view")
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
	//@Log(title = "Shop Branch", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:shopBranch:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,ShopBranch shopBranch){
		PageInfo<ShopBranch> page=shopBranchService.list(tablepar,shopBranch) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
		List<Shop> shopList=	shopservice.selectByExample(null);
		modelMap.put("shopList", shopList);
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "Shop Branch新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:shopBranch:add")
	@ResponseBody
	public AjaxResult add(ShopBranch shopBranch){
		int b=shopBranchService.insertSelective(shopBranch);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * Shop Branch删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "Shop Branch删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:shopBranch:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=shopBranchService.deleteByPrimaryKey(ids);
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
        map.put("ShopBranch", shopBranchService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "Shop Branch修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:shopBranch:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShopBranch shopBranch)
    {
        return toAjax(shopBranchService.updateByPrimaryKeySelective(shopBranch));
    }

    
	/**
	 * 修改状态
	 * @param record
	 * @return
	 */
	@ApiOperation(value = "update status", notes = "update status")
    @PutMapping("/updateStatus")
	@ResponseBody
    public AjaxResult updateStatus(@RequestBody ShopBranch record){
		int i=shopBranchService.updateByPrimaryKeySelective(record);
		 return toAjax(i);
	}


	
}

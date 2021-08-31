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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.auto.SysProvince;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import com.myprice.model.auto.Shop;
import com.myprice.model.auto.ShopCommodity;
import com.myprice.service.ShopCommodityService;
import com.myprice.service.ShopService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Shop CommodityController
 * @ClassName: ShopCommodityController
 * @author Cong
 * @date 2021-08-31 13:19:45
 */
@Api(value = "Shop Commodity")
@Controller
@RequestMapping("/ShopCommodityController")
public class ShopCommodityController extends BaseController{
	
	private String prefix = "gen/shopCommodity";
	
	@Autowired
	private ShopCommodityService shopCommodityService;
	
	@Autowired
	private ShopService shopService;
	
	
	/**
	 * Shop Commodity页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:shopCommodity:view")
    public String view(ModelMap model,String commodityId, String title)
    {
		model.put("commodityId", commodityId);
		model.put("title", title);
        return prefix + "/list";
    }
	
	/**
	 * list集合
	 * @param tablepar
	 * @param searchText
	 * @return
	 */
	//@Log(title = "Shop Commodity", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:shopCommodity:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,String searchText, Integer commodityId){
		System.out.println("------------------------------------------------------------------------>"+commodityId);
		 
		PageInfo<ShopCommodity> page=shopCommodityService.list(tablepar,searchText,commodityId) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap,String commodityId, String title)
    {
		
		List<Shop> shopList=shopService.selectByExample(null);
		modelMap.put("shopList", shopList);
		
		
		
		
		modelMap.put("commodityId", commodityId);
		modelMap.put("title", title);
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "Shop Commodity新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:shopCommodity:add")
	@ResponseBody
	public AjaxResult add(ShopCommodity shopCommodity){
		int b=shopCommodityService.insertSelective(shopCommodity);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * Shop Commodity删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "Shop Commodity删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:shopCommodity:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=shopCommodityService.deleteByPrimaryKey(ids);
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
        map.put("ShopCommodity", shopCommodityService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "Shop Commodity修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:shopCommodity:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ShopCommodity shopCommodity)
    {
        return toAjax(shopCommodityService.updateByPrimaryKeySelective(shopCommodity));
    }

    
	/**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody ShopCommodity record){
		int i=shopCommodityService.updateByPrimaryKeySelective(record);
		 return toAjax(i);
	}

    

	
}

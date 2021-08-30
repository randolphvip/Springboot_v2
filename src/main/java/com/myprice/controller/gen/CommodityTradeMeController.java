package com.myprice.controller.gen;

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
import com.myprice.model.auto.CommodityTradeMe;
import com.myprice.service.CommodityTradeMeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Trade MeController
 * @ClassName: CommodityTradeMeController
 * @author Cong
 * @date 2021-08-29 16:56:02
 */
@Api(value = "Trade Me")
@Controller
@RequestMapping("/CommodityTradeMeController")
public class CommodityTradeMeController extends BaseController{
	
	private String prefix = "gen/commodityTradeMe";
	
	@Autowired
	private CommodityTradeMeService commodityTradeMeService;
	
	
	/**
	 * Trade Me页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:CommodityTradeMe:view")
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
	//@Log(title = "Trade Me", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:CommodityTradeMe:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,CommodityTradeMe commodityTradeMe){
		PageInfo<CommodityTradeMe> page=commodityTradeMeService.list(tablepar,commodityTradeMe) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "Trade Me新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:CommodityTradeMe:add")
	@ResponseBody
	public AjaxResult add(CommodityTradeMe commodityTradeMe){
		int b=commodityTradeMeService.insertSelective(commodityTradeMe);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * Trade Me删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "Trade Me删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:CommodityTradeMe:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=commodityTradeMeService.deleteByPrimaryKey(ids);
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
        map.put("CommodityTradeMe", commodityTradeMeService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	
	
	/**
     * 修改保存
     */
    //@Log(title = "Trade Me修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:CommodityTradeMe:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityTradeMe commodityTradeMe)
    {
        return toAjax(commodityTradeMeService.updateByPrimaryKeySelective(commodityTradeMe));
    }
	
    
	/**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody CommodityTradeMe commodityTradeMe){
		int i=commodityTradeMeService.updateByPrimaryKeySelective(commodityTradeMe);
		 return toAjax(i);
	}



	
}

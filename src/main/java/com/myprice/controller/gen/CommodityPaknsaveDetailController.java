package com.myprice.controller.gen;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import com.myprice.model.auto.CommodityPaknsaveDetail;
import com.myprice.service.CommodityPaknsaveDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * paknsaveController
 * @ClassName: CommodityPaknsaveDetailController
 * @author Cong
 * @date 2021-08-28 20:06:21
 */
@Api(value = "paknsave")
@Controller
@RequestMapping("/CommodityPaknsaveDetailController")
public class CommodityPaknsaveDetailController extends BaseController{
	
	private String prefix = "gen/commodityPaknsaveDetail";
	
	@Autowired
	private CommodityPaknsaveDetailService commodityPaknsaveDetailService;
	
	
	/**
	 * paknsave页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:commodityPaknsaveDetail:view")
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
	//@Log(title = "paknsave", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:commodityPaknsaveDetail:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,CommodityPaknsaveDetail commodityPaknsaveDetail){
		PageInfo<CommodityPaknsaveDetail> page=commodityPaknsaveDetailService.list(tablepar,commodityPaknsaveDetail) ; 
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
	//@Log(title = "paknsave新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:commodityPaknsaveDetail:add")
	@ResponseBody
	public AjaxResult add(CommodityPaknsaveDetail commodityPaknsaveDetail){
		int b=commodityPaknsaveDetailService.insertSelective(commodityPaknsaveDetail);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * paknsave删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "paknsave删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:commodityPaknsaveDetail:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=commodityPaknsaveDetailService.deleteByPrimaryKey(ids);
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
        map.put("CommodityPaknsaveDetail", commodityPaknsaveDetailService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "paknsave修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:commodityPaknsaveDetail:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityPaknsaveDetail commodityPaknsaveDetail)
    {
        return toAjax(commodityPaknsaveDetailService.updateByPrimaryKeySelective(commodityPaknsaveDetail));
    }

    
    

	
}

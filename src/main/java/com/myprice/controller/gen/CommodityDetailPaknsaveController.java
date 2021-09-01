package com.myprice.controller.gen;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.myprice.model.auto.CommodityDetailPaknsave;
import com.myprice.service.CommodityDetailPaknsaveService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * PaknSaveController
 * @ClassName: CommodityDetailPaknsaveController
 * @author Cong
 * @date 2021-09-01 17:47:19
 */
@Api(value = "PaknSave")
@Controller
@RequestMapping("/CommodityDetailPaknsaveController")
public class CommodityDetailPaknsaveController extends BaseController{
	
	private String prefix = "gen/commodityDetailPaknsave";
	
	@Autowired
	private CommodityDetailPaknsaveService commodityDetailPaknsaveService;
	
	
	/**
	 * PaknSave页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:commodityDetailPaknsave:view")
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
	//@Log(title = "PaknSave", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:commodityDetailPaknsave:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,CommodityDetailPaknsave commodityDetailPaknsave){
		PageInfo<CommodityDetailPaknsave> page=commodityDetailPaknsaveService.list(tablepar,commodityDetailPaknsave) ; 
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
	//@Log(title = "PaknSave新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:commodityDetailPaknsave:add")
	@ResponseBody
	public AjaxResult add(CommodityDetailPaknsave commodityDetailPaknsave){
		int b=commodityDetailPaknsaveService.insertSelective(commodityDetailPaknsave);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * PaknSave删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "PaknSave删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:commodityDetailPaknsave:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=commodityDetailPaknsaveService.deleteByPrimaryKey(ids);
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
        map.put("CommodityDetailPaknsave", commodityDetailPaknsaveService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "PaknSave修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:commodityDetailPaknsave:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityDetailPaknsave commodityDetailPaknsave)
    {
        return toAjax(commodityDetailPaknsaveService.updateByPrimaryKeySelective(commodityDetailPaknsave));
    }

    
    

	
}

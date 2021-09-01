package com.myprice.controller.gen;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.myprice.model.auto.MonitorPrice;
import com.myprice.service.MonitorPriceService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * PriceController
 * @ClassName: MonitorPriceController
 * @author Cong
 * @date 2021-09-02 02:04:51
 */
@Api(value = "Price")
@Controller
@RequestMapping("/MonitorPriceController")
public class MonitorPriceController extends BaseController{
	
	private String prefix = "gen/monitorPrice";
	
	@Autowired
	private MonitorPriceService monitorPriceService;
	
	
	/**
	 * Price页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:monitorPrice:view")
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
	//@Log(title = "Price", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:monitorPrice:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,MonitorPrice monitorPrice){
		PageInfo<MonitorPrice> page=monitorPriceService.list(tablepar,monitorPrice) ; 
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
	//@Log(title = "Price新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:monitorPrice:add")
	@ResponseBody
	public AjaxResult add(MonitorPrice monitorPrice){
		int b=monitorPriceService.insertSelective(monitorPrice);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * Price删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "Price删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:monitorPrice:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=monitorPriceService.deleteByPrimaryKey(ids);
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
        map.put("MonitorPrice", monitorPriceService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "Price修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:monitorPrice:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MonitorPrice monitorPrice)
    {
        return toAjax(monitorPriceService.updateByPrimaryKeySelective(monitorPrice));
    }

    
    

	
}

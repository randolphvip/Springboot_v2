package com.myprice.controller.gen;

import com.fc.v2.common.base.BaseController;
import com.fc.v2.common.domain.AjaxResult;
import com.fc.v2.common.domain.ResultTable;
import com.fc.v2.model.custom.Tablepar;
import com.myprice.model.auto.CommodityDetailCountdown;
import com.myprice.service.CommodityDetailCountdownService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * CountDownController
 * @ClassName: CommodityDetailCountdownController
 * @author Cong
 * @date 2021-09-01 17:45:36
 */
@Api(value = "CountDown")
@Controller
@RequestMapping("/CommodityDetailCountdownController")
public class CommodityDetailCountdownController extends BaseController{
	
	private String prefix = "gen/commodityDetailCountdown";
	
	@Autowired
	private CommodityDetailCountdownService commodityDetailCountdownService;
	
	
	/**
	 * CountDown页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:commodityDetailCountdown:view")
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
	//@Log(title = "CountDown", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:commodityDetailCountdown:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,CommodityDetailCountdown commodityDetailCountdown){
		PageInfo<CommodityDetailCountdown> page=commodityDetailCountdownService.list(tablepar,commodityDetailCountdown) ; 
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
	//@Log(title = "CountDown新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:commodityDetailCountdown:add")
	@ResponseBody
	public AjaxResult add(CommodityDetailCountdown commodityDetailCountdown){
		int b=commodityDetailCountdownService.insertSelective(commodityDetailCountdown);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * CountDown删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "CountDown删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:commodityDetailCountdown:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=commodityDetailCountdownService.deleteByPrimaryKey(ids);
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
        map.put("CommodityDetailCountdown", commodityDetailCountdownService.selectByPrimaryKey(id));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "CountDown修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:commodityDetailCountdown:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CommodityDetailCountdown commodityDetailCountdown)
    {
        return toAjax(commodityDetailCountdownService.updateByPrimaryKeySelective(commodityDetailCountdown));
    }

    
    

	
}

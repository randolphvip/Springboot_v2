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
import com.fc.v2.model.auto.SysPosition;
import com.fc.v2.model.auto.SysPositionExample;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageInfo;
import com.myprice.model.auto.Commodity;
import com.myprice.model.auto.Template;
import com.myprice.model.auto.TemplateExample;
import com.myprice.service.CommodityService;
import com.myprice.service.TemplateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * commodityController
 * @ClassName: CommodityController
 * @author Cong
 * @date 2021-08-24 16:48:22
 */
@Api(value = "commodity")
@Controller
@RequestMapping("/CommodityController")
public class CommodityController extends BaseController{
	
	private String prefix = "gen/commodity";
	
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private TemplateService templateService;	
	
	/**
	 * commodity页面展示
	 * @param model
	 * @return String
	 * @author Cong
	 */
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/view")
	@RequiresPermissions("gen:commodity:view")
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
	//@Log(title = "commodity", action = "111")
	@ApiOperation(value = "分页跳转", notes = "分页跳转")
	@GetMapping("/list")
	@RequiresPermissions("gen:commodity:list")
	@ResponseBody
	public ResultTable list(Tablepar tablepar,Commodity commodity){
		PageInfo<Commodity> page=commodityService.list(tablepar,commodity) ; 
		return pageTable(page.getList(),page.getTotal());
	}
	
	/**
     * 新增跳转
     */
	@ApiOperation(value = "新增跳转", notes = "新增跳转")
    @GetMapping("/add")
    public String add(ModelMap modelMap)
    {
		
		List<Template> templates= templateService.selectByExample(new TemplateExample());
		//角色
		modelMap.put("templates",templates);
		//部门
		
        return prefix + "/add";
    }
	
    /**
     * 新增保存
     * @param 
     * @return
     */
	//@Log(title = "commodity新增", action = "111")
	@ApiOperation(value = "新增", notes = "新增")
	@PostMapping("/add")
	@RequiresPermissions("gen:commodity:add")
	@ResponseBody
	public AjaxResult add(Commodity commodity){
		int b=commodityService.insertSelective(commodity);
		if(b>0){
			return success();
		}else{
			return error();
		}
	}
	
	/**
	 * commodity删除
	 * @param ids
	 * @return
	 */
	//@Log(title = "commodity删除", action = "111")
	@ApiOperation(value = "删除", notes = "删除")
	@DeleteMapping("/remove")
	@RequiresPermissions("gen:commodity:remove")
	@ResponseBody
	public AjaxResult remove(String ids){
		int b=commodityService.deleteByPrimaryKey(ids);
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
        map.put("Commodity", commodityService.selectByPrimaryKey(id));
    	
		//引擎模板
		map.put("templates",templateService.selectByExample(new TemplateExample()));

        return prefix + "/edit";
    }
	
	/**
     * 修改保存
     */
    //@Log(title = "commodity修改", action = "111")
	@ApiOperation(value = "修改保存", notes = "修改保存")
    @RequiresPermissions("gen:commodity:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Commodity commodity)
    {
        return toAjax(commodityService.updateByPrimaryKeySelective(commodity));
    }

	
	
	/**
	 * 修改状态
	 * @param record
	 * @return
	 */
    @PutMapping("/updateVisible")
	@ResponseBody
    public AjaxResult updateVisible(@RequestBody Commodity record){
		int i=commodityService.updateByPrimaryKeySelective(record);
		 return toAjax(i);
	}

    
    

	
}

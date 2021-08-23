package com.myprice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myprice.mapper.auto.TemplateMapper;
import com.myprice.model.auto.Template;
import com.myprice.model.auto.TemplateExample;

import cn.hutool.core.util.StrUtil;

/**
 * crawler TemplateService
 * @Title: TemplateService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-23 00:56:01  
 **/
@Service
public class TemplateService implements BaseService<Template, TemplateExample>{
	@Autowired
	private TemplateMapper templateMapper;
	
      	   	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Template> list(Tablepar tablepar,Template template){
	        TemplateExample testExample=new TemplateExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(template);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Template> list= templateMapper.selectByExample(testExample);
	        PageInfo<Template> pageInfo = new PageInfo<Template>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			TemplateExample example=new TemplateExample();
			example.createCriteria().andIdIn(stringB);
			return templateMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Template selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return templateMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Template record) {
		return templateMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Template record) {
				
		record.setId(null);
		
				
		return templateMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Template record, TemplateExample example) {
		
		return templateMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Template record, TemplateExample example) {
		
		return templateMapper.updateByExample(record, example);
	}

	@Override
	public List<Template> selectByExample(TemplateExample example) {
		
		return templateMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(TemplateExample example) {
		
		return templateMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(TemplateExample example) {
		
		return templateMapper.deleteByExample(example);
	}


}

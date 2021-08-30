package com.fc.v2.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.ProductTypeMapper;
import com.fc.v2.model.auto.ProductType;
import com.fc.v2.model.auto.ProductTypeExample;
import com.fc.v2.model.custom.Tablepar;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.util.StrUtil;

/**
 * 产品分类 ProductTypeService
 * @Title: ProductTypeService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2021-06-26 14:52:52  
 **/
@Service
public class ProductTypeService implements BaseService<ProductType, ProductTypeExample>{
	@Autowired
	private ProductTypeMapper productTypeMapper;
	
      	   	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<ProductType> list(Tablepar tablepar,ProductType productType){
	        ProductTypeExample testExample=new ProductTypeExample();
//	        if (productType.getProductTypeName() != null && !"".equals(productType.getProductTypeName())) {
//				testExample.createCriteria().andProductTypeNameLike("%" + productType.getProductTypeName() + "%");
//			}
//			if (StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
//				testExample.setOrderByClause(
//						StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) + " " + tablepar.getIsAsc());
//			}
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(productType);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<ProductType> list= productTypeMapper.selectByExample(testExample);
	        PageInfo<ProductType> pageInfo = new PageInfo<ProductType>(list);
	        return  pageInfo;
	        
	        
	        
	        
	        
	    	 
			
			
			 
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ProductTypeExample example=new ProductTypeExample();
			example.createCriteria().andIdIn(stringB);
			return productTypeMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public ProductType selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return productTypeMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(ProductType record) {
		return productTypeMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(ProductType record) {
				
		record.setId(null);
		
				
		return productTypeMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(ProductType record, ProductTypeExample example) {
		
		return productTypeMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(ProductType record, ProductTypeExample example) {
		
		return productTypeMapper.updateByExample(record, example);
	}

	@Override
	public List<ProductType> selectByExample(ProductTypeExample example) {
		example.createCriteria().andStatusEqualTo(1);
		return productTypeMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProductTypeExample example) {
		
		return productTypeMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProductTypeExample example) {
		
		return productTypeMapper.deleteByExample(example);
	}

	public int updateVisible(ProductType record) {
		return productTypeMapper.updateByPrimaryKeySelective(record);
	}


}

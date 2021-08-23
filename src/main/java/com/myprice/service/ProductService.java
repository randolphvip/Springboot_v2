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
import com.myprice.mapper.auto.ProductMapper;
import com.myprice.model.auto.Product;
import com.myprice.model.auto.ProductExample;

import cn.hutool.core.util.StrUtil;

/**
 *  ProductService
 * @Title: ProductService.java 
 * @Package com.myprice.service 
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-22 01:33:35  
 **/
@Service
public class ProductService implements BaseService<Product, ProductExample>{
	@Autowired
	private ProductMapper productMapper;
	
      	   	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<Product> list(Tablepar tablepar,Product product){
	        ProductExample testExample=new ProductExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(product);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("product_id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<Product> list= productMapper.selectByExample(testExample);
	        PageInfo<Product> pageInfo = new PageInfo<Product>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
					
			Integer[] integers = ConvertUtil.toIntArray(",", ids);
			List<Integer> stringB = Arrays.asList(integers);
			ProductExample example=new ProductExample();
			example.createCriteria().andProductIdIn(stringB);
			return productMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public Product selectByPrimaryKey(String id) {
				
			Integer id1 = Integer.valueOf(id);
			return productMapper.selectByPrimaryKey(id1);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(Product record) {
		return productMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(Product record) {
				
		record.setProductId(null);
		
				
		return productMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(Product record, ProductExample example) {
		
		return productMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(Product record, ProductExample example) {
		
		return productMapper.updateByExample(record, example);
	}

	@Override
	public List<Product> selectByExample(ProductExample example) {
		
		return productMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(ProductExample example) {
		
		return productMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(ProductExample example) {
		
		return productMapper.deleteByExample(example);
	}


}

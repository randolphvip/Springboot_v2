package com.myprice.mapper.auto;

import com.myprice.model.auto.Product;
import com.myprice.model.auto.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *  ProductMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-22 01:33:35
 */
public interface ProductMapper {
      	   	      	      	      	      	      
    long countByExample(ProductExample example);

    int deleteByExample(ProductExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);
		
    Product selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example); 
		
    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
  	  	
}
package com.myprice.mapper.auto;

import com.myprice.model.auto.ShopCommodity;
import com.myprice.model.auto.ShopCommodityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Shop Commodity ShopCommodityMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-31 13:35:29
 */
public interface ShopCommodityMapper {
      	   	      	      	      	      	      
    long countByExample(ShopCommodityExample example);

    int deleteByExample(ShopCommodityExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(ShopCommodity record);

    int insertSelective(ShopCommodity record);

    List<ShopCommodity> selectByExample(ShopCommodityExample example);
		
    ShopCommodity selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") ShopCommodity record, @Param("example") ShopCommodityExample example);

    int updateByExample(@Param("record") ShopCommodity record, @Param("example") ShopCommodityExample example); 
		
    int updateByPrimaryKeySelective(ShopCommodity record);

    int updateByPrimaryKey(ShopCommodity record);
    
    List<ShopCommodity> queryCommodityList(ShopCommodityExample example);
  	  	
}
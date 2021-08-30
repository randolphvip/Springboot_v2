package com.myprice.mapper.auto;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myprice.model.auto.CommodityTradeMe;
import com.myprice.model.auto.CommodityTradeMeExample;

/**
 * Trade Me CommodityTradeMeMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-29 16:56:02
 */
public interface CommodityTradeMeMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(CommodityTradeMeExample example);

    int deleteByExample(CommodityTradeMeExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(CommodityTradeMe record);

    int insertSelective(CommodityTradeMe record);

    List<CommodityTradeMe> selectByExample(CommodityTradeMeExample example);
		
    CommodityTradeMe selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") CommodityTradeMe record, @Param("example") CommodityTradeMeExample example);

    int updateByExample(@Param("record") CommodityTradeMe record, @Param("example") CommodityTradeMeExample example); 
		
    int updateByPrimaryKeySelective(CommodityTradeMe record);

    int updateByPrimaryKey(CommodityTradeMe record);
  	  	
    List<CommodityTradeMe> queryCommodityList(CommodityTradeMeExample example);
    
}
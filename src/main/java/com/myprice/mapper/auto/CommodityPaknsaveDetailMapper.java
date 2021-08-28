package com.myprice.mapper.auto;

import com.myprice.model.auto.CommodityPaknsaveDetail;
import com.myprice.model.auto.CommodityPaknsaveDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * paknsave CommodityPaknsaveDetailMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-08-28 20:06:21
 */
public interface CommodityPaknsaveDetailMapper {
      	   	      	      	      	      	      	      
    long countByExample(CommodityPaknsaveDetailExample example);

    int deleteByExample(CommodityPaknsaveDetailExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(CommodityPaknsaveDetail record);

    int insertSelective(CommodityPaknsaveDetail record);

    List<CommodityPaknsaveDetail> selectByExample(CommodityPaknsaveDetailExample example);
		
    CommodityPaknsaveDetail selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") CommodityPaknsaveDetail record, @Param("example") CommodityPaknsaveDetailExample example);

    int updateByExample(@Param("record") CommodityPaknsaveDetail record, @Param("example") CommodityPaknsaveDetailExample example); 
		
    int updateByPrimaryKeySelective(CommodityPaknsaveDetail record);

    int updateByPrimaryKey(CommodityPaknsaveDetail record);
  	  	
}
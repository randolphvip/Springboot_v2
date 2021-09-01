package com.myprice.mapper.auto;

import com.myprice.model.auto.CommodityDetailPaknsave;
import com.myprice.model.auto.CommodityDetailPaknsaveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * PaknSave CommodityDetailPaknsaveMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-01 17:47:19
 */
public interface CommodityDetailPaknsaveMapper {
      	   	      	      	      	      	      	      	      	      
    long countByExample(CommodityDetailPaknsaveExample example);

    int deleteByExample(CommodityDetailPaknsaveExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(CommodityDetailPaknsave record);

    int insertSelective(CommodityDetailPaknsave record);

    List<CommodityDetailPaknsave> selectByExample(CommodityDetailPaknsaveExample example);
		
    CommodityDetailPaknsave selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") CommodityDetailPaknsave record, @Param("example") CommodityDetailPaknsaveExample example);

    int updateByExample(@Param("record") CommodityDetailPaknsave record, @Param("example") CommodityDetailPaknsaveExample example); 
		
    int updateByPrimaryKeySelective(CommodityDetailPaknsave record);

    int updateByPrimaryKey(CommodityDetailPaknsave record);
  	  	
}
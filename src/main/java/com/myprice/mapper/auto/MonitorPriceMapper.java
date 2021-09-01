package com.myprice.mapper.auto;

import com.myprice.model.auto.MonitorPrice;
import com.myprice.model.auto.MonitorPriceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * Price MonitorPriceMapper
 * @author Cong_自动生成
 * @email ${email}
 * @date 2021-09-02 02:04:51
 */
public interface MonitorPriceMapper {
      	   	      	      	      	      	      	      
    long countByExample(MonitorPriceExample example);

    int deleteByExample(MonitorPriceExample example);
		
    int deleteByPrimaryKey(Integer id);
		
    int insert(MonitorPrice record);

    int insertSelective(MonitorPrice record);

    List<MonitorPrice> selectByExample(MonitorPriceExample example);
		
    MonitorPrice selectByPrimaryKey(Integer id);
		
    int updateByExampleSelective(@Param("record") MonitorPrice record, @Param("example") MonitorPriceExample example);

    int updateByExample(@Param("record") MonitorPrice record, @Param("example") MonitorPriceExample example); 
		
    int updateByPrimaryKeySelective(MonitorPrice record);

    int updateByPrimaryKey(MonitorPrice record);
    List<MonitorPrice> selectByExample2(MonitorPriceExample example);
  	  	
}
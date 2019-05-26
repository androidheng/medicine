package com.medicine.mapper;

import com.medicine.pojo.TbOrderdetail;
import com.medicine.pojo.TbOrderdetailExample;
import com.medicine.vo.OrderDetailVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TbOrderdetailMapper {
    int countByExample(TbOrderdetailExample example);

    int deleteByExample(TbOrderdetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbOrderdetail record);

    int insertSelective(TbOrderdetail record);

    List<TbOrderdetail> selectByExample(TbOrderdetailExample example);
   

    TbOrderdetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbOrderdetail record, @Param("example") TbOrderdetailExample example);

    int updateByExample(@Param("record") TbOrderdetail record, @Param("example") TbOrderdetailExample example);

    int updateByPrimaryKeySelective(TbOrderdetail record);

    int updateByPrimaryKey(TbOrderdetail record);
    
    List<OrderDetailVo> findByOrderId(Integer id);

	String getSumPrice(Integer id);
}
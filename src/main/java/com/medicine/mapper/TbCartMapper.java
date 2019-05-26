package com.medicine.mapper;

import com.medicine.pojo.TbCart;
import com.medicine.pojo.TbCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbCartMapper {
    int countByExample(TbCartExample example);

    int deleteByExample(TbCartExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbCart record);

    int insertSelective(TbCart record);

    List<TbCart> selectByExample(TbCartExample example);
   

    TbCart selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbCart record, @Param("example") TbCartExample example);

    int updateByExample(@Param("record") TbCart record, @Param("example") TbCartExample example);

    int updateByPrimaryKeySelective(TbCart record);

    int updateByPrimaryKey(TbCart record);
    
    List<TbCart> findAllByUid(Integer id);
}
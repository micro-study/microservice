package com.hz.mybatis.mapper;


import com.hz.pojo.WechatInfo;
import com.hz.pojo.WechatInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WechatInfoMapper {
    long countByExample(WechatInfoExample example);

    int deleteByExample(WechatInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(WechatInfo record);

    int insertSelective(WechatInfo record);

    List<WechatInfo> selectByExample(WechatInfoExample example);

    WechatInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") WechatInfo record, @Param("example") WechatInfoExample example);

    int updateByExample(@Param("record") WechatInfo record, @Param("example") WechatInfoExample example);

    int updateByPrimaryKeySelective(WechatInfo record);

    int updateByPrimaryKey(WechatInfo record);
}
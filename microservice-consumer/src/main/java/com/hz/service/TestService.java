package com.hz.service;



import com.hz.pojo.PointPosition;
import com.hz.pojo.WechatInfo;
import com.hz.pojo.WechatSchedule;

import java.util.List;
import java.util.Map;

public interface TestService {


    /**
     * @author huangzhuo
     * @date 2018/11/5 15:28
     * @description: 检查该渠道在当前时间是否允许弹框
     * @param channel 渠道
     */
    boolean checkNeedPopup(String channel);



    PointPosition getSomething(String direction, String len);



    List<PointPosition> getSomethings(String direction, String len);


    Map<String, Map<String,List<WechatSchedule>>> getSchedule(String userId);

    WechatInfo getWethatInfo(String id);

}

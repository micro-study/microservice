package com.hz.service.impl;



import com.hz.mybatis.mapper.MkmRecommendPopupRecordsPoMapper;
import com.hz.mybatis.mapper.PointPositionMapper;
import com.hz.mybatis.mapper.WechatInfoMapper;
import com.hz.mybatis.mapper.WechatScheduleMapper;
import com.hz.pojo.*;
import com.hz.service.TestService;
import com.hz.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TestServiceImpl implements TestService {

    private static final Logger logger = LoggerFactory.getLogger(TestServiceImpl.class);


    @Autowired
    private MkmRecommendPopupRecordsPoMapper mkmRecommendPopupRecordsPoMapper;


    @Autowired
    private PointPositionMapper pointPositionMapper;

    @Autowired
    private WechatInfoMapper wechatInfoMapper;

    @Autowired
    private WechatScheduleMapper wechatScheduleMapper;



    @Override
    public boolean checkNeedPopup(String channel) {
        List<MkmRecommendPopupRecordsPo> mkmRecommendPopupRecordsPos = queryPopupList(channel);
        return mkmRecommendPopupRecordsPos != null && mkmRecommendPopupRecordsPos.size() > 0 ? true : false;
    }

    @Override
    public PointPosition getSomething(String direction, String len) {
        PointPosition pointPosition = getLessThanOrEqualLen(direction, len);
        PointPosition greaterThanOrEqualLen = getGreaterThanOrEqualLen(direction, len);
        if (greaterThanOrEqualLen == null) {
            pointPosition = new PointPosition();
            pointPosition.setRemark("outRange");
        }

        return pointPosition;
    }


    @Override
    public List<PointPosition> getSomethings(String direction, String len) {
        PointPositionExample example = new PointPositionExample();
        example.createCriteria().andDirectionEqualTo(direction).andLenLessThanOrEqualTo(Integer.valueOf(len));
        example.setOrderByClause("len  asc");
        List<PointPosition> pointPositions = pointPositionMapper.selectByExample(example);
        return  pointPositions;
    }

    public PointPosition getLessThanOrEqualLen(String direction, String len) {
        PointPositionExample example = new PointPositionExample();
        example.createCriteria().andDirectionEqualTo(direction).andLenLessThanOrEqualTo(Integer.valueOf(len));
        example.setOrderByClause("len desc");
        List<PointPosition> pointPositions = pointPositionMapper.selectByExample(example);
        return pointPositions != null && pointPositions.size() > 0 ? pointPositions.get(0) : new PointPosition();
    }

    public PointPosition getGreaterThanOrEqualLen(String direction, String len) {
        PointPositionExample example = new PointPositionExample();
        example.createCriteria().andDirectionEqualTo(direction).andLenGreaterThanOrEqualTo(Integer.valueOf(len));
        example.setOrderByClause("len asc");
        List<PointPosition> pointPositions = pointPositionMapper.selectByExample(example);
        return pointPositions != null && pointPositions.size() > 0 ? pointPositions.get(0) : null;
    }

    public List<MkmRecommendPopupRecordsPo> queryPopupList(String channel) {
        MkmRecommendPopupRecordsPoExample example = new MkmRecommendPopupRecordsPoExample();
        String curTime = DateUtil.convertDateToString(new Date(), DateUtil.dataFormatHHmmss);
        example.createCriteria().andEffectBeginTimeLessThanOrEqualTo(curTime).andEffectEndTimeGreaterThanOrEqualTo(curTime).andChannelEqualTo(channel);
        List<MkmRecommendPopupRecordsPo> mkmRecommendPopupRecordsPos = mkmRecommendPopupRecordsPoMapper.selectByExample(example);
        logger.info("数据条数为：{}", mkmRecommendPopupRecordsPos != null ? mkmRecommendPopupRecordsPos.size() : 0);
        return mkmRecommendPopupRecordsPos;
    }


    @Override
    public Map<String, Map<String,List<WechatSchedule>>> getSchedule(String userId) {

        WechatScheduleExample example = new WechatScheduleExample();
        example.createCriteria().andClassidEqualTo("174");

        List<WechatSchedule> list = wechatScheduleMapper.selectByExample(example);
        Map<String, Map<String,List<WechatSchedule>>> allMap =new TreeMap<>();
        for (int i =0 ;i<list.size();i++) {
            WechatSchedule schedule = list.get(i);
            String name = schedule.getTimeperiod();
            String curName = schedule.getTimeperiod() + "_"+ schedule.getDayofweek();
            if (allMap.get(name)!=null){
                Map<String,List<WechatSchedule>> curMap = allMap.get(name);

                List<WechatSchedule> schedules = curMap.get(curName);
                if (schedules== null){
                    schedules = new ArrayList<>();
                }

                schedules.add(schedule);

                curMap.put(curName,schedules);
            }else{
                List<WechatSchedule> curList = new ArrayList<>();
                curList.add(schedule);
                Map<String,List<WechatSchedule>> map =new HashMap<>();
                map.put(curName,curList);
                allMap.put(name,map);
            }
        }

        return allMap;
    }


    @Override
    public WechatInfo getWethatInfo(String id) {
        WechatInfo wechatInfo = wechatInfoMapper.selectByPrimaryKey(Integer.valueOf(id));
        return wechatInfo;
    }
}

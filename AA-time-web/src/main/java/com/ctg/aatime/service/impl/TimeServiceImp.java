package com.ctg.aatime.service.impl;

import com.ctg.aatime.dao.ActivityDao;
import com.ctg.aatime.dao.ActivityMembersDao;
import com.ctg.aatime.dao.TimeDao;
import com.ctg.aatime.domain.Activity;
import com.ctg.aatime.domain.ActivityMembers;
import com.ctg.aatime.domain.dto.RecommendTimeInfo;
import com.ctg.aatime.service.TimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Cx On 2018/4/17 16:04
 */
@Service
@Slf4j
public class TimeServiceImp implements TimeService{
    @Autowired
    ActivityDao activityDao;
    @Autowired
    TimeDao timeDao;
    @Autowired
    ActivityMembersDao activityMembersDao;

    @Override
    public RecommendTimeInfo getRecommendTime(int eventId) {
        //TODO 有点规范的小问题具体看controller
        //List<ActivityMembers> members = activityMembersService.selectJoinMembersByEventId(eventId);
        Activity activity = activityDao.selectActivityByEventId(eventId);
        return null;
    }

    @Override
    public Map<Long, Long> getFreeTimeByUid(int uid,int eventId) {
        //TODO 这里和selectJoinMembersByEventId的方法复用了，应该怎么改
        HashMap<Long, Long> freeTime = new HashMap<Long, Long>();
        List<HashMap<String, Long>> freeTimeList = timeDao.selectFreeTimes(uid, eventId);
        for (HashMap<String, Long> time : freeTimeList) {
            //将该成员每段freeTime置入同一个map中
            freeTime.put(time.get("key"), time.get("value"));
        }
        return freeTime;
    }
}
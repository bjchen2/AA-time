package com.ctg.aatime.service.impl;

import com.ctg.aatime.domain.Activity;
import com.ctg.aatime.service.ActivityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class ActivityServiceImplTest {
    @Autowired
    private ActivityService activityService;

    @Rollback(value = false)
    @Test
    public void createActivity() throws Exception {
        Activity activity = new Activity();
        activity.setEventName("睡觉");
        activity.setEventBrief("嗡嗡嗡");
        activity.setEventPlace("程序");
        activity.setStartTime(1727176808888L);
        activity.setEndTime(1927422288207L);
        activity.setStatisticTime(1727076808888L);
        activity.setMinTime(7200000L);
        activity.setUid(2);
        Activity result = activityService.createActivity(activity);
        System.out.println(result);
    }

    @Test
    public void selectLiveActivitiesByUid() throws Exception {
        List<Activity> activity = activityService.selectJoinActivitiesByUid(2);
        System.out.println("结果是:"+activity);
    }

    @Test
    public void selectLaunchActivitiesByUid() throws Exception {
        List<Activity> activity = activityService.selectLaunchActivitiesByUid(2);
        System.out.println("结果是:"+activity);
    }

    @Test
    public void delActivityByEventId() throws Exception {
        try {
            activityService.delActivityByEventId(27);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void launchActivity(){
//        activityService.launchActivity(15,"好无聊",1524952288207L,1525952288207L);
    }

    @Test
    public void selectAll() {
        List<Activity> activity = activityService.selectDeadActivitiesByUid(2);
        System.out.println("结果是:"+activity);
    }

    @Test
    public void updateActivity() {
        Activity activity = new Activity();
        activity.setEventId(54);
        activity.setEventBrief("wwwello");
        activityService.updateActivity(activity);
    }

}

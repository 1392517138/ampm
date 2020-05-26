package com.nmid.ampm.scheduled;

import com.nmid.ampm.config.AdvisorEmail;
import com.nmid.ampm.config.PostTimes;
import com.nmid.ampm.utils.ShortMessageUtil;
import com.nmid.ampm.utils.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/5/25 9:23 PM
 */
@Component
public class Jobs {
    @Autowired
    AdvisorEmail advisorEmail;
    @Autowired
    ShortMessageUtil shortMessageUtil;
    @Autowired
    PostTimes postTimes;

    @Scheduled(cron = "0 0 10 ? * 1")
    public void sendToAdvisor() throws InterruptedException {
        List<String> email = advisorEmail.getEmail();
        for (String s : email) {
            shortMessageUtil.sendMail(new String[]{s},"Advisor",(byte)1,postTimes.getTimes().get(Times.index));
            Thread.sleep(2);
        }
        //index加一
        Times.addIndex();
    }
}

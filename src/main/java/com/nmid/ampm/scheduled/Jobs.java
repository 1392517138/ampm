package com.nmid.ampm.scheduled;

import com.nmid.ampm.config.AdvisorEmail;
import com.nmid.ampm.utils.ShortMessageUtil;
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
    private static String[] times = {"一","二","三","四","五","六",
                                                "七","八","九","十","十一","十二","十三","十四","十五"};
    private static int index = 0;
    @Scheduled(cron = "0 0 10 ? * 1")
    public void sendToAdvisor() throws InterruptedException {
        List<String> email = advisorEmail.getEmail();
        for (String s : email) {
            shortMessageUtil.sendMail(new String[]{s},"Advisor",(byte)1,"第"+times[index]+"次");
            Thread.sleep(2);
        }
        index++;
    }
}

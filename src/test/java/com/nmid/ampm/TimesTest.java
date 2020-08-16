package com.nmid.ampm;

import com.nmid.ampm.config.PostTimes;
import com.nmid.ampm.utils.Times;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Aaron
 * @description
 * @date 2020/8/16 8:40 上午
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TimesTest {
    @Autowired
    PostTimes postTimes;

    @Test
    public void testTimes() {
        System.out.println(postTimes.getTimes().get(Times.index));
    }
}

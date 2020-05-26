package com.nmid.ampm;

import com.nmid.ampm.config.AdvisorEmail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author Aaron
 * @description
 * @date 2020/5/25 9:35 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YmlTest {
    @Autowired
    AdvisorEmail advisorEmail;
    @Test
    public void listTest(){
        System.out.println(advisorEmail.getEmail());
    }


}

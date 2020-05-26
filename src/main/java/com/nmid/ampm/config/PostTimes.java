package com.nmid.ampm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/5/26 3:59 PM
 */
@Component
@ConfigurationProperties(prefix = "post")
public class PostTimes {
    private List<String> times = new ArrayList<>();

    public List<String> getTimes() {
        return times;
    }

    public void setTimes(List<String> times) {
        this.times = times;
    }
}

package com.nmid.ampm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aaron
 * @description
 * @date 2020/5/25 9:54 PM
 */
@Component
@ConfigurationProperties(prefix = "advisor")
public class AdvisorEmail {
    private List<String> email = new ArrayList<>();

    public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }
}

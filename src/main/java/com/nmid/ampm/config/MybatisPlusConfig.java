package com.nmid.ampm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Aaron
 * @description
 * @date 2020/5/25 11:23 AM
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MyMetaObjHandler myMetaObjHandler() {
        return new MyMetaObjHandler();
    }


}

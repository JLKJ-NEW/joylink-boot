package com.joylink.userms.configuration;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;
import com.joylink.userms.cache.GuavaCacheManager;
import com.joylink.userms.cache.ICacheManager;

@Configuration
@EnableCaching
public class CacheConfiguration {

    /**
     * 配置全局缓存参数，3600秒过期，最大个数1000
     */
    @Bean
    public ICacheManager iCacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(3600, TimeUnit.SECONDS).maximumSize(1000));
        return cacheManager;
    }

}

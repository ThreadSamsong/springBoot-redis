package com.samsong.redis.springbootredis.route.algorithm;

import java.util.List;

public interface RouteHandle {

    /**
     * 选择一台服务器
     * @param values
     * @param key
     * @return
     */

    String routeCacheServer(List<String> values,String key);
}

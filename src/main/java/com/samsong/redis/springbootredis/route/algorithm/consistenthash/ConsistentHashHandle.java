package com.samsong.redis.springbootredis.route.algorithm.consistenthash;

import com.samsong.redis.springbootredis.route.algorithm.RouteHandle;

import java.util.List;

public class ConsistentHashHandle implements RouteHandle {

    private AbstractConsistentHash hash ;

    public void setHash(AbstractConsistentHash hash) {
        this.hash = hash;
    }

    @Override
    public String routeCacheServer(List<String> values, String key) {
        return hash.process(values, key);
    }
}

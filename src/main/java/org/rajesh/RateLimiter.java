package org.rajesh;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiter {

    private final int limit;
    private final long windowSize;
    private final Map<String, List<Long>> userCalls = new ConcurrentHashMap<>();

    public RateLimiter(int limit, long windowMillis){
        this.limit = limit;
        this.windowSize = windowMillis;
    }


    public boolean allowRequest(String userId){
        long now = System.currentTimeMillis();
        userCalls.putIfAbsent(userId, new ArrayList<>());
        List<Long> timestamps = userCalls.get(userId);
        timestamps.removeIf(t-> now - t > windowSize);
        if(timestamps.size()<limit){
            timestamps.add(now);
            return true;
        }
        return false;
    }
}

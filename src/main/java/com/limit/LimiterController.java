package com.limit;

import com.limit.Limit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 
 * @since 
 */
@RestController
public class LimiterController {

    private static final AtomicInteger ATOMIC_INTEGER = new AtomicInteger();

    //时间 period 单位秒    count次数
    @Limit(key = "test", period = 10, count = 10)
    @GetMapping("/test")
    public int testLimiter() {
        // 意味著 10S 内最多允許訪問10次
        return ATOMIC_INTEGER.incrementAndGet();
    }
}

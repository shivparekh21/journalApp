package net.engineeringdigest.journalApp.repository;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;    // to interact with redis

    @Disabled
    @Test
    public void testSendMail() {
        redisTemplate.opsForValue().set("email", "shivparekh21@gmail.com");
        Object email = redisTemplate.opsForValue().get("email");
        int a = 1;
    }
}

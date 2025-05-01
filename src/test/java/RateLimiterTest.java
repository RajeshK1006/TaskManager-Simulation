

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.rajesh.RateLimiter;
class RateLimiterTest {

    @Test
    void testAllowRequest() {
        RateLimiter rateLimiter = new RateLimiter(3, 10000); // Allow 3 requests in 10 seconds

        assertTrue(rateLimiter.allowRequest("user1"));
        assertTrue(rateLimiter.allowRequest("user1"));
        assertTrue(rateLimiter.allowRequest("user1"));
        assertFalse(rateLimiter.allowRequest("user1")); // Exceeds rate limit
    }
}

package org.rajesh;



public class Main {
    public static void main(String[] args) {
        TaskService service = TaskService.getInstance();
        RateLimiter limiter = new RateLimiter(5, 1000); // 5 requests per 10 seconds

        Runnable userJob = () -> {
            for (int i = 0; i < 10; i++) {
                if (limiter.allowRequest("user1")) {
                    service.createTask("Task " + i, "Description " + i, i % 2 == 0 ? "High" : "Low");
                } else {
                    System.out.println("Rate limit exceeded");
                }
            }
        };

        Thread user1 = new Thread(userJob);
        Thread user2 = new Thread(userJob);
        user1.start();
        user2.start();
    }
}

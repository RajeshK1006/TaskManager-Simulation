package org.rajesh;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.stream.Collectors;

//this is an singleton pattern
//this is to retain and use only one instance of this class during the lifetime (like adb connection in the production system)

public class TaskService {
    private static final Logger logger = Logger.getLogger(TaskService.class.getName());
    private static final TaskService instance = new TaskService();
    private final Map<Integer,Task> taskDb = new ConcurrentHashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);
    private final LRUCache<String, List<Task>> cache = new LRUCache<>(10);


    //constructor
    private TaskService() {
        try {
            Handler fileHandler = new FileHandler("taskManager.log", true);

            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler((fileHandler));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static  TaskService getInstance(){
        return instance;
    }

    public Task createTask(String title, String desc, String prior){
        int id = idCounter.getAndIncrement(); // gives the count and 1++ then;
        Task t = new Task(id,title,desc,prior);
        taskDb.put(id,t);
        cache.remove(prior); //invalidating for data Integrity
        logger.info("Created Task ID: "+ id);
        return t;
    }

    public List<Task> searchPriority(String priority){
        if(cache.containsKey(priority)){
            return cache.get(priority);
        }

        List<Task> result = taskDb.values().stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority)).collect(Collectors.toList());

        cache.put(priority,result);
        logger.info("Searched Tasks with Priority: "+ priority);
        return result;
    }

}

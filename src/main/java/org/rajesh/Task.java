package org.rajesh;

public class Task {
    private int id;
    private String title;
    private String description;
    private String priority;


    public Task(int id, String title, String description, String priority){
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
    }


    public int getId() {return this.id;}

    public String getTitle() {return this.title ;}

    public String getDescription() {return this.description ;}

    public String getPriority() {return this.priority ;}
}

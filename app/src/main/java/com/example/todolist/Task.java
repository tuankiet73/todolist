package com.example.todolist;

public class Task {
    private int id;
    private String name;
    private String description;
    private String schedule;  // Format: "yyyy-MM-dd HH:mm"
    private int duration;     // Time in minutes

    public Task(int id, String name, String description, String schedule, int duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.schedule = schedule;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}

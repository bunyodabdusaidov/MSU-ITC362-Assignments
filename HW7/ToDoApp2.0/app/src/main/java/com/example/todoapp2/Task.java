package com.example.todoapp2;

import java.text.SimpleDateFormat;

public class Task {
    private int id;
    private String task;
    private String deadline;

    public Task(int newId, String newTask, String newDeadline) {
        setId(newId);
        setTask(newTask);
        setDeadline(newDeadline);
    }

    private void setId(int newId) {
        id = newId;
    }

    private void setTask(String newTask) {
        task = newTask;
    }

    private void setDeadline(String newDeadline) {
        deadline = newDeadline;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String getDeadline() {return deadline;}

    public String toString() {
        return id + " " + task + " " + deadline;
    }
}

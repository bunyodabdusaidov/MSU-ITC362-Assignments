package com.example.todoapp;

public class Task {
    private int id;
    private String task;

    public Task(int newId, String newTask) {
        setId(newId);
        setTask(newTask);
    }

    private void setId(int newId) {
        id = newId;
    }

    private void setTask(String newTask) {
        task = newTask;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public String toString() {
        return id + " " + task;
    }
}

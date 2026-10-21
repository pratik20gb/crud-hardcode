package org.anovid;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks =  new ArrayList<>();
    public void addTask(Task task) {
        if(findTaskById(task.getId()) != null){
            System.out.println("Task ID already exists");
            return;
        }
        tasks.add(task);
    }
    public List<Task> getAllTasks() {
        return tasks;
    }
    public Task findTaskById(int id) {
        for(Task task:tasks){
            if(task.getId() == id){
                return task;
            }
        }
        return null;
    }
    public void completeTask(int id){
        Task task  =findTaskById(id);
        if(task != null){
        task.markCompleted();
        }else{
            System.out.println("Task "+id+" not found");
        }
    }
    public void deleteTask(int id){
        Task task = findTaskById(id);
        if(task!=null){
            tasks.remove(task);
        }else{
            System.out.println("Task "+id+" not found");
        }
    }
}













package org.anovid;

import java.util.List;

public class Main{
    public static void main(String[] args){
       TaskManager taskManager = new TaskManager();

        Task task1  = new Task(1,"java",false);
        Task task2  = new Task(2,"Ai",false);

        taskManager.addTask(task1);
        taskManager.addTask(task2);

        for(Task task:taskManager.getAllTasks()){
            System.out.println(task.getTitle());
        }

        taskManager.completeTask(2);
        System.out.println(task2.isCompleted());

        taskManager.deleteTask(1);

        for(Task task:taskManager.getAllTasks()){
            System.out.println(task.getTitle());
        }

    }
}
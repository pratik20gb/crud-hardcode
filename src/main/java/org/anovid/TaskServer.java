package org.anovid;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;



public class TaskServer {
    private static int nextId = 1;
    public static void main(String[] args) throws IOException {
        HttpServer server  = HttpServer.create(new InetSocketAddress(8080),0);
        TaskManager taskManager = new TaskManager();
        server.createContext("/tasks",exchange -> {


            String response = "";
            String method = exchange.getRequestMethod();
            String uri = exchange.getRequestURI().toString();


            if(method.equals("GET")){
                StringBuilder builder = new StringBuilder();
                for(Task task:taskManager.getAllTasks()){
                    builder.append(task.getId())
                            .append(" ")
                            .append(task.getTitle())
                            .append("\n");
                    }
                response = builder.toString();
            }else if(method.equals("POST")){
                try(InputStream inputStream = exchange.getRequestBody()) {
                    byte[] bytes = inputStream.readAllBytes();
                    String message = new String(bytes, StandardCharsets.UTF_8);
                    Task task  = new Task(nextId++,message,false);
                    taskManager.addTask(task);

                }

            }else{
                System.out.println("Unsupported method");
            }
            System.out.println(method + " " + uri);

            byte[] data = response.getBytes(StandardCharsets.UTF_8);

            exchange.sendResponseHeaders(200, data.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(data);
            }
        });
            server.start();
        System.out.println("Server started on port 8080");

    }


}

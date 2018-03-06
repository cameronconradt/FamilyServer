package handler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import dao.eventDao;
import model.event;
import model.events;
import service.eventService;

/**
 * Created by camer on 2/16/2018.
 */

public class eventHandler extends Handler {

    static int count = 0;

    @Override
    public void handle(HttpExchange ex) throws IOException {
        System.out.println("event handle" + count);
        count++;

        try{
            switch (ex.getRequestMethod().toLowerCase()) {
                case "post":
                    System.out.println("is post");
                    break;
                case "get":
                    System.out.println("is get");
                    break;
                default:
                    System.out.println("unidentified");
                    break;
            }
            OutputStream responseBody = ex.getResponseBody();
            OutputStreamWriter outBody = new OutputStreamWriter(responseBody);

            String uri = ex.getRequestURI().toString();

            System.out.println(uri);

            String[] path = uri.split("/");

            boolean good_path = true;
            String json = new String();

            if (path.length != 2 || path.length != 3) {
                good_path = false;
            }
            else {
                if (path[path.length - 1].equals("event")) {
                    System.out.println("all events");
                } else if (path[path.length - 2].equals("event")) {
                    System.out.println("one event with id" + path[path.length-1]);
                }else{
                        good_path = false;
                        System.out.println("unidentified");
                    }
                }

            if(good_path){
                Gson gson = new GsonBuilder().setPrettyPrinting().create();

                String auth_token = ex.getRequestHeaders().get("Authorization").get(0);

                System.out.println("auth_token: " + auth_token);

                if(path[path.length-1].equals("event")){
                    events allEvents = new eventService().all(auth_token);

                    json = gson.toJson(allEvents);
                }
                else if(path[path.length-2].equals("event")){
                    System.out.println("event id= " + path[path.length-1]);

                    event singleEvent = new eventService().one(path[path.length-1]);

                    json = gson.toJson(singleEvent);
                }

                ex.sendResponseHeaders(HttpURLConnection.HTTP_OK, 0);
            }
            else{
                ex.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR,0);
            }
            outBody.write(json);
            outBody.close();
            responseBody.close();

        }
        catch(IOException e){
            ex.sendResponseHeaders(HttpURLConnection.HTTP_INTERNAL_ERROR, 0);
            ex.getResponseBody().close();
            e.printStackTrace();
        }
    }

}

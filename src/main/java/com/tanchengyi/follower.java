package com.tanchengyi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class follower extends Thread{
    private String link;
    private int no;
    private int repo;
    private int gist;
    private int follower;
    private int following;
    private String id;
    follower(String link,int no){
        this.link=link;
        this.no=no+1;
    }
    @Override
    public void run(){
        try {
            String a = link.concat("?client_id=eaffcf95370a6dafe89e&client_secret=8339419d67f26547c6fca1b499cf5ac54812c100&per_page=1&page=" + Integer.toString(no));
            URL obj = new URL(a);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            String a1=response.toString();
            String b = a1.replaceAll("\\[|\\]", "");
            JSONObject data = new JSONObject(b);
            String url = data.getString("url");
            String url1=url.concat("?client_id=eaffcf95370a6dafe89e&client_secret=8339419d67f26547c6fca1b499cf5ac54812c100");

            URL obj1 = new URL(url1);
            HttpURLConnection con1 = (HttpURLConnection) obj1.openConnection();
            BufferedReader in1 = new BufferedReader(new InputStreamReader(con1.getInputStream()));
            String inputLine1;
            StringBuffer response1 = new StringBuffer();
            while ((inputLine1 = in1.readLine()) != null) {
                response1.append(inputLine1);
            }
            in.close();
            JSONObject data1 = new JSONObject(response1.toString());
            id = data1.getString("login");
            repo = data1.getInt("public_repos");
            gist = data1.getInt("public_gists");
            follower = data1.getInt("followers");
            following = data1.getInt("following");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getLoginId() {
        return id;
    }
    public int getRepo() {
        return repo;
    }

    public int getGist() {
        return gist;
    }

    public int getFollower() {
        return follower;
    }

    public int getFollowing() {
        return following;
    }

    public int getNo() {
        return no;
    }
}

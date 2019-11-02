package com.tanchengyi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class users {
    private String link;
    private String followersUrl;
    private int numFollowers;
    users(String link){
        this.link=link;
    }
    public void extractData() throws Exception{
        URL obj = new URL(link);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject data = new JSONObject(response.toString());
        followersUrl=data.getString("followers_url");
        numFollowers=data.getInt("followers");
    }

    public String getFollowersUrl() {
        return followersUrl;
    }

    public int getNumFollowers() {
        return numFollowers;
    }
}

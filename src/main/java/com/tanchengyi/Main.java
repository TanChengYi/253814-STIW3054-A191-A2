package com.tanchengyi;

public class Main {

    public static void main(String[] args) {
        String url = "https://api.github.com/users/zhamri?client_id=eaffcf95370a6dafe89e&client_secret=8339419d67f26547c6fca1b499cf5ac54812c100";
        try {
            users users=new users(url);
            users.extractData();
            follower[] followers=new follower[users.getNumFollowers()];
            for(int i=0;i<followers.length;i++){
                followers[i]=new follower(users.getFollowersUrl(),i);
                followers[i].run();
            }
            ListFollowers list =new ListFollowers(followers);
            toExcel doc=new toExcel(followers);
            list.run();
            doc.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

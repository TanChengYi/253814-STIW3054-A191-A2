package com.tanchengyi;

public class ListFollowers extends Thread{
    private follower[] followers;
    ListFollowers(follower[] followers){
        this.followers=followers;
    }

    @Override
    public void run() {
        System.out.println("| No. | login id           | Number of repositories | Number of followers | Number of following | Number of gists |");
        System.out.println("|-----|--------------------|------------------------|---------------------|---------------------|-----------------|");
        for(int i=0;i<followers.length;i++){
            System.out.printf("|%-5d|%-20s|%-24d|%-21d|%-21d|%-17d|\n",followers[i].getNo(),followers[i].getLoginId(),followers[i].getRepo(),followers[i].getFollower(),followers[i].getFollowing(),followers[i].getGist());
        }
    }
}

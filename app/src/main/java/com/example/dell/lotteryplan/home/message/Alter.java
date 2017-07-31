package com.example.dell.lotteryplan.home.message;

/**
 * Created by dell on 2017/6/26.
 */

public class Alter {

    private String content;
    private String url;
    private String id;

    public Alter(String id,String content,String url){
        this.id         =   id;
        this.content    =   content;
        this.url        =   url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

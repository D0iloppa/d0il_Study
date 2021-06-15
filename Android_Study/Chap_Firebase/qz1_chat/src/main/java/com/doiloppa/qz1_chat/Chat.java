package com.doiloppa.qz1_chat;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

public class Chat {
    private String name,content;

    public Chat(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @NonNull
    @Override
    public String toString() {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",getName());
            jsonObject.put("content",getContent());
            return  jsonObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

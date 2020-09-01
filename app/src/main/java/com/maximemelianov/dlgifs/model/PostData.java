package com.maximemelianov.dlgifs.model;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PostData {

    public PostData(int id, String url, String des){
        postId = id;
        gifURL = url;
        description = des;
        createdTime = System.currentTimeMillis();
    }

    private long createdTime;

    private int postId;
    private String gifURL;
    private String description;

    public long getPostId() {
        return postId;
    }

    public String getGifURL() {
        return gifURL;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        return postId;
    }

    @NonNull
    @Override
    public String toString() {
        return "Post: " + description;
    }
}

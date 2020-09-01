
package com.maximemelianov.dlgifs.api;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseData implements Serializable, Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("votes")
    @Expose
    private int votes;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("gifURL")
    @Expose
    private String gifURL;
    @SerializedName("gifSize")
    @Expose
    private int gifSize;
    @SerializedName("previewURL")
    @Expose
    private String previewURL;
    @SerializedName("videoURL")
    @Expose
    private String videoURL;
    @SerializedName("videoPath")
    @Expose
    private String videoPath;
    @SerializedName("videoSize")
    @Expose
    private int videoSize;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("commentsCount")
    @Expose
    private int commentsCount;
    @SerializedName("fileSize")
    @Expose
    private int fileSize;
    @SerializedName("canVote")
    @Expose
    private boolean canVote;
    public final static Parcelable.Creator<ResponseData> CREATOR = new Creator<ResponseData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ResponseData createFromParcel(Parcel in) {
            return new ResponseData(in);
        }

        public ResponseData[] newArray(int size) {
            return (new ResponseData[size]);
        }

    }
    ;
    private final static long serialVersionUID = -1448615139913982812L;

    protected ResponseData(Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.votes = ((int) in.readValue((int.class.getClassLoader())));
        this.author = ((String) in.readValue((String.class.getClassLoader())));
        this.date = ((String) in.readValue((String.class.getClassLoader())));
        this.gifURL = ((String) in.readValue((String.class.getClassLoader())));
        this.gifSize = ((int) in.readValue((int.class.getClassLoader())));
        this.previewURL = ((String) in.readValue((String.class.getClassLoader())));
        this.videoURL = ((String) in.readValue((String.class.getClassLoader())));
        this.videoPath = ((String) in.readValue((String.class.getClassLoader())));
        this.videoSize = ((int) in.readValue((int.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((String) in.readValue((String.class.getClassLoader())));
        this.commentsCount = ((int) in.readValue((int.class.getClassLoader())));
        this.fileSize = ((int) in.readValue((int.class.getClassLoader())));
        this.canVote = ((boolean) in.readValue((boolean.class.getClassLoader())));
    }

    public ResponseData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGifURL() {
        return gifURL;
    }

    public void setGifURL(String gifURL) {
        this.gifURL = gifURL;
    }

    public int getGifSize() {
        return gifSize;
    }

    public void setGifSize(int gifSize) {
        this.gifSize = gifSize;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public String getVideoURL() {
        return videoURL;
    }

    public void setVideoURL(String videoURL) {
        this.videoURL = videoURL;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public int getVideoSize() {
        return videoSize;
    }

    public void setVideoSize(int videoSize) {
        this.videoSize = videoSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public boolean isCanVote() {
        return canVote;
    }

    public void setCanVote(boolean canVote) {
        this.canVote = canVote;
    }

    @Override
    public String toString() {
        return "id:" + id + "\n" + "description:" + description + "\n" + "votes:" + votes + "\n" + "author:" + author + "\n" + "date:" + date + "\n" + "gifURL:" + gifURL + "\n" + "gifSize:" + gifSize + "\n" + "previewURL:" + previewURL + "\n" + "videoURL:" + videoURL + "\n" + "videoPath:" + videoPath + "\n" + "videoSize:" + videoSize + "\n" + "type:" + type + "\n" + "width:" + width + "\n" + "height:" + height + "\n" + "commentsCount:" + commentsCount + "\n" + "fileSize:" + fileSize + "\n" + "canVote:" + canVote;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(description);
        dest.writeValue(votes);
        dest.writeValue(author);
        dest.writeValue(date);
        dest.writeValue(gifURL);
        dest.writeValue(gifSize);
        dest.writeValue(previewURL);
        dest.writeValue(videoURL);
        dest.writeValue(videoPath);
        dest.writeValue(videoSize);
        dest.writeValue(type);
        dest.writeValue(width);
        dest.writeValue(height);
        dest.writeValue(commentsCount);
        dest.writeValue(fileSize);
        dest.writeValue(canVote);
    }

    public int describeContents() {
        return  0;
    }

}

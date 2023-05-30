//Nim:10120084
//Nama:Fadlan Alfalah Baihaaqi
//Kelas:IF2

package com.example.splashscreenanimation;

public class Note {
    private String id;
    private String title;
    private String category;
    private String content;
    private String date;

    public Note(String id, String title, String category, String content, String date) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.content = content;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }
}


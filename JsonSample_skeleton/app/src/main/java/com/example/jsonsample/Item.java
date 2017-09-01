package com.example.jsonsample;

public class Item {
    public String id;
    public String title;
    public String description;
    public String thumbnailImageURL;

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", thumbnailImageURL='" + thumbnailImageURL + '\'' +
                '}';
    }
}

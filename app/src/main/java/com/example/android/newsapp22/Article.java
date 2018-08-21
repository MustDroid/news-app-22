package com.example.android.newsapp22;

/**
 * Created by Emoke Hajdu on 6/23/2018.
 */

public class Article {
    private String mAuthor;
    private String mTitle;
    private String mDescription;
    private String mURL;
    private String mURLToImage;
    private String mPublishedAt;

    public Article(String author, String title, String description, String URL, String URLToImage, String publishedAt) {
        this.mAuthor = author;
        this.mTitle = title;
        this.mDescription = description;
        this.mURL = URL;
        this.mURLToImage = URLToImage;
        this.mPublishedAt = publishedAt;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getURL() {
        return mURL;
    }

    public String getURLToImage() {
        return mURLToImage;
    }

    public String getPublishedAt() {
        return mPublishedAt;
    }
}

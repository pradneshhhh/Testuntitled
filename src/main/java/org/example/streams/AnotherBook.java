package org.example.streams;

public class AnotherBook {
    private String title;
    private String genre;
    AnotherBook(String title, String genre){
        this.title = title;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "AnotherBook{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

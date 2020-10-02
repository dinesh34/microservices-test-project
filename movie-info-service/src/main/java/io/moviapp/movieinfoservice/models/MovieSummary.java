package io.moviapp.movieinfoservice.models;
public class MovieSummary {

    private String id;
    private String original_title = "title";
    private String overview;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return original_title;
    }

    public void setTitle(String title) {
        this.original_title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
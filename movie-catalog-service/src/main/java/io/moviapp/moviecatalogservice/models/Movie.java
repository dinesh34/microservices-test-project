package io.moviapp.moviecatalogservice.models;

public class Movie {
    public String movieId;
    public String name;
    public String desc;

    public Movie(){
    }

    public Movie(String movieId, String name, String desc) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getName() {
        return name;
    }


}

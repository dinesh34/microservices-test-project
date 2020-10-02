package io.moviapp.moviecatalogservice.models;

public class CategoryItem {
    private String name;
    private String desc;
    private int rating;

    public String getName() {
        return name;
    }

    public CategoryItem(String name, String desc, int rating) {
        this.name = name;
        this.desc = desc;
        this.rating = rating;
    }

    public String getDesc() {
        return desc;
    }

    public int getRating() {
        return rating;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

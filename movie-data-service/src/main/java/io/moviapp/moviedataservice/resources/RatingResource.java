package io.moviapp.moviedataservice.resources;

import io.moviapp.moviedataservice.models.Rating;
import io.moviapp.moviedataservice.models.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,10);
    }


    @RequestMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId){
        //hardcoded values -- must be from db
        List<Rating> ratings = Arrays.asList(
                new Rating("500",2),
                new Rating("600",4)
        );

        UserRating userRating = new UserRating();
        userRating.setUserRating(ratings);

        return userRating;

    }
}

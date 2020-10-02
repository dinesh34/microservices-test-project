package io.moviapp.moviecatalogservice.resources;

import io.moviapp.moviecatalogservice.models.CategoryItem;
import io.moviapp.moviecatalogservice.models.UserRating;
import io.moviapp.moviecatalogservice.services.MovieInfo;
import io.moviapp.moviecatalogservice.services.MovieRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient.Builder webClientBuilder;

    @Autowired
    MovieInfo movieInfo;

    @Autowired
    MovieRating movieRating;

    @RequestMapping("/{userId}")
    public List<CategoryItem> getCategory(@PathVariable("userId") String userId) {

        UserRating ratings = movieRating.getRatingsData(userId);

        //For each movie id in ratings, call and get the movie info
        return ratings.getUserRating().stream()
                .map(rating -> movieInfo.getCatagoryItem(rating))
                .collect(Collectors.toList());
    }




    //Fall back method has the same method skeleton but simple hardcoded value is returned
//    public List<CategoryItem> getFallbackCatalog(@PathVariable("userId") String userId) {
//        return Arrays.asList(new CategoryItem("No movie", "No description", 0));
//    }
}
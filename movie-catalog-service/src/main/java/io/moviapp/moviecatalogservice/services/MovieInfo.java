package io.moviapp.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.moviapp.moviecatalogservice.models.CategoryItem;
import io.moviapp.moviecatalogservice.models.Movie;
import io.moviapp.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfo {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackCatalogItem")
    public CategoryItem getCatagoryItem(Rating rating) {

        //Asynchornus using for synchornus prg
//              Movie movie =  webClientBuilder.build()
//                       .get()
//                       .uri("http://localhost:8082/movies/"+rating.getMovieId())
//                       .retrieve()
//                       .bodyToMono(Movie.class)
//                       .block();
        //Then combine and return

        Movie movie =  restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
        return new CategoryItem(movie.getName(), movie.getDesc(), rating.getRating());
    }

    public CategoryItem getFallbackCatalogItem(Rating rating) {
        return new CategoryItem("Movie name not found","movie desc not found",rating.getRating());
    }
}

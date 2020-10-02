package io.moviapp.movieinfoservice;

import io.moviapp.movieinfoservice.models.Movie;
import io.moviapp.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
//            return new Movie(movieId, "Movie Name");

        try {
            MovieSummary movieSummary = restTemplate.getForObject(
                    "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey
                    , MovieSummary.class);
            return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new Movie(movieId,"Test name","desc");
    }
}
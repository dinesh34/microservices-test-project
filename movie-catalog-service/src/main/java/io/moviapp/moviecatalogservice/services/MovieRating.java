package io.moviapp.moviecatalogservice.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import io.moviapp.moviecatalogservice.models.Rating;
import io.moviapp.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//Separate services are created for both Point of Failure methods with seperate classes to avoid
//the fallbackmethod failing because of the proxy wrapping the service when declared inside the resource file.
//Now the instance is created of each class when called, and because it comes in a different proxy (wrapping) Hystrix can
//identify and configure each of them.
//We can also use hystrix properties and give commandProperties and threadpool properties, for bulkhead creation.
// https://stackoverflow.com/questions/31211685/configuring-hystrix-command-properties-using-application-yaml-in-spring-boot-app

@Service
public class MovieRating {

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "getFallbackRatingsData")
    public UserRating getRatingsData(@PathVariable("userId") String userId) {
        return restTemplate.getForObject("http://movie-rating-service/ratings/users/" + userId, UserRating.class);
    }


    public UserRating getFallbackRatingsData(@PathVariable("userId") String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserRating(Arrays.asList(new Rating("Movie Id not found", 0)));
        return userRating;
    }
}

package com.theater;

import com.theater.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class MyRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(MyRunner.class);

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {

        logger.info("Saving movies");

        movieRepository.save(new Movie(counter.getAndIncrement(),"Castle in the sky", 130));
        movieRepository.save(new Movie(counter.getAndIncrement(),"Spirited Away", 130));
        movieRepository.save(new Movie(counter.getAndIncrement(),"Captain America", 130));
        movieRepository.save(new Movie(counter.getAndIncrement(),"The Avengers", 130));
        movieRepository.save(new Movie(counter.getAndIncrement(),"Iron Man", 130));
        movieRepository.save(new Movie(counter.getAndIncrement(),"Your Name", 130));
        movieRepository.save(new Movie(counter.getAndIncrement(),"Kiki's Delivery Service", 130));
        movieRepository.save(new Movie(counter.getAndIncrement(),"Princess Mononoke", 130));
    }
}
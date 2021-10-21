package com.agus.myapp.service.implement;

import com.agus.myapp.dto.MovieDTO;
import com.agus.myapp.entity.Movie;
import com.agus.myapp.repository.MovieRepositories;
import com.agus.myapp.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImplement implements MovieServices {

    @Autowired
    private MovieRepositories movieRepositories;

//    @Autowired
//    ReactiveNeo4jTemplate neo4jTemplate;

    @Override
    public Page<Movie> getALlData(int page, int size) {
        Pageable paging = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC,"identity"));
        return movieRepositories.findAll(paging);
    }

    @Override
    public Movie saveData(MovieDTO movieDTO) {
        return movieRepositories.save(mappingToMovie(movieDTO));
    }

    @Override
    public Movie findById(Long id) {
        Optional<Movie> movie = movieRepositories.findById(id);
        return movie.orElseGet(Movie::new);
    }

    @Override
    public void deleteById(Long id) {
        movieRepositories.deleteById(id);
    }

    private Movie mappingToMovie(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setIdentity(movieDTO.getIdentity());
        movie.setTagline(movieDTO.getTagline());
        movie.setTitle(movieDTO.getTitle());
        movie.setReleased(movieDTO.getReleased());
        return movie;
    }
}

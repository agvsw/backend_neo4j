package com.agus.myapp.service;

import com.agus.myapp.dto.MovieDTO;
import com.agus.myapp.entity.Movie;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface MovieServices {
    Page<Movie> getALlData(int page, int size);
    Movie saveData(MovieDTO movieDTO);
    Movie findById(Long id);
    void deleteById(Long id);
}

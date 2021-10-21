package com.agus.myapp.controller;

import com.agus.myapp.dto.CommonResponse;
import com.agus.myapp.dto.MovieDTO;
import com.agus.myapp.entity.Movie;
import com.agus.myapp.service.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @Autowired
    private MovieServices movieServices;

    @GetMapping("/movie")
    public CommonResponse<Page<Movie>> getAllData(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ){
        CommonResponse<Page<Movie>> response = new CommonResponse<>();
        response.setData(movieServices.getALlData(page, size));
        return response;
    }

    @PostMapping("/movie")
    public CommonResponse<Movie> saveData(@RequestBody MovieDTO movieEntity){
        CommonResponse<Movie> response = new CommonResponse<>();
        response.setData(movieServices.saveData(movieEntity));
        return response;
    }

    @PutMapping("/movie")
    public CommonResponse<Movie> updateData(@RequestBody MovieDTO movieEntity){
        CommonResponse<Movie> response = new CommonResponse<>();
        response.setData(movieServices.saveData(movieEntity));
        return response;
    }

    @GetMapping("/movie/{id}")
    public CommonResponse<Movie> getById(@PathVariable("id") Long id){
        CommonResponse<Movie> response = new CommonResponse<>();
        response.setData(movieServices.findById(id));
        return response;
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
        movieServices.deleteById(id);
        return new ResponseEntity<>(new CommonResponse<>(), HttpStatus.OK);
    }

}

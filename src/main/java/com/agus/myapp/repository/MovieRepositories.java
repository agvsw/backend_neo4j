package com.agus.myapp.repository;

import com.agus.myapp.entity.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepositories extends Neo4jRepository<Movie, Long> {
    List<Movie> findByReleased(Integer released);

}

package com.agus.myapp.entity;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Property;
//import org.springframework.data.neo4j.core.schema.Property;


//@Node("Movie")
@NodeEntity(label = "Movie")
public class Movie {
    @Id
    @GeneratedValue
    private Long identity;
    @Property(name = "tagline")
    private String tagline;
    @Property(name = "title")
    private String title;
    @Property(name = "released")
    private Integer released;

    public Movie() {
    }

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleased() {
        return released;
    }

    public void setReleased(Integer released) {
        this.released = released;
    }
}

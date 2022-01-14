package io.guilhermefasilva.dsmovie.dto;

import io.guilhermefasilva.dsmovie.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class MovieDto {

    private Long id;
    private String title;
    private Double score;
    private Integer count;
    private String image;

    public MovieDto(){}

    public MovieDto(Movie movie){
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.score = movie.getScore();
        this.count = movie.getCount();
        this.image = movie.getImage();
    }

}

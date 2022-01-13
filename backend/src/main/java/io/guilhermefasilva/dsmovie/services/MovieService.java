package io.guilhermefasilva.dsmovie.services;

import io.guilhermefasilva.dsmovie.dto.MovieDto;
import io.guilhermefasilva.dsmovie.entities.Movie;
import io.guilhermefasilva.dsmovie.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Transactional(readOnly = true)
    public Page<MovieDto> findAll(Pageable pageable){
        Page<Movie> moviePage =  movieRepository.findAll(pageable);
        Page<MovieDto> movieDtoPage = moviePage.map(m -> new MovieDto(m));
        return movieDtoPage;
    }

    @Transactional(readOnly = true)
    public MovieDto findById(Long id){
        Movie movie =  movieRepository.findById(id).orElseThrow(()-> new RuntimeException("Erro ao buscar o id " + id));
        MovieDto movieDto = new MovieDto(movie);
        return movieDto ;
    }


}

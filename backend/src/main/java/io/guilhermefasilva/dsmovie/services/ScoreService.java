package io.guilhermefasilva.dsmovie.services;

import io.guilhermefasilva.dsmovie.dto.MovieDto;
import io.guilhermefasilva.dsmovie.dto.ScoreDto;
import io.guilhermefasilva.dsmovie.entities.Movie;
import io.guilhermefasilva.dsmovie.entities.Score;
import io.guilhermefasilva.dsmovie.entities.User;
import io.guilhermefasilva.dsmovie.repositories.MovieRepository;
import io.guilhermefasilva.dsmovie.repositories.ScoreRepository;
import io.guilhermefasilva.dsmovie.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScoreService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScoreRepository scoreRepository;

    @Transactional
    public MovieDto saveScore(ScoreDto scoreDto){
        User user = userRepository.findByEmail(scoreDto.getEmail());
        if(user == null){
            user = new User();
            user.setEmail(scoreDto.getEmail());
            user = userRepository.saveAndFlush(user);
        }
        Movie movie = movieRepository.findById(scoreDto.getMovieId())
                .orElseThrow(()-> new RuntimeException("Erro ao localizar o id: "+scoreDto.getMovieId()));

        Score score = new Score();
        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreDto.getScore());
        score = scoreRepository.saveAndFlush(score);

        double sum = 0.0;
        for(Score s : movie.getScores()){
            sum+=s.getValue();
        }
        double avg = sum / movie.getScores().size();

        movie.setScore(avg);
        movie.setCount(movie.getScores().size());
        movie = movieRepository.save(movie);

        return new MovieDto(movie);
    }




}

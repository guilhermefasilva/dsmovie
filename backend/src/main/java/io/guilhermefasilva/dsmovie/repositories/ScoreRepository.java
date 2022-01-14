package io.guilhermefasilva.dsmovie.repositories;

import io.guilhermefasilva.dsmovie.entities.Score;
import io.guilhermefasilva.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}

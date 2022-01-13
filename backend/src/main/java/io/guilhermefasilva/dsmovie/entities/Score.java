package io.guilhermefasilva.dsmovie.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name="tb_score")
public class Score {

    @EmbeddedId
    private ScorePk id = new ScorePk();
    private Double value;


    public void setMovie(Movie movie){
        this.id.setMovie(movie);
    }

    public void setUser(User user){
        this.id.setUser(user);
    }
}

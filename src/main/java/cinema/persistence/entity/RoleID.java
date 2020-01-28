package cinema.persistence.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RoleID {


     @ManyToOne
     @JoinColumn(name = "id_actor")
     private Person actor;
     public Person getActor() {
             return actor;
     }

     public void setActor(Person actor) {
             this.actor = actor;
     }

     @ManyToOne
     @JoinColumn(name = "id_movie")
     private Movie movie;
     public Movie getMovie() {
             return movie;
     }

     public void setMovie(Movie movie) {
             this.movie = movie;
     }
}

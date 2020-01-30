package cinema.persistence.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RoleID implements java.io.Serializable {

    private Person actor;
    private Movie movie;
    
	private static final long serialVersionUID = 1L;

     @ManyToOne
     @JoinColumn(name = "id_actor")
     public int getActor() {
    	 return actor.getIdPerson();
     }

     public void setActor(Person actor) {
    	 this.actor = actor;
     }

     @ManyToOne
     @JoinColumn(name = "id_movie")
     public int getMovie() {
    	 return movie.getIdMovie();
     }

     public void setMovie(Movie movie) {
    	 this.movie = movie;
     }
}

package cinema.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class LikedMovies {
	@EmbeddedId
	MovieLikingKey id;
	
	@ManyToOne
	@MapsId("user_id")
	@JoinColumn(name="user_id")
	User user;
	
	@ManyToOne
	@MapsId("movie_id")
	@JoinColumn(name="movie_id")
	Movie movie;

}

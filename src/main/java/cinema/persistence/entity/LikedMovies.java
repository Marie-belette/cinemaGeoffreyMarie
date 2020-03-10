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
	@MapsId("id_user")
	@JoinColumn(name="id_user")
	User user;
	
	@ManyToOne
	@MapsId("id_movie")
	@JoinColumn(name="id_movie")
	Movie movie;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	
	
}

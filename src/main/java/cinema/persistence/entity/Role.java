package cinema.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "act")
public class Role {

	private String name;
	
	public Role() {
		super();
	}
	
	public Role(Integer idRole, String name) {
		super();
		this.name = name;
	}

	@Id
    RoleID pk;
    public RoleID getPk() {
        return pk;
    }
    
    public void setPk(RoleID pk) {
        this.pk = pk;
    }

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Movie getMovie() {
        return getPk().getMovie();
	}

	public void setFilm(Movie movie) {
	        getPk().setMovie(movie);
	}
	
	public Person getActor() {
	        return getPk().getActor();
	}

	public void setActor(Person actor) {
	        getPk().setActor(actor);
	}
}

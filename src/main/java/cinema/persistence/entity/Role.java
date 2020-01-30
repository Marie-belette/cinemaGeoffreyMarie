package cinema.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

	private String name;
	private RoleID pk;
	   
	
	@Id
    public RoleID getPk() {
        return pk;
    }
    
    public void setPk(RoleID pk) {
        this.pk = pk;
    }

    @Column(name="name_role")
    public String getName() {return name;}
    
    public void setName(String n) {name= n;}
    
    
    public int getMovie() {
        return getPk().getMovie();
    }

    public void setMovie(Movie movie) {
        getPk().setMovie(movie);
    }

    	@Column(name="played_by")
    public int getActor() {
        return getPk().getActor();
    }

    public void setActor(Person actor) {
        getPk().setActor(actor);
    }
}
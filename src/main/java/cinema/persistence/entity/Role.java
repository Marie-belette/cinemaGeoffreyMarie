package cinema.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


@Entity
@Table(name= "role")
public class Role {

	@Id
	@GeneratedValue
	private int idRole;
	private String name;
	private int idMovie;
	private int idActors;

	
	public Role() {
		super();
	}
	

	public Role(int idRole, String name, int idMovie, int idActors) {
		super();
		this.idRole = idRole;
		this.name = name;
		this.idMovie = idMovie;
		this.idActors = idActors;
	}


	public Role(String name, int idMovie, int idActors) {
		super();
		this.name = name;
		this.idMovie = idMovie;
		this.idActors = idActors;
	}


	public int getIdRole() {
		return idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}
	
	
	public int getIdActors() {
		return idActors;
	}


	public void setIdActors(int idActors) {
		this.idActors = idActors;
	}


	public int getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(int idMovie) {
		this.idMovie = idMovie;
	}

	@Column(nullable = false, length = 255)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@ManyToOne
	@JoinColumn(name= "id_movie")
	
	public int getMovie() {
		return idMovie;
	}

	public void setMovie(int movie) {
		this.idMovie = movie;
	}

	
	
	@ManyToOne
	@JoinColumn(name = "id_actor")
	public int getActors() {
		return idActors;
	}

	public void setActors(int actors) {
		this.idActors = actors;
	}
}

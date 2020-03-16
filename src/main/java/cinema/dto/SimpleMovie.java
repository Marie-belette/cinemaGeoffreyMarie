package cinema.dto;

import java.util.Set;

import cinema.persistence.entity.User;

public class SimpleMovie {
	
	private Integer idMovie;
	private String title;
	private Integer year;
	private Set<User> usersLiking;
	
	public Integer getIdMovie() {
		return idMovie;
	}
	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Set<User> getUsersLiking() {
		return usersLiking;
	}
	public void setUsersLiking(Set<User> usersLiking) {
		this.usersLiking = usersLiking;
	}
	public int getNumberUsersLiking() {
		return usersLiking.size();
	}
}

package cinema.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cinema.data.Classification;
import cinema.data.Couleur;
import cinema.data.Format;
import cinema.data.Rating;

@Entity
@Table(name = "movies")
public class Movie {

	private Integer idMovie;
	private String title;
	private Integer year;
	private Integer duration;
	
	private Person director;
	private List<Person> actors;
	private String originalTitle;
	private Object rating ;
	private String genre;
	private Format format;
	private Classification classification;
	private String synopsis;
	private Couleur couleur;
	
	//@Transient
	// private String director; Ce sont les attributs qui ne sont pas "persistent", donc qui ne seront pas sauvegardés (côté Database)
	
	public Movie() {
		super();
	}

	public Movie(Integer idMovie, String title, String originalTitle, Integer year, Integer duration, Person director, String genre, 
			Rating rating, Format format, Classification classification, String synopsis, Couleur couleur) {
		super();
		this.idMovie = idMovie;
		this.title = title;
		this.originalTitle = originalTitle;
		this.year = year;
		this.duration = duration;
		this.director = director;
		this.actors = new ArrayList<>();
		this.genre = genre;
		this.rating = rating;
		this.format = format;
		this.classification = classification;
		this.synopsis = synopsis;
		this.couleur = couleur;
	}
	
	public Movie(String title, Integer year, Integer duration, Person director) {
		this(null, title, null, year, duration, director, null, null, null, null, null, null);
	}
	
	public Movie(String title, Integer year, Integer duration) {
		this(null, title, null, year, duration, null, null, null, null, null, null, null);
	}

	public Movie(String title, Integer year) {
		this(null, title, null, year, null, null, null, null, null, null, null, null);
	}
	
	public Movie(String title, Integer year, Person director) {
		this(null, title, null, year, null, director, null, null, null, null, null, null);
	}
	
	public Movie(String title, String originalTitle, Integer year, Integer duration, Person director) {
		this(null, title, originalTitle, year, duration, director, null, null, null, null, null, null);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movie")
	public Integer getIdMovie() {
		return idMovie;
	}

	public void setIdMovie(Integer idMovie) {
		this.idMovie = idMovie;
	}
	
	@Column(nullable = false, length = 255)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(nullable = false)
	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	@ManyToOne
	@JoinColumn(name="id_director", nullable=true)
	public Person getDirector() {
		return director;
	}

	public void setDirector(Person director) {
		this.director = director;
	}
	
	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public Object getRating() {
		return rating;
	}

	public void setRating(Object rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@ManyToMany //(fetch = FetchType.EAGER)
	@JoinTable(name="act",
        joinColumns=@JoinColumn(name="id_movie"),
        inverseJoinColumns=@JoinColumn(name="id_actor")
        )
	public List<Person> getActors() {
		return actors;
	}

	public void setActors(List<Person> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(title);
		return builder.append(" (")
		.append(year)
		.append(')')
		.append('#')
		.append(idMovie)
		.toString();
	}
	
}

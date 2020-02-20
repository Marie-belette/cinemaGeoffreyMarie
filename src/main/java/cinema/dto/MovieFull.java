package cinema.dto;

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Iterator;
import java.util.List;
//import java.util.Objects;
//import java.util.stream.Stream;
//
//import javax.persistence.CollectionTable;
//import javax.persistence.ElementCollection;
//import javax.persistence.JoinColumn;

import cinema.enumeration.Classification;
import cinema.enumeration.Color;
import cinema.enumeration.Format;
import cinema.enumeration.Rating;

public class MovieFull extends SimpleMovie {
	
	private String originalTitle;
	private Integer duration;
	private List<String> genres;
	private String synopsis;
	private Rating rating ;
	private Format format;
	private Classification classification;
	private Color color;
	public String getOriginalTitle() {
		return originalTitle;
	}
	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public List<String> getGenres() {
		return genres;
	}
	public void setGenres(List<String> genres) {
		this.genres = genres;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
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
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
	
//	public MovieFull(String title, int year, int duration, Person director) {
//		super();
//		this.title = Objects.requireNonNull(title);
//		this.year = year;
//		this.duration = duration;
//		this.director = director;
//		this.actors = new ArrayList<>();
//	}
//	
//	public MovieFull (String title, int year, int duration) {
//		this(title, year, duration, null);
//	}
//
//	public MovieFull(String title, int year, Person director) {
//		this(title, year, 0, director);
//	}
//
//	public MovieFull(String title, int year) {
//		this(title, year, 0);
//	}
//
//	public String getTitle() {
//		return title;
//	}
//
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	public int getYear() {
//		return year;
//	}
//
//	public void setYear(int year) {
//		this.year = year;
//	}
//
//	public int getDuration() {
//		return duration;
//	}
//
//	public void setDuration(int duration) {
//		this.duration = duration;
//	}
//
//	public Person getDirector() {
//		return director;
//	}
//
//	public void setDirector(Person director) {
//		this.director = director;
//	}
//
//	
//	
//	@Override
//	public String toString() {
//		return title + " (" + year + ")";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(title, year);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		MovieFull other = (MovieFull) obj;
//		return this.title.equals(other.title)
//				&& this.year == other.year;
//	}
//
//	public void addActor(Person actor) {
//		this.actors.add(actor);	
//	}
//	
//	public void addAllActors(Collection<? extends Person> actors) {
//		this.actors.addAll(actors);
//	}
//	
//	public void addAllActor(Person... actors) {
//		this.addAllActors(Arrays.asList(actors));
//	}
//	
//	public Iterator<Person> iteratorActors() {
//		return this.actors.iterator();
//	}
//	
//	public Stream<Person> streamActors() {
//		return this.actors.stream();
//	}
//
//	public String getOriginalTitle() {
//		return originalTitle;
//	}
//
//	public void setOriginalTitle(String originalTitle) {
//		this.originalTitle = originalTitle;
//	}
//
//
//	public void setGenres(List<String> genres) {
//		this.genres = genres;
//	}
//	
//}

package cinema.persistence.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.mapping.Set;

import cinema.enumeration.Nationalities;

	@Entity
	@Table(name = "Persons")
	public class Person {

		private Integer idPerson;
		private String name;
		private LocalDate birthdate;
		private Nationalities nationalities;
		private String biography;

		
		public Person() {
			super();
		}

		public Person(Integer idPerson, String name, LocalDate birthdate, Nationalities nationalities,
				String biography) {
			super();
			this.idPerson = idPerson;
			this.name = name;
			this.birthdate = birthdate;
			this.nationalities = nationalities;
			this.biography = biography;
		}
		
		public Person(String name, LocalDate birthdate) {
			super();
			this.name = name;
			this.birthdate = birthdate;
		}
		
		public Person(String name, LocalDate birthdate, Nationalities nationalities, String biography) {
			this(null, name, birthdate,nationalities,biography);	
		}
		
		public Person(String name, LocalDate birthdate, String biography) {
			this(null,name, birthdate,null,biography);	
		}
		
		@OneToMany(mappedBy = "pk.acteur")
		private ArrayList<Role> roles = new ArrayList<Role>();
		public ArrayList<Role> getRoles() {
		        return this.roles;
		}
		
		public void setRoles(ArrayList<Role> r) {
		        this.roles = r;
		}
		
		@ManyToMany(mappedBy = "actors")
		ArrayList<Movie> filmo;
		public ArrayList<Movie> getFilmo() {
		        return filmo;
		}
		
		public Person(String name) {
			this();	
		}
		
		public Person(String name, LocalDate birthdate, Nationalities nationalities) {
			
			this.name = name;
			this.birthdate = birthdate;
			this.nationalities = nationalities;
		}
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id_person")
		public Integer getIdPerson() {
			return idPerson;
		}

		public void setIdPerson(Integer idPerson) {
			this.idPerson = idPerson;
		}

		@Column(nullable = false, length = 255)
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDate getBirthdate() {
			return birthdate;
		}

		public void setBirthdate(LocalDate birthdate) {
			this.birthdate = birthdate;
		}

		public Nationalities getNationalities() {
			return nationalities;
		}

		public void setNationalities(Nationalities nationalities) {
			this.nationalities = nationalities;
		}

		public String getBiography() {
			return biography;
		}

		public void setBiography(String biography) {
			this.biography = biography;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder(name);
			return builder.append(" (")
			.append(Objects.toString(birthdate, "unknown"))
			.append(')')
			.append(" ")
			.append('#')
			.append(idPerson)
			.toString();
		}

}

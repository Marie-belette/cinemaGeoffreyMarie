package cinema.persistence.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name = "Persons")
	public class Person {

		private Integer idPerson;
		private String name;
		private LocalDate birthdate;
		private int age;
		private String nationalities;
		private String biography;
		
		public Person() {
			super();
		}
		
		
		
		public Person(Integer idPerson, String name, LocalDate birthdate, int age, String nationalities,
				String biography) {
			super();
			this.idPerson = idPerson;
			this.name = name;
			this.birthdate = birthdate;
			this.age = age;
			this.nationalities = nationalities;
			this.biography = biography;

		}
		

		public Person(Integer idPerson, String name, LocalDate birthdate, int age, String nationalities) {
			this(null, name, birthdate,age,nationalities,null);	

		}
		
		public Person(String name, LocalDate birthdate, int age, String biography) {
			this(null,name, birthdate,age,null,biography);	

		}
		
		public Person(String name, LocalDate birthdate, int age) {
			this(null, name, birthdate,age,null,null);	

		}
		
//		public Person(String name, LocalDate birthdate) {
//			this(null, name, birthdate,null,null,null);	
//		}
//		public Person(String name) {
//			this(null, name, null,null, null,null);	
//		}
//		
		
		
		
		
		
		

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
		
		
		
		public int getAge() {
			int annee = birthdate.getYear();
			int annee2 = LocalDate.now().getYear();
			return annee2 - annee;
		}



		public void setAge(int age) {
			this.age = age;
		}



		public String getNationalities() {
			return nationalities;
		}



		public void setNationalities(String nationalities) {
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

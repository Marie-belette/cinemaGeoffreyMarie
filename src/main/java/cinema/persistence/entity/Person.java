package cinema.persistence.entity;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import cinema.enumeration.Nationalities;

	@Entity
	@Table(name = "Persons")
	public class Person {

		private Integer idPerson;
		private String name;
		private LocalDate birthdate;
		private Nationalities nationalities;
		private String biography;
		private int age;
		
		public Person() {
			super();
		}

		public Person(Integer idPerson, String name, LocalDate birthdate, int age, Nationalities nationalities,
				String biography) {
			super();
			this.idPerson = idPerson;
			this.name = name;
			this.birthdate = birthdate;
			this.age = age;
			this.nationalities = nationalities;
			this.biography = biography;
		}
		
		public Person(String name, LocalDate birthdate) {
			super();
			this.name = name;
			this.birthdate = birthdate;
		}

		public Person(Integer idPerson, String name, LocalDate birthdate, int age, Nationalities nationalities) {
			this(null, name, birthdate,age,nationalities,null);	
		}
		
		public Person(String name, LocalDate birthdate, int age, String biography) {
			this(null,name, birthdate,age,null,biography);	
		}
		
		public Person(String name, LocalDate birthdate, int age) {
			this(null, name, birthdate,age,null,null);	
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

		@Column(name = "age")
		public int getAge() {
			LocalDate todayFull = LocalDate.now();
			MonthDay birthday = MonthDay.of(
					birthdate.getMonthValue(), 
					birthdate.getDayOfMonth());
			MonthDay today = MonthDay.now();		
			int age = todayFull.getYear() - birthdate.getYear();
			if (today.compareTo(birthday) < 0) {
				-- age;
			}
			return age;
		}

		public void setAge(int age) {
			this.age = age;
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

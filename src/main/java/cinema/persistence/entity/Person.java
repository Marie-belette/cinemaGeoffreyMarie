package cinema.persistence.entity;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;
import java.util.OptionalInt;

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
			this.nationalities = nationalities;
			this.biography = biography;
		}
		
		public Person(String name, LocalDate birthdate) {
			super();
			this.name = name;
			this.birthdate = birthdate;
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
		
		public Person(String name) {
			this();	
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
			
		public int getAge() {
			if (Objects.isNull(birthdate)) {
				return OptionalInt.empty().getAsInt();
		}
			LocalDate todayFull = LocalDate.now();
			MonthDay birthday = MonthDay.of(
					birthdate.getMonthValue(), 
					birthdate.getDayOfMonth());
			MonthDay today = MonthDay.now()
	;		int deltaYear = todayFull.getYear() - birthdate.getYear();
			if (today.compareTo(birthday) < 0) {
				-- deltaYear;
			}
			int age = OptionalInt.of(deltaYear).getAsInt();
			return age;
			// TODO equals + hashCode
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

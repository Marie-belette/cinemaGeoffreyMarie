package cinema.dto;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Objects;
import java.util.OptionalInt;

public class PersonDTO {
	
	private Integer idPerson;
	private String name;
	private LocalDate birthdate;
	

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

	@Override
	public String toString() {
		return name + " (" + Objects.toString(birthdate, "unknown") + ")";
	}

	public OptionalInt getAge() {
		if (Objects.isNull(birthdate)) {
			return OptionalInt.empty();
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
		return OptionalInt.of(deltaYear);
		
		// TODO equals + hashCode
	}

	public Integer getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Integer idPerson) {
		this.idPerson = idPerson;
	}
}


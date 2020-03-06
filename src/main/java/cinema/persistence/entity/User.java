package cinema.persistence.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class User {

	private Integer idUser;
	private String lastName;
	private String firstName;
	private String eMail;
	private String password;
	private Set<LikedMovies> likedMovies;

	public User() {
		super();
	}

	public User(Integer idUser, String lastName, String firstName, String eMail, String password,
			Set<LikedMovies> likedMovies) {
		super();
		this.idUser = idUser;
		this.lastName = lastName;
		this.firstName = firstName;
		this.eMail = eMail;
		this.password = password;
		this.likedMovies = likedMovies;
	}

	public User(String lastName, String firstName, String eMail, String password) {
		this(null, lastName, firstName, eMail, password, null);
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	@Column(name = "nom")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "prenom")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(nullable = false)
	public String getEMail() {
		return eMail;
	}

	public void setEMail(String eMail) {
		this.eMail = eMail;
	}

	@Column(nullable = false)
	public String getPassword() {
		return password;
	}

	@Column(name = "mot_de_passe")
	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy="user")
	public Set<LikedMovies> getLikedMovies() {
		return likedMovies;
	}

	public void setLikedMovies(Set<LikedMovies> likedMovies) {
		this.likedMovies = likedMovies;
	}
	
	
}

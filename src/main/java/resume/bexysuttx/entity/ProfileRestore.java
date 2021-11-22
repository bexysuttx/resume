package resume.bexysuttx.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "profile_restore")
public class ProfileRestore extends AbstractEntity<Long> implements Serializable {
	private static final long serialVersionUID = -6703443122949942876L;

	@Id
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(unique = true, nullable = false, length = 255)
	private String token;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "id", nullable = false)
	private Profile profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}

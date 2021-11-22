package resume.bexysuttx.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import resume.bexysuttx.Constants;
import resume.bexysuttx.entity.Profile;

import java.util.Collections;

public class CurrentProfile extends User {
	private static final long serialVersionUID = 6215719843283910911L;
	private final Long id;
	private final String fullname;

	public CurrentProfile(Profile profile) {
		super(profile.getUid(), profile.getPassword(), true, true, true, true,
				Collections.singleton(new SimpleGrantedAuthority(Constants.USER)));
		this.id = profile.getId();
		this.fullname = profile.getFullName();
	}

	public Long getId() {
		return id;
	}

	public String getFullname() {
		return fullname;
	}

	@Override
	public String toString() {
		return String.format("CurrentProfile [id=%s, fullname=%s]", id, fullname);
	}

}

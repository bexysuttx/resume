package resume.bexysuttx.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.model.CurrentProfile;

public final class SecurityUtil {

	public static CurrentProfile getCurrentProfile() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return null;
		}
		Object prinObject = authentication.getPrincipal();
		if (prinObject instanceof CurrentProfile) {
			return (CurrentProfile) prinObject;
		} else {
			return null;
		}
	}

	public static Long getCurrentIdProfile() {
		CurrentProfile currentProfile = getCurrentProfile();
		return currentProfile != null ? currentProfile.getId() : null;
	}

	public static void authentificate(Profile profile) {
		CurrentProfile currentProfile = new CurrentProfile(profile);
		Authentication authentication = new UsernamePasswordAuthenticationToken(currentProfile,
				currentProfile.getPassword(), currentProfile.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	public static boolean isCurrentProfileAuthentificated() {
		return getCurrentIdProfile() != null; 
	}

}

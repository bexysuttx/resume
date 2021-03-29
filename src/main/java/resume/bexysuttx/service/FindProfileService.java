package resume.bexysuttx.service;

import resume.bexysuttx.entity.Profile;

public interface FindProfileService {

	Profile findByUid(String uid);
	
}

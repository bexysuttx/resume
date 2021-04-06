package resume.bexysuttx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.repository.storage.ProfileRepository;
import resume.bexysuttx.service.FindProfileService;

@Service
public class FindProfileServiceImpl implements FindProfileService {
	
	@Autowired
	 private ProfileRepository profileRepository;

	@Override
	public Profile findByUid(String uid) {
		return profileRepository.findByUid(uid);
	}

	@Override
	public Page<Profile> findAll(Pageable pageable) {
		return profileRepository.findAll(pageable);
	}

}

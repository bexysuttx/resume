package resume.bexysuttx.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import resume.bexysuttx.entity.Profile;

public interface FindProfileService {

	Profile findByUid(String uid);
	
	Page<Profile> findAll(Pageable pageable);
	
	Iterable<Profile> findAllForIndexing();
	
	Page<Profile> findBySearchQuery(String query,Pageable pageable);
	
}

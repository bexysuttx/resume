package resume.bexysuttx.repository.storage;

import org.springframework.data.repository.CrudRepository;
import resume.bexysuttx.entity.ProfileRestore;

public interface ProfileRestoreRepository extends CrudRepository<ProfileRestore, Long> {

	ProfileRestore findByToken(String token);
}

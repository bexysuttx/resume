package resume.bexysuttx.repository.storage;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.RepositoryDefinition;
import resume.bexysuttx.entity.SkillCategory;

import java.util.List;

@RepositoryDefinition(domainClass = SkillCategory.class, idClass=Long.class)
public interface SkillCategoryRepository {
	
	List<SkillCategory> findAll(Sort sort);

}

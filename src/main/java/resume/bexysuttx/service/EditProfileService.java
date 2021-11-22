package resume.bexysuttx.service;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.entity.Skill;
import resume.bexysuttx.entity.SkillCategory;
import resume.bexysuttx.form.SignUpForm;

import java.util.List;

public interface EditProfileService {
	
	Profile createNewProfile(SignUpForm signUpForm);
	
	List<Skill> listSkills(long idProfile);
	
	List<SkillCategory> listSkillCategories();
	
	void updateSkills(long idProfile, List<Skill> updateData);
	
	
	
}

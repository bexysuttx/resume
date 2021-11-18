package resume.bexysuttx.service;

import java.util.List;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.entity.Skill;
import resume.bexysuttx.entity.SkillCategory;
import resume.bexysuttx.form.SignUpForm;

public interface EditProfileService {
	
	Profile createNewProfile(SignUpForm signUpForm);
	
	List<Skill> listSkills(long idProfile);
	
	List<SkillCategory> listSkillCategories();
	
	void updateSkills(long idProfile, List<Skill> updateData);
	
	
	
}

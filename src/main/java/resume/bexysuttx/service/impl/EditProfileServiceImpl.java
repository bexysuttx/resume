package resume.bexysuttx.service.impl;


import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.entity.Skill;
import resume.bexysuttx.entity.SkillCategory;
import resume.bexysuttx.exception.CantCompleteClientRequestException;
import resume.bexysuttx.form.SignUpForm;
import resume.bexysuttx.repository.storage.ProfileRepository;
import resume.bexysuttx.repository.storage.SkillCategoryRepository;
import resume.bexysuttx.service.EditProfileService;
import resume.bexysuttx.util.DataUtil;

@Service
public class EditProfileServiceImpl implements EditProfileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EditProfileServiceImpl.class);

	@Autowired
	private SkillCategoryRepository skillCategoryRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Value("${generate.uid.max.try.count}")
	private int maxTryCountToGenerateUid;

	@Value("${generate.uid.alphabet}")
	private String alphabetToGenerateUid;

	@Value("${generate.uid.suffix.length}")
	private int suffixLengthToGenerateUid;

	@Override
	@Transactional
	public Profile createNewProfile(SignUpForm signUpForm) {
		Profile profile = new Profile();
		profile.setUid(generateProfileUid(signUpForm));
		profile.setFirstName(DataUtil.capitalizeName(signUpForm.getFirstName()));
		profile.setLastName(DataUtil.capitalizeName(signUpForm.getLastName()));
		profile.setPassword(signUpForm.getPassword());
		profile.setCompleted(false);
		profileRepository.save(profile);
		return profile;
	}

	@Override
	public List<Skill> listSkills(long idProfile) {
		return profileRepository.findOne(idProfile).getSkills();
	}

	@Override
	public List<SkillCategory> listSkillCategories() {
		return skillCategoryRepository.findAll(new Sort("id"));
	}

	@Override
	@Transactional
	public void updateSkills(long idProfile, List<Skill> updatedData) {
		Profile profile = profileRepository.findOne(idProfile);
		if (CollectionUtils.isEqualCollection(updatedData, profile.getSkills())) {
			LOGGER.debug("Profile skills: nothing to update");
			return;
		} else {
			profile.setSkills(updatedData);
			profileRepository.save(profile);
		}
	}

	private String generateProfileUid(SignUpForm signUpForm) {
		String baseUid = DataUtil.generateProfileUid(signUpForm);
		String uid = baseUid;
		for (int i = 0; 0 < profileRepository.countByUid(uid); i++) {
			uid = DataUtil.regenerateUidWithRandomSuffix(baseUid, alphabetToGenerateUid, suffixLengthToGenerateUid);
			if (i >= maxTryCountToGenerateUid) {
				throw new CantCompleteClientRequestException(
						"Can't generate unique uid for profile: " + baseUid + ": maxTryCountToGenerateUid detected");
			}

		}
		return uid;
	}

}

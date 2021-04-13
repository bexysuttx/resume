package resume.bexysuttx.service.impl;

import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;


import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.entity.Skill;
import resume.bexysuttx.entity.SkillCategory;
import resume.bexysuttx.exception.CantCompleteClientRequestException;
import resume.bexysuttx.form.SignUpForm;
import resume.bexysuttx.repository.search.ProfileSearchRepository;
import resume.bexysuttx.repository.storage.ProfileRepository;
import resume.bexysuttx.repository.storage.SkillCategoryRepository;
import resume.bexysuttx.service.EditProfileService;
import resume.bexysuttx.util.DataUtil;

@Service
@SuppressWarnings("unchecked")
public class EditProfileServiceImpl implements EditProfileService {
	private static final Logger LOGGER = LoggerFactory.getLogger(EditProfileServiceImpl.class);

	@Autowired
	private SkillCategoryRepository skillCategoryRepository;

	@Autowired
	private ProfileRepository profileRepository;

	@Autowired
	private ProfileSearchRepository profileSearchRepository;

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
		registerCreateIndexProfileIfTransactionSuccess(profile);
		return profile;
	}

	private void registerCreateIndexProfileIfTransactionSuccess(final Profile profile) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("New profile created: {}", profile.getUid());
				profile.setCertificates(Collections.EMPTY_LIST);
				profile.setPractics(Collections.EMPTY_LIST);
				profile.setLanguages(Collections.EMPTY_LIST);
				profile.setSkills(Collections.EMPTY_LIST);
				profile.setCourses(Collections.EMPTY_LIST);
				profileSearchRepository.save(profile);
				LOGGER.info("New profile index created: {}", profile.getUid());
			}
		});

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
			registerUpdateIndexProfileSkillsIfTransactionSuccess(idProfile, updatedData);
		}
	}

	private void registerUpdateIndexProfileSkillsIfTransactionSuccess(final long idProfile,
			final List<Skill> updatedData) {
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				LOGGER.info("Profile skills updated");
				updateIndexProfileSkills(idProfile, updatedData);
			}
		});

	}

	protected void updateIndexProfileSkills(long idProfile, List<Skill> updatedData) {
		Profile profile = profileSearchRepository.findOne(idProfile);
		profile.setSkills(updatedData);
		profileSearchRepository.save(profile);
		LOGGER.info("Profile skills index updated");

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

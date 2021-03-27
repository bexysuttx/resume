package resume.bexysuttx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.repository.storage.ProfileRepository;

@Controller
public class PublicDataController {

	@Autowired
	private ProfileRepository profileRepository;

	@RequestMapping(value = "/{uid}", method = RequestMethod.GET)
	public String getProfile(@PathVariable("uid") String uid, Model model) {
		Profile profile = profileRepository.findByUid(uid);
		if (profile == null) {
			return "profile_not_found";
		}
		model.addAttribute("profile", profile);
		return "profile";
	}

	@RequestMapping(value = "/error", method = RequestMethod.GET)
	public String getError() {
		return "error";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String getWelcome() {
		return "welcome";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String getSearch() {
		return "search";
	}

	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String getSignIn() {
		return "sign-in";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String getSignUp() {
		return "sign-up";
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String getSignUpPost() {
		return "sign-up";
	}

	@RequestMapping(value = "/sign-up/success", method = RequestMethod.GET)
	public String getSignUpSuccess() {
		return "sign-up-success";
	}

	@RequestMapping(value = "/sign-in-failed", method = RequestMethod.GET)
	public String getSignInFailed() {
		return "sign-in-failed";
	}

	@RequestMapping(value = "/restore", method = RequestMethod.GET)
	public String getRestore() {
		return "restore";
	}

	@RequestMapping(value = "/restore/success", method = RequestMethod.GET)
	public String getRestoreSuccess() {
		return "restore-success";
	}

	@RequestMapping(value = "/restore", method = RequestMethod.POST)
	public String getRestorePost() {
		return "restore";
	}

	@RequestMapping(value = "/restore/{token}", method = RequestMethod.GET)
	public String getRestoreToken(@PathVariable("token") String token) {
		return "restore-token";

	}
}

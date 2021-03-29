package resume.bexysuttx.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import resume.bexysuttx.form.SkillForm;
import resume.bexysuttx.service.EditProfileService;
import resume.bexysuttx.util.SecurityUtil;

@Controller
public class EditProfileController {

	@Autowired
	private EditProfileService  editProfileService;



	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String getEditProfile() {
		return "edit";
	}

	@RequestMapping(value = "/edit/skills", method = RequestMethod.GET)
	public String getEditSkills(Model model) {
		model.addAttribute("skillForm", new SkillForm(editProfileService.listSkills(SecurityUtil.getCurrentIdProfile())));
		return gotoSkillsJSP(model);
	}

	@RequestMapping(value = "/edit/skills", method = RequestMethod.POST)
	public String saveEditSkills(@Valid @ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return gotoSkillsJSP(model);
		} 

			// update
			return "redirect:/amy-fowler";
		
	}

	private String gotoSkillsJSP(Model model) {
		model.addAttribute("skillCategories", editProfileService.listSkillCategories());
		return "edit/skills";
	}
}

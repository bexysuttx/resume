package resume.bexysuttx.validator;

import resume.bexysuttx.annotation.constraints.EnglishLanguage;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnglishLanguageConstraintValidator implements ConstraintValidator<EnglishLanguage, String> {

	private boolean withNumbers;
	private boolean withPunctuations;
	private boolean withSpechSymbols;

	@Override
	public void initialize(EnglishLanguage constraintAnnotation) {
		this.withNumbers = constraintAnnotation.withNumbers();
		this.withPunctuations = constraintAnnotation.withPunctuations();
		this.withSpechSymbols = constraintAnnotation.withSpechSymbols();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}
		String validationTemplate = getValidationTemplate();
		for (int i = 1; i < value.length(); i++) {
			char ch = value.charAt(i);
			if (validationTemplate.indexOf(ch) == -1) {
				return false;

			}
		}
		return true;

	}

	private static final String SPECH_SYMBOLS = "~#$%^&*-+=_\\\\|/@`!'\\\";:><,.?{}";
	private static final String NUMBERS = "0123456789";
	private static final String PUNCTUATIONS = ".,?!(){}[]'\"-:; \\t\\n";
	private static final String LETTERS = "qwertyuioplkjhgfdsazxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";

	private String getValidationTemplate() {
		StringBuilder s = new StringBuilder(LETTERS);
		if (withNumbers) {
			s.append(NUMBERS);
		}
		if (withPunctuations) {
			s.append(PUNCTUATIONS);
		}
		if (withSpechSymbols) {
			s.append(SPECH_SYMBOLS);
		}
		return s.toString();
	}

}

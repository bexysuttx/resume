package resume.bexysuttx.util;

import org.apache.commons.text.WordUtils;
import resume.bexysuttx.form.SignUpForm;

import java.util.Random;

public class DataUtil {
	
	public static String normalizeName(String name) {
		return  name.toLowerCase();
	}
	
	public static String capitalizeName(String name) {
		return WordUtils.capitalize(normalizeName(name));
	}
	
	public static String generateProfileUid(SignUpForm profile) {
		return normalizeName(profile.getFirstName()) + "-" + normalizeName(profile.getLastName());
	}
	
	public static String regenerateUidWithRandomSuffix(String baseUid, String alphabet, int letterCount) {
		return baseUid + "-" + generateRandomSuffix(alphabet, letterCount);
	}

	private static String generateRandomSuffix(String alphabet, int letterCount) {
		Random r = new Random();
		StringBuilder uid = new StringBuilder();
		for (int i = 0; i < letterCount; i++) {
			uid.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return uid.toString();
	}

}

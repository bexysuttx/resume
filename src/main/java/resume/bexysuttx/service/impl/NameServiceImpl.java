package resume.bexysuttx.service.impl;

import org.apache.commons.text.WordUtils;
import org.springframework.stereotype.Service;

import resume.bexysuttx.service.NameService;

@Service
public class NameServiceImpl implements NameService {

	@Override
	public String convertName(String name) {
		if (name.contains("-")) {
			String[] parts = name.split("-");
			return WordUtils.capitalize(parts[0]) + " " + WordUtils.capitalize(parts[1]);

		} else {
			return WordUtils.capitalize(name);
		}
	}

}

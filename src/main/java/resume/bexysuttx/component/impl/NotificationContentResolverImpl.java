package resume.bexysuttx.component.impl;

import java.io.IOException;
import java.io.StringReader;

import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import resume.bexysuttx.component.NotificationContentResolver;

@Component
public class NotificationContentResolverImpl implements NotificationContentResolver {

	@Override
	public String resolve(String stringTemplate, Object model) {
		try {
			Template template = new Template("", new StringReader(stringTemplate),
					new Configuration(Configuration.VERSION_2_3_0));
			return FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
		} catch (IOException | TemplateException e) {
			throw new IllegalArgumentException("Can't resolve string template: " + e.getMessage(), e);
		}
	}

}

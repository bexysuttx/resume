package resume.bexysuttx.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfig {

	@Autowired
	private ConfigurableEnvironment environment;

	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost(environment.getRequiredProperty("email.smtp.server"));
		if (environment.containsProperty("email.smtp.username")) {
			javaMailSenderImpl.setUsername(environment.getRequiredProperty("email.smtp.username"));
			javaMailSenderImpl.setPassword(environment.getRequiredProperty("email.smtp.password"));
			javaMailSenderImpl.setPort(Integer.parseInt(environment.getRequiredProperty("email.port")));
			javaMailSenderImpl.setDefaultEncoding("UTF-8");
			javaMailSenderImpl.setJavaMailProperties(javaMailProperties());
		}
		return javaMailSenderImpl;
	}

	private Properties javaMailProperties() {
		Properties p = new Properties();
		p.setProperty("mail.smtp.auth", "true");
		p.setProperty("mail.smtp.starttls.enable", "true");
		return p;
	}

}

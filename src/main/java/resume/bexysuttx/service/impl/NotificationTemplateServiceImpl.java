package resume.bexysuttx.service.impl;

import java.util.Collections;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.PathResource;
import org.springframework.stereotype.Service;

import resume.bexysuttx.component.NotificationContentResolver;
import resume.bexysuttx.exception.CantCompleteClientRequestException;
import resume.bexysuttx.model.NotificationMessage;

@Service
public class NotificationTemplateServiceImpl implements resume.bexysuttx.service.NotificationTemplateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationTemplateServiceImpl.class);
	private Map<String, NotificationMessage> notificationTemplate;

	@Value("${notification.config.path}")
	private String notificationConfigPath;

	@Autowired
	private NotificationContentResolver notificationContentResolver;

	@Override
	public NotificationMessage createNotificationMessage(String templateName, Object model) {
		NotificationMessage message = notificationTemplate.get(templateName);
		if (message == null) {
			throw new CantCompleteClientRequestException("Notification template " + templateName + "not found");
		}
		String resolveSubject = notificationContentResolver.resolve(message.getSubject(), model);
		String resolveContent = notificationContentResolver.resolve(message.getContent(), model);
		return new NotificationMessage(resolveSubject, resolveContent);
	}

	@PostConstruct 
	private void postConstruct() {
		notificationTemplate = Collections.unmodifiableMap(getNotificationTemplates());
		LOGGER.info("Loaded {} notification templates", notificationTemplate.size());
	}

	private Map<String, NotificationMessage> getNotificationTemplates() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
		reader.setValidating(false);
		reader.loadBeanDefinitions(new PathResource(notificationConfigPath));
		return beanFactory.getBeansOfType(NotificationMessage.class);
	}

}

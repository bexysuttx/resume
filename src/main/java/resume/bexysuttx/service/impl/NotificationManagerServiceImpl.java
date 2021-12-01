package resume.bexysuttx.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.model.NotificationMessage;
import resume.bexysuttx.service.NotificationManagerService;
import resume.bexysuttx.service.NotificationSenderService;
import resume.bexysuttx.service.NotificationTemplateService;

public class NotificationManagerServiceImpl implements NotificationManagerService {
	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationTemplateServiceImpl.class);

	@Autowired
	private NotificationSenderService notificationSenderService;

	@Autowired
	private NotificationTemplateService notificationTemplateService;

	@Override
	public void sendRestoreAccessLink(Profile profile, String restoreLink) {
		LOGGER.debug("Restore link: {} for account {}", restoreLink, profile.getUid());
		Map<String, Object> model = new HashMap<>();
		model.put("profile", profile);
		model.put("restoreLink", restoreLink);
		proccessNotification(profile, "restoreAccessNotification", model);

	}

	@Override
	public void sendPasswordChanged(Profile profile) {
		LOGGER.debug("Password changed for account {}", profile.getUid());
		Map<String, Object> model = new HashMap<>();
		model.put("profile", profile);
		proccessNotification(profile, "passwordChangedNotification", model);
	}

	private void proccessNotification(Profile profile, String string, Map<String, Object> model) {
		String destinationAddress = notificationSenderService.getDestinationAddress(profile);
		if (StringUtils.isNotBlank(destinationAddress)) {
			NotificationMessage notificationMessage = notificationTemplateService.createNotificationMessage(string,
					model);
			notificationMessage.setDestinationAddress(destinationAddress);
			notificationMessage.setDestinationName(profile.getFullName());
			notificationSenderService.sendNotification(notificationMessage);
		} else {
			LOGGER.error("Notification ignored: destinationAddress is empty for profile " + profile.getUid());
		}

	}

}

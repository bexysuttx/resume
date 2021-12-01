package resume.bexysuttx.service;

import resume.bexysuttx.model.NotificationMessage;

public interface NotificationTemplateService {

	NotificationMessage createNotificationMessage (String templateName, Object model);

}

package resume.bexysuttx.service;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.model.NotificationMessage;

public interface NotificationSenderService {
	
	void sendNotification(NotificationMessage notificationMessage);
	
	String getDestinationAddress(Profile profile);

}

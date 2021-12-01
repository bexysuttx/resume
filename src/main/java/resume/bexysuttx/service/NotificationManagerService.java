package resume.bexysuttx.service;

import resume.bexysuttx.entity.Profile;

public interface NotificationManagerService {

	void sendRestoreAccessLink(Profile profile, String restoreLink);

	void sendPasswordChanged(Profile profile);

}

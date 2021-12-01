package resume.bexysuttx.service.impl;

import java.util.concurrent.ExecutorService;

import javax.mail.internet.InternetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import resume.bexysuttx.entity.Profile;
import resume.bexysuttx.model.NotificationMessage;
import resume.bexysuttx.service.NotificationSenderService;

@Service
public class AsynsEmailNotificationSenderServiceImpl implements NotificationSenderService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AsynsEmailNotificationSenderServiceImpl.class);

	@Autowired
	private ExecutorService executorService;

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${email.sendTryCount }")
	private int tryCount;

	@Value("${email.fromEmail}")
	private String fromEmail;

	@Value("${email.fromName}")
	private String fromName;

	@Override
	public void sendNotification(NotificationMessage notificationMessage) {
		executorService.submit(new EmailItem(notificationMessage, tryCount));
	}

	@Override
	public String getDestinationAddress(Profile profile) {
		return profile.getEmail();
	}

	private class EmailItem implements Runnable {
		private final NotificationMessage message;
		private int tryCount;

		public EmailItem(NotificationMessage message, int trySendCount) {
			super();
			this.message = message;
			this.tryCount = trySendCount;
		}

		@Override
		public void run() {
			try {
				LOGGER.debug("Send a new email to {}", message.getDestinationAddress());
				MimeMessageHelper messageHelper = new MimeMessageHelper(javaMailSender.createMimeMessage(), false);
				messageHelper.setSubject(message.getSubject());
				messageHelper.setTo(new InternetAddress(message.getDestinationAddress(), message.getDestinationName()));
				messageHelper.setFrom(fromEmail, fromName);
				messageHelper.setText(message.getContent());
				MimeMailMessage mail = new MimeMailMessage(messageHelper);
				javaMailSender.send(mail.getMimeMessage());
				LOGGER.debug("Email to {} successful sent", message.getDestinationAddress());

			} catch (Exception e) {
				LOGGER.error("Can't send email to " + message.getDestinationAddress() + ": " + e.getMessage(), e);
				tryCount--;
				if (tryCount > 0) {
					LOGGER.debug("Decrement tryCount and try again to send email: tryCount={}, destinationEmail={}",
							tryCount, message.getDestinationAddress());
					executorService.submit(this);
				} else {
					LOGGER.error("Email not sent to " + message.getDestinationAddress());
				}

			}
		}

	}

}

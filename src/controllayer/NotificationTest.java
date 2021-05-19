package controllayer;

import java.awt.AWTException;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;

import doryan.windowsnotificationapi.fr.Notification;

public class NotificationTest {

	public static void main(String[] args) {
		try {
			Notification.sendNotification("sad :-( ", MessageType.ERROR);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}

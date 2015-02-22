package eu.hohenegger.winloger;

import java.util.Timer;
import java.util.TimerTask;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.HWND;

class Logger extends TimerTask {
	@Override
	public void run() {
		HWND activeWindow = User32x.INSTANCE.GetForegroundWindow();
		int processId = User32.INSTANCE.GetWindowThreadProcessId(activeWindow, null);

		char[] windowText = getForegroundWindow(activeWindow);
		System.out.println(windowText);
		System.out.println(processId);
	}

	private static char[] getForegroundWindow(HWND activeWindow) {
		int textLength = User32.INSTANCE.GetWindowTextLength(activeWindow) + 1;
		char[] windowText = new char[textLength];
		User32.INSTANCE.GetWindowText(activeWindow, windowText, textLength);
		return windowText;
	}
}

public class WinLogger {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new Logger(), 0, 5000);
	}
}
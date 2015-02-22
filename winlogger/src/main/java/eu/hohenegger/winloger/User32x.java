package eu.hohenegger.winloger;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.StdCallLibrary;

/**
 * Not yet in standard JNA.
 */
public interface User32x extends StdCallLibrary {
	static User32x INSTANCE = (User32x) Native.loadLibrary("user32.dll", User32x.class);

	HWND GetForegroundWindow();
}

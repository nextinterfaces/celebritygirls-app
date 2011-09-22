package next.celebs;

import java.util.logging.Logger;

// just one master logger. KISS
public class Log {

	static Logger log = Logger.getLogger("next");

	{
		// Logger.getLogger("").getHandlers()[0].
		// com.google.gwt.logging.Logging
	}

	public static void trace(String msg) {
		log.fine(msg);
	}

	public static void info(String msg) {
		log.info(msg);
	}

	public static void warn(String msg) {
		log.warning(msg);
	}

	public static void error(String msg) {
		log.severe(msg);
	}

	// public static void throwing(String sourceClass, String sourceMethod, Throwable failure) {
	// log.throwing(sourceClass, sourceMethod, failure);
	// }

}

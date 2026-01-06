package com.utility;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

public class LoggerUtility {// Singleton Design Pattern (Only 1 Object in Logger/DB connectivity)

	

	private LoggerUtility() {

	}

	public static Logger getLogger(Class<?> clazz) {
		Logger logger = null;
		if (logger == null) {
			logger = LogManager.getLogger(clazz);

		}
		return logger;

	}

}

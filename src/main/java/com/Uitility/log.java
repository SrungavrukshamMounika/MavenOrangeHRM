package com.Uitility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log 
{
	public static Logger log = Logger.getLogger("Log");

	public static void info(String message)
	{
	PropertyConfigurator.configure("Log4j.properties");
	log.info(message);
	}

}

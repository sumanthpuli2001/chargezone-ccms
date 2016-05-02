/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import org.apache.log4j.Logger;

/**
 *
 * @author Jayesh
 */
public class MySQLDBOperation {

	private static final Logger logger = Logger
			.getLogger(MySQLDBOperation.class);

	public static void main(String[] args) {
		MySQLDBOperation ref = new MySQLDBOperation();
		String dbName = "testdb";
		String dbUserName = "root";
		String dbPassword = "root";
		String path = "d:\\etender.sql";
		// ref.createDB();
		// ref.restoreDB(dbUserName, dbPassword, path);
		MySQLDBOperation.restoreDB(dbName, dbUserName, dbPassword, path);
	}

	public static boolean restoreDB(String dbName, String dbUserName,
			String dbPassword, String source) {

		MySQLDBOperation ref = new MySQLDBOperation();
		ref.createDB(dbName);

		String[] executeCmd = new String[] { "mysql", "--user=" + dbUserName,
				"--password=" + dbPassword, dbName, "-e", " source " + source };

		Process runtimeProcess;
		try {

			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				System.out.println("Backup restored successfully");
				return true;
			} else {
				System.out.println("Could not restore the backup");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean backupDB(String dbName, String dbUserName,
			String dbPassword, String host, String port, String path) {

		String executeCmd = "mysqldump -P " + port + " -h " + host + " -u "
				+ dbUserName + " -p" + dbPassword + " --add-drop-database -B "
				+ dbName + " -r " + path;
		logger.debug("path = " + executeCmd);
		Process runtimeProcess;
		try {

			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				logger.info("Backup created successfully");
				return true;
			} else {
				logger.error("Could not create the backup");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean backupDBWithout(String dbName, String dbUserName,
			String dbPassword, String host, String port, String path) {

		String executeCmd = "mysqldump -P " + port + " -h " + host + " -u "
				+ dbUserName + " -p" + dbPassword + " " + dbName + " -r "
				+ path;
		logger.debug("path = " + executeCmd);
		Process runtimeProcess;
		try {

			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				logger.info("Backup created successfully");
				return true;
			} else {
				logger.error("Could not create the backup");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean createDB(String DBName) {

		String executeCmd = "mysql -u root -proot -e \"create database "
				+ DBName + "\"";
		// logger.debug("path = " + executeCmd);
		Process runtimeProcess;
		try {

			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				System.out.println("Backup created successfully");
				return true;
			} else {
				System.out.println("Could not create the backup");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	public boolean restoreDB(String dbUserName, String dbPassword, String source) {

		String[] executeCmd = new String[] { "mysql", "--user=" + dbUserName,
				"--password=" + dbPassword, "-e", "source " + source };

		Process runtimeProcess;
		try {

			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();

			if (processComplete == 0) {
				System.out.println("Backup restored successfully");
				return true;
			} else {
				System.out.println("Could not restore the backup");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}
}

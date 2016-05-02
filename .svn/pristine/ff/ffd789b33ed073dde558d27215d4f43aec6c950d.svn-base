/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * 
 * @author Er. Jayesh Prajapati < Jayesh at www.bulwarks.com >
 */
public class DirDelRec {

	private static final Logger logger = Logger.getLogger(DirDelRec.class);

	public static void delete(File file) throws IOException {
		if (!file.exists()) {
			logger.trace("Directory does not exist.");
		} else {
			if (file.isDirectory()) {
				// directory is empty, then delete it
				if (file.list().length == 0) {
					file.delete();
					logger.trace("Directory is deleted : "
							+ file.getAbsolutePath());
				} else {
					// list all the directory contents
					String files[] = file.list();
					File fileDelete;
					for (String temp : files) {
						// construct the file structure
						fileDelete = new File(file, temp);
						// recursive delete
						delete(fileDelete);
					}
					// check the directory again, if empty then delete it
					if (file.list().length == 0) {
						file.delete();
						logger.trace("Directory is deleted : "
								+ file.getAbsolutePath());
					}
				}
			} else {
				// if file, then delete it
				file.delete();
				logger.trace("File is deleted : " + file.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		String SRC_FOLDER = "C:\\testing";
		// make sure directory exists
		try {
			delete(new File(SRC_FOLDER));
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.trace("Done");
	}
}

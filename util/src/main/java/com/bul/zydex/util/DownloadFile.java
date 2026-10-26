/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 
 * @author Jayesh
 */
public class DownloadFile {

	private static final Logger logger = Logger.getLogger(DownloadFile.class);

	public void doDownload(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int BUFFER_SIZE = 4096;
		String filePath = (String) request.getAttribute("filePath");

		// // get absolute path of the application
		ServletContext context = request.getServletContext();
		// String appPath = context.getRealPath("");
		//
		// // construct the complete absolute path of the file
		// String fullPath = appPath + filePath;
		// File downloadFile = new File(fullPath);

		String fullPath = filePath;
		File downloadFile = new File(fullPath);

		FileInputStream inputStream = new FileInputStream(downloadFile);
//		FileInputStream inputStream = new FileInputStream("\\StorageYard\\Other\\UserDoc\\EmployeeRegistration\\Employee.txt");

		// get MIME type of the file
		String mimeType = context.getMimeType(fullPath);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}

		// set content attributes for the response
		response.setContentType(mimeType);
		response.setContentLength((int) downloadFile.length());

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				downloadFile.getName());
		response.setHeader(headerKey, headerValue);

		// get output stream of the response
		OutputStream outStream = response.getOutputStream();

		byte[] buffer = new byte[BUFFER_SIZE];
		int bytesRead = -1;

		// write bytes read from the input stream into the output stream
		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outStream.close();
	}

	public void doDownload(HttpServletRequest request,
			HttpServletResponse response, ByteArrayOutputStream baos)
			throws IOException {

		logger.debug("Writing report to the stream");

		String fileName = (String) request.getAttribute("fileName");
		ServletContext context = request.getServletContext();

		// get MIME type of the file
		String mimeType = context.getMimeType(fileName);
		if (mimeType == null) {
			// set to binary type if MIME mapping not found
			mimeType = "application/octet-stream";
		}

		// set content attributes for the response
		response.setContentType(mimeType);

		// set headers for the response
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"",
				fileName);
		response.setHeader(headerKey, headerValue);

		// Retrieve the output stream
		ServletOutputStream outputStream = response.getOutputStream();
		// Write to the output stream
		baos.writeTo(outputStream);
		// Flush the stream
		outputStream.flush();
	}
}

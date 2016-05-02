/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bul.zydex.util;

import java.io.ByteArrayOutputStream;

import javax.servlet.http.HttpServletRequest;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXhtmlExporter;
import net.sf.jasperreports.engine.export.JRXlsAbstractExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.oasis.JROdsExporter;
import net.sf.jasperreports.engine.export.oasis.JROdtExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;

import org.apache.log4j.Logger;

/**
 * 
 * @author Jayesh
 */
public class Exporter {

	private static final Logger logger = Logger.getLogger(Exporter.class);

	public void csv(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRCsvExporter exporter = new JRCsvExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("CSV creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void docx(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRDocxExporter exporter = new JRDocxExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("DOCX creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void export(JasperPrint jp, ByteArrayOutputStream baos,
			HttpServletRequest request) throws JRException {

		String fileType = request.getParameter("fileType");
		String fileName = (String) request.getAttribute("fileName");

		if ("pdf".equals(fileType)) {
			new Exporter().pdf(jp, baos);
			fileName += ".pdf";
		} else if ("xml".equals(fileType)) {
			new Exporter().xml(jp, baos);
			fileName += ".xml";
		} else if ("html".equals(fileType)) {
			new Exporter().html(jp, baos);
			fileName += ".html";
		} else if ("rtf".equals(fileType)) {
			new Exporter().rtf(jp, baos);
			fileName += ".rtf";
		} else if ("xls".equals(fileType)) {
			new Exporter().xls(jp, baos);
			fileName += ".xls";
		} else if ("jxl".equals(fileType)) {
			new Exporter().jxl(jp, baos);
			fileName += ".jxl.xls";
		} else if ("csv".equals(fileType)) {
			new Exporter().csv(jp, baos);
			fileName += ".csv";
		} else if ("odt".equals(fileType)) {
			new Exporter().odt(jp, baos);
			fileName += ".odt";
		} else if ("ods".equals(fileType)) {
			new Exporter().ods(jp, baos);
			fileName += ".ods";
		} else if ("docx".equals(fileType)) {
			new Exporter().docx(jp, baos);
			fileName += ".docx";
		} else if ("xlsx".equals(fileType)) {
			new Exporter().xlsx(jp, baos);
			fileName += ".xlsx";
		} else if ("pptx".equals(fileType)) {
			new Exporter().pptx(jp, baos);
			fileName += ".pptx";
		} else if ("xhtml".equals(fileType)) {
			new Exporter().xhtml(jp, baos);
			fileName += ".x.html";
		}
		request.setAttribute("fileName", fileName);
	}

	public void html(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRHtmlExporter exporter = new JRHtmlExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
				false);
		exporter.setParameter(
				JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		exporter.setParameter(JRHtmlExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.TRUE);

		exporter.exportReport();

		System.err.println("HTML creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void jxl(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JExcelApiExporter exporter = new JExcelApiExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.setParameter(
				JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.TRUE);

		exporter.exportReport();

		System.err.println("XLS creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void ods(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JROdsExporter exporter = new JROdsExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.setParameter(
				JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.TRUE);

		exporter.exportReport();

		System.err.println("ODS creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void odt(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JROdtExporter exporter = new JROdtExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("ODT creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void pdf(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRPdfExporter exporter = new JRPdfExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("PDF creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void pptx(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRPptxExporter exporter = new JRPptxExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("PPTX creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void rtf(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRRtfExporter exporter = new JRRtfExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("RTF creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void xhtml(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {

		long start = System.currentTimeMillis();

		JRXhtmlExporter exporter = new JRXhtmlExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("XHTML creation time : "
				+ (System.currentTimeMillis() - start));

	}

	public void xls(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRXlsExporter exporter = new JRXlsExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.setParameter(
				JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);
		exporter.setParameter(
				JRXlsAbstractExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		exporter.setParameter(
				JRXlsAbstractExporterParameter.IS_WHITE_PAGE_BACKGROUND,
				Boolean.FALSE);

		exporter.exportReport();

		System.err.println("XLS creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void xlsx(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRXlsxExporter exporter = new JRXlsxExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.setParameter(
				JRXlsAbstractExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.FALSE);

		exporter.exportReport();

		System.err.println("XLSX creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void xml(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();

		JRXmlExporter exporter = new JRXmlExporter();

		// Here we assign the parameters jp and baos to the exporter
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);

		exporter.exportReport();

		System.err.println("XML creation time : "
				+ (System.currentTimeMillis() - start));
	}

	public void xmlEmbed(JasperPrint jp, ByteArrayOutputStream baos)
			throws JRException {
		long start = System.currentTimeMillis();
		System.err.println("XML creation time : "
				+ (System.currentTimeMillis() - start));
	}
}

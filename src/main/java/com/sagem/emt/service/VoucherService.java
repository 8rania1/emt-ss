package com.sagem.emt.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sagem.emt.dao.bo.Movement;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Service
public class VoucherService {

	public InputStream generate(List<Movement> movements) throws IOException, JRException {

		final JasperReport report = loadTemplate();
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(movements));
		byte[] pdfByteArray = JasperExportManager.exportReportToPdf(print);
		return new ByteArrayInputStream(pdfByteArray);
	}

	public void pdf(List<Movement> movements) throws JRException {
		final JasperReport report = loadTemplate();
		JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(movements));
		JasperExportManager.exportReportToPdfFile(print, "report.pdf");
	}

	private JasperReport loadTemplate() throws JRException {

		final InputStream reportInputStream = getClass().getResourceAsStream("/movements.jrxml");
		final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);
		return JasperCompileManager.compileReport(jasperDesign);
	}

	/*
	 * private Map<String, Object> parameters(VoucherData voucherData) { final
	 * Map<String, Object> parameters = new HashMap<>(); parameters.put("firstName",
	 * voucherData.getFirstName()); parameters.put("lastName",
	 * voucherData.getLastName()); parameters.put("email", voucherData.getEmail());
	 * parameters.put("voucherId", voucherData.getVoucherId());
	 * parameters.put("event", voucherData.getEvent()); parameters.put("date",
	 * voucherData.getDate()); return parameters; }
	 */

}

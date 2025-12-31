package br.com.thstec.hsts.relatorio.impl;

import br.com.thstec.hsts.relatorio.SprintReport;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import java.io.InputStream;

@Component
public class SprintReportImpl implements SprintReport {
    @Override
    public byte[] gerarPdf(Long id) throws Exception {

        // Carrega o .jasper já compilado
        InputStream jasperStream =
                new ClassPathResource("report/RelatorioSprint.jasper").getInputStream();

        JasperReport report =
                (JasperReport) JRLoader.loadObject(jasperStream);


        JasperPrint print =
                JasperFillManager.fillReport(
                        report,
                        null,
                        new JREmptyDataSource()
                );

        return JasperExportManager.exportReportToPdf(print);
    }
}

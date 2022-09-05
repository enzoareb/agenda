package presentacion.reportes;

import java.io.File;
import java.sql.Connection;
import org.apache.log4j.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import persistencia.conexion.Conexion;
public class ReporteDeporte {
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint reporteLleno;
	private Logger log = Logger.getLogger(ReporteDeporte.class);

	public ReporteDeporte() {
		try {
			Connection conexion = Conexion.getConexion().getSQLConexion();
			this.reporte = (JasperReport) JRLoader.loadObjectFromFile( "reportes" + File.separator + "ReporteDeporte2.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, null, conexion);
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, null, conexion);
			log.info("Se cargó correctamente el reporte");
		} catch (JRException ex) {
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
		}
	}

	public void mostrar() {
		this.reporteViewer = new JasperViewer(this.reporteLleno, false);
		this.reporteViewer.setVisible(true);
	}

}
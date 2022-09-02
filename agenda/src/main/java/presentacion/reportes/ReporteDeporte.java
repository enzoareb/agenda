package presentacion.reportes;

import java.io.File;
import java.sql.Connection;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;


import org.apache.log4j.Logger;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import persistencia.conexion.Conexion;
//import dto.PersonaDTO;
//import dto.PersonaDomicilioDTO;

public class ReporteDeporte
{
	private JasperReport reporte;
	private JasperViewer reporteViewer;
	private JasperPrint	reporteLleno;
	private Logger log = Logger.getLogger(ReporteDeporte.class);
	//Recibe la lista de personas para armar el reporte   File.separator
	

    public ReporteDeporte()
    {	

    try		
		{

		Connection conexion = Conexion.getConexion().getSQLConexion();
		//00JasperPrint jasperPrintWindow = JasperFillManager.fillReport("C:\\PROYECTO\\agenda\\agenda\\reportes\\ReporteDeporte.jasper", null,conexion);
		//00 JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
		//00 jasperViewer.setVisible(true);


			this.reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\PROYECTO\\agenda\\agenda\\reportes" + File.separator + "ReporteDeporte.jasper" );
			this.reporteLleno = JasperFillManager.fillReport(this.reporte, null, conexion);
    		log.info("Se cargó correctamente el reporte");


		}
		catch( JRException ex ) 
		{
			log.error("Ocurrió un error mientras se cargaba el archivo ReporteAgenda.Jasper", ex);
		}
    }       
    
    public void mostrar()
	{
		this.reporteViewer = new JasperViewer(this.reporteLleno,false);
		this.reporteViewer.setVisible(true);
	}
   
}	
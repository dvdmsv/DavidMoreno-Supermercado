package modelo;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import vista.login.Usuario;
import vista.login.VentanaLogin;
/**
 * Clase que contiene la plantilla para generar el ticket
 * @author David
 *
 */
public class PlantillaPDF {
	/**
	 * ArrayList con el nombre de producto
	 */
	private ArrayList<String> nombreProd;
	/**
	 * ArrayList con la cantidad de producto
	 */
	private ArrayList<String> cantidadProd;
	/**
	 * ArrayList con el precio de producto
	 */
	private ArrayList<String> precioProd;
	/**
	 * ArrayList con el IVA de producto
	 */
	private ArrayList<String> ivaProd;
	/**
	 * ArrayList con el precio total de producto
	 */
	private ArrayList<String> precTotalProd;
	/**
	 * Precio total de todos los productos
	 */
	private String total;
	/**
	 * Documento a generar
	 */
	Document documento;
	/**
	 * Generar un archivo
	 */
	FileOutputStream archivo;
	/**
	 * Titulo del PDF
	 */
	Paragraph titulo;
	/**
	 * Constructor de PlantillaPDF
	 * @param nombreProd ArrayList con el nombre de producto
	 * @param cantidadProd ArrayList con la cantidad de producto
	 * @param precioProd ArrayList con el precio de producto
	 * @param ivaProd ArrayList con el IVA de producto
	 * @param precTotalProd ArrayList con el precio total de producto
	 * @param total Precio total de todos los productos
	 */
	public PlantillaPDF(ArrayList<String> nombreProd, ArrayList<String> cantidadProd, ArrayList<String> precioProd, ArrayList<String> ivaProd, ArrayList<String> precTotalProd, String total) {
		this.nombreProd = nombreProd;
		this.cantidadProd = cantidadProd;
		this.precioProd = precioProd;
		this.ivaProd = ivaProd;
		this.precTotalProd = precTotalProd;
		this.total = total;
		
		documento = new Document();
		titulo = new Paragraph("Ticket de compra GALDI", FontFactory.getFont(FontFactory.COURIER, 20));
	}
	/**
	 * Metodo par crear la plantilla y generar el pdf
	 */
	public void crearPlantilla() {
		try {
			LocalDateTime fecha = LocalDateTime.now();
			DateTimeFormatter formatFecha = DateTimeFormatter.ofPattern("EEE, d MMM yyyy HH:mm:ss");
			DateTimeFormatter formatFecha2 = DateTimeFormatter.ofPattern("MM-dd-yyyy HH.mm.ss");
			archivo = new FileOutputStream("Ticket-" + fecha.format(formatFecha2) + ".pdf");
			PdfWriter.getInstance(documento, archivo);
			documento.open();
			titulo.setAlignment(1);
			
			documento.add(titulo);
			documento.add(new Paragraph("------------------------------------------------------------------------", FontFactory.getFont(FontFactory.COURIER, 12)));
			documento.add(Chunk.NEWLINE);
			
			for(int i=0; i<nombreProd.size(); i++) { //Bucle para los productos
				documento.add(new Paragraph("Producto: " + nombreProd.get(i), FontFactory.getFont(FontFactory.COURIER, 12)));
				documento.add(new Paragraph("Cantidad: " + cantidadProd.get(i), FontFactory.getFont(FontFactory.COURIER, 12)));
				documento.add(new Paragraph("Precio: " + precioProd.get(i), FontFactory.getFont(FontFactory.COURIER, 12)));
				documento.add(new Paragraph("IVA: " + ivaProd.get(i), FontFactory.getFont(FontFactory.COURIER, 12)));
				documento.add(new Paragraph("Total del producto: " + precTotalProd.get(i) + "€", FontFactory.getFont(FontFactory.COURIER, 12)));
				documento.add(Chunk.NEWLINE);
			}
			
			documento.add(Chunk.NEWLINE);
			documento.add(new Paragraph("" + total));
			documento.add(new Paragraph("Fecha de compra: " + fecha.format(formatFecha), FontFactory.getFont(FontFactory.COURIER, 12)));
			documento.add(new Paragraph("Vendedor: "+ Usuario.getUsuarioLogueado(), FontFactory.getFont(FontFactory.COURIER, 12)));
			

			documento.close();
		}catch(Exception e) {
			
		}
	}
}

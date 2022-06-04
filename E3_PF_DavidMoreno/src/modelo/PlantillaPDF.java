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

public class PlantillaPDF {
	private ArrayList<String> nombreProd;
	private ArrayList<String> cantidadProd;
	private ArrayList<String> precioProd;
	private ArrayList<String> ivaProd;
	private ArrayList<String> precTotalProd;
	private String total;
	private VentanaLogin vL;
	
	Document documento;
	FileOutputStream archivo;
	Paragraph titulo;
	
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

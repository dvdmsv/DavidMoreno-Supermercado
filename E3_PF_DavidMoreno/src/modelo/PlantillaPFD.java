package modelo;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Image;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PlantillaPFD {
	private ArrayList<String> nombreProd;
	private ArrayList<String> cantidadProd;
	private ArrayList<String> precioProd;
	private ArrayList<String> ivaProd;
	private ArrayList<String> precTotalProd;
	private String total;
	
	Document documento;
	FileOutputStream archivo;
	Paragraph titulo;
	
	public PlantillaPFD(ArrayList<String> nombreProd, ArrayList<String> cantidadProd, ArrayList<String> precioProd, ArrayList<String> ivaProd, ArrayList<String> precTotalProd, String total) {
		this.nombreProd = nombreProd;
		this.cantidadProd = cantidadProd;
		this.precioProd = precioProd;
		this.ivaProd = ivaProd;
		this.precTotalProd = precTotalProd;
		this.total = total;
		
		documento = new Document();
		titulo = new Paragraph("Ticket de compra GALDI");
	}
	
	public void crearPlantilla() {
		try {
			archivo = new FileOutputStream("Ticket-" +LocalDate.now() + ".pdf");
			PdfWriter.getInstance(documento, archivo);
			documento.open();
			titulo.setAlignment(1);
			
			documento.add(titulo);
			
			for(int i=0; i<nombreProd.size(); i++) { //Bucle para los productos
				documento.add(new Paragraph("Producto: " + nombreProd.get(i)));
				documento.add(new Paragraph("Cantidad: " + cantidadProd.get(i)));
				documento.add(new Paragraph("Precio: " + precioProd.get(i)));
				documento.add(new Paragraph("IVA: " + ivaProd.get(i)));
				documento.add(new Paragraph("Total del producto: " + precTotalProd.get(i)));
				documento.add(Chunk.NEWLINE);
			}
			
			documento.add(Chunk.NEWLINE);
			documento.add(new Paragraph("" + total));
			
			
			
			/*Paragraph texto = new Paragraph("Hola mu wenas que tal");
			documento.add(texto);*/
			
			documento.close();
		}catch(Exception e) {
			
		}
	}

}

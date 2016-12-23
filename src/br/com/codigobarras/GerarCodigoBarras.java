package br.com.codigobarras;

import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class GerarCodigoBarras {
	
	public static void main(String args[]){
		 
		 System.out.println("Barcode Linha de C�digo ");
		 
		// criando um objeto da classe Document
		 
		 Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		 
		 try {
		 
		 //Aqui come�amos a utilizar as classes do iText: o documento
		 
		 //criado acima ser�
		 
		//direcionado para um arquivo PDF.
		 
		 PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\workspace\\CodigBarras.pdf"));
		 
		//abrindo o documento.
		 
		document.open();
		 
		//adicionando um novo paragrafo.
		 
		document.add(new Paragraph("C�DIGOS DE BARRA"));
		 
		 document.add(new Paragraph(" "));
		 
		 document.add(new Paragraph(" "));
		 
		 //Comecando a configurar o cod de barras
		 
		PdfContentByte cb = writer.getDirectContent();
		 
		BarcodeEAN codeEAN = new BarcodeEAN();
		 
		 //O iText suporta os principais tipos de c�digo de barra, como Barcode39,
		 
		//  Barcode128 (128, 128_UCC, 128_RAW),  BarcodeEAN (EAN13, EAN8, UPCA, UPCE), EANSUP, etc
		 
		codeEAN.setCodeType(codeEAN.EAN13);
		 
		codeEAN.setCode("9780201615883");
		 
		Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
		 
		document.add(new Phrase(new Chunk(imageEAN, 0, 0)));
		 
		}
		 
		catch (Exception de)
		 
		{            de.printStackTrace();
		 
		 }        document.close();
		 
		 }  }



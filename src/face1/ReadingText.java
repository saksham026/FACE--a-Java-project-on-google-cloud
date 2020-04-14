package face1;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import it.grabz.grabzit.GrabzItClient;
public class ReadingText {

   public static void main(String args[]) throws IOException {
	   
	   GrabzItClient grabzIt = new GrabzItClient("ZTAyMjVjZjI0YWVlNDgzNmJjYzZjZjI0MGU5NmM3MGI=", "V1NzPz9LfD8/dT8/T3ZkPz8/HDY/Ri4mED8nPyw/P0A=");
	   grabzIt.URLToPDF("https://www.astroyogi.com/kundli/result.aspx?Kund_Name=rishabh%20&Kund_Dateofbirth=24/12/1997&Kund_BirthTime=12:35:00%20PM&Kund_Longitude=77.3144&Kund_Latitude=28.7486&Kund_Timezone=5.5"); 
	   try {
		grabzIt.SaveTo("C:/Users/HP/Desktop/result.pdf");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	      

      //Loading an existing document
      File file = new File("C:/Users/HP/Desktop/result.pdf");
      PDDocument document = PDDocument.load(file);

      //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();

      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
      String[] arr = text.split("\n");
      //System.out.println(text);
      
      for(int i=68;i<=83;i++)
    	  System.out.println(arr[i]);
      
      for(int i=46;i<=61;i++)
          System.out.println(arr[i]);
          
      
   
      //Closing the document
      document.close();

   }
}
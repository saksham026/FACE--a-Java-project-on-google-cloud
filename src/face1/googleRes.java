package face1;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class googleRes {

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException,IOException{
		// TODO Auto-generated method stub
		
		WebClient w=new WebClient(BrowserVersion.CHROME);
		w.getOptions().setJavaScriptEnabled(true);
		HtmlPage h=w.getPage("https://www.astroyogi.com/kundli/result.aspx?Kund_Name=rishabh%20&Kund_Dateofbirth=24/12/1997&Kund_BirthTime=12:35:00%20PM&Kund_Longitude=77.3144&Kund_Latitude=28.7486&Kund_Timezone=5.5");
		String p=h.asText();
		System.out.println(p);

	}

}

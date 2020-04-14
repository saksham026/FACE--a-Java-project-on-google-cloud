package face1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.auth.AuthMethod;
import com.nexmo.client.auth.TokenAuthMethod;
import com.nexmo.client.sms.SmsSubmissionResult;
import com.nexmo.client.sms.messages.TextMessage;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.DataOutputStream;
import java.io.File;
import java.net.HttpURLConnection;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@SuppressWarnings("unused")
public class Methods {
	
public static String suggestPassword() //this code returns the  unique 8 DIGIT PASSWORD 
	{
	    long code   =(long)((Math.random()*9*Math.pow(10,15))+Math.pow(10,15)); 
	    String unique_password="";
	    for (long i=code;i!=0;i/=100)//a loop extracting 2 digits from the code  
	    { 
	        long digit=i%100;//extracting two digits 
	        if (digit<=90) 
	        digit=digit+32;  
	        //converting those two digits(ascii value) to its character value 
	        char ch=(char) digit; 
	        // adding 32 so that our least value be a valid character  
	        unique_password=ch+unique_password;//adding the character to the string 
	    }
		return unique_password;
	}

	static char[] OTP(int len) 
    { 
  
        // Using numeric values 
        String numbers = "0123456789"; 
  
        // Using random method 
        Random rndm_method = new Random(); 
  
        char[] otp = new char[len]; 
  
        for (int i = 0; i < len; i++) 
        { 
            
            otp[i] = 
             numbers.charAt(rndm_method.nextInt(numbers.length())); 
        } 
        return otp; 
    }
	
	public int send_otp(String em_ph,String medium)
	{
		char[] otp1=OTP(6);
		String otp=new String(otp1);
		
		
		if(medium.equals("mail"))
		{
		final String user="hitman26445sharma@gmail.com";//change accordingly  for sending user
		final String pass="rohit@264";  //change accordingly for sending password
   
		Properties props = new Properties();    
		props.put("mail.smtp.host", "smtp.gmail.com");    
		props.put("mail.smtp.socketFactory.port", "465");    
		props.put("mail.smtp.socketFactory.class",    
		          "javax.net.ssl.SSLSocketFactory");    
		props.put("mail.smtp.auth", "true");    
		props.put("mail.smtp.port", "465");    
		  
		
		Session session = Session.getDefaultInstance(props,  
		 new javax.mail.Authenticator() {  
		  protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication(user,pass);  
		   }  
		});  

		
		try {  
		 MimeMessage message = new MimeMessage(session);  
		 message.setFrom(new InternetAddress(user));  
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress(em_ph));  
		 message.setSubject("otp for FACE");  
		 message.setText(otp);  
		   
		 //3rd step)send message  
		 Transport.send(message);  
		  
		 return Integer.parseInt(otp);  
		  
		}
		catch (Exception e)
		{  
		    throw new RuntimeException(e);
		}  
		}
		else if(medium.equals("phone"))
		{

			/*AuthMethod auth = new TokenAuthMethod("94bedf9e", "dPlSVEstmKHJ5Bcf");
			NexmoClient client = new NexmoClient(auth);
			
					String messageText = otp;
					System.out.print(otp);
					TextMessage message = new TextMessage("918057971750", "917447424746",messageText);

					SmsSubmissionResult[] response = null;
					
					try {
						response = client.getSmsClient().submitMessage(message);
					} catch (IOException | NexmoClientException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					for (SmsSubmissionResult response1 : response) {
					    System.out.println(response1);
					}*/
			
			 String url = "https://www.sms4india.com";
			    /**
			     * @param senderId 
			     * @param token
			     */
			 
			try{
	            // construct data
	          JSONObject urlParameters = new JSONObject();
	          urlParameters.put("apikey", "GFYFIKL6RDTQH2XUAQUKIYVTZLMEFXPX");
	          urlParameters.put("secret","BO55LQBJWQYNAN7Z");
	          urlParameters.put("usetype","stage");
	          urlParameters.put("senderid", "8057971750");
	          URL obj = new URL(url + "/api/v1/createSenderId");
	            // send data
	          HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
	          httpConnection.setDoOutput(true);
	          httpConnection.setRequestMethod("POST");
	          httpConnection.setRequestProperty("Content-Type", "application/json");
	          DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
	          wr.write(urlParameters.toString().getBytes());
	          // get the response
	          BufferedReader bufferedReader = null;
	          if (httpConnection.getResponseCode() == 200) {
	              bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
	          } else {
	              bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
	          }
	          StringBuilder content = new StringBuilder();
	          String line;
	          while ((line = bufferedReader.readLine()) != null) {
	              content.append(line).append("\n");
	          }
	          bufferedReader.close();
	          //return content.toString();
	    	}catch(Exception ex){
	    		System.out.println("Exception at createSenderId():"+ex);
	            //return "{'status':500,'message':'Internal Server Error'}";
	    	}
			
		}
		return Integer.parseInt(otp);
	
	}
	
	public int verify_otp(int gen_otp,String rec_otp)
	{
		int re_otp=Integer.parseInt(rec_otp);
		if(re_otp==gen_otp)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public void signup_email(String f1, String f2,Connection con)
	{
		String createUser =
			    "INSERT INTO basic_profile (private_email_id,password) VALUES (?,?)";
		
		try {
			PreparedStatement p = con.prepareStatement(createUser);
			p.setString(1, f1);
			p.setString(2, f2);
			
			p.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int verify_login_credentials(String f1, String f2, String medium,Connection con)
	{
		if(medium.equals("otp"))
		{
		int otp=send_otp(f1, "phone");
		return verify_otp(otp, "rec_otp");	//change string accordingly
		
		/*int otp2=send_otp(f1, "email");
		return verify_otp(otp2, "rec_otp");	//change string accordingly
		 */		
		}
		
		if(medium.equals("email"))
		{
			String verUserId = "SELECT private_email_id,password FROM basic_profile";
			String id=null;
			String pass=null;
			
			
			try {
				ResultSet rs = con.prepareStatement(verUserId).executeQuery();
				
				while (rs.next()) {
				      id=rs.getString(1);
				      pass=rs.getString(2);
				      
				    }
				
				if(id.equals(f1)&&pass.equals(f2))
				{
					return 1;
				}
				
				return 0;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(medium.equals("signin"))
		{
		//code for google signin button directly
			//add this in any servlet doget() method
			//req and res are by default variable in servlets so error will be removed
			
		/*	UserService userService = UserServiceFactory.getUserService();
		    if (userService.isUserLoggedIn()) {
		      // Save the relevant profile info and store it in the session.
		      User user = userService.getCurrentUser();
		      req.getSession().setAttribute("userEmail", user.getEmail());
		      req.getSession().setAttribute("userId", user.getUserId());

		      String destination = (String) req.getSession().getAttribute("loginDestination");
		      if (destination == null) {
		        destination = "/fo.jsp";
		      }

		      resp.sendRedirect(destination);
		    } else {
		      resp.sendRedirect(userService.createLoginURL("/login"));
		    }*/
		}
		
		return 0;
	}
	
	//we will have both eid(it is for all opeartion to be performed) and user_id(it is only for user to be seen and retrieve)
	public String check_user_id(Connection con,String entered_id)
	{
	
		String getUserId = "SELECT user_id FROM basic_profile where user_id='"+entered_id+"'";
		int flag=0;
		
		try {
			ResultSet rs = con.prepareStatement(getUserId).executeQuery();
			
			while (rs.next()) {
			      flag=1;
			    }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag==0)
		{	
		return entered_id;
		}
		else
		{
			return "id have already been taken";
		}
	}
	
	public int id_generator(Connection con)
	{
		String getUserId = "SELECT max(e_id) FROM basic_profile";
		int id=0;
		
		try {
			ResultSet rs = con.prepareStatement(getUserId).executeQuery();
			
			while (rs.next()) {
			      id=rs.getInt(1);
			      
			    }
			id+=1;
			
			return id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public void add_to_db(String f_name,String l_name, int whatsapp,String gender, Connection con)	//parameters
	{
		
		String createUser =
			    "INSERT INTO basic_profile (e_id, first_name,last_name, private_whatsapp_number,gender) VALUES (?,?,?,?,?)";
		
		try {
			PreparedStatement p = con.prepareStatement(createUser);
			
			p.setInt(1, id_generator(con));
			p.setString(2, f_name);
			p.setString(3, l_name);
			p.setInt(4, whatsapp);
			p.setString(5, gender);
			
			p.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int decide_type_entity(ArrayList<String> list,Connection con)	//parameters also require list of values
	{
		//add id to aaray lsit first
		 Iterator<String> iter = list.iterator();

		String createUser =
			    "INSERT INTO type_of_profile (";
			    
		 try {
		
		while (iter.hasNext()) { 
			createUser+=iter.next();
			if(iter.hasNext())
			{
				createUser+=",";
			}
        }
		
		
		createUser+=") values (";
		
		for(int k=0;k<list.size();k++)
		{
			createUser+="?";
			if(k<list.size()-1)
			{
				createUser+=",";
			}
		}
		
		createUser+=")";
		
		PreparedStatement p = con.prepareStatement(createUser);
		int i=2;
		
		p.setInt(1,1);
		for(int k=1;k<list.size();k++)
		{
			p.setString(k+1,"YES");
		}
		
		p.executeUpdate();
		con.close();
		
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return 0;
	}
	
	public int edit_type_entity(ArrayList<String> list,ArrayList<String> val,int id,Connection con)	//parameters (this is jsp related) and require list of values 
	{
		Iterator<String> iter = list.iterator();
		Iterator<String> iter2 = val.iterator();
		
		String createUser =
			    "update table type_of_profile set";
			    
		 try {
			PreparedStatement p = con.prepareStatement(createUser);
		
		while (iter.hasNext()) { 
			
			createUser+=iter.next()+"= '"+iter2.next()+"'";
			if(iter2.hasNext())
			{
				createUser+=", ";
			}
			
        }
		
		createUser+=" where e_id="+id;
		p.executeUpdate();
		con.close();
		
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return 0;
	}

	public int update_service_table(ArrayList<String> list,ArrayList<String> val,int id,Connection con)
	{
		
		Iterator<String> iter = list.iterator();
		Iterator<String> iter2 = val.iterator();
			
		String createPseudoUser =
			    "insert into services (e_id) values (?)";
			   
		 try {
			PreparedStatement p = con.prepareStatement(createPseudoUser);
			p.setInt(1, id);
			p.executeUpdate();
			
		 }
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		String createUser =
			    "update services set ";
			    
		 try {
			PreparedStatement p = con.prepareStatement(createUser);
		
		while (iter.hasNext()) { 
			
			createUser+=iter.next()+"='yes'";
			if(iter.hasNext())
			{
				createUser+=", ";
			}
			
        }
		
		createUser+=" where e_id="+id+";";
		System.out.println(createUser);
		p.executeUpdate();
		con.close();
		
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return 0;
		
	}
	
	public  ArrayList<String> get_opted_services(int id,Connection con)
	{
		
		    ArrayList<String> numbers = new ArrayList<String>();
		    String selectService="select * from services where e_id="+id;
		    ResultSet rs;
			try {
				rs = con.prepareStatement(selectService).executeQuery();
				 
				while (rs.next()) {
				        
					if(rs.getString(1).equals("yes"))
					{
						numbers.add("investment");
					}
					if(rs.getString(2).equals("yes"))
					{
						numbers.add("collaboration");
					}
					if(rs.getString(3).equals("yes"))
					{
						numbers.add("worker_as_an_artist");
					}
					
			      }
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		   
		    
		    return(numbers);
		
	}
	
	//please try this code once with html although it is tried before seperately
	//limiting posts to 10 only as it is some_posts
	
	//**********check for exceptions if column for image is empty
	public  LinkedHashMap<Integer, byte[]> recommend_some_post(int id,String service,Connection con)
	{
		
		LinkedHashMap<Integer, byte[]> posts = new LinkedHashMap<Integer, byte[]>();
		try
			{
				  //Database is name of class in model package 
				Statement stmt=con.createStatement();
				String str="select";// where username ='"+user+"'";
				
				if(service.equals("investment"))
				{
					str+=" project_investment_post_detail_image from project_post";
				}
				if(service.equals("collaboration"))
				{
					str+=" project_collaboration_post_detail_image from project_post";
				}
				if(service.equals("worker_as_an_artist"))
				{
					str+=" project_worker_post_offline_detail_image,project_worker_post_online_detail_image from project_post";
				}
				
				
				str+=" sort by date_added desc";
				ResultSet rs=stmt.executeQuery(str);
				String len1="";
				String len2="";
				int no_of_posts=10;
				
				
				//add line 552 or set of lines in block commnet in jsp's to retrieve image
				
				rs=stmt.executeQuery(str);
				if(service.equals("investment"))
				{
				while(rs.next())
				{
					if(no_of_posts==0)
					{
						break;
					}
					len1=rs.getString(1);    
					int size=len1.length();
					byte[] b=new byte[size];
					InputStream is=rs.getBinaryStream(1);
					int rlen=is.read(b,0,size);
					posts.put(rlen, b);
					no_of_posts--;
					/*response.reset();
					response.getOutputStream().write(b,0,rlen);
					response.getOutputStream().flush();
					response.getOutputStream().close();*/
				}
				}
				
				if(service.equals("collaboration"))
				{
				while(rs.next())
				{
					if(no_of_posts==0)
					{
						break;
					}
					len1=rs.getString(1);  
					int size=len1.length();
					byte[] b=new byte[size];
					InputStream is=rs.getBinaryStream(1);
					int rlen=is.read(b,0,size);
					posts.put(rlen, b);
					no_of_posts--;
					/*response.reset();
					response.getOutputStream().write(b,0,rlen);
					response.getOutputStream().flush();
					response.getOutputStream().close();*/
				}
				}
				
				if(service.equals("worker_as_an_artist"))
				{
				while(rs.next())
				{
					if(no_of_posts==0)
					{
						break;
					}
					len1=rs.getString(1);
					len1=rs.getString(2);
					int size=len1.length();
					byte[] b=new byte[size];
					
					int size2=len2.length();
					byte[] b2=new byte[size2];
					
					InputStream is=rs.getBinaryStream(1);
					int rlen=is.read(b,0,size);
					
					InputStream is2=rs.getBinaryStream(2);
					int rlen2=is.read(b2,0,size2);
					
					
					posts.put(rlen, b);
					posts.put(rlen2, b2);
					no_of_posts--;
					
					/*response.reset();
					response.getOutputStream().write(b,0,rlen);
					response.getOutputStream().flush();
					response.getOutputStream().close();*/
				}
				}

				
			}catch(Exception e)
			{
				
			}
		    
		   
		    return posts;
		
	}
	
	public  ArrayList<Integer> recommend_some_post_id(int id,String service,Connection con)
	{
		
		 ArrayList<Integer> ids = new ArrayList<Integer>();
		try
			{
				  //Database is name of class in model package 
				Statement stmt=con.createStatement();
				String str="select project_post_id,";// where username ='"+user+"'";
				
				if(service.equals("investment"))
				{
					str+=" project_investment_post_detail_image from project_post";
				}
				if(service.equals("collaboration"))
				{
					str+=" project_collaboration_post_detail_image from project_post";
				}
				if(service.equals("worker_as_an_artist"))
				{
					str+=" project_worker_post_offline_detail_image,project_worker_post_online_detail_image from project_post";
				}
				
				str+=" sort by date_added desc";
				ResultSet rs=stmt.executeQuery(str);
				int no_of_posts=10;
				
				//add line 552 or set of lines in block commnet in jsp's to retrieve image
				
				rs=stmt.executeQuery(str);
				if(service.equals("investment"))
				{
				while(rs.next())
				{
					if(no_of_posts==0)
					{
						break;
					}
					
					ids.add(rs.getInt(1));
					no_of_posts--;
					/*response.reset();
					response.getOutputStream().write(b,0,rlen);
					response.getOutputStream().flush();
					response.getOutputStream().close();*/
				}
				}
				
				if(service.equals("collaboration"))
				{
				while(rs.next())
				{
					if(no_of_posts==0)
					{
						break;
					}
					
					ids.add(rs.getInt(1));
					no_of_posts--;
					/*response.reset();
					response.getOutputStream().write(b,0,rlen);
					response.getOutputStream().flush();
					response.getOutputStream().close();*/
				}
				}
				
				if(service.equals("worker_as_an_artist"))
				{
				while(rs.next())
				{
					if(no_of_posts==0)
					{
						break;
					}
					
					ids.add(rs.getInt(1));
					no_of_posts--;
					/*response.reset();
					response.getOutputStream().write(b,0,rlen);
					response.getOutputStream().flush();
					response.getOutputStream().close();*/
				}
				}

				
			}catch(Exception e)
			{
				
			}
		    
		   
		    return ids;
		
	}
	
	int give_followers(String id) throws IOException{  
		
		String url="http://trialdemo.appspot.com/"+id;
        Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(0).get();  
        Elements inputElements = doc.getElementsByTag("body"); 
        
        String key=null;
        for (Element inputElement : inputElements) { 
        	
            key = inputElement.text();
            //System.out.println("Param name: "+key); 
            
            
        }  
        String[] words=key.split(" ");
        String[] follow=words[1].split(":");
        return Integer.parseInt(follow[1]);
	} 
	
	int give_likes(String id) throws IOException{  
		String url="http://trialdemo.appspot.com/"+id;
        Document doc = Jsoup.connect(url).ignoreContentType(true).timeout(0).get();  
        Elements inputElements = doc.getElementsByTag("body");  
        
        String key=null;
        for (Element inputElement : inputElements) { 
        	
        	key = inputElement.text();
            //System.out.println("Param name: "+key); 
            
            
        }   
        String[] words=key.split(" ");

        String[] like=words[0].split(":");
        return Integer.parseInt(like[1]);
 
	} 
	
	//this will give id of those who will be recommended
	public  Object[] id_for_find_a_face(int e_id,String profile_type_to_search_in,Connection con)
	{
		
		//step 1
		//retreiving all unique eid from a structure
		
		String str="select distinct(e_id) from artist_project_selected_response"
				+ " union select distinct(e_id) from collaboration_project_selected_response"
				+ " union select distinct(e_id) from investment_project_selected_response";
		
		ArrayList<Integer> unique_ids = new ArrayList<Integer>();
		try {
		
			Statement stmt=con.createStatement();
		
			ResultSet rs;
		
			rs = stmt.executeQuery(str);

			rs=stmt.executeQuery(str);
		
			while(rs.next())
			{
				if(rs.getInt(1)!=e_id)
				unique_ids.add(rs.getInt(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//step2
		//for every other e_id other than user find list of entity_id
		LinkedHashMap<Integer, ArrayList<Integer>> entity_ids_for_e_ids = new LinkedHashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> list_of_entity_particular_id = new ArrayList<Integer>();
		
		for(int i=0;i<unique_ids.size();i++)
		{
			
			String str1="select distinct(e_id) from artist_project_selected_response where e_id="+unique_ids.get(i)+" entity_id in (select e_id from scoreboard where type_of_profile="+profile_type_to_search_in+")"
					+ " union select distinct(e_id) from collaboration_project_selected_response where e_id="+unique_ids.get(i)+" entity_id in (select e_id from scoreboard where type_of_profile="+profile_type_to_search_in+")"
					+ " union select distinct(e_id) from investment_project_selected_response where e_id="+unique_ids.get(i)+" entity_id in (select e_id from scoreboard where type_of_profile="+profile_type_to_search_in+")";
			try {
			
				Statement stmt=con.createStatement();
			
				ResultSet rs;
			
				rs = stmt.executeQuery(str);

				rs=stmt.executeQuery(str);
			
				while(rs.next())
				{
					list_of_entity_particular_id.add(rs.getInt(1));
				}
				
				entity_ids_for_e_ids.put(i, list_of_entity_particular_id);
				
				list_of_entity_particular_id.clear();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//step3
		//get list of entity id for current users for whihc recommendation is to be given
		ArrayList<Integer> list_of_my_entity_id = new ArrayList<Integer>();
		
		
		String str1="select distinct(e_id) from artist_project_selected_response where e_id="+e_id+" entity_id in (select e_id from scoreboard where type_of_profile="+profile_type_to_search_in+")"
				+ " union select distinct(e_id) from collaboration_project_selected_response where e_id="+e_id+" entity_id in (select e_id from scoreboard where type_of_profile="+profile_type_to_search_in+")"
				+ " union select distinct(e_id) from investment_project_selected_response where e_id="+e_id+" entity_id in (select e_id from scoreboard where type_of_profile="+profile_type_to_search_in+")";
			try {
			
			Statement stmt=con.createStatement();
			
			ResultSet rs;
			
			rs = stmt.executeQuery(str);

			rs=stmt.executeQuery(str);
			
			while(rs.next())
			{
				list_of_my_entity_id.add(rs.getInt(1));
			}
				
			} 
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		
		//step4
		//now we have 3 things as list of unique ids, map of entity_ids for other users with their respective e_ids, and list of my_entity ids
		//now we have to calculate dot product for user similarity i.e common entity_ids between the 2 users
		ArrayList<Integer> similar_user_list_of_entity_id = new ArrayList<Integer>();
		LinkedHashMap<Integer, Integer> similar_entity_ids_for_e_ids = new LinkedHashMap<Integer, Integer>();
		
		for(int i=0;i<unique_ids.size();i++)
		{
			
		int similarity_score=0;	
		ArrayList<Integer> list_of_entityid = entity_ids_for_e_ids.get(i);
		
		ArrayList<Integer> list3 = new ArrayList<Integer>(list_of_my_entity_id); 

		list3.retainAll(list_of_entityid);

		//find unique elements in the list
		HashSet<Integer> hSetNumbers = new HashSet<Integer>(list3);
        
        
        //iterate through HashSet
        for(int strNumber : hSetNumbers)
        {
        	similar_user_list_of_entity_id.add(strNumber);
        }
		
        similarity_score=similar_user_list_of_entity_id.size();
        similar_entity_ids_for_e_ids.put(i,similarity_score);
        similar_user_list_of_entity_id.clear();
		}
		
		//step5
		//finding top similar users by sorting them on basis of similarity_score
		Comparator<Entry<Integer, Integer>> valueComparator = new Comparator<Entry<Integer,Integer>>() {
            
            @Override
            public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
                int v1 = e1.getValue();
                int v2 = e2.getValue();
                return v1-v2;
            }
        };
        
        Set<Entry<Integer, Integer>> entries = similar_entity_ids_for_e_ids.entrySet();
        
        List<Entry<Integer, Integer>> listOfEntries = new ArrayList<Entry<Integer, Integer>>(entries);
        
        // sorting HashMap by values using comparator
        Collections.sort(listOfEntries, valueComparator);
        
        LinkedHashMap<Integer, Integer> sorted_similar_entity_ids_for_e_ids = new LinkedHashMap<Integer, Integer>(listOfEntries.size());
        
        // copying entries from List to Map
        for(Entry<Integer, Integer> entry : listOfEntries){
        	sorted_similar_entity_ids_for_e_ids.put(entry.getKey(), entry.getValue());
        }
        
        //step6
        //now we have sorted mapping of similiarity score and e_id and will use it to recommend lists
        //and if greater than recommend_threshold put in a array list
        
        
        int similar_no_of_users_threshold=10;
        int recommend_criteria_threshold=5;
        
        ArrayList<Integer> recommended_entity_ids_old = new ArrayList<Integer>();
        ArrayList<Integer> recommended_entity_ids_new = new ArrayList<Integer>();
        
        //putting my already visted ids
        for(int i=0;i<list_of_my_entity_id.size();i++)
        {
        	recommended_entity_ids_old.add(list_of_my_entity_id.get(i));
        }

        Set<Entry<Integer, Integer>> entrySetSortedByValue = sorted_similar_entity_ids_for_e_ids.entrySet();
        
        for(Entry<Integer, Integer> mapping : entrySetSortedByValue){
        	
           if(similar_no_of_users_threshold<0)
           {
        	   break;
           }
           else
           {
        	   if(mapping.getValue()>recommend_criteria_threshold)
        	   {
        		   for(int i=0;i<entity_ids_for_e_ids.get(mapping.getKey()).size();i++)
        		   {
        			   recommended_entity_ids_new.add(entity_ids_for_e_ids.get(mapping.getKey()).get(i));
        		   }
        		   similar_no_of_users_threshold--;
        	   }
           }
        }
        
        //step7 check size of new recommendations if it is less than 20 then sort by score of entity and add it to recommended_enityt_id_new
        ArrayList<Integer> recommended_entity_ids_score = new ArrayList<Integer>();
        
        if(recommended_entity_ids_new.size()>=20)
        {
        	//do nothing
        }
        else
        {
        	int more_to_add=20-recommended_entity_ids_new.size();
        	String score_sorted_entity="select distinct(e_id) from scoreboard where type_of_profile="+profile_type_to_search_in +" sort by score desc";
			try {
			
				Statement stmt=con.createStatement();
			
				ResultSet rs;
			
				rs = stmt.executeQuery(score_sorted_entity);
			
				while(rs.next())
				{
					if(more_to_add<=0)
					{
						break;
					}
					else
					{	
						if(!(recommended_entity_ids_old.contains(rs.getInt(1))||recommended_entity_ids_new.contains(rs.getInt(1))))
						{
							recommended_entity_ids_score.add(rs.getInt(1));
							more_to_add--;
						}
					}
					
				}
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        //step8 create a combine list and add it to object
        //at front end marker of new and old can be shown
        Object total_recommendation[]= {recommended_entity_ids_old,recommended_entity_ids_new,recommended_entity_ids_score};
		return total_recommendation;

		
	}
	
	//in query please consider whether input is string or not
	public  ArrayList<Integer> filter_for_find_a_face_basic_and_body_profile(int e_id,String profile_type_to_search_in, ArrayList<String> filter,ArrayList<Object> value,String sort_by,Connection con)
	{
		
		PreparedStatement pst;
		String str="";
		if(sort_by.equals("null"))
		{
			sort_by="score";
		}
		
		if(sort_by.equals("score"))
		{
		str+="select e_id from scoreboard where type_of_profile="+profile_type_to_search_in+" and e_id in ( select e_id from basic_profile,body_attributes_profile where";
		
		for(int i=0;i<filter.size();i++)
		{
			if(filter.get(i).equalsIgnoreCase("gender"))
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+"= ?";
				}
				else
				{
					str+=" "+filter.get(i)+"= ? and ";
				}
			}
			
			
			else if(filter.get(i).equalsIgnoreCase("dob"))
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+" between ? and ? ";
				}
				else
				{
					str+=" "+filter.get(i)+" between ? and ? and ";
				}
			}
			
			//here construct array list as name of parameter(filter) and then followed by number of items in the filter values like location followed by 4(if 4 locationsa re specified)
			else if(filter.get(i).equalsIgnoreCase("home_town")||filter.get(i).equalsIgnoreCase("current_location")||filter.get(i).equalsIgnoreCase("indian_nationality")||filter.get(i).equalsIgnoreCase("foreigner_nationality"))
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+" in (";
				}
				else
				{
					str+=" "+filter.get(i)+" in ( ";
				}
				i++;
				
				for(int j=0;j<Integer.parseInt(filter.get(i));j++)
				{
					
					if(j==Integer.parseInt(filter.get(i))-1)
					{
						str+="? )";
					}
					else
					{
						str+="?, ";
					}
				}
				
				
			}
			
			else if(filter.get(i).equalsIgnoreCase("height")||filter.get(i).equalsIgnoreCase("weight")||filter.get(i).equalsIgnoreCase("hips")||filter.get(i).equalsIgnoreCase("waist")||filter.get(i).equalsIgnoreCase("shoulders")||filter.get(i).equalsIgnoreCase("chest_or_bust"))
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+" between ? and ? ";
				}
				else
				{
					str+=" "+filter.get(i)+" between ? and ? and ";
				}
			}
			
			else
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+"= ?";
				}
				else
				{
					str+=" "+filter.get(i)+"= ? and ";
				}
			}
			
			
			
		
			
		}
		
		str+=" ) sort by score";
		}
		
		
		ArrayList<Integer> e_ids = new ArrayList<Integer>();
		try {
		
			pst=con.prepareStatement(str);  
			for(int i=0;i<value.size();i++)
			{
				
				if(value.get(i).getClass().getName().equalsIgnoreCase("java.lang.Date"))
				{
					Date date1 = null;
					try {
						
						//********try as date is coverted to string first
						date1 = (Date) new  SimpleDateFormat("dd/MM/yyyy").parse((String)value.get(i));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pst.setDate(i+1, date1);
				}
				else if(value.get(i).getClass().getName().equalsIgnoreCase("java.lang.Integer"))
				{
					pst.setInt(i+1, (Integer)(value.get(i)));
				
				}
				else
				{
				pst.setString(i+1, (String)value.get(i));
				}
			
			}
			 
			ResultSet rs;
			rs=pst.executeQuery();
			
		
			while(rs.next())
			{
				if(rs.getInt(1)!=e_id)
					e_ids.add(rs.getInt(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e_ids;
	
	}
	
	public  ArrayList<Integer> filter_for_find_project_post(int e_id,String profile_type_to_search_in, ArrayList<String> filter,ArrayList<Object> value,String sort_by,Connection con)
	{
		
		PreparedStatement pst;
		String str="";
		
		str+="select e_id from project_post where";
		
		for(int i=0;i<filter.size();i++)
		{
	
			//here construct array list as name of parameter(filter) and then followed by number of items in the filter values like location followed by 4(if 4 locationsa re specified)
			if(filter.get(i).equalsIgnoreCase("Language_of_project")||filter.get(i).equalsIgnoreCase("shoot_location")||filter.get(i).equalsIgnoreCase("type_of_post"))
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+" in (";
				}
				else
				{
					str+=" "+filter.get(i)+" in ( ";
				}
				i++;
				
				for(int j=0;j<Integer.parseInt(filter.get(i));j++)
				{
					
					if(j==Integer.parseInt(filter.get(i))-1)
					{
						str+="? )";
					}
					else
					{
						str+="?, ";
					}
				}
				
				
			}
			
			else
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+"= ?";
				}
				else
				{
					str+=" "+filter.get(i)+"= ? and ";
				}
			}
			
		}
		
		str+="sort by e_id";
		
		ArrayList<Integer> e_ids = new ArrayList<Integer>();
		try {
		
			pst=con.prepareStatement(str);  
			for(int i=0;i<value.size();i++)
			{
				
				if(value.get(i).getClass().getName().equalsIgnoreCase("java.lang.Date"))
				{
					Date date1 = null;
					try {
						date1 = (Date) new  SimpleDateFormat("dd/MM/yyyy").parse((String)value.get(i));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pst.setDate(i+1, date1);
				}
				else if(value.get(i).getClass().getName().equalsIgnoreCase("java.lang.Integer"))
				{
					pst.setInt(i+1, (Integer)(value.get(i)));
				
				}
				else
				{
				pst.setString(i+1, (String)value.get(i));
				}
			
			}
			 
			ResultSet rs;
			rs=pst.executeQuery();
		
			while(rs.next())
			{
				if(rs.getInt(1)!=e_id)
					e_ids.add(rs.getInt(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e_ids;
	}
	
	public  ArrayList<Integer> filter_for_find_promotional_post(int e_id,String profile_type_to_search_in, ArrayList<String> filter,ArrayList<Object> value,String sort_by,Connection con)
	{
		
		PreparedStatement pst;
		String str="";
		
		str+="select e_id from promotional_post where";
		
		for(int i=0;i<filter.size();i++)
		{
	
			//here construct array list as name of parameter(filter) and then followed by number of items in the filter values like location followed by 4(if 4 locationsa re specified)
			if(filter.get(i).equalsIgnoreCase("class_venue_city")||filter.get(i).equalsIgnoreCase("type_of_post"))
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+" in (";
				}
				else
				{
					str+=" "+filter.get(i)+" in ( ";
				}
				i++;
				
				for(int j=0;j<Integer.parseInt(filter.get(i));j++)
				{
					
					if(j==Integer.parseInt(filter.get(i))-1)
					{
						str+="? )";
					}
					else
					{
						str+="?, ";
					}
				}
				
				
			}
			
			else if(filter.get(i).equalsIgnoreCase("class_time"))
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+" between ? and ? ";
				}
				else
				{
					str+=" "+filter.get(i)+" between ? and ? and ";
				}
			}
			
			else
			{
				if(i==filter.size()-1)
				{
					str+=" "+filter.get(i)+"= ?";
				}
				else
				{
					str+=" "+filter.get(i)+"= ? and ";
				}
			}
			
		}
		
		str+="sort by e_id";
		
		ArrayList<Integer> e_ids = new ArrayList<Integer>();
		try {
		
			pst=con.prepareStatement(str);  
			for(int i=0;i<value.size();i++)
			{
				
				if(value.get(i).getClass().getName().equalsIgnoreCase("java.lang.Date"))
				{
					Date date1 = null;
					try {
						date1 = (Date) new  SimpleDateFormat("dd/MM/yyyy").parse((String)value.get(i));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					pst.setDate(i+1, date1);
				}
				else if(value.get(i).getClass().getName().equalsIgnoreCase("java.lang.Integer"))
				{
					pst.setInt(i+1, (Integer)(value.get(i)));
				
				}
				else
				{
				pst.setString(i+1, (String)value.get(i));
				}
			
			}
			 
			ResultSet rs;
			rs=pst.executeQuery();
		
			while(rs.next())
			{
				if(rs.getInt(1)!=e_id)
					e_ids.add(rs.getInt(1));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return e_ids;
	}
	
	public  ArrayList<Integer> total_filter_for_find_a_face(int e_id,String profile_type_to_search_in, ArrayList<String> filter,ArrayList<Object> value,String sort_by,Connection con)
	{
		//call methods in below 2 line accordingly
        ArrayList<Integer> list1 = new ArrayList<Integer>();

        ArrayList<Integer> list2 = new ArrayList<Integer>(); 
  
        ArrayList<Integer> list3 = new ArrayList<Integer>(list1); 
  
        list3.retainAll(list2); 

        return list3;
		
	}
	
	public ResultSet display_face_basic_profile_by_id(int e_id,Connection con)
	{
		String str="select first_name,last_name,,personal_profile_photo from basic_profile where e_id="+e_id;
		
		ArrayList<Integer> unique_ids = new ArrayList<Integer>();

		ResultSet rs = null;
	
		try {
		
			Statement stmt=con.createStatement();
		
			rs = stmt.executeQuery(str);

			rs=stmt.executeQuery(str);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;		
		
	}
	
	public int display_face_score_by_id(int e_id,Connection con)
	{
		
		String str="select score from scoreboard where e_id="+e_id;
		
		ArrayList<Integer> unique_ids = new ArrayList<Integer>();

		ResultSet rs = null;
		int score=0;
		
		try {
		
			Statement stmt=con.createStatement();
		
			rs = stmt.executeQuery(str);

			rs=stmt.executeQuery(str);
			
			while(rs.next())
			{
				score=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return score;

	}
	
	public void make_snapshot_investment(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
	{

        BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);// Represents an image with 8-bit RGBA color components packed into integer pixels.
        Graphics2D graphics2d = image.createGraphics();
        
        Font font = new Font("TimesNewRoman", Font.BOLD, 12);
        graphics2d.setFont(font);
        FontMetrics fontmetrics = graphics2d.getFontMetrics();
        
        //int width = fontmetrics.stringWidth(text);
        //int height = fontmetrics.getHeight();
        graphics2d.dispose();
 
        //change this image location with reference to project later
        File fi = new File("Desktop/f2.jpg");
        BufferedImage image1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        
        try {
			image1 = ImageIO.read(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int width_background=image1.getWidth();
        int height_background=image1.getHeight();
        
        
        image = new BufferedImage(width_background, height_background, BufferedImage.TYPE_INT_ARGB);
        
        graphics2d = image.createGraphics();
        graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2d.setFont(font);
        fontmetrics = graphics2d.getFontMetrics();
        
        
		graphics2d.drawImage(image1, 0,0, null);
		
		font = new Font("TimesNewRoman", Font.BOLD, 12);
        graphics2d.setFont(font);
        
        for(int i=0;i<details.size();i++)
        {
        	graphics2d.setColor(Color.BLUE);
        	graphics2d.drawString(labels.get(i)+" : ", 0, (15+10*i));	
        	int width = fontmetrics.stringWidth(labels.get(i));
        	graphics2d.setColor(Color.GREEN);
        	graphics2d.drawString(details.get(i), width, (15+10*i));
        
        	graphics2d.dispose();
        }
        
        /*try {
            ImageIO.write(image, "png", new File("e:/Sample11.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
        
        try {
        String str="update project_post set project_investment_post_detail_iamge=? where e_id=?";
		PreparedStatement ps=con.prepareStatement(str);
		ps.setBlob(1, (Blob) image);
		ps.setInt(2, e_id);
		
		
		boolean b=ps.execute();
		
		ps.close();
        }
        catch(Exception e)
        {
        	
        }
        
	}
	
	
	//this is seperate function if any change in layout
	public void make_snapshot_collaboration(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
	{
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);// Represents an image with 8-bit RGBA color components packed into integer pixels.
        Graphics2D graphics2d = image.createGraphics();
        
        Font font = new Font("TimesNewRoman", Font.BOLD, 12);
        graphics2d.setFont(font);
        FontMetrics fontmetrics = graphics2d.getFontMetrics();
        
        //int width = fontmetrics.stringWidth(text);
        //int height = fontmetrics.getHeight();
        graphics2d.dispose();
 
        //change this image location with reference to project later
        File fi = new File("Desktop/f2.jpg");
        BufferedImage image1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        
        try {
			image1 = ImageIO.read(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int width_background=image1.getWidth();
        int height_background=image1.getHeight();
        
        
        image = new BufferedImage(width_background, height_background, BufferedImage.TYPE_INT_ARGB);
        
        graphics2d = image.createGraphics();
        graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2d.setFont(font);
        fontmetrics = graphics2d.getFontMetrics();
        
        
		graphics2d.drawImage(image1, 0,0, null);
		
		font = new Font("TimesNewRoman", Font.BOLD, 12);
        graphics2d.setFont(font);
        
        for(int i=0;i<details.size();i++)
        {
        	graphics2d.setColor(Color.BLUE);
        	graphics2d.drawString(labels.get(i)+" : ", 0, (15+10*i));	
        	int width = fontmetrics.stringWidth(labels.get(i));
        	graphics2d.setColor(Color.GREEN);
        	graphics2d.drawString(details.get(i), width, (15+10*i));
        
        	graphics2d.dispose();
        }
        
        /*try {
            ImageIO.write(image, "png", new File("e:/Sample11.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
        
        try {
        String str="update project_post set project_collaboration_post_detail_iamge=? where e_id=?";
		PreparedStatement ps=con.prepareStatement(str);
		ps.setBlob(1, (Blob) image);
		ps.setInt(2, e_id);
		
		
		boolean b=ps.execute();
		
		ps.close();
        }
        catch(Exception e)
        {
        	
        }
		
	}
	
	//this is seperate function if any change in layout
	public void make_snapshot_worker(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
	{
		
		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);// Represents an image with 8-bit RGBA color components packed into integer pixels.
        Graphics2D graphics2d = image.createGraphics();
        
        Font font = new Font("TimesNewRoman", Font.BOLD, 12);
        graphics2d.setFont(font);
        FontMetrics fontmetrics = graphics2d.getFontMetrics();
        
        //int width = fontmetrics.stringWidth(text);
        //int height = fontmetrics.getHeight();
        graphics2d.dispose();
 
        //change this image location with reference to project later
        File fi = new File("Desktop/f2.jpg");
        BufferedImage image1 = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        
        try {
			image1 = ImageIO.read(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int width_background=image1.getWidth();
        int height_background=image1.getHeight();
        
        
        image = new BufferedImage(width_background, height_background, BufferedImage.TYPE_INT_ARGB);
        
        graphics2d = image.createGraphics();
        graphics2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        graphics2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        graphics2d.setFont(font);
        fontmetrics = graphics2d.getFontMetrics();
        
        
		graphics2d.drawImage(image1, 0,0, null);
		
		font = new Font("TimesNewRoman", Font.BOLD, 12);
        graphics2d.setFont(font);
        
        for(int i=0;i<details.size();i++)
        {
        	graphics2d.setColor(Color.BLUE);
        	graphics2d.drawString(labels.get(i)+" : ", 0, (15+10*i));	
        	int width = fontmetrics.stringWidth(labels.get(i));
        	graphics2d.setColor(Color.GREEN);
        	graphics2d.drawString(details.get(i), width, (15+10*i));
        
        	graphics2d.dispose();
        }
        
        /*try {
            ImageIO.write(image, "png", new File("e:/Sample11.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
        
        try {
        String str="update project_post set project_worker_post_online_detail_iamge=? where e_id=?";
		PreparedStatement ps=con.prepareStatement(str);
		ps.setBlob(1, (Blob) image);
		ps.setInt(2, e_id);
		
		
		boolean b=ps.execute();
		
		ps.close();
        }
        catch(Exception e)
        {
        	
        }
	}
	
	public BufferedInputStream share_downlaod(Connection con)
	{
		Blob show_office_profile_image=null;
		BufferedInputStream is=null;
		try {
			
			ResultSet rs; 
			PreparedStatement pst;
			
			String str="select photo from register";// where username ='"+user+"'";
			pst=con.prepareStatement(str);
			rs=pst.executeQuery();
			
			
			while(rs.next())  
			{
			
				show_office_profile_image = rs.getBlob(1);
					 
			}
			is = new BufferedInputStream(show_office_profile_image.getBinaryStream());
			
			}
		catch(Exception e)
		{
			
		}
		return is;
	}
	

	public int project_post_id_generator(Connection con)
	{
		String getUserId = "SELECT max(e_id) FROM project_post";
		int id=0;
		
		try {
			ResultSet rs = con.prepareStatement(getUserId).executeQuery();
			
			while (rs.next()) {
			      id=rs.getInt(1);
			      id+=1;
					
					return id;
			    }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 1;
	}
	
	
	public int promotional_post_id_generator(Connection con)
	{
		String getUserId = "SELECT max(e_id) FROM promotional_post";
		int id=0;
		
		try {
			ResultSet rs = con.prepareStatement(getUserId).executeQuery();
			
			while (rs.next()) {
			      id=rs.getInt(1);
			      
			    }
			id+=1;
			
			return id;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}
	
	public ArrayList<Integer> search_results(String type_of_search,String characterstic,Connection con)
	{
		ArrayList<Integer> result=new ArrayList<Integer>();
		ResultSet rs;
		PreparedStatement pst;
		
		if(type_of_search.equals("body_attributes"))
		{
			
			String col_name="SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name = 'body_attributes_profile'"; 
			ArrayList<String> specified_column_name = new ArrayList<String>();
			
			try {
				
				pst=con.prepareStatement(col_name);
				rs=pst.executeQuery();
				while(rs.next())  
				{
					if(rs.next())
					specified_column_name.add(rs.getString(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String s="select eid from body_attributes_profile where ";
			for(int i=1;i<specified_column_name.size();i++)
			{
				s+=" "+specified_column_name.get(i)+" like ";
				if(specified_column_name.get(i).equalsIgnoreCase("eid")||specified_column_name.get(i).equalsIgnoreCase("height")||specified_column_name.get(i).equalsIgnoreCase("weight")||specified_column_name.get(i).equalsIgnoreCase("hips")||specified_column_name.get(i).equalsIgnoreCase("waist")||specified_column_name.get(i).equalsIgnoreCase("shoulders")||specified_column_name.get(i).equalsIgnoreCase("chest_or_bust"))
				{
					s+=Integer.parseInt(characterstic);
				}
				else
				{
					s+="'"+characterstic+"'";
				}
				
				if(i<specified_column_name.size()-1)
				{
					s+=" or ";
				}
			}
			
			try {
				
				pst=con.prepareStatement(s);
				rs=pst.executeQuery();
				while(rs.next())  
				{

					result.add(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else if(type_of_search.equals("entity"))
		{
			String col_name="SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name = 'basic_profile'"; 
			ArrayList<String> specified_column_name = new ArrayList<String>();
			
			try {
				
				pst=con.prepareStatement(col_name);
				rs=pst.executeQuery();
				while(rs.next())  
				{
					specified_column_name.add(rs.getString(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String s="select eid from basic_profile where ";
			for(int i=0;i<specified_column_name.size()-3;i++)
			{
				s+=" "+specified_column_name.get(i)+" like ";
				if(specified_column_name.get(i).equalsIgnoreCase("eid")||specified_column_name.get(i).equalsIgnoreCase("public_whatsapp_number")||specified_column_name.get(i).equalsIgnoreCase("private_whatsapp_number")||specified_column_name.get(i).equalsIgnoreCase("public_calling_number")||specified_column_name.get(i).equalsIgnoreCase("private_calling_number"))
				{
					s+=Integer.parseInt(characterstic);
				}
				else if(specified_column_name.get(i).equalsIgnoreCase("dob"))
				{
					
				}
				else
				{
					s+="'"+characterstic+"'";
				}
				
				if(i<specified_column_name.size()-1)
				{
					s+=" or ";
				}
			}
			
			try {
				
				pst=con.prepareStatement(s);
				rs=pst.executeQuery();
				while(rs.next())  
				{

					result.add(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(type_of_search.equals("project_post"))
		{
			String col_name="SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name = 'project_post'"; 
			ArrayList<String> specified_column_name = new ArrayList<String>();
			
			try {
				
				pst=con.prepareStatement(col_name);
				rs=pst.executeQuery();
				while(rs.next())  
				{
					specified_column_name.add(rs.getString(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String s="select project_post_id from project_post where ";
			for(int i=1;i<specified_column_name.size()-5;i++)
			{
				s+=" "+specified_column_name.get(i)+" like ";
				if(specified_column_name.get(i).equalsIgnoreCase("project_post_id")||specified_column_name.get(i).equalsIgnoreCase("budget_min_value")||specified_column_name.get(i).equalsIgnoreCase("budget_max_value")||specified_column_name.get(i).equalsIgnoreCase("public_calling_number")||specified_column_name.get(i).equalsIgnoreCase("male_number")||specified_column_name.get(i).equalsIgnoreCase("female_number")||specified_column_name.get(i).equalsIgnoreCase("transgender_number")||specified_column_name.get(i).equalsIgnoreCase("other_number_gender"))
				{
					s+=Integer.parseInt(characterstic);
				}
				else if(specified_column_name.get(i).equalsIgnoreCase("height_min")||specified_column_name.get(i).equalsIgnoreCase("weight_min")||specified_column_name.get(i).equalsIgnoreCase("hips_min")||specified_column_name.get(i).equalsIgnoreCase("waist_min")||specified_column_name.get(i).equalsIgnoreCase("shoulders_min")||specified_column_name.get(i).equalsIgnoreCase("chest_or_bust_min"))
				{
					s+=Integer.parseInt(characterstic);
				}
				else if(specified_column_name.get(i).equalsIgnoreCase("height_max")||specified_column_name.get(i).equalsIgnoreCase("weight_max")||specified_column_name.get(i).equalsIgnoreCase("hips_max")||specified_column_name.get(i).equalsIgnoreCase("waist_max")||specified_column_name.get(i).equalsIgnoreCase("shoulders_max")||specified_column_name.get(i).equalsIgnoreCase("chest_or_bust_max"))
				{
					s+=Integer.parseInt(characterstic);
				}
				else if(specified_column_name.get(i).equalsIgnoreCase("shoot_start_date")||specified_column_name.get(i).equalsIgnoreCase("shoot_end_date")||specified_column_name.get(i).equalsIgnoreCase("shoot_time")||specified_column_name.get(i).equalsIgnoreCase("online_audition_script"))
				{
					
				}
				else if(specified_column_name.get(i).equalsIgnoreCase("online_audition_end_date")||specified_column_name.get(i).equalsIgnoreCase("online_audition_end_time")||specified_column_name.get(i).equalsIgnoreCase("offline_audition_start_date")||specified_column_name.get(i).equalsIgnoreCase("offline_audition_end_date")||specified_column_name.get(i).equalsIgnoreCase("offline_audition_start_time")||specified_column_name.get(i).equalsIgnoreCase("offline_audition_end_time"))
				{
					
				}
				else
				{
					s+="'"+characterstic+"'";
				}
				
				if(i<specified_column_name.size()-1)
				{
					s+=" or ";
				}
			}
			
			try {
				
				pst=con.prepareStatement(s);
				rs=pst.executeQuery();
				while(rs.next())  
				{

					result.add(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(type_of_search.equals("prmotional_post"))
		{
			
			String col_name="SELECT COLUMN_NAME FROM information_schema.columns WHERE table_name = 'prmotional_post'"; 
			ArrayList<String> specified_column_name = new ArrayList<String>();
			
			try {
				
				pst=con.prepareStatement(col_name);
				rs=pst.executeQuery();
				while(rs.next())  
				{
					specified_column_name.add(rs.getString(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String s="select promotional_post_id from promotional_post where ";
			for(int i=1;i<specified_column_name.size()-4;i++)
			{
				s+=" "+specified_column_name.get(i)+" like ";
				if(specified_column_name.get(i).equalsIgnoreCase("promotional_post_id")||specified_column_name.get(i).equalsIgnoreCase("class_venue_floor_number")||specified_column_name.get(i).equalsIgnoreCase("class_venue_plot_or_building_number")||specified_column_name.get(i).equalsIgnoreCase("class_venue_pincode")||specified_column_name.get(i).equalsIgnoreCase("event_venue_plot_or_building_number")||specified_column_name.get(i).equalsIgnoreCase("event_venue_floor_number")||specified_column_name.get(i).equalsIgnoreCase("event_venue_pincode"))
				{
					s+=Integer.parseInt(characterstic);
				}
				else if(specified_column_name.get(i).equalsIgnoreCase("shoot_start_date")||specified_column_name.get(i).equalsIgnoreCase("shoot_end_date")||specified_column_name.get(i).equalsIgnoreCase("shoot_time")||specified_column_name.get(i).equalsIgnoreCase("online_audition_script"))
				{
					
				}
				else if(specified_column_name.get(i).equalsIgnoreCase("class_time")||specified_column_name.get(i).equalsIgnoreCase("class_date")||specified_column_name.get(i).equalsIgnoreCase("class_promotional_photo")||specified_column_name.get(i).equalsIgnoreCase("class_promotional_video")||specified_column_name.get(i).equalsIgnoreCase("event_time")||specified_column_name.get(i).equalsIgnoreCase("event_date"))
				{
					
				}
				else
				{
					s+="'"+characterstic+"'";
				}
				
				if(i<specified_column_name.size()-1)
				{
					s+=" or ";
				}
			}
			
			try {
				
				pst=con.prepareStatement(s);
				rs=pst.executeQuery();
				while(rs.next())  
				{

					result.add(rs.getInt(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}
	
	public void fill_type_of_enity_or_project(Connection con,ArrayList<String> col_names,ArrayList<String> values,String table_name)
	{
		String filltable =
			    "update table_name set";
		
		//table must have balnk rows with their id filled
		for(int i=0;i<col_names.size();i++)
		{
			filltable+=" "+join_underscore(col_names.get(i))+" = "+values.get(i);
		}
		
		try {
			PreparedStatement p = con.prepareStatement(filltable);
			
			p.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String join_underscore(String raw)
	{
        String[] arrOfStr = raw.split(" "); 
        String joined="";
        
        for (String a : arrOfStr) 
        {
        	joined+=a;
        }
        
		return joined;
		
	}
	
	public void sub_fun_for_inserting_yes_and_others(Connection con, int user_id, String Table,String default_options[],ArrayList<String> chosen_options,ArrayList<String> options_value)
	{
		ResultSet rs; 
		PreparedStatement pst;
		
		//first set all to 'NO' only
		
		String set_no="update "+Table+" set ";
		
		for(int i=0;i<default_options.length;i++)
		{
			if(i==default_options.length-1)
			{
				set_no+= default_options[i]+  "='No'";
					
			}
			else
				set_no+= default_options[i]+  "='No',";
			
			
		}
		
		set_no+=" where e_id=?";
		try
		{
			pst=con.prepareStatement(set_no);
			
			pst.setInt(1,user_id);
			
			pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//here change only selected options
		String edit_profile="update "+Table+" set ";
		
		for(int i=0;i<chosen_options.size();i++)
		{
			if(i==chosen_options.size()-1)
			{
				edit_profile+= chosen_options.get(i)+  "='"+options_value.get(i)+"'";
					
			}
			else
				edit_profile+= chosen_options.get(i)+  "='"+options_value.get(i)+"',";
			
			
		}
		
		edit_profile+=" where eid=?";
		try
		{
			pst=con.prepareStatement(edit_profile);
			
			pst.setInt(1,user_id);
			
			pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void for_calling_inserting_yes_function()
	{
		String acting_role_type[]= {"e_id ",  "lead_actor "," lead_support "," supporting_actor "," junior_artist "," cameo "," other "};
		
		
		String modelling_types[]= {"e_id ","  fashion "," runaway "," swimsuit "," lingerie "," commercial "," fitness ","print "," glamour ","promotional "," hand_parts "," arm_parts "," feet_parts "," legs_parts ","other_parts "," other_modelling" };
		
		String dance_types[]={"e_id ","  bollywood "," ballet "," break_dance ","belly "," tango "," salsa "," bhangra "," classical "," tap "," jazz "," lyrical "," hip_hop "," contempory "," arial "," bolly_hop_fusion "," urban_bhangra_fusion "," other_fusion "," other "};
		
		String instrument_types[]={"e_id ","  keyboard "," piano "," accoustic_guitar "," electric_guitar "," other_guitar "," drums "," violin "," saxophone "," flulte "," celio "," clarinet "," other "};
		
		String music_types[]={"e_id ","  musical_theatre "," jazz "," rock "," classical "," hip_hop "," fusion "," pop "," bollywood "," religious "," electronic "," disco "," other "};
		
		
		String comedy_types[]={"e_id ","  observation  "," anecdotal "," situational  "," character_type  "," one_liner  "," ironic  "," deadpan "," slapstick "," self_deprecating "," farcical "," other  "};
	
		String investment_services_for_which_project[]={"e_id ","  feature_film "," short_film "," web_series "," tv_series "," documentary_series "," movie_commercial "," tv_commercial "," web_commercial "," music_album_or_video "," theatre_or_musical_or_stage_shows "," stand_up_comedy_event "," fashion_or_style_or_beauty_event "," lifestyle_event "," food_event "," fitness_event "," health_event "," travel_event "," gaming_or_tech_event "," cultural_or_social_event "," wedding_event "," party_event "," magazine_photoshoot_event "," billboard_photoshoot_event "," campaign_photoshoot_event "," booklets_photoshoot_event "," flyers_photoshoot_event "," posters_photoshoot_event "," other_photoshoot_event "," glitz_modelling_event "," semi_glitz_modelling_event "," natural_modelling_event "," other_modelling_event "," acting_competition_event "," dance_competition_event "," music_competition_event "," other_competition_event "," other_event "};
	
		String collaboration_services_for_which_project[]={"e_id ","  feature_film "," short_film "," web_series "," tv_series "," documentary_series "," movie_commercial "," tv_commercial "," web_commercial "," music_album_or_video "," theatre_or_musical_or_stage_shows "," stand_up_comedy_event "," fashion_or_style_or_beauty_event "," lifestyle_event "," food_event "," fitness_event "," health_event "," travel_event "," gaming_or_tech_event "," cultural_or_social_event "," wedding_event "," party_event "," magazine_photoshoot_event "," billboard_photoshoot_event "," campaign_photoshoot_event "," booklets_photoshoot_event "," flyers_photoshoot_event "," posters_photoshoot_event "," other_photoshoot_event "," glitz_modelling_event "," semi_glitz_modelling_event "," natural_modelling_event "," other_modelling_event "," acting_competition_event "," dance_competition_event "," music_competition_event "," other_competition_event "," other_event "};
	
		String worker_as_an_artist_services_for_which_project[]={"e_id ","  feature_film "," short_film "," web_series "," tv_series "," documentary_series "," movie_commercial "," tv_commercial "," web_commercial "," music_album_or_video "," theatre_or_musical_or_stage_shows "," stand_up_comedy_event "," fashion_or_style_or_beauty_event "," lifestyle_event "," food_event "," fitness_event "," health_event "," travel_event "," gaming_or_tech_event "," cultural_or_social_event "," wedding_event "," party_event "," magazine_photoshoot_event "," billboard_photoshoot_event "," campaign_photoshoot_event "," booklets_photoshoot_event "," flyers_photoshoot_event "," posters_photoshoot_event "," other_photoshoot_event "," glitz_modelling_event "," semi_glitz_modelling_event "," natural_modelling_event "," other_modelling_event "," acting_competition_event "," dance_competition_event "," music_competition_event "," other_competition_event "," other_event "};
	
	
		String semi_nude_shoot_or_dress_for_which_projects[]={"e_id ","  feature_film "," short_film "," web_series "," tv_series "," documentary_series "," movie_commercial "," tv_commercial "," web_commercial "," music_album_or_video "," theatre_or_musical_or_stage_shows "," stand_up_comedy_event "," fashion_or_style_or_beauty_event "," lifestyle_event "," food_event "," fitness_event "," health_event "," travel_event "," gaming_or_tech_event "," cultural_or_social_event "," wedding_event "," party_event "," magazine_photoshoot_event "," billboard_photoshoot_event "," campaign_photoshoot_event "," booklets_photoshoot_event "," flyers_photoshoot_event "," posters_photoshoot_event "," other_photoshoot_event "," glitz_modelling_event "," semi_glitz_modelling_event "," natural_modelling_event "," other_modelling_event "," acting_competition_event "," dance_competition_event "," music_competition_event "," other_competition_event "," other_event "};
	
		String nude_shoot_for_which_projects[]={"e_id ","  feature_film "," short_film "," web_series "," tv_series "," documentary_series "," movie_commercial "," tv_commercial "," web_commercial "," music_album_or_video "," theatre_or_musical_or_stage_shows "," stand_up_comedy_event "," fashion_or_style_or_beauty_event "," lifestyle_event "," food_event "," fitness_event "," health_event "," travel_event "," gaming_or_tech_event "," cultural_or_social_event "," wedding_event "," party_event "," magazine_photoshoot_event "," billboard_photoshoot_event "," campaign_photoshoot_event "," booklets_photoshoot_event "," flyers_photoshoot_event "," posters_photoshoot_event "," other_photoshoot_event "," glitz_modelling_event "," semi_glitz_modelling_event "," natural_modelling_event "," other_modelling_event "," acting_competition_event "," dance_competition_event "," music_competition_event "," other_competition_event "," other_event "};
	
		//here call only desired function
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Methods m=new Methods();
	
		try {
			Class.forName("com.mysql.jdbc.Driver");
		   //3306 is port no of mysql
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","saksham026");
		ArrayList<String> a=new ArrayList<String>();
		a.add("investment");
		a.add("collaboration");
		a.add("worker_as_an_artist");
		
		m.update_service_table(a,a,1,con);
		
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}

}

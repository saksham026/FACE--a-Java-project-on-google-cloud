package face1;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

public class profile {

	
	public ArrayList<String> get_type_of_profile(Connection con, int user_id)
	{
		
	
		ResultSet rs; 
		PreparedStatement pst;
		int no_of_coloumns;
		
		String[]  type_of_profile=null;
	
		//String[] type_of_profle= {"Executive Producer", "Line Producer", "Supervising Producer", "Co Producer","Co Ordinating_producer","Primary Assistant Producer", "Secondary Assistant Producer", "Assistant Producer","Segment Producer", "Event Producer","Music Producer","film_director","Film Director","Primary Associate Film Director","Secondary Associate Film Director", "Associate Film Director"};
		
		// varchar(10), casting_director varchar(10), primary_associate_casting_director varchar(10),secondary_associate_casting_director varchar(10),other_associate_casting_director varchar(10), music_director varchar(10),primary_associate_music_director varchar(10),secondary_associate_music_director varchar(10), other_associate_music_director varchar(10), dop varchar(10), primary_camera_operator varchar(10), secondary_camera_operator varchar(10), other_camera_operator varchar(10), gafer varchar(10), best_boy varchar(10), lighting_technician_or_grip varchar(10), film_video_editor varchar(10), sound_designer varchar(10), dialouge_editor varchar(10), foley_artist varchar(10), language_translator varchar(10), language_tutor varchar(10), fashion_stylist varchar(10), hair_makeup_stylist varchar(10), illustrator varchar(10), graphic_artist varchar(10), production_designer varchar(10), art_director varchar(10),  set_designer varchar(10), set_dressor varchar(10), set_constructor varchar(10), script_writter varchar(10), script_supervisor varchar(10),
		
		// query to find no of coloumns and name of specific coloumn
		
		String col_name="SELECT distinct COLUMN_NAME FROM information_schema.columns WHERE table_name = 'type_of_profile' and ORDINAL_POSITION IN (";
		String col_count="SELECT count(*) " + 
				"FROM information_schema.columns " + 
				"WHERE table_name = 'type_of_profile'"
				+ "and TABLE_SCHEMA='database';"; 
				
		int count=0;
		ArrayList<String> specified_column_name = new ArrayList<String>();
		
		try {
			
			pst=con.prepareStatement(col_count);
		 	rs=pst.executeQuery();
			
			while(rs.next())  
			{
				count=rs.getInt(1);
			}
			
			
			pst=con.prepareStatement("select * from type_of_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			
				while(rs.next())  
				{
					for(int i=1;i<=count;i++)
					{
					//System.out.println(rs.getString(i));
					if(rs.getString(i).equals("yes"))
					{
					
						
						if(i!=count)
						{
							col_name+=i+",";
						}
						else
						{
							col_name+=i;
						}
						
					}
				}
				
				
			}
			
			col_name=col_name.substring(0, col_name.length() - 1);
			col_name+=")";
			
			pst=con.prepareStatement(col_name);
			//System.out.println(col_name);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				specified_column_name.add(rs.getString(1));
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
	
		return specified_column_name;
		
	}
	
	public ArrayList<Integer> get_fixed_body_attributes_values(Connection con, int user_id)
	{
		ResultSet rs; 
		PreparedStatement pst;

	
		//String[] type_of_profle= {"Executive Producer", "Line Producer", "Supervising Producer", "Co Producer","Co Ordinating_producer","Primary Assistant Producer", "Secondary Assistant Producer", "Assistant Producer","Segment Producer", "Event Producer","Music Producer","film_director","Film Director","Primary Associate Film Director","Secondary Associate Film Director", "Associate Film Director"};
		
		// varchar(10), casting_director varchar(10), primary_associate_casting_director varchar(10),secondary_associate_casting_director varchar(10),other_associate_casting_director varchar(10), music_director varchar(10),primary_associate_music_director varchar(10),secondary_associate_music_director varchar(10), other_associate_music_director varchar(10), dop varchar(10), primary_camera_operator varchar(10), secondary_camera_operator varchar(10), other_camera_operator varchar(10), gafer varchar(10), best_boy varchar(10), lighting_technician_or_grip varchar(10), film_video_editor varchar(10), sound_designer varchar(10), dialouge_editor varchar(10), foley_artist varchar(10), language_translator varchar(10), language_tutor varchar(10), fashion_stylist varchar(10), hair_makeup_stylist varchar(10), illustrator varchar(10), graphic_artist varchar(10), production_designer varchar(10), art_director varchar(10),  set_designer varchar(10), set_dressor varchar(10), set_constructor varchar(10), script_writter varchar(10), script_supervisor varchar(10),
		
		// query to find no of coloumns and name of specific coloumn
		
		
		ArrayList<Integer> specified_column_name = new ArrayList<Integer>();
		
		try {
			
			
			pst=con.prepareStatement("select height,weight,hips,waist,shoulders,chest_or_bust from body_attributes_profile where eid=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
				{
				specified_column_name.add(rs.getInt(1));
				
				}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
	
		return specified_column_name;
		

	}
	
	public ArrayList<String> get_body_attributes(Connection con, int user_id)
	{
		
	
		ResultSet rs; 
		PreparedStatement pst;
		int no_of_coloumns;
		
		String[]  body_profile=null;
	
		//String[] type_of_profle= {"Executive Producer", "Line Producer", "Supervising Producer", "Co Producer","Co Ordinating_producer","Primary Assistant Producer", "Secondary Assistant Producer", "Assistant Producer","Segment Producer", "Event Producer","Music Producer","film_director","Film Director","Primary Associate Film Director","Secondary Associate Film Director", "Associate Film Director"};
		
		// varchar(10), casting_director varchar(10), primary_associate_casting_director varchar(10),secondary_associate_casting_director varchar(10),other_associate_casting_director varchar(10), music_director varchar(10),primary_associate_music_director varchar(10),secondary_associate_music_director varchar(10), other_associate_music_director varchar(10), dop varchar(10), primary_camera_operator varchar(10), secondary_camera_operator varchar(10), other_camera_operator varchar(10), gafer varchar(10), best_boy varchar(10), lighting_technician_or_grip varchar(10), film_video_editor varchar(10), sound_designer varchar(10), dialouge_editor varchar(10), foley_artist varchar(10), language_translator varchar(10), language_tutor varchar(10), fashion_stylist varchar(10), hair_makeup_stylist varchar(10), illustrator varchar(10), graphic_artist varchar(10), production_designer varchar(10), art_director varchar(10),  set_designer varchar(10), set_dressor varchar(10), set_constructor varchar(10), script_writter varchar(10), script_supervisor varchar(10),
		
		// query to find no of coloumns and name of specific coloumn
		
		String col_name="SELECT distinct COLUMN_NAME FROM information_schema.columns WHERE table_name = 'body_attributes_profile' and ORDINAL_POSITION IN (";
		String col_count="SELECT count(*) " + 
				"FROM information_schema.columns " + 
				"WHERE table_name = 'body_attributes_profile'"
				+"and TABLE_SCHEMA='database';"; 
				
		int count=0;
		ArrayList<String> specified_column_name = new ArrayList<String>();
		
		try {
			
			pst=con.prepareStatement(col_count);
		 	rs=pst.executeQuery();
			
			while(rs.next())  
			{
				count=rs.getInt(1);
			}
			
			//System.out.println(count);
			
			pst=con.prepareStatement("select * from body_attributes_profile where eid=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			int k=0;
			
			
				while(rs.next())  
				{
					for(int i=1;i<=count;i++)
					{
					if(rs.getString(i).equals("Yes"))
					{
					
						k++;
						if(i!=count)
						{
							col_name+=i+",";
						}
						else
						{
							col_name+=i;
						}
						
					}
				}
				
				
			}
			
			col_name=col_name.substring(0, col_name.length() - 1);
			col_name+=")";
			
			if(k!=0)
			{
				pst=con.prepareStatement(col_name);
			
			//System.out.println(col_name);
			rs=pst.executeQuery();
			
			
			while(rs.next())  
			{
				
				specified_column_name.add(rs.getString(1));
					
			}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
	
		return specified_column_name;
		
	}
	
	public byte[] get_profile_image(Connection con, int user_id)
	{
		
		ResultSet rs; 
		PreparedStatement pst;
		byte[] profile_image_bytes=null;
		Blob profile_image=null;
		
		try {
			
			pst=con.prepareStatement("select personal_profile_photo from basic_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
			 if(rs.getBlob(1)!=null)
			 {
			 profile_image = rs.getBlob(1);
			 
			 profile_image_bytes = profile_image.getBytes(1,(int)profile_image.length());
			 }
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
		return profile_image_bytes;
		
	}
	
	 public String check_type_of_influencer(double instagram_followers)
	 {
		String type_of_influencer=null;
		
		if(instagram_followers>=1000 && instagram_followers<100000)
		{
			type_of_influencer="Micro Influencer";
		}
		else if(instagram_followers>=100000 && instagram_followers<500000)
		{
			type_of_influencer="Middle Influencer";
		}
		else if(instagram_followers>=500000 && instagram_followers<1000000)
		{
			type_of_influencer="Macro Influencer";
		}
		else if(instagram_followers>=1000000)
		{
			type_of_influencer="Celebrity";
		}
		else
		{
			type_of_influencer="null";
		}
		
		
		return type_of_influencer;  
	 }
	
	
	public Map get_profile_highlights(Connection con, int user_id)
	{
		
		Map profile_highlights = new HashMap();
		ResultSet rs; 
		PreparedStatement pst;
		String name = null,about_me=null,office_name=null,type_of_influencer=null;
		ArrayList<String> type_of_profile=null;
		Double score=null,no_of_post=null,no_of_projects_accomplished=null,no_of_honor_award_accomplished=null,no_of_organisation_associated_with_accomplished=null ,instagram_followers=null;
		
		try {
			
			//name and about me
			pst=con.prepareStatement("select first_name, last_name, about_me  from basic_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
			 name = rs.getString(1);
			 name = name + " " + rs.getString(2);
			 about_me= rs.getString(3);
			 
			}
		
			
			//type_of_profile
			type_of_profile=get_type_of_profile(con,user_id);
			
			
			//office_name
			pst=con.prepareStatement("select distinct name from office_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
			 if(rs.isLast())
			 {
				 office_name += rs.getString(1);
				 	 
			 }
			 else
				 office_name += rs.getString(1)+",";
			 
					 
			}
			  
			
			//score
			pst=con.prepareStatement("select score from scoreboard where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				score = rs.getDouble(1);
					 
			}
			
		
			//no_of_post
			pst=con.prepareStatement("select count(*) from all_post where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				no_of_post = rs.getDouble(1);
					 
			}
			
			
			//no_of_projects_accomplished
			pst=con.prepareStatement("select count(carrer_profile_project_id) from carrer_profile_project where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				no_of_projects_accomplished = rs.getDouble(1);
					 
			}
			
			
			//no_of_honor_award_accomplished
			pst=con.prepareStatement("select count(carrer_profile_honor_award_id) from carrer_profile_honor_award where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				no_of_honor_award_accomplished = rs.getDouble(1);
					 
			}
					
			
			//no_of_organisation_associated_with_accomplished
			pst=con.prepareStatement("select count( organisation_associated_with_id ) from carrer_profile_organisation_associated_with where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				no_of_organisation_associated_with_accomplished = rs.getDouble(1);
					 
			}
				
			
			//instagram_followers
			pst=con.prepareStatement("select instagram_followers from carrer_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				instagram_followers = rs.getDouble(1);
					 
			}
			
			
			//type_of_influencer
			type_of_influencer = check_type_of_influencer(instagram_followers);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

		
		profile_highlights.put("name", name);
		profile_highlights.put("type_of_rofile", type_of_profile);
		profile_highlights.put("at", office_name);
		profile_highlights.put("about_me", about_me);
		profile_highlights.put("score", score);
		profile_highlights.put("No of post", no_of_post);
		profile_highlights.put("no_of_projects_accomplished", no_of_projects_accomplished);
		profile_highlights.put("no_of_honor_award_accomplished", no_of_honor_award_accomplished);
		profile_highlights.put("no_of_organisation_associated_with_accomplished", no_of_organisation_associated_with_accomplished);
		profile_highlights.put("instagram_followers", instagram_followers);
		profile_highlights.put("type_of_influencer", type_of_influencer);
		
		return profile_highlights;	
	}
	
	
	/*public Map get_post(Connection con, int user_id)
	{
		 
		ResultSet rs,rs1; 
		PreparedStatement pst;
		
		int post_id;
		String type_of_post = null;
		
		Date date;
		int i=0;
		int post_id_array[] = null; 
		String type_of_post_array[] = null;
		
		String type_of_promotional_post=null;
		String 	type_of_project_post=null;	
		
		Blob promotional_photo = null,promotional_video =null, detail_image=null,project_promotional_photo=null;		
		
		byte[]  detail_image_bytes, promotional_photo_bytes,project_promotional_photo_bytes, promotional_video_bytes;
		//post[] =null;
		Map post= new HashMap();
			try
			{
				
				
				pst=con.prepareStatement("select post_id, type_of_post, date_of_post from all_post order by date_of_post desc where e_id=?");  

				pst.setInt(1,user_id);
				
				rs=pst.executeQuery();
			
				while(rs.next())  
				{
				
				 post_id = rs.getInt(1);
				 type_of_post= rs.getString(2);	
				 date = rs.getDate(3);
				 
				 post_id_array[i]=post_id;
				 type_of_post_array[i]= type_of_post;
				 i++;
				 
				}
			
				
				for(int ctr =0;ctr < post_id_array.length; ctr++)
				{
					post_id = post_id_array[ctr];
					type_of_post = type_of_post_array[ctr];
					
					if(type_of_post.equals("promotional_post"))
					{
							 pst=con.prepareStatement("select detail_image , promotional_photo, promotional_video from promotional_post where e_id=? and promotional_post_id=?");  
							 pst.setInt(1,user_id);
							 pst.setInt(2,post_id);
							 rs=pst.executeQuery();
							 
							 while(rs.next())
							 {
								 detail_image = rs.getBlob(1);
								 promotional_photo= rs.getBlob(2);
								 promotional_video= rs.getBlob(3);
							
								 if(detail_image!=null)
								 {
									 detail_image_bytes = detail_image.getBytes(1,(int)detail_image.length());
									 post.put(post_id, detail_image_bytes);
									  
								 }
								 else if(promotional_photo!=null)
								 {
									 promotional_photo_bytes = promotional_photo.getBytes(1,(int)promotional_photo.length());
									 post.put(post_id, promotional_photo_bytes);
									  
								 }
								 else if(promotional_video!=null)
								 {
									 promotional_video_bytes = promotional_video.getBytes(1,(int)promotional_video.length());
									 post.put(post_id, promotional_video_bytes);
									  
								 }
								  
							 }
								 
					 }
						 
					else if(type_of_post.equals("project_post"))
					{
						
						pst=con.prepareStatement("select type_of_post from project_post where e_id=? and project_post_id=?");  

						pst.setInt(1,user_id);
						pst.setInt(2,post_id);
						
						
						rs=pst.executeQuery();
						
						while(rs.next())  
						{
						
						
						 type_of_project_post= rs.getString(1);	
						 
						 
						 if(type_of_project_post.equals("project_worker_post_offline"))
						 {
							
							 pst=con.prepareStatement("select project_worker_post_offline_detail_image from project_post where e_id=? and promotional_post_id=?");  

								pst.setInt(1,user_id);
								pst.setInt(2,post_id);
								
								
								rs1=pst.executeQuery();
								
								while(rs1.next())  
								{
								
									project_promotional_photo = rs1.getBlob(1);
									
									 project_promotional_photo_bytes = project_promotional_photo.getBytes(1,(int)project_promotional_photo.length());
									
									 post.put(post_id, project_promotional_photo_bytes);
									 
									 
								}					 
						 }
						 
						 else if(type_of_project_post.equals("project_worker_post_online"))
						 {
							
							 pst=con.prepareStatement("select project_worker_post_online_detail_image from project_post where e_id=? and promotional_post_id=?");  

								pst.setInt(1,user_id);
								pst.setInt(2,post_id);
								
								
								rs1=pst.executeQuery();
								
								while(rs1.next())  
								{
								
									project_promotional_photo = rs1.getBlob(1);
									
									project_promotional_photo_bytes = project_promotional_photo.getBytes(1,(int)project_promotional_photo.length());
									
									post.put(post_id, project_promotional_photo_bytes);
									 
								}	
						 }
						 else if(type_of_project_post.equals("project_investment_post"))
						 {
							
							 pst=con.prepareStatement("select project_investment_post_detail_image from project_post where e_id=? and promotional_post_id=?");  

								pst.setInt(1,user_id);
								pst.setInt(2,post_id);
								
								
								rs1=pst.executeQuery();
								
								while(rs1.next())  
								{
								
									project_promotional_photo = rs1.getBlob(1);
									
									project_promotional_photo_bytes = project_promotional_photo.getBytes(1,(int)project_promotional_photo.length());

									post.put(post_id, project_promotional_photo_bytes);
									 
								}	
						 }						 
						 else if(type_of_project_post.equals("project_collaboration_post"))
						 {
							
							 pst=con.prepareStatement("select project_collaboration_post_detail_image from project_post where e_id=? and promotional_post_id=?");  

								pst.setInt(1,user_id);
								pst.setInt(2,post_id);
								
								
								rs1=pst.executeQuery();
								
								while(rs1.next())  
								{
								
									project_promotional_photo = rs1.getBlob(1);
									
									project_promotional_photo_bytes = project_promotional_photo.getBytes(1,(int)project_promotional_photo.length());
									
									post.put(post_id, project_promotional_photo_bytes);
									 
								}	
						 }
					  }
					}
					
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		return post;
	}
	
	*/
	/*public void add_basic_profile(Connection con, int user_id,String first_name, String last_name,int public_whatsapp_number,int public_calling_number,String public_email_id,int private_whatsapp_number,int private_calling_number,String private_email_id,Date dob,String gender,String home_town,String current_location,String indian_nationality,String foreigner_nationality,String about_me,String[] type_of_profile,String[] body_attributes)
	{
		ResultSet rs; 
		PreparedStatement pst;
		
		try {
			
	
			pst=con.prepareStatement("insert into  basic_profile (e_id, first_name ,last_name ,public_whatsapp_number ,public_calling_number ,public_email_id ,private_whatsapp_number ,private_calling_number ,private_email_id ,dob ,gender ,home_town ,current_location ,indian_nationality ,foreigner_nationality ,about_me )  values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1, user_id);
			pst.setString(2, first_name);
			pst.setString(3, last_name);
			pst.setInt(4, public_whatsapp_number);
			pst.setInt(5, public_calling_number);
			pst.setString(6, public_email_id);
			pst.setInt(7, private_whatsapp_number);
			pst.setInt(8, private_calling_number);
			pst.setString(9, private_email_id);
			pst.setDate(10, (java.sql.Date) dob); 
			pst.setString(11, gender);
			pst.setString(12, home_town);
			pst.setString(13, current_location);
			pst.setString(14, indian_nationality);
			pst.setString(15, foreigner_nationality);
			pst.setString(16, about_me);
		
			
			pst.executeQuery();
			

			//type_of_profile edit
				// match type of profile[] values to coloumn name in db, whichever matches put yes in that
			
			//body attributes edit
				// match body_attributes[] values to coloumn name in db, whichever matches put yes in that
			
			
			// create basic profile detail image and store it 
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
*/	
	public int generate_offcie_id(Connection con,int user_id)
	{
		String getUserId = "SELECT max(office_id) FROM office_profile where e_id="+user_id;
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
	
	public void add_office_profile(Connection con, int user_id,String name, int whatsapp_number,int calling_number,String email_id,String website_link,String instgram_link,String facebook_link,String twitter_link,String other_link,String about_us,int plot_or_building_number,String building_name,int floor_number,String street,String locality,String landmark,String city,String state,int pincode,String country,String google_map_link, Blob logo)
	{
		ResultSet rs; 
		PreparedStatement pst;
		int office_id=generate_offcie_id(con,user_id);
			// check communication_profile_photo longblob in office_profile  table
		try {

			pst=con.prepareStatement("insert into office_profile (e_id,_name,whatsapp_number,calling_number,email_id,website_link,instgram_link,facebook_link,twitter_link,other_link,about_us,plot_or_building_number,building_name,floor_number,street,locality,landmark,city,state,pincode,country,google_map_link,logo,office_id) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			pst.setInt(1, user_id);
			pst.setString(2, name);
			pst.setInt(3, whatsapp_number);
			pst.setInt(4, calling_number);
			pst.setString(5, email_id);
			pst.setString(6, website_link);
			pst.setString(7, instgram_link);
			pst.setString(8, facebook_link);
			pst.setString(9, twitter_link);
			pst.setString(10, other_link); 
			pst.setString(11, about_us);
			pst.setInt(12, plot_or_building_number);
			pst.setString(13, building_name);
			pst.setInt(14, floor_number);
			pst.setString(15, street);
			pst.setString(16, locality);
			pst.setString(17, landmark);
			pst.setString(18, city);
			pst.setString(19, state);
			pst.setInt(20, pincode);
			pst.setString(21, country);
			pst.setString(22, google_map_link);
			pst.setBlob(23, logo);
			pst.setInt(24, office_id);

			
			pst.executeUpdate();
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		String s=null;
		
		if(logo!=null)
		{
		byte[] bdata = null;
		try {
			bdata = logo.getBytes(1, (int) logo.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s = new String(bdata);
		}
		
			ArrayList<String> values=new ArrayList<String>();
			values.add(name);
			values.add(Integer.toString(whatsapp_number));
			values.add(Integer.toString(calling_number));
			
			values.add(email_id);
			values.add(website_link);
			values.add(instgram_link);
			values.add(facebook_link);
			values.add(twitter_link);
			values.add(other_link); 
			values.add(about_us);
			values.add(Integer.toString(plot_or_building_number));
			values.add(building_name);
			values.add(Integer.toString(floor_number));
			values.add(street);
			values.add(locality);
			values.add(landmark);
			values.add(city);
			values.add(state);
			values.add(Integer.toString(pincode));
			values.add(country);
			values.add(google_map_link);
			if(s!=null)
			values.add(s);
			values.add(Integer.toString(user_id));
			values.add(Integer.toString(office_id));
			
			ArrayList<String> labels=new ArrayList<String>();
			labels.add("name");
			labels.add("whatsapp_number");
			labels.add("calling_number");
			
			labels.add("email_id");
			labels.add("website_link");
			labels.add("instgram_link");
			labels.add("facebook_link");
			labels.add("twitter_link");
			labels.add("other_link"); 
			labels.add("about_us");
			labels.add("plot_or_building_number");
			labels.add("building_name");
			labels.add("floor_number");
			labels.add("street");
			labels.add("locality");
			labels.add("landmark");
			labels.add("city");
			labels.add("state");
			labels.add("pincode");
			labels.add("country");
			labels.add("google_map_link");
			if(s!=null)
			labels.add("logo");
			labels.add("user_id");
			labels.add("office_id");
				// create office profile detail image and store it 
			make_snapshot_office_image(values, labels, con, user_id);
		
	}
	
	public ArrayList<Object> post_detail_image(Connection con, int user_id,int post_id[],String type_of_post[],String purpose)
	{
		// (show or delete) (all or single) post  for (particular or all) type
		ResultSet rs = null; 
		PreparedStatement pst;
		Date date;		
		ArrayList<Object> post = new ArrayList<Object>();
		ArrayList<Object> post_list = new ArrayList<Object>();
		int sample_product_media_id,i=0;
		int post_id_array[]=new int[post_id.length];
		String sample_product_media_type,sample_product_media_text,type_of_promotional_post,type_of_project_post ,sample_product_media_description;
		String[] type_of_post_array = new String[type_of_post.length];
		String sample_product_text=null;
		Blob sample_product_media,detail_image;
		byte[] sample_product_media_bytes,detail_image_bytes;
		
			try
			{
				//for all post irrespective of their type
				if(post_id==null && type_of_post==null)
				{
					pst=con.prepareStatement("select post_id, type_of_post from all_post order by date_of_post desc where e_id=?");  

					pst.setInt(1,user_id);
					
					rs=pst.executeQuery();
				
					while(rs.next())  
					{
						post_id_array[i]=rs.getInt(1);
					 //post_id = rs.getInt(1);
						type_of_post_array[i]=rs.getString(2);	
					// type_of_post= rs.getString(2);	
					 //date = rs.getDate(3);
					 
					 //post_id_array[i]=post_id;
					// type_of_post_array[i]= type_of_post;
					 i++;		 
					}
				}
				else if(post_id==null)
				{
					
					for(int k=0;i<type_of_post.length;k++)
					{
						pst=con.prepareStatement("select post_id, date_of_post from all_post order by date_of_post desc where e_id=? and type_of_post=?");  

						pst.setInt(1,user_id);
						pst.setString(2,type_of_post[k]);
						rs=pst.executeQuery();
						
						while(rs.next())  
						{	
						 //post_id = rs.getInt(1);
						 //date = rs.getDate(2);
						 
						 post_id_array[i]=rs.getInt(1);
						 type_of_post_array[i]= type_of_post[k];
						 i++;		 
						}
					}
					
				}
				else //for specific post 
				{	
					for(int j=0;j<post_id.length;j++)
					{
						//System.out.println(post_id[j]);
						//System.out.println(type_of_post[j]);
						
						post_id_array[j]=post_id[j];
						type_of_post_array[j]= type_of_post[j];
					}
					 
					 	
				}
						
				for(int ctr =0;ctr < post_id_array.length; ctr++)
				{
					int post_id_ = post_id_array[ctr];
					String type_of_post_ = type_of_post_array[ctr];
					
					if(purpose.equals("show"))
						{
							post.add(user_id);
							post.add(post_id_);
							post.add(type_of_post_);
						 
							//if(type_of_post.equals("class_promotional_post") ||type_of_post.equals("workshop_promotional_post") )
							if(type_of_post_.contains("promotion"))
							{
								pst=con.prepareStatement("select promotional_post_detail_image from promotional_post where e_id=? and promotional_post_id=? and type_of_post=?");  
							}
							else // else if(type_of_post.contains("project_post"))
							{
								pst=con.prepareStatement("select project_post_detail_image from project_post where e_id=? and project_post_id=? and type_of_post=?");  
							} 
							
							pst.setInt(1,user_id);
							pst.setInt(2,post_id_);
							pst.setString(3,type_of_post_);
							rs=pst.executeQuery();
							
							 while(rs.next())
							 {
								 detail_image = rs.getBlob(1);
								 if(detail_image!=null)
								 {
									 detail_image_bytes = detail_image.getBytes(1,(int)detail_image.length());	
									 post.add(detail_image_bytes);
								 }
										 
							 }	
							 
							
							 pst=con.prepareStatement("select sample_product_media_id,sample_product_media,sample_product_media_type,media_description from sample_post_product_media where e_id=? and post_id=? and type_of_post=?");  
							 pst.setInt(1,user_id);
							 pst.setInt(2,post_id_);
							 pst.setString(3,type_of_post_);
							 rs=pst.executeQuery();
							
							 while(rs.next())
							 {
								 sample_product_media_id = rs.getInt(1);
								 sample_product_media_type = rs.getString(3);
								 sample_product_media_description = rs.getString(4);
								 sample_product_media = rs.getBlob(2);
									 
									 if(sample_product_media!=null)
									 {
										 sample_product_media_bytes = sample_product_media.getBytes(1,(int)sample_product_media.length());
										 post.add(sample_product_media_bytes);
										 post.add(sample_product_media_description);
										 post.add(sample_product_media_id);
										 post.add(sample_product_media_type);
										 	
									 }
									
							 }
							 post_list.add(post);
							 //System.out.println(post_list);
			}
			else //delete case
			{
 
				  if(type_of_post_.contains("promotion"))
				  {
					  	 pst=con.prepareStatement("delete from promotional_post where e_id= ? and promotional_post_id =?  and type_of_post=?");
						 pst.setInt(1,user_id);
						 pst.setInt(2,post_id_);
						 pst.setString(3,type_of_post_);
						 pst.executeUpdate();		
				  }
				  else//if(type_of_post.contains("project_post"))
				  {
					  	 pst=con.prepareStatement("delete from project_post where e_id= ? and project_post_id =? and type_of_post=? ");
						 pst.setInt(1,user_id);
						 pst.setInt(2,post_id_);
						 pst.setString(3,type_of_post_);
						 pst.executeUpdate();	
				  }
				 
				 pst=con.prepareStatement("delete from sample_post_product_media where e_id= ? and post_id =? and type_of_post=? ");
				 pst.setInt(1,user_id);
				 pst.setInt(2,post_id_);
				 pst.setString(3,type_of_post_);
				 pst.executeUpdate();	
				 
				 pst=con.prepareStatement("delete from all_post where e_id= ? and post_id =? and type_of_post=? ");
				 pst.setInt(1,user_id);
				 pst.setInt(2,post_id_);
				 pst.setString(3,type_of_post_);
				 pst.executeUpdate();	
			}
		}								
	}
	catch (Exception e)	
	{
		e.printStackTrace();
	}

			return post_list;
	}

	
	public Object[] show_profile(Connection con, int user_id)
	{
	
		byte[] profile_image = get_profile_image(con,user_id);
		Map profile_highlights = get_profile_highlights(con,user_id);
		ArrayList<Object> post = post_detail_image(con,user_id,null,null,"show");
		
		Object[] show_profile = {profile_image,profile_highlights,post};
			
		return show_profile;
	} 
	
	public byte[][] show_basic_profile_detail_image(Connection con, int user_id)
	{
		
		ResultSet rs; 
		PreparedStatement pst;
		int ctr=0;
		Blob basic_profile_detail_image=null,body_attributes_profile_detail_image;
		
		byte[] body_attributes_profile_detail_image_bytes,basic_profile_image[]=null,basic_profile_detail_image_bytes = null;
		
		
		try {
			pst=con.prepareStatement("select basic_profile_detail_image from basic_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				basic_profile_detail_image = rs.getBlob(1);
				basic_profile_detail_image_bytes = basic_profile_detail_image.getBytes(1,(int)basic_profile_detail_image.length());
				basic_profile_image[ctr]=basic_profile_detail_image_bytes;
				ctr++;
			}
			
			
			pst=con.prepareStatement("select body_attributes_profile_detail_image from body_attributes_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				body_attributes_profile_detail_image= rs.getBlob(1);
				body_attributes_profile_detail_image_bytes = body_attributes_profile_detail_image.getBytes(1,(int)body_attributes_profile_detail_image.length());
				basic_profile_image[ctr]=basic_profile_detail_image_bytes;
				ctr++;
					 
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return basic_profile_image;
	}

	
	public byte[] show_office_profile_detail_image(Connection con, int user_id)
	{
		
		ResultSet rs; 
		PreparedStatement pst;
		Blob show_office_profile_image=null;
		byte[] show_office_profile_detail_image=null;
		
		try {
			pst=con.prepareStatement("select office_profile_detail_image from office_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
			
				show_office_profile_image = rs.getBlob(1);
				show_office_profile_detail_image = show_office_profile_image.getBytes(1,(int)show_office_profile_image.length());
					 
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*response.setContentType("image/gif");
		OutputStream o = response.getOutputStream();

		o.write(imgData);*/
		return show_office_profile_detail_image;
	}

	public byte[] show_carrer_profile_detail_image(Connection con, int user_id)
	{
		
		ResultSet rs; 
		PreparedStatement pst;
		
		Blob carrer_profile_image=null,carrer_profile_project_audio=null,carrer_profile_project_video=null,carrer_profile_project_images=null;
		byte[] carrer_profile_image_bytes=null, carrer_profile_project_audio_bytes=null,carrer_profile_project_video_bytes=null,carrer_profile_project_images_bytes=null;
		Object[] carrer_profile_detail = new Object[4];
		
		try {
			pst=con.prepareStatement("select carrer_profile_detail_image from carrer_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				carrer_profile_image = rs.getBlob(1);
				carrer_profile_image_bytes = carrer_profile_image.getBytes(1,(int)carrer_profile_image.length());		 
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return carrer_profile_image_bytes;
	}
	
	public ArrayList<Object> show_carrer_profile_media(Connection con, int user_id,String carrer_profile_type)
	{
	
		ResultSet rs; 
		PreparedStatement pst;
		int media_id;
		String media_type,media_text;
		Blob media;
		byte[] media_bytes;
		ArrayList<Integer> carrer_profile_id= new ArrayList<Integer>();
		ArrayList<Object> carrer_profile_project_media= new ArrayList<Object>();
		ArrayList<Object> carrer_profile_project_media_list= new ArrayList<Object>();
		
		try 
		{
			
			if(carrer_profile_type.contains("project"))
			{
				pst=con.prepareStatement("select carrer_profile_project_id from carrer_profile_project where e_id=?");
			}
			else if(carrer_profile_type.contains("honor_award"))
			{
				pst=con.prepareStatement("select carrer_profile_honor_award_id from carrer_profile_honor_award where e_id=?");
			}
			else
			{
				pst=con.prepareStatement("select organisation_associated_with_id from carrer_profile_organisation_associated_with where e_id=?");
			}
			
			pst.setInt(1,user_id);
			rs=pst.executeQuery();
			
			while(rs.next())  
			{			
				carrer_profile_id.add(rs.getInt(1));	 
			}
			
			carrer_profile_project_media_list.add(user_id);
			carrer_profile_project_media_list.add(carrer_profile_type);
			
			for(int ctr=0;ctr<carrer_profile_id.size();ctr++)
			{
				
				carrer_profile_project_media_list.add(carrer_profile_id.get(ctr));
				
				 pst=con.prepareStatement("select media_id,media,media_type  from carrer_profile_media where e_id=? and carrer_profile_id=? and carrer_profile_type=?");  
				 pst.setInt(1,user_id);
				 pst.setInt(2,carrer_profile_id.get(ctr));
				 pst.setString(3,carrer_profile_type);
				 rs=pst.executeQuery();
				
				 while(rs.next())
				 {
					 media_id = rs.getInt(1);
					 media_type = rs.getString(3);
					 
					 carrer_profile_project_media.add(media_id);
					 carrer_profile_project_media.add(media_type);
					 
					 if(media_type.equals("text"))
					 {
						  media_text = rs.getString(2);
						
						 if(!(media_text.equals(null)))
							 {
							 	media_text = rs.getString(2);
							 	carrer_profile_project_media.add(media_text);
							 }
					 }
					 else
					 {
						  media = rs.getBlob(2);
						 
						 if(media!=null)
						 {
							 media_bytes = media.getBytes(1,(int)media.length());
							 carrer_profile_project_media.add(media_bytes);
						 }
					 }
					 
					 carrer_profile_project_media_list.add(carrer_profile_project_media);
	 
				 }
			}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

return carrer_profile_project_media_list;
	
}
	
	
	public ArrayList<Object> show_talent_profile_detail(Connection con, int user_id, String type)
	{
		ResultSet rs; 
		PreparedStatement pst;
		ArrayList<Object> talent_profile = new ArrayList<Object>();
	
		byte[] talent_profile_media_bytes;
		Blob talent_profile_media;
		String talent_profile_media_description;
		try {
				
			pst=con.prepareStatement("select media,media_description from talent_profile_media where e_id=? and media_type=?");
			pst.setInt(1,user_id);
			pst.setString(2,type);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				
					talent_profile_media= rs.getBlob(1);
					talent_profile_media_bytes = talent_profile_media.getBytes(1,(int)talent_profile_media.length());
					talent_profile.add(talent_profile_media_bytes);

					talent_profile_media_description= rs.getString(2);
					talent_profile.add(talent_profile_media_description);
						
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return talent_profile;
		
	}
	
	public void edit_or_remove_profile_image(Connection con, int user_id, Blob profile_image )
	{
		//to remove provide profile_image value as null 

		ResultSet rs; 
		PreparedStatement pst;
		
		try {
			
			pst=con.prepareStatement(" update basic_profile set personal_profile_photo=? where  eid=?" );
			pst.setBlob(1, profile_image);
			pst.setInt(2, user_id);
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
	}
	
	public int body_attribute_entity(ArrayList<String> list,Connection con,int user_id)	//parameters also require list of values
	{
		//add id to aaray lsit first
		 Iterator<String> iter = list.iterator();

		 String emptyrow="delete eid  ,extremely_fair    , fair    , wheatish    , dark    , other_skin_tone    , straight_hair    , wavy_hair    , curly_hair    , other_type_hair    , thin_volume_hair    , thick_volume_hair    , normal_volume_hair    ,monolids_eyes     , round_eyes    , almond_eyes    , downturned_eyes    , upturned_eyes    , hooded_eyes    , other_type_eyes    , height  , weight  , hips  , waist  , shoulders  , chest_or_bust  , skinny_body    , avg_physique_body    , muscular_body    , fat_body    ,plus_size_body    , body_attributes_profile_detail_image from body_attributes_profile where eid="+user_id;
		 ResultSet rs; 
			PreparedStatement pst;
			
				try
				{
					pst=con.prepareStatement(emptyrow);
					pst.executeUpdate();
				}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
				
			}  
				
		String createUser =
			    "INSERT INTO body_attributes_profile (";
			    
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
	
	public int edit_type_profile(ArrayList<String> list,Connection con,int user_id)	//parameters also require list of values
	{
		//add id to aaray lsit first
		 Iterator<String> iter = list.iterator();

		 
		 String emptyrow="delete e_id  ,  executive_producer   , line_producer   , supervising_producer   , co_producer   , co_ordinating_producer   , primary_associate_or_assistant_producer   , secondary_associate_or_assistant_producer   , other_associate_or_assistant_producer   , segment_producer   , event_producer   , music_producer   , film_director   , primary_associate_film_director   , secondary_associate_film_director   , other_associate_film_director   , casting_director   , primary_associate_casting_director   ,secondary_associate_casting_director   ,other_associate_casting_director   , music_director   ,primary_associate_music_director   ,secondary_associate_music_director   , other_associate_music_director   , dop   , primary_camera_operator   , secondary_camera_operator   , other_camera_operator   , gafer   , best_boy   , lighting_technician_or_grip   , film_video_editor   , sound_designer   , dialouge_editor   , foley_artist   , language_translator   , language_tutor   , fashion_stylist   , hair_makeup_stylist   , illustrator   , graphic_artist   , production_designer   , art_director   ,  set_designer   , set_dressor   , set_constructor   , script_writter   , script_supervisor   ,\r\n" + 
		 		"		 finance_manager   , location_manager   , scout   , primary_assistant_location_manager   , secondary_assistant_location_manager   , other_assistant_location_manager   , primary_production_manager   , secondary_production_manager   , other_production_manager   , unit_publicist   , legal_counsel   , system_adminstrator   , event_manager   , of_any_other_entity   , actor   , model   , dancer   , singer   , insrumentalist   , composer   , music_engineer   , radio_or_voice_over   , dj   , band   , stand_up_comedian    , other_type from type_of_profile where e_id="+user_id; 
			PreparedStatement pst;
			
				try
				{
					pst=con.prepareStatement(emptyrow);
					pst.executeUpdate();
				}
			
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
				
			}  
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
	
	public void delete_office_profile(Connection con, int user_id,int[] office_id)
	{
		ResultSet rs; 
		PreparedStatement pst;
		
			try
			{
				for(int i=0;i<office_id.length;i++)
				{
					pst=con.prepareStatement("delete from office_profile where e_id= ? and office_id =? ");
					pst.setInt(1, user_id);
					pst.setInt(2, office_id[i]);
					pst.executeUpdate();
					
				}		
			
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			
		}  
			
	}
	
	public void edit_basic_profile(Connection con, int user_id,String first_name, String last_name,int public_whatsapp_number,int public_calling_number,String public_email_id,int private_whatsapp_number,int private_calling_number,String private_email_id,Date dob,String gender,String home_town,String current_location,String indian_nationality,String foreigner_nationality,String about_me,ArrayList<String> type_of_profile,ArrayList<String> body_attributes,ArrayList<Integer> body_fixed_attributes)
	{
		ResultSet rs; 
		PreparedStatement pst;
		
		
		try {
		
			pst=con.prepareStatement("update basic_profile set first_name=?,last_name=?,public_whatsapp_number=?,public_calling_number=?,public_email_id=?,private_whatsapp_number=?,private_calling_number=?,private_email_id=?,dob=?,gender=?,home_town=?,current_location=?,indian_nationality=?,foreigner_nationality=?,about_me=?,type_of_entity=? where  e_id=?");
			pst.setString(1, first_name);
			pst.setString(2, last_name);
			pst.setInt(3, public_whatsapp_number);
			pst.setInt(4, public_calling_number);
			pst.setString(5, public_email_id);
			pst.setInt(6, private_whatsapp_number);
			pst.setInt(7, private_calling_number);
			pst.setString(8, private_email_id);
			pst.setDate(9, new java.sql.Date( dob.getTime())); 
			pst.setString(10, gender);
			pst.setString(11, home_town);
			pst.setString(12, current_location);
			pst.setString(13, indian_nationality);
			pst.setString(14, foreigner_nationality);
			pst.setString(15, about_me);
			pst.setInt(17, user_id);
			
			

			//type_of_profile edit
				// match type of profile[] values to coloumn name in db, whichever matches put yes in that
			//delete first all coumn values
			edit_type_profile(type_of_profile, con,user_id);
			

			String type_of_entity="";
			for(int i=0;i<type_of_profile.size();i++)
			{
				if(i==type_of_profile.size()-1)
					type_of_entity+=get_type_of_entity(type_of_profile.get(i));
				else
				type_of_entity+=get_type_of_entity(type_of_profile.get(i))+",";
				
			}
				//body attributes edit
				// match body_attributes[] values to coloumn name in db, whichever matches put yes in that
			
			body_attribute_entity(body_attributes, con,user_id);
			//get type of entity
			
			body_fixed_attribute_entity(body_fixed_attributes,con,user_id);
			
			
			pst.setString(16, type_of_entity);
			// create basic profile detail image and store it 
			pst.executeUpdate();
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	
	public void body_fixed_attribute_entity(ArrayList<Integer> body_fixed_attributes, Connection con,int user_id) {
		
		ResultSet rs; 
		PreparedStatement pst;
		
		try
		{
	           
			pst=con.prepareStatement("update body_attributes_profile set height=?,weight=?,hips=?,waist=?,shoulders=?,chest_or_bust=? where eid=?");
			pst.setInt(1, body_fixed_attributes.get(0));
			pst.setInt(2, body_fixed_attributes.get(1));
			pst.setInt(3, body_fixed_attributes.get(2));
			pst.setInt(4, body_fixed_attributes.get(3));
			pst.setInt(5, body_fixed_attributes.get(4));
			pst.setInt(6, body_fixed_attributes.get(5));
			pst.setInt(6, user_id);
			
			pst.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			//pst.setInt(4,1);
	}

	public void edit_office_profile(Connection con, int user_id,String name, int whatsapp_number,int calling_number,String email_id,String website_link,String instgram_link,String facebook_link,String twitter_link,String other_link,String about_us,int plot_or_building_number,String building_name,int floor_number,String street,String locality,String landmark,String city,String state,int pincode,String country,String google_map_link, Blob logo,int office_id)
	{
		ResultSet rs; 
		PreparedStatement pst;
			// check communication_profile_photo longblob in office_profile  table
		try {

			pst=con.prepareStatement("update office_profile set _name=?,whatsapp_number=?,calling_number=?,email_id=?,website_link=?,instgram_link=?,facebook_link=?,twitter_link=?,other_link=?,about_us=?,plot_or_building_number=?,building_name=?,floor_number=?,street=?,locality=?,landmark=?,city=?,state=?,pincode=?,country=?,google_map_link=?,logo=? where e_id=? and office_id=?");
			pst.setString(1, name);
			pst.setInt(2, whatsapp_number);
			pst.setInt(3, calling_number);
			pst.setString(4, email_id);
			pst.setString(5, website_link);
			pst.setString(6, instgram_link);
			pst.setString(7, facebook_link);
			pst.setString(8, twitter_link);
			pst.setString(9, other_link); 
			pst.setString(10, about_us);
			pst.setInt(11, plot_or_building_number);
			pst.setString(12, building_name);
			pst.setInt(13, floor_number);
			pst.setString(14, street);
			pst.setString(15, locality);
			pst.setString(16, landmark);
			pst.setString(17, city);
			pst.setString(18, state);
			pst.setInt(19, pincode);
			pst.setString(20, country);
			pst.setString(21, google_map_link);
			pst.setBlob(22, logo);
			pst.setInt(23, user_id);
			pst.setInt(24, office_id);
			
			
			pst.executeUpdate();
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
String s=null;
		
		if(logo!=null)
		{
		byte[] bdata = null;
		try {
			bdata = logo.getBytes(1, (int) logo.length());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		s = new String(bdata);
		}
		
			ArrayList<String> values=new ArrayList<String>();
			values.add(name);
			values.add(Integer.toString(whatsapp_number));
			values.add(Integer.toString(calling_number));
			
			values.add(email_id);
			values.add(website_link);
			values.add(instgram_link);
			values.add(facebook_link);
			values.add(twitter_link);
			values.add(other_link); 
			values.add(about_us);
			values.add(Integer.toString(plot_or_building_number));
			values.add(building_name);
			values.add(Integer.toString(floor_number));
			values.add(street);
			values.add(locality);
			values.add(landmark);
			values.add(city);
			values.add(state);
			values.add(Integer.toString(pincode));
			values.add(country);
			values.add(google_map_link);
			if(s!=null)
			values.add(s);
			values.add(Integer.toString(user_id));
			values.add(Integer.toString(office_id));
			
			ArrayList<String> labels=new ArrayList<String>();
			labels.add("name");
			labels.add("whatsapp_number");
			labels.add("calling_number");
			
			labels.add("email_id");
			labels.add("website_link");
			labels.add("instgram_link");
			labels.add("facebook_link");
			labels.add("twitter_link");
			labels.add("other_link"); 
			labels.add("about_us");
			labels.add("plot_or_building_number");
			labels.add("building_name");
			labels.add("floor_number");
			labels.add("street");
			labels.add("locality");
			labels.add("landmark");
			labels.add("city");
			labels.add("state");
			labels.add("pincode");
			labels.add("country");
			labels.add("google_map_link");
			if(s!=null)
			labels.add("logo");
			labels.add("user_id");
			labels.add("office_id");
				// create office profile detail image and store it 
			//make_snapshot_office_image(values, labels, con, user_id);
		
	}
	
	
	public void delete_media_carrer_profile_media(Connection con, int user_id,int carrer_profile_id,String carrer_profile_type,String media_type,int[] carrer_profile_media_id)
	{
		ResultSet rs; 
		PreparedStatement pst;
		try
		{
			if(carrer_profile_media_id!=null)
			{
				for(int ctr=0;ctr<carrer_profile_media_id.length;ctr++)
				{
					pst=con.prepareStatement("delete from carrer_profile_media where carrer_profile_id=? and carrer_profile_type=? and media_id=? and media_type=? ");
					pst.setInt(1,carrer_profile_id);
					pst.setString(2,carrer_profile_type);
					pst.setInt(3,carrer_profile_media_id[ctr]);	
					pst.setString(4,media_type);
					pst.executeUpdate();
				}
				
			}
			else
			{
				pst=con.prepareStatement("delete from carrer_profile_media where carrer_profile_id=? and carrer_profile_type=?  and media_type=? ");
				pst.setInt(1,carrer_profile_id);
				pst.setString(2,carrer_profile_type);	
				pst.setString(3,media_type);
				pst.executeUpdate();		
			}		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	public void delete_carrer_profile_project(Connection con, int user_id,int carrer_profile_id,String carrer_profile_type,String media_type[])
	{
		ResultSet rs; 
		PreparedStatement pst;
		
			try
			{
				pst=con.prepareStatement("delete from carrer_profile_project where e_id= ? and carrer_profile_project_id =? ");
				pst.setInt(1, user_id);
				pst.setInt(2, carrer_profile_id);
		
				for(int ctr=0;ctr<media_type.length;ctr++)
				{
					delete_media_carrer_profile_media( con,  user_id, carrer_profile_id, carrer_profile_type,media_type[ctr],null);
				}

				pst.executeUpdate();
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			
		}  
			
	}
	
	public void delete_carrer_profile_honor_award(Connection con, int user_id,int carrer_profile_id,String carrer_profile_type, String media_type[])
	{
		ResultSet rs; 
		PreparedStatement pst;
		
			try
			{
				pst=con.prepareStatement("delete from carrer_profile_honor_award where e_id= ? and carrer_profile_honor_award_id =? ");
				pst.setInt(1, user_id);
				pst.setInt(2, carrer_profile_id);
				
				for(int ctr=0;ctr<media_type.length;ctr++)
				{
					delete_media_carrer_profile_media( con,  user_id, carrer_profile_id, carrer_profile_type,media_type[ctr],null);
				}

				pst.executeUpdate();
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			
		}  
			
	}
	public void delete_carrer_profile_organisation_associated_with(Connection con, int user_id,int carrer_profile_id/*,String carrer_profile_type,  String media_type[]*/)
	{
		ResultSet rs; 
		PreparedStatement pst;
		
			try
			{
				pst=con.prepareStatement("delete from carrer_profile_organisation_associated_with where e_id= ? and organisation_associated_with_id =? ");
				pst.setInt(1, user_id);
				pst.setInt(2, carrer_profile_id);
				
				/*
				for(int ctr=0;ctr<media_type.length;ctr++)
				{
					delete_media_carrer_profile_media( con,  user_id, carrer_profile_id, carrer_profile_type,media_type[ctr],null);
				}*/
				
				pst.executeUpdate();
				
			}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
			
		}  
			
	}

	public int carrer_profile_project_media_id_generator(Connection con,int user_id,int carrer_profile_id)
	{
		String getUserId = "SELECT max(media_id) FROM carrer_profile_media where e_id="+user_id+" and carrer_profile_id="+carrer_profile_id;
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
	
	
	public void add_carrer_profile_media(Connection con, int user_id,int carrer_profile_id, String carrer_profile_type,HashMap carrer_profile_media)
	{
		ResultSet rs; 
		PreparedStatement pst;
		
		try
		{
			Iterator hmIterator = carrer_profile_media.entrySet().iterator(); 
			  
	        // Iterate through the hashmap 
	        // and add some bonus marks for every student 
	        while (hmIterator.hasNext()) { 
	           
			pst=con.prepareStatement("insert into carrer_profile_media (e_id,carrer_profile_id,carrer_profile_type,media_id,media,media_type) values(?,?,?,?,?,?)");
			pst.setInt(1, user_id);
			pst.setInt(2, carrer_profile_id);
			pst.setString(3,carrer_profile_type );
			pst.setInt(4, carrer_profile_project_media_id_generator(con,user_id,carrer_profile_id));
			//pst.setInt(4,1);
			
			Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
			
			pst.setBlob(5, (Blob)mapElement.getValue());   //check whether this works or not
			pst.setString(6, (String) mapElement.getKey());
			
			pst.execute();
		}
		}catch(Exception e)
		{
			System.out.println("error");
		}
		
		
		
	}
	
	/*public void add_carrer_profile_media(Connection con, int user_id,int carrer_profile_id,String media_type,String carrer_profile_type,Blob[] media)
	{		
		ResultSet rs; 
		PreparedStatement pst;
		//create table database.carrer_profile_media( carrer_profile_id integer,carrer_profile_type String, media_id integer,media longblob,media_type varchar(20))
		try {
			
			
				for(int ctr=0;ctr<media.length;ctr++)
				{
					pst=con.prepareStatement("insert into carrer_profile_media (carrer_profile_id,carrer_profile_type,media_id,media,media_type) values(?,?) where carrer_profile_project_id=?");
					pst.setInt(1, carrer_profile_id);
					pst.setString(2,  carrer_profile_type);
					pst.setInt(3, carrer_profile_project_audio_id_generator(con,user_id,carrer_profile_id));
					pst.setBlob(4, media[ctr]);
					pst.setString(5, media_type);
				}

			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			//create carrer honour and award profile detail image and store it
		}  
	}*/
	
	public ArrayList<Object> get_carrer_profile_media(Connection con, int user_id,int carrer_profile_project_id,String carrer_profile_type, String media_type)
	{
		ArrayList<Object> media= new ArrayList<Object>();
		ResultSet rs = null; 
		PreparedStatement pst;	
		try 
		{
			pst=con.prepareStatement("select media from carrer_profile_media where e_id=? and carrer_profile_id=? and carrer_profile_type=? and media_type=? ");
			pst.setInt(1, user_id);
			pst.setInt(2,carrer_profile_project_id);
			pst.setString(3,carrer_profile_type);
			pst.setString(4,media_type);
			
			rs=pst.executeQuery();
			
			while(rs.next())
			{
				
				media.add(rs.getBlob(1));
			}	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return media;
		
	}
	
	public int carrer_profile_project_id_generator(Connection con,int user_id)
	{
		String getUserId = "SELECT max(carrer_profile_project_id) FROM carrer_profile_project where e_id="+user_id;
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
	
	public void add_carrer_profile_project(Connection con, int user_id,String project_name,Date project_start_date,Date project_end_date,String project_organisation_associated_with,String project_cast_associated_with,String project_website_link,String project_instgram_link,String project_facebook_link,String project_twitter_link,String project_other_link,String project_description,HashMap carrer_profile_media)
	{
		
		// connect insta for instagram_followers etc..
		
		
		int carrer_profile_project_id= carrer_profile_project_id_generator(con,user_id);
		
		
		/*carrer_profile_project_id integer, project_name varchar(30), project_start_date date, project_end_date date,
		project_organisation_associated_with varchar(3000), project_cast_associated_with varchar(3000),
		project_website_link varchar(255), project_instgram_link varchar(255), project_facebook_link varchar(255), 
		project_twitter_link varchar(255), project_other_link varchar(255) , project_description varchar(3000)) */
		
		
		ResultSet rs;
		PreparedStatement pst;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		
		try {
			
			pst=con.prepareStatement("insert into carrer_profile_project (e_id,carrer_profile_project_id,project_name,project_start_date,project_end_date, project_organisation_associated_with,project_cast_associated_with,project_website_link,project_instgram_link,project_facebook_link,project_twitter_link,project_other_link,project_description) values(?,?,?,?,?,?,?,?,?,?,?,?,?) ");
			pst.setInt(1, user_id);
			pst.setInt(2, carrer_profile_project_id);
			pst.setString(3, project_name);
			pst.setDate(4, new java.sql.Date( project_start_date.getTime()));
			pst.setDate(5, new java.sql.Date(project_end_date.getTime()));
			pst.setString(6, project_organisation_associated_with); // csv
			pst.setString(7, project_cast_associated_with);//csv
			pst.setString(8, project_website_link);
			pst.setString(9, project_instgram_link);
			pst.setString(10, project_facebook_link);
			pst.setString(11, project_twitter_link);
			pst.setString(12, project_other_link); //csv
			pst.setString(13, project_description);
			
			if(!carrer_profile_media.isEmpty())
			add_carrer_profile_media(con, user_id,carrer_profile_project_id, "carrer_profile_project", carrer_profile_media);
			
			pst.execute();
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			ArrayList<String> values=new ArrayList<String>();
			values.add(Integer.toString(user_id));
			values.add(Integer.toString(carrer_profile_project_id));
			values.add(project_name);
			values.add(dateFormat.format(project_start_date));
			values.add(dateFormat.format(project_end_date));
			values.add(project_organisation_associated_with);
			
			values.add(project_cast_associated_with);
			values.add(project_website_link);
			values.add(project_instgram_link);
			values.add(project_facebook_link);
			values.add(project_twitter_link);
			values.add(project_other_link);
			values.add(project_description);
			
			
			ArrayList<String> labels=new ArrayList<String>();
			labels.add("user_id");
			labels.add("carrer_profile_project_id");
			labels.add("project_name");
			labels.add("project_start_date");
			labels.add("project_end_date");
			labels.add("project_organisation_associated_with");
			
			labels.add("project_cast_associated_with");
			labels.add("project_website_link");
			labels.add("project_instgram_link");
			labels.add("project_facebook_link");
			labels.add("project_twitter_link");
			labels.add("project_other_link");
			labels.add("project_description");
			// create carrer project profile detail image and store it 
			make_snapshot_carrer_profile(values, labels, con, user_id);
		}  
			
	}
	
	
	
	public Map get_carrer_profile_project_detail(Connection con, int user_id,int carrer_profile_project_id)
	{
		
		// 	update insta for instagram_followers etc..
		Date project_start_date = null, project_end_date = null;
		String project_name = null,project_organisation_associated_with = null, project_cast_associated_with = null, project_website_link = null, project_instgram_link = null, project_facebook_link = null, project_twitter_link = null, project_other_link = null, project_description = null;
		Blob[] carrer_profile_project_audio = null,carrer_profile_project_video = null,carrer_profile_project_images = null;
		ArrayList<Object> audio= new ArrayList<Object>();
		ArrayList<Object> video= new ArrayList<Object>();
		ArrayList<Object> images= new ArrayList<Object>();
		Map carrer_profile_project = new HashMap();
		
		ResultSet rs; 
		PreparedStatement pst;
		
		try {
			
			pst=con.prepareStatement("select project_name,project_start_date,project_end_date, project_organisation_associated_with,project_cast_associated_with,project_website_link,project_instgram_link,project_facebook_link,project_twitter_link,project_other_link,project_description from carrer_profile_project where e_id=? and carrer_profile_project_id=?");
			pst.setInt(1, user_id);
			pst.setInt(2, carrer_profile_project_id);
			rs=pst.executeQuery();
			while(rs.next())  
			{
				project_name=rs.getString(1);
				project_start_date=rs.getDate(2);
				project_end_date=rs.getDate(3);
				project_organisation_associated_with=rs.getString(4);
				project_cast_associated_with=rs.getString(5);
				project_website_link=rs.getString(6);
				project_instgram_link=rs.getString(7);
				project_facebook_link=rs.getString(8);
				project_twitter_link=rs.getString(9);
				project_other_link=rs.getString(10);
				project_description=rs.getString(11);
			}
					
			audio=get_carrer_profile_media(con,user_id,carrer_profile_project_id,"carrer_profile_project","audio");
			video=get_carrer_profile_media(con,user_id,carrer_profile_project_id,"carrer_profile_project","video");
			images=get_carrer_profile_media(con,user_id,carrer_profile_project_id,"carrer_profile_project","images");
				
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}  
		
		carrer_profile_project.put("project_name", project_name);
		carrer_profile_project.put("project_start_date", project_start_date);
		carrer_profile_project.put("project_end_date", project_end_date);
		carrer_profile_project.put("project_organisation_associated_with", project_organisation_associated_with);
		carrer_profile_project.put("project_cast_associated_with", project_cast_associated_with);
		carrer_profile_project.put("project_website_link", project_website_link);
		carrer_profile_project.put("project_instgram_link", project_instgram_link);
		carrer_profile_project.put("project_facebook_link", project_facebook_link);
		carrer_profile_project.put("project_twitter_link", project_twitter_link);
		carrer_profile_project.put("project_other_link", project_other_link);
		carrer_profile_project.put("project_description", project_description);
		carrer_profile_project.put("project_name", project_name);
		carrer_profile_project.put("audio", audio);
		carrer_profile_project.put("video", video);
		carrer_profile_project.put("images", images);
		
		return carrer_profile_project;		
	}
	
	
	//add editing option to jsp pre-filled form
	public void edit_carrer_profile_project(Connection con, int user_id,int carrer_profile_project_id,String project_name,Date project_start_date,Date project_end_date,String project_organisation_associated_with,String project_cast_associated_with,String project_website_link,String project_instgram_link,String project_facebook_link,String project_twitter_link,String project_other_link,String project_description,HashMap carrer_profile_media)
	{
		
		// connect insta for instagram_followers etc..	
		ResultSet rs; 
		PreparedStatement pst;
		 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		
		try {
			
			
			pst=con.prepareStatement("update  carrer_profile_project set project_name=?,project_start_date=?,project_end_date=?, project_organisation_associated_with=?,project_cast_associated_with=?,project_website_link=?,project_instgram_link=?,project_facebook_link=?,project_twitter_link=?,project_other_link=?,project_description=? where e_id=? and carrer_profile_project_id=?");
			pst.setString(1, project_name);
			pst.setDate(2, new java.sql.Date( project_start_date.getTime()));
			pst.setDate(3, new java.sql.Date(project_end_date.getTime()));
			pst.setString(4, project_organisation_associated_with); // csv
			pst.setString(5, project_cast_associated_with);//csv
			pst.setString(6, project_website_link);
			pst.setString(7, project_instgram_link);
			pst.setString(8, project_facebook_link); 
			pst.setString(9, project_twitter_link);
			pst.setString(10, project_other_link); //csv
			pst.setString(11, project_description);
			pst.setInt(12, user_id);
			pst.setInt(13, carrer_profile_project_id);
			
			//pst=con.prepareStatement("update basic_profile set name=?,whatsapp_number=?,calling_number=?,email_id=?,website_link=?,instgram_link=?,facebook_link=?,twitter_link=?,other_link=?,about_us=?,plot_or_building_number=?,building_name=?,floor_number=?,street,locality=?,landmark=?,city=?,state=?,pincode=?,country=?,google_map_link=?,logo=?) where eid=? ");
			//create table database.carrer_profile_media( e_id integer, carrer_profile_id integer,carrer_profile_type String, media_id integer,media longblob,media_type varchar(20))
			
			if(!carrer_profile_media.isEmpty())
				add_carrer_profile_media(con, user_id,carrer_profile_project_id, "carrer_profile_project", carrer_profile_media);
				
				pst.execute();
				
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			// create carrer project profile detail image and store it 
		}  
		
		ArrayList<String> values=new ArrayList<String>();
		values.add(Integer.toString(user_id));
		values.add(Integer.toString(carrer_profile_project_id));
		values.add(project_name);
		values.add(dateFormat.format(project_start_date));
		values.add(dateFormat.format(project_end_date));
		values.add(project_organisation_associated_with);
		
		values.add(project_cast_associated_with);
		values.add(project_website_link);
		values.add(project_instgram_link);
		values.add(project_facebook_link);
		values.add(project_twitter_link);
		values.add(project_other_link);
		values.add(project_description);
		
		
		ArrayList<String> labels=new ArrayList<String>();
		labels.add("user_id");
		labels.add("carrer_profile_project_id");
		labels.add("project_name");
		labels.add("project_start_date");
		labels.add("project_end_date");
		labels.add("project_organisation_associated_with");
		
		labels.add("project_cast_associated_with");
		labels.add("project_website_link");
		labels.add("project_instgram_link");
		labels.add("project_facebook_link");
		labels.add("project_twitter_link");
		labels.add("project_other_link");
		labels.add("project_description");
		// create carrer project profile detail image and store it 
		make_snapshot_carrer_profile(values, labels, con, user_id);
			
	}
	
	
	
	public int carrer_profile_honor_award_id_generator(Connection con,int user_id)
	{
		String getUserId = "SELECT max(carrer_profile_honor_award_id) FROM carrer_profile_honor_award where e_id="+user_id;
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
	
	public void add_carrer_profile_honor_award(Connection con, int user_id,String honor_award_title,String honor_award_associated_with,String honor_award_issuer,Date honor_award_date,String honor_award_description,String honor_award_website_link,String honor_award_instgram_link,String honor_award_facebook_link,String honor_award_twitter_link,String honor_award_other_link,HashMap carrer_profile_honor_award_media)
	{	
		int carrer_profile_honor_award_id= carrer_profile_honor_award_id_generator(con,user_id);
		
		/*honor_award_title varchar(200), honor_award_associated_with varchar(3000), 
		 * honor_award_issuer varchar(200), honor_award_date date, honor_award_description varchar(3000),  
		 * honor_award_website_link varchar(255), honor_award_instgram_link varchar(255),
		 *  honor_award_facebook_link varchar(255), honor_award_twitter_link varchar(255), honor_award_other_link*/
		
		ResultSet rs; 
		PreparedStatement pst;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		
		
		try {
			
			pst=con.prepareStatement("insert into carrer_profile_honor_award (e_id,carrer_profile_honor_award_id,honor_award_title,honor_award_associated_with,honor_award_issuer,honor_award_date,honor_award_description,honor_award_website_link,honor_award_instgram_link,honor_award_facebook_link,honor_award_twitter_link,honor_award_other_link) values(?,?,?,?,?,?,?,?,?,?,?,?) ");
			pst.setInt(1, user_id);
			pst.setInt(2, carrer_profile_honor_award_id);
			pst.setString(3, honor_award_title);
			pst.setString(4, honor_award_associated_with);
			pst.setString(5, honor_award_issuer);
			pst.setDate(6, new java.sql.Date(honor_award_date.getTime()));
			pst.setString(7, honor_award_description); 
			pst.setString(8, honor_award_website_link);
			pst.setString(9, honor_award_instgram_link);
			pst.setString(10, honor_award_facebook_link);
			pst.setString(11, honor_award_twitter_link);
			pst.setString(12, honor_award_other_link);
			
			if(!carrer_profile_honor_award_media.isEmpty())
			add_carrer_profile_media(con, user_id,carrer_profile_honor_award_id, "carrer_profile_honor_award", carrer_profile_honor_award_media);
			
			pst.execute();
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			
			ArrayList<String> values=new ArrayList<String>();
			values.add(Integer.toString(user_id));
			values.add(Integer.toString(carrer_profile_honor_award_id));
			values.add(honor_award_title);
			values.add(honor_award_associated_with);
			values.add(dateFormat.format(honor_award_date));
			values.add(honor_award_issuer);
			values.add(honor_award_description); 
			values.add(honor_award_website_link);
			values.add(honor_award_instgram_link);
			values.add(honor_award_facebook_link);
			values.add(honor_award_twitter_link);
			values.add(honor_award_other_link);

			
			
			ArrayList<String> labels=new ArrayList<String>();
			labels.add("user_id");
			labels.add("carrer_profile_honor_award_id");
			labels.add("honor_award_title");
			labels.add("honor_award_associated_with");
			labels.add("honor_award_date");
			labels.add("honor_award_issuer");
			labels.add("honor_award_description"); 
			labels.add("honor_award_website_link");
			labels.add("honor_award_instgram_link");
			labels.add("honor_award_facebook_link");
			labels.add("honor_award_twitter_link");
			labels.add("honor_award_other_link");
			// create carrer project profile detail image and store it 
			make_snapshot_honor_award(values, labels, con, user_id);
			
			//create carrer honour and award profile detail image and store it
		
			
	}
	
	
	
	public Map get_carrer_profile_honor_award(Connection con, int user_id,int carrer_profile_honor_award_id)
	{	
		
		/*honor_award_title varchar(200), honor_award_associated_with varchar(3000), 
		 * honor_award_issuer varchar(200), honor_award_date date, honor_award_description varchar(3000),  
		 * honor_award_website_link varchar(255), honor_award_instgram_link varchar(255),
		 *  honor_award_facebook_link varchar(255), honor_award_twitter_link varchar(255), honor_award_other_link*/
	
		  String honor_award_title = null,  honor_award_associated_with = null,  honor_award_issuer = null, honor_award_website_link = null,  honor_award_instgram_link = null,  honor_award_facebook_link = null,  honor_award_twitter_link = null,  honor_award_other_link = null,honor_award_description = null;
		  Blob[] carrer_profile_honor_award_audio = null,carrer_profile_honor_award_video = null, carrer_profile_honor_award_images = null;
		  Date honor_award_date = null;
		  ArrayList<Object> audio= new ArrayList<Object>();
		  ArrayList<Object> video= new ArrayList<Object>();
		  ArrayList<Object> images= new ArrayList<Object>();
		  Map carrer_profile_honor_award = new HashMap();
		  
		  ResultSet rs; 
		  PreparedStatement pst;
		
		try {
			pst=con.prepareStatement("select honor_award_title,honor_award_associated_with,honor_award_issuer,honor_award_date,honor_award_description,honor_award_website_link,honor_award_instgram_link,honor_award_facebook_link,honor_award_twitter_link,honor_award_other_link from carrer_profile_honor_award  where e_id=? and  carrer_profile_honor_award_id=?");
			pst.setInt(1, user_id);
			pst.setInt(2, carrer_profile_honor_award_id);
			rs=pst.executeQuery();
			while(rs.next())  
			{
				honor_award_title=rs.getString(1);
				honor_award_associated_with=rs.getString(2);
				honor_award_issuer=rs.getString(3);
				honor_award_date=rs.getDate(4);
				honor_award_description=rs.getString(5); 
				honor_award_website_link=rs.getString(6);
				honor_award_instgram_link=rs.getString(7);
				honor_award_facebook_link=rs.getString(8);
				honor_award_twitter_link=rs.getString(9);
				honor_award_other_link=rs.getString(10);
			}
						
			
			audio=get_carrer_profile_media(con,user_id,carrer_profile_honor_award_id,"carrer_profile_honor_award","audio");
			video=get_carrer_profile_media(con,user_id,carrer_profile_honor_award_id,"carrer_profile_honor_award","video");
			images=get_carrer_profile_media(con,user_id,carrer_profile_honor_award_id,"carrer_profile_honor_award","images");
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		carrer_profile_honor_award.put("honor_award_title", honor_award_title);
		carrer_profile_honor_award.put("honor_award_associated_with", honor_award_associated_with);
		carrer_profile_honor_award.put("honor_award_issuer", honor_award_issuer);
		carrer_profile_honor_award.put("honor_award_description", honor_award_description);
		carrer_profile_honor_award.put("honor_award_website_link", honor_award_website_link);
		carrer_profile_honor_award.put("honor_award_instgram_link", honor_award_instgram_link);
		carrer_profile_honor_award.put("honor_award_facebook_link", honor_award_facebook_link);
		carrer_profile_honor_award.put("honor_award_twitter_link", honor_award_twitter_link);
		carrer_profile_honor_award.put("honor_award_other_link", honor_award_other_link);
		carrer_profile_honor_award.put("audio", audio);
		carrer_profile_honor_award.put("video", video);
		carrer_profile_honor_award.put("images", images);
		
		return carrer_profile_honor_award;
	}
	
	
	public void edit_carrer_profile_honor_award(Connection con, int user_id, int carrer_profile_honor_award_id,String honor_award_title,String honor_award_associated_with,String honor_award_issuer,Date honor_award_date,String honor_award_description,String honor_award_website_link,String honor_award_instgram_link,String honor_award_facebook_link,String honor_award_twitter_link,String honor_award_other_link,HashMap carrer_profile_media)
	{	
		ResultSet rs; 
		PreparedStatement pst;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
		
		
		try {
		
			pst=con.prepareStatement("update  carrer_profile_honor_award set honor_award_title=?,honor_award_associated_with=?,honor_award_issuer=?,honor_award_date=?,honor_award_description=?,honor_award_website_link=?,honor_award_instgram_link=?,honor_award_facebook_link=?,honor_award_twitter_link=?,honor_award_other_link=? where e_id=? and carrer_profile_honor_award_id=?");

			pst.setString(1, honor_award_title);
			pst.setString(2, honor_award_associated_with);
			pst.setString(3, honor_award_issuer);
			pst.setDate(4, new java.sql.Date(honor_award_date.getTime()));
			pst.setString(5, honor_award_description);
			pst.setString(6, honor_award_website_link);
			pst.setString(7, honor_award_instgram_link);
			pst.setString(8, honor_award_facebook_link);
			pst.setString(9, honor_award_twitter_link);
			pst.setString(10, honor_award_other_link);
			pst.setInt(11, user_id);
			pst.setInt(12, carrer_profile_honor_award_id);
			
			if(!carrer_profile_media.isEmpty())
			add_carrer_profile_media(con, user_id, carrer_profile_honor_award_id, "carrer_profile_honor_award", carrer_profile_media);

			pst.executeUpdate();
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
			// edit carrer honor_and_award profile detail image and store it 
		}  
		ArrayList<String> values=new ArrayList<String>();
		values.add(Integer.toString(user_id));
		values.add(Integer.toString(carrer_profile_honor_award_id));
		values.add(honor_award_title);
		values.add(honor_award_associated_with);
		values.add(dateFormat.format(honor_award_date));
		values.add(honor_award_issuer);
		values.add(honor_award_description); 
		values.add(honor_award_website_link);
		values.add(honor_award_instgram_link);
		values.add(honor_award_facebook_link);
		values.add(honor_award_twitter_link);
		values.add(honor_award_other_link);

		
		
		ArrayList<String> labels=new ArrayList<String>();
		labels.add("user_id");
		labels.add("carrer_profile_honor_award_id");
		labels.add("honor_award_title");
		labels.add("honor_award_associated_with");
		labels.add("honor_award_date");
		labels.add("honor_award_issuer");
		labels.add("honor_award_description"); 
		labels.add("honor_award_website_link");
		labels.add("honor_award_instgram_link");
		labels.add("honor_award_facebook_link");
		labels.add("honor_award_twitter_link");
		labels.add("honor_award_other_link");
		// create carrer project profile detail image and store it 
		make_snapshot_honor_award(values, labels, con, user_id);
			
	}
	
	public int carrer_profile_organisation_associated_with_id_generator(Connection con,int user_id)
	{
		String getUserId = "SELECT max(organisation_associated_with_id) FROM carrer_profile_organisation_associated_with where e_id="+user_id;
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
	
	public void make_snapshot_organisation_associated_with(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
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
        String str="update carrer_profile set carrer_profile_organisation_with_detail_image=? where e_id=?";
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
	
	public void make_snapshot_carrer_profile(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
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
        String str="update carrer_profile set carrer_profile_project_detail_image=? where e_id=?";
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
	
	public void make_snapshot_honor_award(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
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
        String str="update carrer_profile set carrer_profile_honor_award_detail_image=? where e_id=?";
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
	
	public void make_snapshot_office_image(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
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
        String str="update office_profile set office_profile_detail_image=? where e_id=?";
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
	
	public void make_snapshot_basic_profile_image(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
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
        String str="update basic_profile set baisc_profile_detail_image=? where e_id=?";
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
	
	public void add_carrer_profile_organisation_associated_with(Connection con, int user_id,String organisation_associated_with_name,String organisation_associated_with_position,Date organisation_associated_with_start_date, Date organisation_associated_with_end_date,String organisation_associated_with_description)
	{
		int carrer_profile_organisation_associated_with_id= carrer_profile_organisation_associated_with_id_generator(con,user_id);
		
		/*carrer_profile_organisation_associated_with(e_id integer, organisation_associated_with_id integer, 
		organisation_associated_with_name varchar(200), organisation_associated_with_position varchar(200), 
		organisation_associated_with_start_date date, organisation_associated_with_end_date date, 
		organisation_associated_with_description varchar(3000))*/
		
		ResultSet rs; 
		PreparedStatement pst;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
        
		try {
			
			pst=con.prepareStatement("insert into carrer_profile_organisation_associated_with (e_id,organisation_associated_with_id,organisation_associated_with_name,organisation_associated_with_position,organisation_associated_with_start_date,organisation_associated_with_end_date,organisation_associated_with_description) values(?,?,?,?,?,?,?) ");
			pst.setInt(1, user_id);
			pst.setInt(2, carrer_profile_organisation_associated_with_id);
			pst.setString(3, organisation_associated_with_name);
			pst.setString(4, organisation_associated_with_position);
			pst.setDate(5, new java.sql.Date( organisation_associated_with_start_date.getTime()));
			pst.setDate(6, new java.sql.Date(organisation_associated_with_end_date.getTime()));
			pst.setString(7, organisation_associated_with_description);
			
			pst.execute();
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			ArrayList<String> values=new ArrayList<String>();
			values.add(Integer.toString(user_id));
			values.add(Integer.toString(carrer_profile_organisation_associated_with_id));
			values.add(organisation_associated_with_name);
			values.add(organisation_associated_with_position);
			values.add(dateFormat.format(organisation_associated_with_start_date));
			values.add(dateFormat.format(organisation_associated_with_end_date));
			values.add(organisation_associated_with_description);
			
			ArrayList<String> labels=new ArrayList<String>();
			labels.add("user Id");
			labels.add("organisation_associated_with_id");
			labels.add("organisation_associated_with_name");
			labels.add("organisation_associated_with_position");
			labels.add("organisation_associated_with_start_date");
			labels.add("organisation_associated_with_end_date");
			labels.add("organisation_associated_with_description");
			
			//create carrer organisation associated with profile detail image and store it
			make_snapshot_organisation_associated_with(values, labels, con, user_id);
			
			
		}  
			
	}
	

	public Map get_carrer_profile_organisation_associated_with(Connection con, int user_id,int carrer_profile_organisation_associated_with_id)
	{		
		ResultSet rs; 
		PreparedStatement pst;
		String organisation_associated_with_name = null, organisation_associated_with_position = null, organisation_associated_with_description = null;
		Date organisation_associated_with_start_date = null, organisation_associated_with_end_date = null;	
		Map carrer_profile_organisation_associated_with = new HashMap();
	
	try {
		pst=con.prepareStatement("select organisation_associated_with_name,organisation_associated_with_position,organisation_associated_with_start_date,organisation_associated_with_end_date,organisation_associated_with_description from carrer_profile_organisation_associated_with where e_id=? and organisation_associated_with_id=?");
		pst.setInt(1,user_id);
		pst.setInt(2, carrer_profile_organisation_associated_with_id);
		rs=pst.executeQuery();
		while(rs.next())  
		{
			organisation_associated_with_name=rs.getString(1);
			organisation_associated_with_position=rs.getString(2);
			organisation_associated_with_start_date=rs.getDate(3);
			organisation_associated_with_end_date=rs.getDate(4); 
			organisation_associated_with_description=rs.getString(5);	
		}	
	
		}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	
		carrer_profile_organisation_associated_with.put("organisation_associated_with_name", organisation_associated_with_name);
		carrer_profile_organisation_associated_with.put("organisation_associated_with_position", organisation_associated_with_position);
		carrer_profile_organisation_associated_with.put("organisation_associated_with_start_date", organisation_associated_with_start_date);
		carrer_profile_organisation_associated_with.put("organisation_associated_with_end_date", organisation_associated_with_end_date);
		carrer_profile_organisation_associated_with.put("organisation_associated_with_description", organisation_associated_with_description);
		
		return carrer_profile_organisation_associated_with;

	}  
				
	
	public void edit_carrer_profile_organisation_associated_with(Connection con, int user_id,int carrer_profile_organisation_associated_with_id,String organisation_associated_with_name,String organisation_associated_with_position,Date organisation_associated_with_start_date, Date organisation_associated_with_end_date,String organisation_associated_with_description)
	{		
	
		ResultSet rs; 
		PreparedStatement pst;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
	
		try {
			
			pst=con.prepareStatement("update  carrer_profile_organisation_associated_with set organisation_associated_with_name=?,organisation_associated_with_position=?,organisation_associated_with_start_date=?,organisation_associated_with_end_date=?,organisation_associated_with_description=? where e_id=? and organisation_associated_with_id=?");
			pst.setString(1, organisation_associated_with_name);
			pst.setString(2, organisation_associated_with_position);
			pst.setDate(3, new java.sql.Date( organisation_associated_with_start_date.getTime()));
			pst.setDate(4, new java.sql.Date(organisation_associated_with_end_date.getTime())); 
			pst.setString(5, organisation_associated_with_description);
			pst.setInt(6,user_id);
			pst.setInt(7, carrer_profile_organisation_associated_with_id);
			
			pst.executeUpdate();
			
			}catch (SQLException e)
			{
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		ArrayList<String> values=new ArrayList<String>();
		values.add(Integer.toString(user_id));
		values.add(Integer.toString(carrer_profile_organisation_associated_with_id));
		values.add(organisation_associated_with_name);
		values.add(organisation_associated_with_position);
		values.add(dateFormat.format(organisation_associated_with_start_date));
		values.add(dateFormat.format(organisation_associated_with_end_date));
		values.add(organisation_associated_with_description);
		
		ArrayList<String> labels=new ArrayList<String>();
		labels.add("user Id");
		labels.add("organisation_associated_with_id");
		labels.add("organisation_associated_with_name");
		labels.add("organisation_associated_with_position");
		labels.add("organisation_associated_with_start_date");
		labels.add("organisation_associated_with_end_date");
		labels.add("organisation_associated_with_description");
		
		//create carrer organisation associated with profile detail image and store it
		make_snapshot_organisation_associated_with(values, labels, con, user_id);
		
	}
				
	
	public int talent_profile_media_id_generator(Connection con,int user_id,String upload_type)
	{
		String getUserId = "SELECT max(media_id) FROM talent_profile_media where e_id="+user_id+" and media_type="+upload_type;
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
public void add_talent_profile(Connection con, int user_id,String upload_type, Blob[] uploaded_media, String media_description)
{
	ResultSet rs; 
	PreparedStatement pst;

	
try {
		
		for(int ctr=0; ctr<uploaded_media.length;ctr++)
		{
			pst=con.prepareStatement("insert into talent_profile_media (e_id,media_id,media,media_type,media_description) values(?,?,?,?,?)");
			pst.setInt(1, user_id);
			pst.setInt(2, talent_profile_media_id_generator(con,user_id,upload_type));
			pst.setBlob(3, uploaded_media[ctr]);
			pst.setString(4, upload_type);
			pst.setString(5, media_description);
		}
	}	
				
	catch (SQLException e) 		{
		// TODO Auto-generated catch block
		e.printStackTrace()	;	}  	
}

	
	public void delete_talent_profile_media(Connection con, int user_id,String type,int[] talent_profile_media_id)
	{
		ResultSet rs; 
		PreparedStatement pst;
		//create table database.talent_profile_media(e_id integer, media_id integer, media longblob, media_type varchar(20))
		try
		{
			
				for(int ctr=0;ctr<talent_profile_media_id.length;ctr++)
				{
					pst=con.prepareStatement("delete from talent_profile_media where e_id=? and media_id=? and media_type=? ");
					pst.setInt(1,user_id);
					pst.setInt(2,talent_profile_media_id[ctr]);		
					pst.setString(2,type);		
					rs=pst.executeQuery();
				}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	
	public Map get_basic_profile_detail(Connection con, int user_id)
	{
		int public_whatsapp_number=0, public_calling_number=0,private_calling_number=0,private_whatsapp_number=0;
		String  first_name=null,last_name=null,public_email_id=null,gender=null,home_town=null,current_location=null,indian_nationality=null, foreigner_nationality=null, about_me=null,private_email_id=null;
		Date dob=null;
		ArrayList<String> type_of_profile=null,body_attributes=null;
		Map basic_profile_detail = new HashMap();
		//for height,wieght,etc
		ArrayList<Integer> fixed_body_attr=null;
		
		ResultSet rs; 
		PreparedStatement pst;
		
		try {
			
			pst=con.prepareStatement("select first_name,last_name,public_whatsapp_number,public_calling_number,public_email_id,private_whatsapp_number,private_calling_number,private_email_id,dob,gender,home_town,current_location,indian_nationality,foreigner_nationality,about_me from basic_profile where e_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				first_name= rs.getString(1);
				last_name= rs.getString(2);
				public_whatsapp_number= rs.getInt(3);
				public_calling_number= rs.getInt(4);
				public_email_id= rs.getString(5);
				private_whatsapp_number= rs.getInt(6);
				private_calling_number= rs.getInt(7);
				private_email_id= rs.getString(8);
				dob= rs.getDate(9);
				gender= rs.getString(10);
				home_town= rs.getString(11);
				current_location= rs.getString(12);
				indian_nationality= rs.getString(13);
				foreigner_nationality= rs.getString(14);
				about_me = rs.getString(15);
			}
	
			type_of_profile=get_type_of_profile(con, user_id);	
			body_attributes=get_body_attributes(con, user_id);	
			fixed_body_attr=get_fixed_body_attributes_values(con, user_id);
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
		basic_profile_detail.put("first_name", first_name);
		basic_profile_detail.put("last_name", last_name);
		basic_profile_detail.put("public_whatsapp_number", public_whatsapp_number);
		basic_profile_detail.put("public_calling_number", public_calling_number);
		basic_profile_detail.put("public_email_id", public_email_id);
		basic_profile_detail.put("private_whatsapp_number", private_whatsapp_number);
		basic_profile_detail.put("private_calling_number", private_calling_number);
		basic_profile_detail.put("private_email_id", private_email_id);
		basic_profile_detail.put("dob", dob);
		basic_profile_detail.put("gender", gender);
		basic_profile_detail.put("home_town", home_town);
		basic_profile_detail.put("current_location", current_location);
		basic_profile_detail.put("indian_nationality", indian_nationality);
		basic_profile_detail.put("foreigner_nationality", foreigner_nationality);
		basic_profile_detail.put("about_me", about_me);	
		basic_profile_detail.put("type_of_profile", type_of_profile);
		basic_profile_detail.put("body_attributes", body_attributes);
		basic_profile_detail.put("body_fixed_attributes", fixed_body_attr);
		
		return basic_profile_detail;
			
	}
	
	
	public HashMap get_office_profile_detail(Connection con, int user_id,int office_id)
	{
		ResultSet rs; 
		PreparedStatement pst;
	
		int whatsapp_number=0, calling_number=0,plot_or_building_number=0,pincode=0,floor_number=0;
		String email_id=null, website_link=null, instgram_link=null, facebook_link=null, twitter_link=null,name=null,other_link=null, about_us=null,building_name=null, street=null, locality=null, landmark=null, city=null, state=null,country=null,google_map_link=null;
		Blob logo=null;
		
		HashMap basic_profile_detail = new HashMap();
			// check communication_profile_photo longblob in office_profile  table
		try {
			
			pst=con.prepareStatement("select _name,whatsapp_number,calling_number,email_id,website_link,instgram_link,facebook_link,twitter_link,other_link,about_us,plot_or_building_number,building_name,floor_number,street,locality,landmark,city,state,pincode,country,google_map_link,logo from office_profile where e_id=? and office_id=?");
			pst.setInt(1,user_id);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				name= rs.getString(1);
				whatsapp_number= rs.getInt(2);
				calling_number= rs.getInt(3);
				email_id= rs.getString(4);
				website_link= rs.getString(5);
				instgram_link= rs.getString(6);
				facebook_link= rs.getString(7);
				twitter_link= rs.getString(8);
				other_link= rs.getString(9);
				about_us= rs.getString(10);
				plot_or_building_number= rs.getInt(11);
				building_name= rs.getString(12);
				floor_number= rs.getInt(13);
				street= rs.getString(14);
				locality= rs.getString(15);
				landmark= rs.getString(16);
				city= rs.getString(17);
				state= rs.getString(18);
				pincode= rs.getInt(19);
				country= rs.getString(20);
				google_map_link= rs.getString(21);
				logo= rs.getBlob(22);
				//office_id=rs.getInt(25);
			}
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
		}
		basic_profile_detail.put("name", name);
		basic_profile_detail.put("whatsapp_number", whatsapp_number);
		basic_profile_detail.put("calling_number", calling_number);
		basic_profile_detail.put("email_id", email_id);
		basic_profile_detail.put("website_link", website_link);
		basic_profile_detail.put("instgram_link", instgram_link);
		basic_profile_detail.put("facebook_link", facebook_link);
		basic_profile_detail.put("twitter_link", twitter_link);
		basic_profile_detail.put("other_link", other_link);
		basic_profile_detail.put("about_us", about_us);
		basic_profile_detail.put("plot_or_building_number", plot_or_building_number);
		basic_profile_detail.put("building_name", building_name);
		basic_profile_detail.put("floor_number", floor_number);
		basic_profile_detail.put("locality", locality);
		basic_profile_detail.put("landmark", landmark);
		basic_profile_detail.put("city", city);
		basic_profile_detail.put("state", state);
		basic_profile_detail.put("pincode", pincode);
		basic_profile_detail.put("country", country);
		basic_profile_detail.put("google_map_link", google_map_link);
		basic_profile_detail.put("logo", logo);
		
		return basic_profile_detail;
	}
	
	
	public String get_type_of_entity(String type_of_profile)
	{
		//type_of_profile is coming from user after selection from all possible profiles
		String type_of_entity=null;
	
		//if(type_of_profile.equals("executive_producer")||type_of_profile.equals("line_producer")||type_of_profile.equals("supervising_producer")||type_of_profile.equals("co_producer")||type_of_profile.equals("co_ordinating_producer")||type_of_profile.equals("primary_associate_or_assistant_producer ")||type_of_profile.equals("secondary_associate_or_assistant_producer")||type_of_profile.equals("other_associate_or_assistant_producer")||type_of_profile.equals("segment_producer")||type_of_profile.equals("event_producer")|type_of_profile.equals("music_producer"))
		if(type_of_profile.contains("producer"))
		{
			type_of_entity="Producer";
			return type_of_entity;
		}
		//film_director varchar(10), primary_associate_film_director varchar(10), secondary_associate_film_director varchar(10), other_associate_film_director varchar(10), casting_director varchar(10), primary_associate_casting_director varchar(10),secondary_associate_casting_director varchar(10),other_associate_casting_director varchar(10), music_director varchar(10),primary_associate_music_director varchar(10),secondary_associate_music_director varchar(10), other_associate_music_director varchar(10),
		else if(type_of_profile.contains("director"))
		{
			type_of_entity="Director";
			return type_of_entity;
		}
		else if(type_of_profile.equals("Academy"))
		{
			type_of_entity="Academy";
			return type_of_entity;
		}
		// FLAW 
		else if(type_of_profile.equals("actor")||type_of_profile.equals("model")||type_of_profile.equals("dancer")||type_of_profile.equals(" singer")||type_of_profile.equals(" insrumentalist")||type_of_profile.equals("composer")||type_of_profile.equals("music_engineer")||type_of_profile.equals("radio_or_voice_over")||type_of_profile.equals(" dj")||type_of_profile.equals("band")||type_of_profile.equals("stand_up_comedian")||type_of_profile.equals("other_type_of_entity"))
		{
			type_of_entity="Entertainer";
			return type_of_entity;
		}
		else
		//if(type_of_profile.equals("Film_crew"))
		{
			type_of_entity="Film_crew";
			return type_of_entity;
		}
				//return type_of_entity;
	}
	
	public void edit_talent_profile_media_description(Connection con, int user_id,String type,int talent_profile_media_id,String media_description)
	{
		ResultSet rs; 
		PreparedStatement pst;
		//create table database.talent_profile_media(e_id integer, media_id integer, media longblob, media_type varchar(20))
		try
		{
					pst=con.prepareStatement("update talent_profile_media set media_description=? where e_id=? and audio_id=? and media_type=? ");
					pst.setString(1,media_description);
					pst.setInt(2,user_id);
					pst.setInt(3,talent_profile_media_id);		
					pst.setString(4,type);		
					rs=pst.executeQuery();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add_profile_image(Connection con, int user_id,Blob profile_image)
	{
		
		ResultSet rs; 
		PreparedStatement pst;
		try {
			
		
			pst=con.prepareStatement("update basic_profile set personal_profile_photo=? where e_id=?");
			pst.setInt(1,user_id);
			pst.setBlob(2,profile_image);
			
			rs=pst.executeQuery();
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
		
	}
	public void delete_profile_image(Connection con, int user_id)
	{
		
		ResultSet rs; 
		PreparedStatement pst;
		try {
			
		
			pst=con.prepareStatement("delete personal_profile_photo from basic_profile where e_id=?");
			pst.setInt(1,user_id);
			rs=pst.executeQuery();
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
		
	}
	
	public void make_default(Connection con)
	{
		
		String body_attributes_non_numeric[]= {"feature_film  "," short_film  "," web_series  "," tv_series  "," documentary_series  "," movie_commercial  "," tv_commercial  "," web_commercial  "," music_album_or_video  "," theatre_or_musical_or_stage_shows  "," stand_up_comedy_event  "," fashion_or_style_or_beauty_event  "," lifestyle_event  "," food_event  "," fitness_event  "," health_event  "," travel_event  "," gaming_or_tech_event  "," cultural_or_social_event  "," wedding_event  "," party_event  "," magazine_photoshoot_event  "," billboard_photoshoot_event  "," campaign_photoshoot_event  "," booklets_photoshoot_event  "," flyers_photoshoot_event  "," posters_photoshoot_event  "," other_photoshoot_event  "," glitz_modelling_event  "," semi_glitz_modelling_event  "," natural_modelling_event  "," other_modelling_event  "," acting_competition_event  "," dance_competition_event  "," music_competition_event  "," other_competition_event  "," other_event"};
		//String body_attributes_numeric[]= {" height  "," weight  "," hips  "," waist  "," shoulders  "," chest_or_bust  "};
		for(int i=0;i<body_attributes_non_numeric.length;i++)
		{
			String query1= "ALTER TABLE project_post ALTER column " +body_attributes_non_numeric[i]+  " SET DEFAULT 'No' ";
			
			boolean rs; 
			PreparedStatement pst;
			
			try
			{
						pst=con.prepareStatement(query1);	
						pst.execute();
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
			

	}
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		profile p=new profile();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		   //3306 is port no of mysql
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","saksham026");
		
		java.util.Date myDate = new java.util.Date("01/01/2009");
		HashMap m=new HashMap();
		//java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		//System.out.println(sqlDate);
		//p.edit_carrer_profile_project(con, 1,1, "try1", myDate, myDate, "face1,face2,face3", "abc", "wl", "il", "fl","tl", "ol", "desc",m );//empty map to be done by jsp
		//m=(HashMap) p.get_carrer_profile_project_detail(con,1, 1);
		
		
		//*************to add in jsp while retreiving empty arraylist of audio,video 
		/*ArrayList a=new ArrayList();
		a=(ArrayList) m.get("audio");
		
		if(!a.isEmpty())
		System.out.println(m.get("audio").toString());
		 */
		
		String mt[]=new String[] {"audio","video"};
		
		//p.delete_carrer_profile_project(con,1,1,"carrer_profile_project",mt);
		//p.add_carrer_profile_honor_award(con, 2, "abcdvgv", "we,rt", "ertt", myDate, "wert", "fdch", "gvjh", "fjvj", "xytu", "ftcfghj", m);
		
		//m=(HashMap) p.get_carrer_profile_honor_award(con, 2, 1);
		
		
		//p.delete_carrer_profile_honor_award(con, 2, 1, null, mt);
		
		
		/*p.edit_carrer_profile_organisation_associated_with(con,2,1, "sss", "vhj", myDate, myDate, "hj");
		p.get_carrer_profile_organisation_associated_with(con, 2, 1);
		
		p.delete_carrer_profile_organisation_associated_with(con, 2, 1);*/
		
		//p.add_office_profile(con, 1, "sghvhg",1187278, 27359, "s@mb", "sbsk.com", "il", "fl", "tl", "other", "abjdk", 5, "skbsk", 3,"street", "locality","lmark", "city", "stte", 123, "india","gmaplink", null);
		//m=(HashMap) p.get_office_profile_detail(con, 1);
		
		
		//System.out.println(m.get("city").toString());
		
		
		//p.edit_office_profile(con, user_id, name, whatsapp_number, calling_number, email_id, website_link, instgram_link, facebook_link, twitter_link, other_link, about_us, plot_or_building_number, building_name, floor_number, street, locality, landmark, city, state, pincode, country, google_map_link, logo);
		
		String mt1[]=new String[] {"singer","dancer"};
		String bd1[]=new String[] {"fair","height:6"};
		
		
		//p.edit_basic_profile(con, 1, "fn", "ln", 1234567859, 17891, "s@hbk", 4536, 74889, "shjs@h", myDate, "m", "ss", "loc", "india", "for", "sss", mt1, bd1);
		//p.get_basic_profile_detail(con, 1);
		
		int[] a= {1};
		
		//p.delete_office_profile(con,1,a);
		//p.make_default(con);
		
		//to check
		//p.post_detail_image(con, 1,2,"investment_project_post","delete");
		
		int[] post_id= {2};
		Blob up[]= {null};
		ArrayList<Object> aa=new ArrayList<Object>();
		
		String[] type= {"class_promotional_post"};
		
		aa=p.post_detail_image(con, 1, post_id, type, "delete");
		System.out.println(aa);
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

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.imageio.ImageIO;

import face1.profile.*;

public class post extends profile{
	
	
	public String[] get_post_options(String type_of_profile)
	{
	
		String type_of_entity= get_type_of_entity(type_of_profile);
		
		String[] post_options=null;
		
		if(type_of_entity.equals("Producer"))
		{
			post_options = new String[]{"Collaboration", "Artist" , "Promotion"};
			return post_options;
		}
		else if(type_of_entity.equals("Director"))
		{
			post_options = new String[]{"Investment","Collaboration", "Artist" , "Promotion"};
			return post_options;
		}
		else if(type_of_entity.equals("Film_crew"))
		{
			post_options = new String[]{"Collaboration", "Investment" , "Promotion"};
			return post_options;
		}
	
		else if(type_of_entity.equals("Entertainer"))
		{
			post_options = new String[]{"Collaboration", "Investment" , "Promotion"};
			return post_options;
		}
		else if(type_of_entity.equals("Academy"))
		{
			post_options = new String[]{"Investment","Collaboration", "Artist" , "Promotion"};
			return post_options;
		}
		return post_options;

	}
	

	//String Connection con, int user_id, 
	//String type_of_profile, int male_number, int female_number,int transgender_number, int other_number_gender, String home_town, String current_location, String type_of_nationality,String type_of_skin_tone,String type_of_hair, String volume_of_hair, String type_of_eyes, int height_min, int height_max, int weight_min, int weight_max, int hips_min , int hips_max, int waist_min , int  waist_max , int shoulders_min ,int shoulders_max ,int chest_min , int chest_max , int bust_min ,int bust_max , String type_of_body, String type_of_appearance,  
	//Date online_audition_end_date , DateTime online_audition_end_time , String online_audition_script , Date offline_audition_start_date , Date offline_audition_end_date , Datetime offline_audition_start_time ,Datetime offline_audition_end_time , String offline_audition_script, 
	//Blob[] sample_product_video,Blob[] sample_product_audio , Blob[] sample_product_image, String sample_product_text)
	// feature_film varchar(10), short_film varchar(10), web_series varchar(10), tv_series varchar(10), documentary_series varchar(10), movie_commercial varchar(10), tv_commercial varchar(10), web_commercial varchar(10), music_album_or_video varchar(10), theatre_or_musical_or_stage_shows varchar(10), stand_up_comedy_event varchar(10), fashion_or_style_or_beauty_event varchar(10), lifestyle_event varchar(10), food_event varchar(10), fitness_event varchar(10), health_event varchar(10), travel_event varchar(10), gaming_or_tech_event varchar(10), cultural_or_social_event varchar(10), wedding_event varchar(10), party_event varchar(10), magazine_photoshoot_event varchar(10), billboard_photoshoot_event varchar(10), campaign_photoshoot_event varchar(10), booklets_photoshoot_event varchar(10), flyers_photoshoot_event varchar(10), posters_photoshoot_event varchar(10), other_photoshoot_event varchar(10), glitz_modelling_event varchar(10), semi_glitz_modelling_event varchar(10), natural_modelling_event varchar(10), other_modelling_event varchar(10), acting_competition_event varchar(10), dance_competition_event varchar(10), music_competition_event varchar(10), other_competition_event varchar(10), other_event varchar(30),
	public void make_snapshot_project_post_detail_image(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
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
        String str="update project_post set project_post_detail_image=? where e_id=?";
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
	
	public void make_snapshot_promotional_post_detail_image(ArrayList<String> details,ArrayList<String> labels,Connection con,int e_id)
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
        String str="update promotional_post set promotional_post_detail_image=? where e_id=?";
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
	
	
	public int add_project_post_details(Connection con, int user_id,String type_of_post,String type_of_project,String project_name,String organiser_name,String language_of_project,String shoot_location,Date shoot_start_date, Date shoot_end_date, Date  shoot_time,double budget_min_value,double budget_max_value,String other_means_of_budget,String note, String purpose,String purpose_value)
	{
		
		int post_id;
		if (type_of_post.equals("investment"))
		{
			post_id = post_id_generator(con,user_id,type_of_post);
		}
		else if(type_of_post.equals("collaboration"))
		{
			post_id = post_id_generator(con,user_id,type_of_post);
		}
		else 
		{
			post_id = post_id_generator(con,user_id,type_of_post);
		}

		ResultSet rs; 
		PreparedStatement pst;
		
		try
		{
			pst=con.prepareStatement("insert into project_post (e_id, project_post_id,type_of_post,project_name,organiser_name,language_of_project,shoot_location,shoot_start_date,shoot_end_date,shoot_time,budget_min_value,budget_max_value,other_means_of_budget,note,"+purpose+") values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setInt(1,user_id);
			pst.setInt(2,post_id);
			pst.setString(3,type_of_post);
			pst.setString(4,project_name);
			pst.setString(5,organiser_name);
			pst.setString(6,language_of_project);
			pst.setString(7,shoot_location);
			pst.setDate(8,(java.sql.Date) shoot_start_date);
			pst.setDate(9,(java.sql.Date)shoot_end_date);
			pst.setDate(10,(java.sql.Date)shoot_time);
			pst.setDouble(11,budget_min_value);
			pst.setDouble(12,budget_max_value);
			pst.setString(13,other_means_of_budget);
			pst.setString(14,note);
			pst.setString(15, purpose_value);
			pst.execute();
			
			// match purpose with coloumn name  and put its value as yes
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			Date dateobj = new Date();
			//System.out.println(df.format(dateobj));
			
			pst=con.prepareStatement("insert into all_post (e_id,post_id,type_of_post,date_of_post) values(?,?,?,curdate())");
			pst.setInt(1,user_id);
			pst.setInt(2,post_id);
			pst.setString(3,type_of_post);
			//pst.setDate(4,new java.sql.Date( ));
			
			pst.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//create project image and store in db
		//make_snapshot_project_post_detail_image(null, null, con, post_id);
		return post_id;
	}
	
	public int post_id_generator(Connection con,int user_id, String type_of_posts) {
		String getUserId = "SELECT max(post_id) FROM all_post where e_id="+user_id+" and type_of_post='"+type_of_posts+"'";
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

	public int promotional_post_id_generator(Connection con,int user_id, String type_of_posts) {
		String getUserId = "SELECT max(promotional_post_id) FROM promotional_post where e_id="+user_id+" and type_of_post='"+type_of_posts+"'";
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

	public void edit_project_post_details(Connection con, int user_id,int post_id,String type_of_post,String project_name,String organiser_name,String language_of_project,String shoot_location,Date shoot_start_date, Date shoot_end_date, Date  shoot_time,double budget_min_value,double budget_max_value,String other_means_of_budget,String note, String purpose,String purpose_value)
	{

		ResultSet rs; 
		PreparedStatement pst;
		String old_purpose=get_purpose_of_project_post(con,user_id,post_id,type_of_post);
		//System.out.println(old_purpose);
		try
		{
			String str="update project_post set project_name=?,organiser_name=?,language_of_project=?,shoot_location=?,shoot_start_date=?,shoot_end_date=?,shoot_time=?,budget_min_value=?,budget_max_value=?,other_means_of_budget=?,note=?,"+old_purpose+"='No',"+purpose+"=? where e_id=? and project_post_id=? and type_of_post=?";
			pst=con.prepareStatement(str);
			pst.setString(1,project_name);
			pst.setString(2,organiser_name);
			pst.setString(3,language_of_project);
			pst.setString(4,shoot_location);
			pst.setDate(5,(java.sql.Date) shoot_start_date);
			pst.setDate(6,(java.sql.Date)shoot_end_date);
			pst.setDate(7,(java.sql.Date)shoot_time);
			pst.setDouble(8,budget_min_value);
			pst.setDouble(9,budget_max_value);
			pst.setString(10,other_means_of_budget);
			pst.setString(11,note);
			pst.setInt(13,user_id);
			pst.setInt(14,post_id);
			pst.setString(15,type_of_post);
			pst.setString(12,purpose_value);
			
			pst.execute();
			// match purpose with coloumn name  and put its value as yes
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//create project image and store in db
	}
	
	public String get_purpose_of_project_post(Connection con, int user_id,int project_post_id,String type_of_post)
	{
		ResultSet rs; 
		PreparedStatement pst;
		int no_of_coloumns;
		String purpose = null;
	
		//String[] type_of_profle= {"Executive Producer", "Line Producer", "Supervising Producer", "Co Producer","Co Ordinating_producer","Primary Assistant Producer", "Secondary Assistant Producer", "Assistant Producer","Segment Producer", "Event Producer","Music Producer","film_director","Film Director","Primary Associate Film Director","Secondary Associate Film Director", "Associate Film Director"};
		
		// varchar(10), casting_director varchar(10), primary_associate_casting_director varchar(10),secondary_associate_casting_director varchar(10),other_associate_casting_director varchar(10), music_director varchar(10),primary_associate_music_director varchar(10),secondary_associate_music_director varchar(10), other_associate_music_director varchar(10), dop varchar(10), primary_camera_operator varchar(10), secondary_camera_operator varchar(10), other_camera_operator varchar(10), gafer varchar(10), best_boy varchar(10), lighting_technician_or_grip varchar(10), film_video_editor varchar(10), sound_designer varchar(10), dialouge_editor varchar(10), foley_artist varchar(10), language_translator varchar(10), language_tutor varchar(10), fashion_stylist varchar(10), hair_makeup_stylist varchar(10), illustrator varchar(10), graphic_artist varchar(10), production_designer varchar(10), art_director varchar(10),  set_designer varchar(10), set_dressor varchar(10), set_constructor varchar(10), script_writter varchar(10), script_supervisor varchar(10),
		
		// query to find no of coloumns and name of specific coloumn
		
		String col_name="SELECT distinct COLUMN_NAME FROM information_schema.columns WHERE table_name = 'project_post' and ORDINAL_POSITION IN (";
		String col_count="SELECT count(*) " + 
				"FROM information_schema.columns " + 
				"WHERE table_name = 'project_post'"
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
			
			
			pst=con.prepareStatement("select * from project_post where e_id=? and project_post_id=? and type_of_post=?");
			pst.setInt(1,user_id);
			pst.setInt(2,project_post_id);
			pst.setString(3,type_of_post);
			
			rs=pst.executeQuery();
			
			
				while(rs.next())  
				{
					for(int i=15;i<=51;i++)
					{
					//System.out.println(rs.getString(i));
					if(!(rs.getString(i).equals("No")))
					{
					
							col_name+=i;
						
					}
				}
				
				
			}
			
			//col_name=col_name.substring(0, col_name.length() - 1);
			col_name+=")";
			
			pst=con.prepareStatement(col_name);
			//System.out.println(col_name);
			
			rs=pst.executeQuery();
			
			
			while(rs.next())  
			{
					purpose=rs.getString(1);

			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
	
		return purpose;
	
	}
	
	public ArrayList<String> sub_fun_get_project_entity_requirements_column(Connection con, int user_id,int project_post_id,String type_of_post,int start,int end)
	{
		ResultSet rs;
		ResultSet rs1;
		
		PreparedStatement pst;
		int no_of_coloumns;
		ArrayList<String> column_names = new ArrayList<String>();
	
		//String[] type_of_profle= {"Executive Producer", "Line Producer", "Supervising Producer", "Co Producer","Co Ordinating_producer","Primary Assistant Producer", "Secondary Assistant Producer", "Assistant Producer","Segment Producer", "Event Producer","Music Producer","film_director","Film Director","Primary Associate Film Director","Secondary Associate Film Director", "Associate Film Director"};
		
		// varchar(10), casting_director varchar(10), primary_associate_casting_director varchar(10),secondary_associate_casting_director varchar(10),other_associate_casting_director varchar(10), music_director varchar(10),primary_associate_music_director varchar(10),secondary_associate_music_director varchar(10), other_associate_music_director varchar(10), dop varchar(10), primary_camera_operator varchar(10), secondary_camera_operator varchar(10), other_camera_operator varchar(10), gafer varchar(10), best_boy varchar(10), lighting_technician_or_grip varchar(10), film_video_editor varchar(10), sound_designer varchar(10), dialouge_editor varchar(10), foley_artist varchar(10), language_translator varchar(10), language_tutor varchar(10), fashion_stylist varchar(10), hair_makeup_stylist varchar(10), illustrator varchar(10), graphic_artist varchar(10), production_designer varchar(10), art_director varchar(10),  set_designer varchar(10), set_dressor varchar(10), set_constructor varchar(10), script_writter varchar(10), script_supervisor varchar(10),
		
		// query to find no of coloumns and name of specific coloumn
		
		String col_name="SELECT distinct COLUMN_NAME FROM information_schema.columns WHERE table_name = 'project_post' and ORDINAL_POSITION IN (";
		String col_count="SELECT count(*) " + 
				"FROM information_schema.columns " + 
				"WHERE table_name = 'project_post'"
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
			
			
			pst=con.prepareStatement("select * from project_post where e_id=? and project_post_id=? and type_of_post=?");
			pst.setInt(1,user_id);
			pst.setInt(2,project_post_id);
			pst.setString(3,type_of_post);
			
			rs=pst.executeQuery();
			
			
				while(rs.next())  
				{
					for(int i=start;i<=end;i++)
					{
					//System.out.println(rs.getString(i));
					if(!(rs.getString(i).equals("No")))
					{
					
							col_name+=i;
						
					}
				}
				
				
			}
			
			//col_name=col_name.substring(0, col_name.length() - 1);
			col_name+=")";
			
			pst=con.prepareStatement(col_name);
			//System.out.println(col_name);
			
			rs=pst.executeQuery();
			
			
			while(rs.next())  
			{	
				if(rs.getString(1).contains("other")||rs.getString(1).equals("indian nationality"))
				{
					pst=con.prepareStatement("select "+rs.getString(1)+" from project_post where e_id=? and project_post_id=? and type_of_post=?");
					pst.setInt(1,user_id);
					pst.setInt(2,project_post_id);
					pst.setString(3,type_of_post);
					
					rs1=pst.executeQuery();
					column_names.add(rs1.getString(1));
				}
					else
				{
						column_names.add(rs.getString(1));
				}
					

			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
			
	
		return column_names;
	
	}
	
	public HashMap get_project_post_details_for_edit(Connection con, int user_id,int project_post_id,String type_of_post)
	{
		
		HashMap project_post_details_for_edit = new HashMap();
		//String type_of_project,project_name, organiser_name,language_of_project,shoot_location, other_means_of_budget,  note,   purpose;
		Date shoot_start_date,shoot_end_date, shoot_time ;
		double budget_min_value, budget_max_value;
		ResultSet rs; 
		PreparedStatement pst;
		
		try
		{
			pst=con.prepareStatement("select project_name,organiser_name,language_of_project,shoot_location,shoot_start_date,shoot_end_date,shoot_time,budget_min_value,budget_max_value,other_means_of_budget,note from project_post where e_id=? and project_post_id=? and type_of_post=?");
			pst.setInt(1,user_id);
			pst.setInt(2,project_post_id);
			pst.setString(3,type_of_post);
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				project_post_details_for_edit.put("project_name", rs.getString(1));
				project_post_details_for_edit.put("organiser_name", rs.getString(2));
				project_post_details_for_edit.put("language_of_project", rs.getString(3));
				project_post_details_for_edit.put("shoot_location", rs.getString(4));
				project_post_details_for_edit.put("shoot_start_date", rs.getString(5));
				project_post_details_for_edit.put("shoot_end_date", rs.getString(6));
				project_post_details_for_edit.put("shoot_time", rs.getString(7));
				project_post_details_for_edit.put("budget_min_value", rs.getString(8));
				project_post_details_for_edit.put("budget_max_value", rs.getString(9));
				project_post_details_for_edit.put("other_means_of_budget", rs.getString(10));
				project_post_details_for_edit.put("note", rs.getString(11));
				String purpose=get_purpose_of_project_post(con, user_id,project_post_id,type_of_post);
				if(purpose.contains("other"))
				{
					pst=con.prepareStatement("select "+purpose+" from project_post where e_id=? and project_post_id=? and type_of_post=?");
					pst.setInt(1,user_id);
					pst.setInt(2,project_post_id);
					pst.setString(3,type_of_post);
					
					rs=pst.executeQuery();
					project_post_details_for_edit.put("purpose", rs.getString(1));
				}
					else
				{
				project_post_details_for_edit.put("purpose", purpose);
				}
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return project_post_details_for_edit;
	}
	
	
	public void edit_project_audition_details(Connection con, int user_id,int project_post_id,String type_of_post,Date online_audition_end_date , String online_audition_end_time , String online_audition_script , Date offline_audition_start_date ,  Date offline_audition_end_date ,String offline_audition_start_time  ,String offline_audition_end_time , String offline_audition_script)
	{
			
		ResultSet rs; 
		PreparedStatement pst;
		
		try
		{
			pst=con.prepareStatement("update  project_post set online_audition_end_date=?,online_audition_end_time=?,online_audition_script=?,offline_audition_start_date=?,offline_audition_end_date=?,offline_audition_start_time=?,offline_audition_end_time=?,offline_audition_script=? where e_id=? and project_post_id=? and type_of_post=?");
			pst.setDate(1,new java.sql.Date( online_audition_end_date.getTime()));
			pst.setString(2,online_audition_end_time);
			pst.setString(3,online_audition_script);
			
			if(offline_audition_start_date==null)
			{
				pst.setDate(4,null);
					
			}
			else
				pst.setDate(4,new java.sql.Date(offline_audition_start_date.getTime()));
				
			if(offline_audition_end_date==null)
			{
				pst.setDate(5,null);
					
			}
			else
				pst.setDate(5,new java.sql.Date(offline_audition_end_date.getTime()));
			
			pst.setString(6,offline_audition_start_time);
			pst.setString(7,offline_audition_end_time);
			pst.setString(8, offline_audition_script);
			pst.setInt(9,user_id);
			pst.setInt(10,project_post_id);
			pst.setString(11,type_of_post);
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public HashMap get_project_audition_details(Connection con, int user_id,int project_post_id,String type_of_post)
	{
		ResultSet rs; 
		PreparedStatement pst;
		HashMap project_audition_details= new HashMap();
		try
		{
			pst=con.prepareStatement("select online_audition_end_date,online_audition_end_time,online_audition_script,offline_audition_start_date,offline_audition_end_date,offline_audition_start_time,offline_audition_end_time,offline_audition_script,online_audition_start_date,online_audition_start_time from project_post  where e_id=? and project_post_id=? and type_of_post=?");
			pst.setInt(1,user_id);
			pst.setInt(2,project_post_id);
			pst.setString(3,type_of_post);
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				project_audition_details.put("online_audition_end_date", rs.getDate(1));
				project_audition_details.put("online_audition_end_time", rs.getString(2));
				project_audition_details.put("online_audition_start_date", rs.getDate(9));
				project_audition_details.put("online_audition_start_time", rs.getString(10));
				project_audition_details.put("online_audition_script", rs.getString(3));
				project_audition_details.put("offline_audition_start_date", rs.getDate(4));
				project_audition_details.put("offline_audition_end_date", rs.getDate(5));
				project_audition_details.put("offline_audition_start_time", rs.getString(6));
				project_audition_details.put("offline_audition_end_time", rs.getString(7));
				project_audition_details.put("offline_audition_script", rs.getString(8));		
			}
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project_audition_details;
		
	}

	
	public void sub_fun_edit_all_type_of_project_entity(Connection con, int user_id,int project_post_id, String type_of_post,String default_options[],ArrayList<String> chosen_options,ArrayList<String> options_value)
	{
		ResultSet rs; 
		PreparedStatement pst;
		
		//first set all to 'NO' only
		
		String set_no="update project_post set ";
		
		for(int i=0;i<default_options.length;i++)
		{
			if(i==default_options.length-1)
			{
				set_no+= default_options[i]+  "='No'";
					
			}
			else
				set_no+= default_options[i]+  "='No',";
			
			
		}
		
		set_no+=" where eid=? and post_id=? and type_of_post=?";
		try
		{
			pst=con.prepareStatement(set_no);
			
			pst.setInt(1,user_id);
			pst.setInt(2,project_post_id);	
			pst.setString(3,type_of_post);	
			
			pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//here change only selected options
		String edit_profile="update project_post set ";
		
		for(int i=0;i<chosen_options.size();i++)
		{
			if(i==chosen_options.size()-1)
			{
				edit_profile+= chosen_options.get(i)+  "='"+options_value.get(i)+"'";
					
			}
			else
				edit_profile+= chosen_options.get(i)+  "='"+options_value.get(i)+"',";
			
			
		}
		
		edit_profile+=" where eid=? and post_id=? and type_of_post=?";
		try
		{
			pst=con.prepareStatement(edit_profile);
			
			pst.setInt(1,user_id);
			pst.setInt(2,project_post_id);	
			pst.setString(3,type_of_post);	
			
			pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*String type_of_profile,
	 *  int male_number, int female_number,int transgender_number,
	int other_number_gender, String home_town, String current_location, 
	String type_of_nationality,String type_of_skin_tone,String type_of_hair,
	String volume_of_hair, String type_of_eyes, int height_min, int height_max,
	int weight_min, int weight_max, int hips_min , int hips_max, int waist_min , 
	int  waist_max , int shoulders_min ,int shoulders_max ,int chest_min , int chest_max ,
	int bust_min ,int bust_max , String type_of_body, 
	String type_of_appearance,*/
	public void edit_project_entity_requirement_details(Connection con, int user_id,int project_post_id, String type_of_post, int male_number, int female_number,int transgender_number, int other_number_gender, String home_town, String current_location,int weight_min, int weight_max, int hips_min , int hips_max, int waist_min ,  int  waist_max , int shoulders_min ,int shoulders_max ,int chest_min , int chest_max , int bust_min ,int bust_max ,int height_min, int height_max,ArrayList<String> options,ArrayList<String> values) 
	{
			
		ResultSet rs; 
		PreparedStatement pst;
		
		try
		{
			pst=con.prepareStatement("update  project_post set male_number=?,female_number=?,transgender_number=?,other_number_gender=?,home_town=?,current_location=?,weight_min=?,weight_max=?,hips_min =?,hips_max=?, waist_min =?,waist_max =?,shoulders_min =?,shoulders_max =?,chest_min =?, chest_max =?,bust_min =?,bust_max =?,height_min=?,height_max where eid=? and post_id=? and type_of_post=?");
			pst.setInt(1,male_number);
			pst.setInt(2,female_number);
			pst.setInt(3,transgender_number);
			pst.setInt(4,other_number_gender);
			pst.setString(5,home_town);
			pst.setString(6,current_location);
			pst.setInt(7, weight_min);
			pst.setInt(8, weight_max);
			pst.setInt(9, hips_min);
			pst.setInt(10, hips_max);
			pst.setInt(11, waist_min);
			pst.setInt(12, waist_max);
			pst.setInt(13, shoulders_min);
			pst.setInt(14, shoulders_max);
			pst.setInt(15, chest_min);
			pst.setInt(16, chest_max);
			pst.setInt(17,bust_min);
			pst.setInt(18, bust_max);
			pst.setInt(19, height_min);
			pst.setInt(20, height_max);
		
			
			/*
		 	pst.setInt(1,type_of_profile);pst.setString(8, type_of_nationality);
			pst.setString(8, type_of_skin_tone);
			pst.setString(8, type_of_hair);
			pst.setString(8, volume_of_hair);
			pst.setInt(8, type_of_body);
			
			match them with coloumn name  and put its value as yes
			*/
			String type_of_profile_all_options[]= {"executive_producer  "," line_producer  "," supervising_producer  "," co_producer  "," co_ordinating_producer  "," primary_associate_or_assistant_producer  "," secondary_associate_or_assistant_producer  "," other_associate_or_assistant_producer  "," segment_producer  "," event_producer  "," music_producer  "," film_director  "," primary_associate_film_director  "," secondary_associate_film_director  "," other_associate_film_director  "," casting_director  "," primary_associate_casting_director  ","secondary_associate_casting_director  ","other_associate_casting_director  "," music_director  ","primary_associate_music_director  ","secondary_associate_music_director  "," other_associate_music_director  "," dop  "," primary_camera_operator  "," secondary_camera_operator  "," other_camera_operator  "," gafer  "," best_boy  "," lighting_technician_or_grip  "," film_video_editor  "," sound_designer  "," dialouge_editor  "," foley_artist  "," language_translator  "," language_tutor  "," fashion_stylist  "," hair_makeup_stylist  "," illustrator  "," graphic_artist  "," production_designer  "," art_director  ","  set_designer  "," set_dressor  "," set_constructor  "," script_writter  "," script_supervisor  ",
					 "finance_manager  "," location_manager  "," scout  "," primary_assistant_location_manager  "," secondary_assistant_location_manager  "," other_assistant_location_manager  "," primary_production_manager  "," secondary_production_manager  "," other_production_manager  "," unit_publicist  "," legal_counsel  "," system_adminstrator  "," event_manager  "," of_any_other_entity  "," actor  "," model  "," dancer  "," singer  "," insrumentalist  "," composer  "," music_engineer  "," radio_or_voice_over  "," dj  "," band  "," stand_up_comedian   "," other_type_of_entity " };
			
			sub_fun_edit_all_type_of_project_entity(con,user_id,project_post_id, type_of_post,type_of_profile_all_options,options,values);
	
			String type_of_skin_all_options[]= {"indian_nationality"  , "foreigner_nationality"};
			sub_fun_edit_all_type_of_project_entity(con,user_id,project_post_id, type_of_post,type_of_skin_all_options,options,values);
	
			String type_of_hair_all_options[]= {"straight_hair"  , "wavy_hair"  , "curly_hair"  , "other_type_hair"};
			sub_fun_edit_all_type_of_project_entity(con,user_id,project_post_id, type_of_post,type_of_hair_all_options,options,values);
	
			String volume_of_hair_all_options[]= { "thin_volume_hair"  , "thick_volume_hair"  , "normal_volume_hair"};
			sub_fun_edit_all_type_of_project_entity(con,user_id,project_post_id, type_of_post,volume_of_hair_all_options,options,values);
	
			String type_of_body_all_options[]= {"skinny_body"  , "avg_physique_body"  , "muscular_body"  , "fat_body"  ,"plus_size_body" };
			sub_fun_edit_all_type_of_project_entity(con,user_id,project_post_id, type_of_post,type_of_body_all_options,options,values);
			
			String type_of_eyes_all_options[]= {"monolids_eyes"   , "round_eyes"  , "almond_eyes"  , "downturned_eyes"  , "upturned_eyes"  , "hooded_eyes"  , "other_type_eyes"};
			sub_fun_edit_all_type_of_project_entity(con,user_id,project_post_id, type_of_post,type_of_eyes_all_options,options,values);
			
			String type_of_apperances_all_options[]= {"pleasant_appearance"  , "hot"   ,"villager"   , "upmarket"   , "cute"   , "goodlooking"   , "expressive_eyes"   , "bright_smile"   , "other_characteristics"};
			sub_fun_edit_all_type_of_project_entity(con,user_id,project_post_id, type_of_post,type_of_apperances_all_options,options,values);
				
			pst.setInt(21,user_id);
			pst.setInt(22,project_post_id);	
			pst.setString(23,type_of_post);	
			
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public HashMap get_project_entity_requirement_details(Connection con, int user_id,int project_post_id, String type_of_post) 
	{
			
		ResultSet rs; 
		PreparedStatement pst;
		HashMap project_entity_requirement_details = new HashMap();
		ArrayList<String> column_names = new ArrayList<String>();
		
		try
		{
			pst=con.prepareStatement("select male_number,female_number,transgender_number,other_number_gender,home_town,current_location,weight_min,weight_max,hips_min ,hips_max, waist_min ,waist_max ,shoulders_min ,shoulders_max ,chest_min , chest_max ,bust_min ,bust_max ,height_min,height_max from project_post where e_id=? and post_id=? and type_of_post=?");
			pst.setInt(1,user_id);
			pst.setInt(2,project_post_id);	
			pst.setString(2,type_of_post);	
			
			rs=pst.executeQuery();
			
			while(rs.next())  
			{
				project_entity_requirement_details.put("male_number", rs.getInt(1));
				project_entity_requirement_details.put("female_number", rs.getInt(2));
				project_entity_requirement_details.put("transgender_number", rs.getInt(3));
				project_entity_requirement_details.put("other_number_gender",rs.getInt(4));
				project_entity_requirement_details.put("home_town", rs.getString(5));
				project_entity_requirement_details.put("current_location", rs.getString(6));
				project_entity_requirement_details.put("weight_min",rs.getInt(7)); 
				project_entity_requirement_details.put("weight_max", rs.getInt(8));
				project_entity_requirement_details.put("hips_min",rs.getInt(9)); 
				project_entity_requirement_details.put("hips_max",rs.getInt(10)); 
				project_entity_requirement_details.put("waist_min",rs.getInt(11));
				project_entity_requirement_details.put("waist_max",rs.getInt(12)); 
				project_entity_requirement_details.put("shoulders_min",rs.getInt(13)); 
				project_entity_requirement_details.put("shoulders_max",rs.getInt(14)); 
				project_entity_requirement_details.put("chest_min", rs.getInt(15));
				project_entity_requirement_details.put("chest_max", rs.getInt(16));
				project_entity_requirement_details.put("bust_min", rs.getInt(17));
				project_entity_requirement_details.put("bust_max",rs.getInt(18));
				project_entity_requirement_details.put("height_min", rs.getInt(19));
				project_entity_requirement_details.put("height_max", rs.getInt(20));;		
			}
		
			
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 52, 125);
		 	//type_of_profile start=52 and end =52+73
			project_entity_requirement_details.put("type_of_profile",column_names);
			column_names.clear();
		 	 
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 131, 132);
		 	//type_of_nationality start=131 and end =132
			project_entity_requirement_details.put("type_of_nationality",column_names);
			column_names.clear();
			
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 133, 137);
			//type_of_skin_tone start=133 and end =137
			project_entity_requirement_details.put("type_of_skin_tone",column_names);
			column_names.clear();
			
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 138, 141);
			//type_of_hair start=138 and end =141
			project_entity_requirement_details.put("type_of_hair",column_names);
			column_names.clear();
			
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 142,144);
			//volume_of_hair start=142 and end =144
			project_entity_requirement_details.put("volume_of_hair",column_names);
			column_names.clear();
			
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 145, 151);
			//type_of_eyes_all_options start=145 end=151
			project_entity_requirement_details.put("type_of_eyes_all_options",column_names);
			column_names.clear();
			
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 166, 170);
			//type_of_body start=166 and end =170
			project_entity_requirement_details.put("type_of_body",column_names);
			column_names.clear();
			
			column_names=sub_fun_get_project_entity_requirements_column(con, user_id, project_post_id, type_of_post, 171,179);
			//type_of_appearance start=171 and end =179
			project_entity_requirement_details.put("type_of_appearance",column_names);
			column_names.clear();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return project_entity_requirement_details;
		
	}

	public int sample_product_id_generator(Connection con,int user_id, int post_id,String type_of_posts,String type) {
		String getUserId = "SELECT max(sample_product_media_id) FROM sample_post_product_media where e_id="+user_id+" and type_of_post='"+type_of_posts+"' and post_id="+post_id+" and sample_product_media_type='"+type+"'";
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
	
	public void add_post_sample_media(Connection con, int user_id,int post_id, String type_of_post,String type,Blob[] sample_media,String media_description)
	{		
		ResultSet rs; 
		PreparedStatement pst;
		try {
			
			
				for(int ctr=0;ctr<sample_media.length;ctr++)
				{
					pst=con.prepareStatement("insert into sample_post_product_media (e_id,post_id,type_of_post,sample_product_media_id,sample_product_media,sample_product_media_type,media_description) values(?,?,?,?,?,?,?)");
					pst.setInt(1, user_id);
					pst.setInt(2, post_id);
					pst.setString(3, type_of_post);
					pst.setInt(4, sample_product_id_generator(con,user_id,post_id,type_of_post,type));
					pst.setBlob(5, sample_media[ctr]);
					pst.setString(6, type);
					
					pst.setString(7, media_description);
					
					pst.execute();
				}
			}

			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}  
	}
	
	public void delete_post_sample_media(Connection con, int user_id,int post_id, String type_of_post,int[] sample_product_media_id,String sample_product_media_type)
	{		
		ResultSet rs; 
		PreparedStatement pst;
		try {
				for(int ctr=0;ctr<sample_product_media_id.length;ctr++)
				{
					pst=con.prepareStatement("delete from sample_post_product_media where e_id=? and post_id=? and type_of_post=? and sample_product_media_id=? and sample_product_media_type=? ");
					pst.setInt(1, user_id);
					pst.setInt(2, post_id);
					pst.setString(3, type_of_post);
					pst.setInt(4, sample_product_media_id[ctr]);
					pst.setString(5, sample_product_media_type);
					
					pst.executeUpdate();
				}
			}

			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}  
	}

	
	public void add_promotional_post_details(Connection con, int user_id,String type_of_promotional_post, String  name ,String  by ,String  s_time  ,String  e_time,int  venue_plot_or_building_number , String  venue_building_name ,int  venue_floor_number ,String  venue_street ,String  venue_locality , String  venue_landmark , String  venue_city , String  venue_state ,  int  venue_pincode ,String  venue_country , String  venue_google_map_link ,Date  s_date  ,Date  e_date,String other_details)
	{		
			int promotional_post_id = promotional_post_id_generator(con,user_id,type_of_promotional_post);
			ResultSet rs; 
			PreparedStatement pst;

			try
			{
				pst=con.prepareStatement("insert into promotional_post (e_id, promotional_post_id,type_of_post, _name,  _by,  start_time,end_time , venue_plot_or_building_number ,  venue_building_name , venue_floor_number ,  venue_street,  venue_locality, venue_landmark,  venue_city,  venue_state, venue_pincode , venue_country,  venue_google_map_link ,   start_date  ,end_date, other_details) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setInt(1,user_id);
				pst.setInt(2,promotional_post_id);
				pst.setString(3,type_of_promotional_post);
				pst.setString(4, name);
				pst.setString(5, by);
				pst.setString(6,s_time);
				pst.setString(7,e_time);
				
				pst.setInt(8, venue_plot_or_building_number);
				pst.setString(9, venue_building_name);
				pst.setInt(10, venue_floor_number);
				pst.setString(11, venue_street);
				pst.setString(12, venue_locality);
				pst.setString(13, venue_landmark);
				pst.setString(14, venue_city);
				pst.setString(15, venue_state);
				pst.setInt(16, venue_pincode);
				pst.setString(17, venue_country);
				pst.setString(18, venue_google_map_link);
				pst.setDate(19,new java.sql.Date(  s_date.getTime()));
				pst.setDate(20,new java.sql.Date(  e_date.getTime()));
				
				pst.setString(21,other_details);
				
				pst.execute();
				
				pst=con.prepareStatement("insert into all_post (e_id,post_id,type_of_post,date_of_post) values(?,?,?,curdate())");
				pst.setInt(1,user_id);
				pst.setInt(2,promotional_post_id);
				pst.setString(3,type_of_promotional_post);
				
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			//make_snapshot_promotional_post_detail_image(null, null, con, post_id);
	}
	
	public void edit_promotional_post_details(Connection con, int user_id,int project_post_id,String type_of_promotional_post, String  name ,String  by ,String  s_time  ,String  e_time,int  venue_plot_or_building_number , String  venue_building_name ,int  venue_floor_number ,String  venue_street ,String  venue_locality , String  venue_landmark , String  venue_city , String  venue_state ,  int  venue_pincode ,String  venue_country , String  venue_google_map_link ,Date  s_date  ,Date  e_date ,String other_details)
	{		
			
			ResultSet rs; 
			PreparedStatement pst;

			try
			{
				pst=con.prepareStatement("update  promotional_post set  _name=?,  _by=?,  start_time=?,end_time =?, venue_plot_or_building_number =?,  venue_building_name =?, venue_floor_number =?,  venue_street=?,  venue_locality=?, venue_landmark=?,  venue_city=?,  venue_state=?, venue_pincode =?, venue_country=?,  venue_google_map_link =?,   start_date  =?,end_date=?, other_details=? where e_id=? and promotional_post_id=? and type_of_post=? ");
				pst.setString(1, name);
				pst.setString(2, by);
				pst.setString(3,s_time);
				pst.setString(4,e_time);
				
				pst.setInt(5, venue_plot_or_building_number);
				pst.setString(6, venue_building_name);
				pst.setInt(7, venue_floor_number);
				pst.setString(8, venue_street);
				pst.setString(9, venue_locality);
				pst.setString(10, venue_landmark);
				pst.setString(11, venue_city);
				pst.setString(12, venue_state);
				pst.setInt(13, venue_pincode);
				pst.setString(14, venue_country);
				pst.setString(15, venue_google_map_link);
				pst.setDate(16,new java.sql.Date(  s_date.getTime()));
				pst.setDate(17,new java.sql.Date ( e_date.getTime()));
				
				pst.setString(18,other_details);
				pst.setInt(19,user_id);
				pst.setInt(20,project_post_id);
				pst.setString(21,type_of_promotional_post);
				
				pst.executeUpdate();
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	public HashMap get_promotional_post_details(Connection con, int user_id,int project_post_id ,String type_of_promotional_post)
	{		
			ResultSet rs; 
			PreparedStatement pst;
			HashMap promotional_post_details= new HashMap();

			try
			{
				pst=con.prepareStatement("select  _name,  _by,  start_time,end_time , venue_plot_or_building_number ,  venue_building_name , venue_floor_number ,  venue_street,  venue_locality, venue_landmark,  venue_city,  venue_state, venue_pincode , venue_country,  venue_google_map_link ,   start_date  ,end_date, other_details from promotional_post where e_id=? and promotional_post_id=? and type_of_post=? ");
				pst.setInt(1,user_id);
				pst.setInt(2,project_post_id);
				pst.setString(3,type_of_promotional_post);
				
				rs=pst.executeQuery();
				while(rs.next())  
				{
					promotional_post_details.put("name", rs.getString(1));
					promotional_post_details.put("by",rs.getString(2 ));
					promotional_post_details.put("s_time", rs.getString(3 ));
					promotional_post_details.put("e_time", rs.getString(4 ));
					
					promotional_post_details.put("venue_plot_or_building_number", rs.getInt(5));
					
					promotional_post_details.put("venue_building_name",rs.getString(6));
					promotional_post_details.put("venue_floor_number", rs.getInt(7));
					promotional_post_details.put("venue_street", rs.getString(8));
					promotional_post_details.put("venue_locality", rs.getString(9));
					promotional_post_details.put("venue_landmark",rs.getString(10) );
					promotional_post_details.put("venue_city", rs.getString(11));
					promotional_post_details.put("venue_state", rs.getString(12));
					promotional_post_details.put("venue_pincode", rs.getInt(13));
					promotional_post_details.put("venue_country",rs.getString(14) );
					promotional_post_details.put("venue_google_map_link", rs.getString(15));
					promotional_post_details.put("s_date", rs.getDate(16));
					promotional_post_details.put("e_date", rs.getDate(17));
					
					promotional_post_details.put("other_details", rs.getString(18));
					
					
				}
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return promotional_post_details;
		
	}
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		post p=new post();
		String options[]=p.get_post_options("Executive Producer");
		//System.out.println(options);
		for(int i=0;i<options.length;i++)
		{
			System.out.println(options[i]);
		}
		try {
			Class.forName("com.mysql.jdbc.Driver");
		   //3306 is port no of mysql
			
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","saksham026");
		HashMap m=new HashMap();
		
		//p.edit_project_post_details(con, 1, 5,"investment", "abcd", null, null, null, null, null, null, 0, 0, null, null, "short_film","Yes");
		
		//m=p.get_project_post_details_for_edit(con, 1, 5, "investment");
		
		//System.out.println(m.get("purpose"));
		
		java.util.Date myDate = new java.util.Date("01/01/2009");
		//p.edit_project_audition_details(con, 1, 5, "investment", myDate, "1 pm", "ss", null, null, null, null, null);
		
		//m=p.get_project_audition_details(con, 1, 5, "investment");
		
		//System.out.println(m);
		Blob[] a= {null};
		int[] b= {1};
		
		//p.add_post_sample_media(con, 1, 7, "investment_project_post", "audio", a, "Aa");
		//p.delete_post_sample_media(con, 1, 7, "investment_project_post", b, "audio");
		
																			
		//p.edit_promotional_post_details(con,1,2,"class_promotional_post","ab","by","6pm","6pm",23,"building name",2,"street","locla","land","city","state",24,"country","gmaplink",myDate,myDate,"other");
		//m=p.get_promotional_post_details(con, 1, 2, "class_promotional_post");
		//System.out.println(m);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}

}

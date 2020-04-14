package face1;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class more
{



public ArrayList<HashMap> show_fav_face_list(Connection con, int user_id)
//get_fav_entity(Connection con, int user_id,String type_of_entity)
{

	HashMap fav_entity = new HashMap();
	ArrayList<HashMap> fav_entity_list= new ArrayList<HashMap>();
	String entity_name,type_of_entity;
	Blob personal_profile_photo;
	byte[] personal_profile_photo_bytes = null;
	int e_id;		 	 
	
	ResultSet rs; 
	PreparedStatement pst;

	try
	{
			pst=con.prepareStatement("select e_id,first_name,last_name,type_of_entity,personal_profile_photo from basic_profile where e_id in (select face_id from favourite_face where user_id=?) and type_of_entity in (select type_of_face from favourite_face where user_id=?)");
			pst.setInt(1,user_id);
			pst.setInt(2,user_id);
			
			rs=pst.executeQuery();	
			
			while(rs.next())  
			{
			
				e_id = rs.getInt(1);
				entity_name = rs.getString(2)+" " +rs.getString(3);
				type_of_entity = rs.getString(4);
				personal_profile_photo = rs.getBlob(5);
				
				if(personal_profile_photo!=null)
				personal_profile_photo_bytes = personal_profile_photo.getBytes(1,(int)personal_profile_photo.length());
					
				fav_entity.put("e_id", e_id);
				fav_entity.put("entity_name", entity_name);
				fav_entity.put("type_of_entity", type_of_entity);
				
				if(personal_profile_photo!=null)
				fav_entity.put("personal_profile_photo", personal_profile_photo_bytes);
				
				fav_entity_list.add(fav_entity);
			}			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return fav_entity_list;
}


public void add_to_fav_face(Connection con, int user_id, int face_id[], String type_of_profile[])
{
	ResultSet rs; 
	PreparedStatement pst;

	try
	{
			
		for(int ctr=0; ctr<face_id.length;ctr++)
		{
			pst=con.prepareStatement("insert into favourite_face values(?,?,?)");
			pst.setInt(1,user_id);
			pst.setInt(2,face_id[ctr]);
			pst.setString(3,type_of_profile[ctr]);
			
			pst.execute();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}

public void remove_from_fav_face(Connection con, int user_id, int face_id[], String type_of_profile[])
{
	ResultSet rs; 
	PreparedStatement pst;

	try
	{
			
		for(int ctr=0; ctr<face_id.length;ctr++)
		{
			pst=con.prepareStatement("delete from favourite_face where user_id=? and face_id=? and type_of_face=?");
			pst.setInt(1,user_id);
			pst.setInt(2,face_id[ctr]);
			pst.setString(3,type_of_profile[ctr]);
			
			pst.executeUpdate();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}


public ArrayList<HashMap> show_fav_post_list(Connection con, int user_id,String type_of_post)
{
	
	HashMap fav_post = new HashMap();
	ArrayList<HashMap> fav_project_post_list= new ArrayList<HashMap>();
	
	String post_name,type_of_entity;
	int entity_id,post_id,ctr=0;		 
	
	ResultSet rs; 
	PreparedStatement pst;

	try
	{

		if(type_of_post.contains("project"))
		{
			pst=con.prepareStatement("select e_id, project_post_id,project_name,type_of_post from project_post where e_id in (select post_owner_id from favourite_post where user_id=? and type_of_post=?) and type_of_post in (select type_of_post from favourite_post where user_id=? and type_of_post=?) and project_post_id in (select post_id from favourite_post where user_id=? and type_of_post=?)");
			pst.setInt(1,user_id);		
			pst.setString(2,type_of_post);	
			
			pst.setInt(3,user_id);		
			pst.setString(4,type_of_post);	
			
			pst.setInt(5,user_id);		
			pst.setString(6,type_of_post);	
		}
		else
		{
			pst=con.prepareStatement("select e_id, promotional_post_id,_name,type_of_post from promotional_post where e_id in (select post_owner_id from favourite_post where user_id=? and type_of_post=?) and type_of_post in (select type_of_post from favourite_post where user_id=? and type_of_post=?) and promotional_post_id in (select post_id from favourite_post where user_id=? and type_of_post=?)");
			pst.setInt(1,user_id);		
			pst.setString(2,type_of_post);	
			
			pst.setInt(3,user_id);		
			pst.setString(4,type_of_post);	
			
			pst.setInt(5,user_id);		
			pst.setString(6,type_of_post);	
			
		}
		
		rs=pst.executeQuery();
		
		while(rs.next())  
		{
		
			entity_id = rs.getInt(1);
			//type_of_entity = rs.getString(2);
			post_id = rs.getInt(2);
			post_name = rs.getString(3);
			type_of_post = rs.getString(4);
			
			fav_post.put("entity_id", entity_id);
			//fav_post.put("type_of_entity", type_of_entity);
			fav_post.put("post_id", post_id);
			fav_post.put("post_name", post_name);
			fav_post.put("type_of_post", type_of_post);
			
			fav_project_post_list.add(fav_post);
		 
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return fav_project_post_list;
}

public void add_to_fav_post(Connection con, int user_id, int post_id[], String type_of_post[],int post_owner[])
{
	ResultSet rs; 
	PreparedStatement pst;

	try
	{	
		for(int ctr=0; ctr<post_id.length;ctr++)
		{
			pst=con.prepareStatement("insert into favourite_post values(?,?,?,?)");
			pst.setInt(1,user_id);
			pst.setInt(2,post_id[ctr]);
			pst.setString(3,type_of_post[ctr]);
			pst.setInt(4,post_owner[ctr]);
			
			pst.execute();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}


public void remove_from_fav_post(Connection con, int user_id, int post_id[], String type_of_post[],int post_owner_id[])
{
	ResultSet rs; 
	PreparedStatement pst;

	try
	{
			
		for(int ctr=0; ctr<post_id.length;ctr++)
		{
			pst=con.prepareStatement("delete from favourite_post where user_id=? and post_id=? and type_of_post=? and post_owner_id=?");
			pst.setInt(1,user_id);
			pst.setInt(2,post_id[ctr]);
			pst.setString(3,type_of_post[ctr]);
			pst.setInt(4, post_owner_id[ctr]);
			
			pst.executeUpdate();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}

public ArrayList<Object[]> show_request_list(Connection con, int user_id,String type_of_post,String status ,String keyword)
{
	
	int other_user_id,post_id,e_id;
	ArrayList<Object[]> request_list= new ArrayList<Object[]>();
	Object[] request = new Object[5];
	String entity_name = null;
	Blob personal_profile_photo = null;
	byte[] personal_profile_photo_bytes = null;

	ResultSet rs; 
	ResultSet rs2; 
	
	PreparedStatement pst;

		try
		{
			if(keyword.equals("receieved"))
			{
				pst=con.prepareStatement("select from_user_id, post_id from request where to_user_id=? and type_of_post=? and status_=? ");
			}
			else //sent case
			{
				pst=con.prepareStatement("select to_user_id, post_id from request where from_user_id=? and type_of_post=? and status_=? ");
			}
			
			pst.setInt(1,user_id);	
			pst.setString(2,type_of_post);	
			pst.setString(3,status);	
			rs=pst.executeQuery();
	
			while(rs.next())  
			{
				other_user_id=rs.getInt(1);
				post_id=rs.getInt(2);
				
				pst=con.prepareStatement("select first_name,last_name,personal_profile_photo from basic_profile where e_id=?");
				pst.setInt(1,other_user_id);	
				rs2=pst.executeQuery();
				
				while(rs2.next())  
				{
				entity_name = rs2.getString(1)+" " +rs2.getString(2);
				personal_profile_photo = rs2.getBlob(3);
				}
				
				if(personal_profile_photo!=null)
				personal_profile_photo_bytes = personal_profile_photo.getBytes(1,(int)personal_profile_photo.length());
				
				request[0]=other_user_id;
				request[1]=entity_name;
				request[2]=personal_profile_photo_bytes;
				request[3]=post_id;
				request[4]=type_of_post;
				
				request_list.add(request);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return request_list;			
}





public void add_to_request(Connection con, int from_user_id, int to_user_id[], int post_id[], String type_of_post[],String status)
{
	ResultSet rs; 
	PreparedStatement pst;

	try
	{	
		for(int ctr=0; ctr<to_user_id.length;ctr++)
		{
			pst=con.prepareStatement("insert into request values(?,?,?,?,?)");
			pst.setInt(1,from_user_id);
			pst.setInt(2,to_user_id[ctr]);
			pst.setInt(3,post_id[ctr]);
			pst.setString(4,type_of_post[ctr]);
			pst.setString(5,status);
			
			pst.execute();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}



public void remove_or_change_status_from_request_list(Connection con, int to_user_id,String type_of_post[],int from_user_id[],String status,String keyword)
{
	ResultSet rs; 
	PreparedStatement pst;

	try
	{
		if(from_user_id==null && status==null)  //deletion or change status according to type of post
		{
			for(int ctr=0; ctr<type_of_post.length;ctr++)
			{
				if(keyword.equals("delete"))
				{
					pst=con.prepareStatement("delete from request where to_user_id=?  and type_of_post=? ");
				}
				else
				{
					pst=con.prepareStatement("update  request set status_='Accepted' where to_user_id=? and type_of_post=? ");					
				}
				

				pst.setInt(1,to_user_id);
				pst.setString(2,type_of_post[ctr]);
				pst.executeUpdate();
			}
		} 
		else if(status==null) //deletion/change status of request from multiple people for a single type of post 
		{
			for(int ctr=0; ctr<from_user_id.length;ctr++)
			{
				if(keyword.equals("delete"))
				{
					pst=con.prepareStatement("delete from request where to_user_id=? and from_user_id=? and type_of_post=? ");
				}
				else
				{
					pst=con.prepareStatement("update  request  set status_='Accepted'  where to_user_id=? and from_user_id=? and type_of_post=? ");					
				}
				
				pst.setInt(1,to_user_id);
				pst.setInt(2,from_user_id[ctr]);
				pst.setString(3,type_of_post[0]);
				pst.executeUpdate();	
			}
		}
		else //deletion or change status of request from all people for a single type of post depending on status 
		{
			if(keyword.equals("delete"))
			{
				pst=con.prepareStatement("delete from request where to_user_id=?  and type_of_post=? and status_=? ");
			}
			else
			{
				pst=con.prepareStatement("update  request  set status_='Accepted'  where to_user_id=?  and type_of_post=? and status_=? ");					
			}
			
			pst.setInt(1,to_user_id);
			pst.setString(2,type_of_post[0]);
			pst.setString(3,status);
			pst.executeUpdate();
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}
		


public ArrayList<Object[]> show_response_list(Connection con, int user_id,int post_id,String type_of_post,String status )
{
	
	int response_user_id,e_id;
	ArrayList<Object[]> response_list= new ArrayList<Object[]>();
	Object[] response= new Object[6];
	String entity_name = null;
	Blob personal_profile_photo = null,audition_uploaded;
	byte[] personal_profile_photo_bytes = null,audition_uploaded_bytes = null;

	ResultSet rs; 
	ResultSet rs2; 
	
	PreparedStatement pst;

		try
		{
			//create table database.resonse(user_id integer, post_id integer, type_of_post varchar(30), from_user_id integer,type_ varchar(20))

			pst=con.prepareStatement("select from_user_id,audition_uploaded from response where user_id=? and post_id=? and type_of_post=? and status_=? ");		
			pst.setInt(1,user_id);	
			pst.setInt(2,post_id);	
			pst.setString(3,type_of_post);	
			pst.setString(4,status);	
			rs=pst.executeQuery();
	
			while(rs.next())  
			{
				response_user_id=rs.getInt(1);
				audition_uploaded=rs.getBlob(2);
				
				if(audition_uploaded!=null)
				audition_uploaded_bytes = audition_uploaded.getBytes(1,(int)audition_uploaded.length());
				
				
				pst=con.prepareStatement("select first_name,last_name,personal_profile_photo from basic_profile where e_id=?");
				pst.setInt(1,response_user_id);	
				rs2=pst.executeQuery();
				
				while(rs2.next())
				{
				entity_name = rs2.getString(1)+" " +rs2.getString(2);
				
				personal_profile_photo = rs2.getBlob(3);
				}
				
				if(personal_profile_photo!=null)
				personal_profile_photo_bytes = personal_profile_photo.getBytes(1,(int)personal_profile_photo.length());
				
				response[0]=response_user_id;
				response[1]=entity_name;
				response[2]=personal_profile_photo_bytes;
				response[3]=post_id;
				response[4]=type_of_post;
				response[5]=audition_uploaded_bytes;
				
				response_list.add(response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return response_list;			
}



/*public void add_to_response(Connection con, int user_id,  int post_id[], String type_of_post[],int from_user_id[],String status, Blob[] audition_upload )
{
	ResultSet rs; 
	PreparedStatement pst;

	//user id = project owner id
	// post id and type  is of that project
	try
	{	
		for(int ctr=0; ctr<from_user_id.length;ctr++)
		{
			pst=con.prepareStatement("insert into response values(?,?,?,?,?,?)");
			pst.setInt(1,user_id);
			pst.setInt(2,post_id[ctr]);
			pst.setString(3,type_of_post[ctr]);
			pst.setInt(4,from_user_id[ctr]);
			pst.setString(5,status);
			pst.setBlob(6,audition_upload[ctr]);
			
			pst.execute();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}*/


public void add_to_response(Connection con, int user_id,  int post_id[], String type_of_post[],int post_owner_id[],String status, Blob[] audition_upload )
{
	ResultSet rs; 
	PreparedStatement pst;

	//user id =from me 
	
	try
	{	
		for(int ctr=0; ctr<post_id.length;ctr++)
		{
			pst=con.prepareStatement("insert into response values(?,?,?,?,?,?)");
			pst.setInt(1,post_owner_id[ctr]);
			pst.setInt(2,post_id[ctr]);
			pst.setString(3,type_of_post[ctr]);
			pst.setInt(4,user_id);
			pst.setString(5,status);
			pst.setBlob(6,audition_upload[ctr]);
			
			pst.execute();
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
}


public void remove_or_change_status_from_response(Connection con, int user_id, int post_id[],String type_of_post[],int from_user_id[],String status,String keyword,String change_to)
{
	ResultSet rs; 
	PreparedStatement pst;
	//if keyword delete then change_to is null
	 //change to can be selected or shortlisted  and by default it is applied 
	try
	{
		if(from_user_id==null && status==null)  //deletion according to single type of post and multiple post id
		{
				for(int ctr=0;ctr<post_id.length;ctr++)
				{
					if(keyword.equals("delete"))
					{
						pst=con.prepareStatement("delete from response where user_id=? and type_of_post=? and post_id=?  ");
					}
					else
					{
						String query="update response set status_='"+ change_to + "' where user_id=? and type_of_post=? and post_id=? ";
						pst=con.prepareStatement(query);					
					}
					pst.setInt(1,user_id);
					pst.setString(2,type_of_post[0]);
					pst.setInt(3,post_id[ctr]);
					pst.executeUpdate();					
				}
		} 
		else if(status==null) //deletion or change of status of response of multiple people for a single type of post and single post id 
		{
			for(int ctr=0; ctr<from_user_id.length;ctr++)
			{
				if(keyword.equals("delete"))
				{
					pst=con.prepareStatement("delete from response where user_id=? and from_user_id=? and type_of_post=? and post_id=?");
				}
				else
				{
					String query="update response set status_='"+ change_to + "' where user_id=? and from_user_id=? and type_of_post=? and post_id=? ";
					pst=con.prepareStatement(query);	
				}
				
				pst.setInt(1,user_id);
				pst.setInt(2,from_user_id[ctr]);
				pst.setString(3,type_of_post[0]);
	
				pst.setInt(4,post_id[0]);
				pst.executeUpdate();
			}
		}
		else //deletion or change of status of response of all people for a single type of post and single post  depending on status 
		{
			if(keyword.equals("delete"))
			{
				pst=con.prepareStatement("delete from response where user_id=?  and type_of_post=? and post_id=? and status_=? ");
			}
			else
			{
				String query="update response set status_='"+ change_to + "' where user_id=?  and type_of_post=? and post_id=? and status_=? ";
				pst=con.prepareStatement(query);	
				System.out.println(query);
			}
			
		
			pst.setInt(1,user_id);
			pst.setString(2,type_of_post[0]);
			pst.setInt(3,post_id[0]);
			pst.setString(4,status);
			pst.executeUpdate();
		}
		
} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
}
	
}

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

public  ArrayList<Integer> total_filter_for_find_a_post(int e_id,String profile_type_to_search_in, ArrayList<String> filter,ArrayList<Object> value,String sort_by,Connection con)
{
	//call methods in below 2 line accordingly
    ArrayList<Integer> list1 = filter_for_find_project_post(e_id, profile_type_to_search_in, filter, value, sort_by, con);
    
    ArrayList<Integer> list2 = filter_for_find_promotional_post(e_id, profile_type_to_search_in, filter, value, sort_by, con);

    ArrayList<Integer> list3 = new ArrayList<Integer>(list1); 

    list3.retainAll(list2); 

    return list3;
	
}

//lists should contain id's only
public ArrayList<Integer> total_filter_combine(ArrayList<Integer> list1,ArrayList<Integer> list2)
{

    ArrayList<Integer> list3 = new ArrayList<Integer>(list1); 

    list3.retainAll(list2); 

    return list3;
	
}



public static void main(String args[]) {
	// TODO Auto-generated method stub
	more p=new more();
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","saksham026");
	HashMap m=new HashMap();
	ArrayList<HashMap> a=new ArrayList<HashMap>();
	ArrayList<Object[]> b=new ArrayList<Object[]>();
	
	int[] f= {1};
	int[] post_id= {5};
	Blob up[]= {null};
	
	String[] type= {"investment"};
	//p.add_to_fav_face(con, 1, f, type);
	
	//a=p.show_fav_face_list(con, 1);
	//System.out.println(a);
	
	//p.remove_from_fav_face(con, 1, f,type);
	
	//p.add_to_fav_post(con, 1, f, type,post_owner);
	
	//a=p.show_fav_post_list(con, 1, "investment");
	//System.out.println(a);
	
	//p.remove_from_fav_post(con, 1, f, type,post_owner);
	
	
	//p.add_to_request(con, 1, f, post_id, type, "pending");
	
	/*b=p.show_response_list(con, 1,5, "investment", "pending");
	
	
	for(Object o[]:b)
	{
		for(int i=0;i<o.length;i++)
		{
			System.out.println(o[i]);
		}
	}
	*/
	//p.remove_or_change_status_from_response(con, 2, post_id, type, null,null,"s","applied");
	
	//p.add_to_response(con, 1, post_id, type, f, "pending ", up);
	//p.remove_or_change_status_from_request_list(con, 1, type, null, null, "aa");
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	

	
	}
}


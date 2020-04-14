package face1;


import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

import org.joda.time.format.DateTimeFormat;

import com.mindfusion.common.*;
import com.mindfusion.common.Rectangle;
import com.mindfusion.drawing.*;
import com.mindfusion.drawing.awt.AwtImage;
import com.mindfusion.scheduling.*;
import com.mindfusion.scheduling.awt.*;
import com.mindfusion.scheduling.model.*;

@SuppressWarnings({ "unused", "serial" })
public class MainWindow extends JFrame {

    AwtCalendar calendar;
    Recurrence recurrence;
    
    static JFrame f; 

    JWindow w, w1,w2;

    protected MainWindow(int e_id) {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
 
        setTitle("Appointments");
        setMinimumSize(new Dimension(screenSize.width+10,600));
        //getContentPane().setPreferredSize(new Dimension(400, 300));
        BorderLayout layout = new BorderLayout();
        getContentPane().setLayout(layout);


        JLabel label = new JLabel("Here are your appointments schedule");
        label.setBorder(new EmptyBorder(10,10,10,10));
        getContentPane().add(label, BorderLayout.NORTH);
        
        w2 = new JWindow(w);   
		JPanel p = new JPanel(); 
		JLabel l = new JLabel("Search results..."); 
		p.setBorder(BorderFactory.createLineBorder(Color.black)); 
		p.add(l);
		
        JTextField tf=new JTextField();  
        tf.setBounds(1100,10, 130,20);  
        JButton b=new JButton("Search");  
        b.setBounds(1250,10,75,20);  
        b.addActionListener(new ActionListener()
        {  
        	@Override
        	public void actionPerformed(ActionEvent arg0) {
        		// TODO Auto-generated method stub
        		String search_text=tf.getText();  
        		try
        		{
        		Class.forName("com.mysql.jdbc.Driver");     //3306 is port no of mysql
    			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/face","root","saksham026");
    					
    			Statement stmt=con.createStatement();  
    			ResultSet rs=stmt.executeQuery("select project_name,project_post_id from project_post where project_post_id in (select project_post_id from project_schedular where e_id="+e_id+") and project_name like '%"+search_text+"%' or project_post_id like %"+Integer.parseInt(search_text)+"%");  
    			while(rs.next())  
    			{
    				JLabel l1 = new JLabel(rs.getString(2)+"("+rs.getInt(1)+")");
    				p.add(l1);
    			}
    			
    			rs=stmt.executeQuery("select type_of_post,promotional_post_id from promotional_post where project_post_id in (select promotional_post_id from promotional_project_schedular where e_id="+e_id+") and type_of_post like '%"+search_text+"%' or promotional_post_id like %"+Integer.parseInt(search_text)+"%");  
    			while(rs.next())  
    			{
    				JLabel l1 = new JLabel(rs.getString(2)+"("+rs.getInt(1)+")");
    				p.add(l1);
    			}
        	
    			
        		}
        		catch(Exception e1)
        		{
        			System.out.println(e1);
        		} 
        		
        	}  
        }); 
        
        w2.add(p);
        p.setBackground(Color.white); 
		w2.setSize(screenSize.width,screenSize.height-650); 
		w2.setVisible(true); 
		w2.setLocation(7, 590);

        getContentPane().add(b);
        getContentPane().add(tf);
        
        calendar = new AwtCalendar();
        calendar.beginInit();
        //calendar.setSize(1620, 820);
        //calendar.setBounds(10, 10, 620, 630);
        //set the current time
        calendar.setCurrentTime(DateTime.now());
        DateTime today = DateTime.today();
        //set the current date
        calendar.setDate(today);
        // Select the current date
        calendar.getSelection().set(DateTime.today());

        calendar.setCurrentView(CalendarView.SingleMonth);
        calendar.setCustomDraw(CustomDrawElements.CalendarItem);
        calendar.getMonthSettings().getDaySettings().setHeaderSize(20);
        calendar.getItemSettings().setSize(32);
        calendar.endInit();

       calendar.addCalendarListener(new CalendarAdapter()
        {
            @Override()
            public void draw(DrawEvent e) {
                onDraw(e);
            }
        });

        //add a listener for selecting events
        calendar.addCalendarListener(new CalendarAdapter(){
            public void dateClick(ResourceDateEvent e) {
                onDateClicked(e,e_id);
            }

        });


        getContentPane().add(calendar);

        //pack();
        setVisible(true);
        
    }

    /* called when a date is clicked. Creates a recurring appointment. */
	protected void onDateClicked(ResourceDateEvent e,int e_id) {
    	
		w1 = new JWindow(w);   
		// set panel 
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JPanel p = new JPanel(); 

		Date dNow = new Date();
		SimpleDateFormat ft = 
				new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss");

		//System.out.println("Current Date: " + e.getDate().getYear());
		//System.out.println("Current Date: " + e.getDate().getMonth());
		//System.out.println("Current Date: " + e.getDate().getDay());
		

		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		org.joda.time.DateTime d2 = formatter.parseDateTime(ft.format(dNow));

		/*Appointment item = new Appointment();
		item.setStartTime(new com.mindfusion.common.DateTime(
				d2.getYear(), d2.getMonthOfYear(), d2.getDayOfMonth(),
				d2.getHourOfDay(), d2.getMinuteOfHour(), d2.getSecondOfMinute()));

		item.setEndTime(new com.mindfusion.common.DateTime(
				d2.getYear(), d2.getMonthOfYear(), d2.getDayOfMonth(),
				d2.getHourOfDay(), d2.getMinuteOfHour(), d2.getSecondOfMinute()));*/
		
		//item.setHeaderText(events[i]);
		//item.getStyle().setBrush(brushes[i]);

		//calendar.getSchedule().getItems().add(item);

		JLabel l = new JLabel("Projects"); 
		p.setBorder(BorderFactory.createLineBorder(Color.black)); 
		p.add(l);

		//code to store that day appintment in database
				//for e.getDtae();
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");     //3306 is port no of mysql
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/face","root","saksham026");
			//here sonoo is database name, root is username and password  
			DateTime da=e.getDate();
			
			int year=e.getDate().getYear();
			int month=e.getDate().getMonth();
			int day=e.getDate().getDay();
			String formed_date=""+year+"-"+month+"-"+day;
					
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select project_name,project_post_id from project_post where project_post_id in (select project_post_id from project_schedular where e_id="+e_id +"and date_of_project='"+formed_date+"')");  
			while(rs.next())  
			{
				l = new JLabel(rs.getString(2)+"("+rs.getInt(1)+")");
				p.add(l);
			}
			
			l = new JLabel("Promotional Projects"); 
			p.add(l);
			 rs=stmt.executeQuery("select type_of_post,promotional_post_id from promotional_post where project_post_id in (select promotional_post_id from promotional_project_schedular where e_id="+e_id +"and date_of_promotional_project='"+formed_date+"')");  
			while(rs.next())  
			{
				l = new JLabel(rs.getString(2)+"("+rs.getInt(1)+")");
				p.add(l);
			}
			
			
			w1.add(p);
			con.close();  
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		} 
		
		p.setBackground(Color.white); 
		w1.setSize(screenSize.width,screenSize.height-650); 
		w1.setVisible(true); 
		w1.setLocation(7, 590);

		         
    }

    private void onDraw(DrawEvent e)
    {
        if(recurrence == null)
            return;
        if (e.getElement() == CustomDrawElements.CalendarItem)
        {
            if(e.getDate().getDay() == 6 )
            {
                java.awt.Image img = null;

                /*try {
                    // Read the image file from an input stream
                    //InputStream is = new BufferedInputStream(
                            //new FileInputStream("../cake.png"));
                    //img = ImageIO.read(is);

                } catch (IOException ioe) {
                }*/

                //gets the bounds of the drawing area
                Rectangle r = e.getBounds();
                AwtImage awtImage = new AwtImage(img);
                //draw the image
                e.getGraphics().drawImage(awtImage, e.getBounds().getLeft(), e.getBounds().getTop(), 32, 32);

            }
        }
    }

    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainWindow window = null;
                try {
                    window = new MainWindow(1);
                    window.setVisible(true);
                }
                catch (Exception exp) {
                }
            }
        });
    }
/*
    Brush[] brushes = {
            Brushes.AliceBlue, Brushes.Beige, Brushes.LightBlue,
            Brushes.LightGreen, Brushes.LightGray, Brushes.LightPink,
            Brushes.LemonChiffon
    };

    String[] events = {
            "swimming", "yoga", "piano",
            "shopping", "cooking", "french",
            "party night"
    };*/

}


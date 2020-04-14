package face1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class TestClass{
	
	

    // No. of vertices in TestClass 
    private int v; 
    public static HashMap<String,Integer> hm=new HashMap<String,Integer>();
    public  static ArrayList<List<Integer> > allPathList=new  ArrayList<List<Integer> >();
      
    // adjacency list  
    private ArrayList<Integer>[] adjList;  
      
    //Constructor 
    public TestClass(int vertices){ 
          
        //initialise vertex count 
        this.v = vertices; 
          
        // initialise adjacency list 
        initAdjList();  
    } 
      
    // utility method to initialise 
    // adjacency list 
    @SuppressWarnings("unchecked")
    private void initAdjList() 
    { 
        adjList = new ArrayList[v]; 
          
        for(int i = 0; i < v; i++) 
        { 
            adjList[i] = new ArrayList<>(); 
        } 
    } 
      
    // add edge from u to v 
    public void addEdge(int u, int v) 
    { 
        // Add v to u's list. 
        adjList[u].add(v);  
    } 
      
    // Prints all paths from 
    // 's' to 'd' 
    public void printAllPaths(int s, int d)  
    { 
        boolean[] isVisited = new boolean[v]; 
        ArrayList<Integer> pathList = new ArrayList<>(); 
          
        //add source to path[] 
        pathList.add(s); 
          
        //Call recursive utility 
        printAllPathsUtil(s, d, isVisited, pathList); 
    } 
  
    // A recursive function to print 
    // all paths from 'u' to 'd'. 
    // isVisited[] keeps track of 
    // vertices in current path. 
    // localPathList<> stores actual 
    // vertices in the current path 
    private void printAllPathsUtil(Integer u, Integer d, 
                                    boolean[] isVisited, 
                            List<Integer> localPathList) { 
          
        // Mark the current node 
        isVisited[u] = true; 
          
        if (u.equals(d))  
        { 
            //System.out.println(localPathList);
            ArrayList<Integer> a=new ArrayList<Integer>();
            for(int y=0;y<localPathList.size();y++)
            {
                a.add(localPathList.get(y));
            }
            allPathList.add(a);
            //System.out.println(localPathList);

            //System.out.println(allPathList);
            
            // if match found then no need to traverse more till depth 
            isVisited[u]= false; 
            return ; 
        } 
          
        // Recur for all the vertices 
        // adjacent to current vertex 
        for (Integer i : adjList[u])  
        { 
            if (!isVisited[i]) 
            { 
                // store current node  
                // in path[] 
                localPathList.add(i); 
                printAllPathsUtil(i, d, isVisited, localPathList); 
                  
                // remove current node 
                // in path[] 
                localPathList.remove(i); 
            } 
        } 
          
        // Mark the current node 
        isVisited[u] = false; 
    } 
    
    public static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> apmap) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(apmap.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
            if(o1.getValue().equals(o2.getValue())&&allPathList.get(o1.getKey()).size()==allPathList.get(o2.getKey()).size())
            	{
            		int i=o1.getKey();
            		int j=o2.getKey();
            		String key1="";
            		String key2="";
            		List<Integer> localPathList= allPathList.get(i);  

                    for(int hu=0;hu<localPathList.size();hu++)
                    {
                        
                        Integer value=localPathList.get(hu);
                        for(String key:hm.keySet())
                        {
                            if(value.equals(hm.get(key)))
                            {
                                key1+=key+" ";
                            }
                        }
                    
                        
                    }
                    
            		localPathList= allPathList.get(j);  

                    for(int hu=0;hu<localPathList.size();hu++)
                    {
                        
                        Integer value=localPathList.get(hu);
                        for(String key:hm.keySet())
                        {
                            if(value.equals(hm.get(key)))
                            {
                            	key2+=key+" ";
                            }
                        }
                    
                        
                    } 
                    
                    return (key1).compareTo(key2);
            	}
            	else if(o1.getValue().equals(o2.getValue()))
                {
                	return allPathList.get(o1.getKey()).size()-allPathList.get(o2.getKey()).size();  
                }
                else
                {	
            	return (o1.getValue()).compareTo(o2.getValue());
                }
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    }

    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

        // Write your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stdis;
        
        String deparr = br.readLine();
        String splitted[]=deparr.split(" ");

        //Stdis=new StringTokenizer((String)deparr," ");

        String dep=splitted[0];
        String arr=splitted[1];

        int ctr=-1;
        TestClass g=new TestClass(20);
          
        HashMap<String,Integer> dist=new HashMap<String,Integer>();
        HashMap<String,Integer> dist2=new HashMap<String,Integer>();
        HashMap<String,Integer> dist3=new HashMap<String,Integer>();
        HashMap<String,Integer> toggle=new HashMap<String,Integer>();
        HashMap<String,Integer> toggle2=new HashMap<String,Integer>();
        
        String deparrdist;

        while((deparrdist=br.readLine())!=null&&!deparrdist.isEmpty())
        {
            //stdis=new StringTokenizer((String)deparrdist," ");
            String f[]=deparrdist.split(" ");
            String d=f[0];
            String s=f[1];

            if(!hm.containsKey(d))
            {
                ctr++;
                hm.put(d,ctr);
            }

            if(!hm.containsKey(s))
            {
                ctr++;
                hm.put(s,ctr);
            }

            g.addEdge(hm.get(d),hm.get(s));
            
            if(!dist.containsKey(d+" "+s))
            dist.put(d+" "+s,Integer.parseInt(f[2]));
            else if((!dist2.containsKey(d+" "+s)))
            {

                dist2.put(d+" "+s,Integer.parseInt(f[2]));
            }
            else
            {
                dist3.put(d+" "+s,Integer.parseInt(f[2]));

            }
        }

        g.printAllPaths(hm.get(dep),hm.get(arr));
        //List l=new ArrayList();
        //l.add(1);
        //allPathList.add(l);
        //System.out.println(allPathList);
        HashMap<Integer,Integer> apmap=new HashMap<Integer,Integer>();
        for(int i=0;i<allPathList.size();i++)
            {
                apmap.put(i, 0);
            }
            apmap = sortByValue(apmap);
            
            for (Map.Entry<Integer,Integer> entry : apmap.entrySet()) 
            {
                int i=entry.getKey();
                List<Integer> localPathList= allPathList.get(i);  
                int distance=0;
            
            for(int hu=0;hu<localPathList.size();hu++)
            {
                
                Integer value=localPathList.get(hu);
                String a=null;
                for(String key:hm.keySet())
                {
                    if(value.equals(hm.get(key)))
                    {
                        //System.out.print(key);
                    	a=key;
                    }
                }
                
                if(hu+1<localPathList.size())
                {
                Integer value1=localPathList.get(hu+1);
                String b=null;
                
                for(String key:hm.keySet())
                {
                    if(value1.equals(hm.get(key)))
                    {
                        //System.out.print(key);
                    	b=key;
                    }
                }
                
                if(dist3.containsKey(a+" "+b))
                {
                distance+=dist3.get(a+" "+b);
                int v=dist3.remove(a+" "+b);
                //System.out.println("2");
                toggle2.put(a+" "+b,v);
                
                }
                else if(dist2.containsKey(a+" "+b))
                {
                distance+=dist2.get(a+" "+b);
                int v=dist2.remove(a+" "+b);
                //System.out.println("2");
                toggle.put(a+" "+b,v);
                }
                else 
                {
                distance+=dist.get(a+" "+b);
                //System.out.println("1");
                if(toggle.containsKey(a+" "+b))
                dist2.put(a+" "+b,toggle.get(a+" "+b));
                if(toggle2.containsKey(a+" "+b))
                dist3.put(a+" "+b,toggle2.get(a+" "+b));
                
                }
                
                }
            
            } 
            apmap.put(i, distance);

            }
            
            //sort apmap by distance
            //System.out.println(apmap);
            apmap = sortByValue(apmap);
            //System.out.println(apmap);
            
            for (Map.Entry<Integer,Integer> entry : apmap.entrySet()) 
            {
                int i=entry.getKey();
                List<Integer> localPathList= allPathList.get(i);  

                for(int hu=0;hu<localPathList.size();hu++)
                {
                    
                    Integer value=localPathList.get(hu);
                    for(String key:hm.keySet())
                    {
                        if(value.equals(hm.get(key)))
                        {
                            System.out.print(key+" ");
                        }
                    }
                
                    
                } 

                System.out.println(entry.getValue());
            
            }                     
            
    
    }
}
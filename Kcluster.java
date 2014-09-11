/**
 * 
 */
import java.util.Vector;

/**
 * @author burd691
 *
 */
public class Kcluster {

	/**
	 * @param args
	 */
	
	private Vector<Kpoint> points; 
	private Kpoint centroid;
	
	public Kcluster(int num_clusters) // Constructor
	{
		points = new Vector<Kpoint>(num_clusters); // Initializes vector to size of this cluster
		centroid = new Kpoint();
	}
	
	public Kcluster() // Default constructor creates a vector of Kpoints of length 10.
	{
		points = new Vector<Kpoint>(10); // 10 is the default size
		centroid = new Kpoint();
	}
	
	public void set_centroid(Kpoint input) // Changes the centroid of this cluster
	{
		centroid.set_x_coord(input.get_x_coord());
		centroid.set_y_coord(input.get_y_coord());
		centroid.set_z_coord(input.get_y_coord());
	}
	
	public Kpoint get_centroid() // returns centroid as a Kpoint 
		{return centroid;}
	
	public Kpoint get_Kpoint(int i) // returns the kpoint in the cluster at the given index
	{return points.elementAt(i);}
	
	public void add_point(Kpoint add_me) // adds a Kpoint to the list "points"
		{points.add(add_me);}
	
	public int size() // Returns number of points in the list "points"
		{return points.size();}
	
	public void clear_cluster_list() // Clears the list of points
		{points.clear();}
	
	public void calculate_centroid() // Calculates centroid AND sets it as the new centroid. 
	{
		
		double total_y = 0;
		double total_x = 0;
		double total_z = 0;
		for(int i=0; i<points.size(); i++)
		{
			total_x = total_x + points.get(i).get_x_coord(); // adds this points x value to the total
			total_y = total_y + points.get(i).get_y_coord(); // adds this points y value to the total
			total_z = total_z + points.get(i).get_z_coord(); // adds the points  z value to the total
			
		}
		centroid.set_x_coord( total_x / points.size() ); //Sets x coord of centroid to average of all x coords
		centroid.set_y_coord( total_y / points.size() ); // sets y coord of centroid to average of all y coords
		centroid.set_z_coord( total_z / points.size() );
	}
	
	public void print(int cluster_number) // prints cluster, PARAM cluster_number must be provided.
	{
		System.out.println("Printing Cluster : "+cluster_number); // Prints Header for this cluster
		
		if(centroid.get_z_coord() != 0) // 3D is being used
			System.out.println("-Centroid : " + centroid.get_x_coord()+","+centroid.get_y_coord() + "," +centroid.get_z_coord());    
		else // Print 2D
			System.out.println(("-Centroid : " + centroid.get_x_coord()+","+centroid.get_y_coord()));
		
		
		if(this.size() ==0)
			System.out.println("Cluster is empty");
		
		for(int i =0; i<this.size(); i++) // Prints each Kpoint in the cluster
		{
			points.elementAt(i).print();
		}
		}
	}
	

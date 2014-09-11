//
// Project 1
// Name: Matthew Burdumy
// E-mail: mcb226@georgetown.edu
// Instructor: Singh
// COSC 150
//
// In accordance with the class policies and Georgetown's Honor Code,
// I certify that, with the exceptions of the lecture notes and those
// items noted below, I have neither given nor received any assistance
// on this project.
//
// Description: Runs the K-means clustering algorithm on a given test file of inputs

import java.util.Collections;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;


// ARGS: Objects of type Kmain may be instantiated with one argument (file of points) OR a total of 3
// (Filepath of points) number_clusters number_iterations
public class Kmain 
{

	final static int NUMBER_CLUSTERS = 3; // default value
	final static int NUMBER_ITERATIONS = 5; // default value
	
	Vector<Kcluster> clusters;
	Vector<Kpoint> input_points;
	
	private int num_iterations;
	
	public static void main(String[] args)
	{ // Expect command line input to be filename.txt num_clusters  num_iterations
		
	try
	{
		Kmain obj;
	// Testing command line arguments
		if(args.length == 1) // the user only passed in the data file.
		{
			obj = new Kmain(); // number of clusters, number of iterations
		}
		else if(args.length == 3)
		{
			obj = new Kmain(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
		}
		else // Wrong number of arguments passed 
		{
			throw new Exception("Wrong number of Arguments Passed on Command Line");
		}
		
		obj.input_data(args[0]);
		obj.initial_centroids();
		
		for(int i =0; i<obj.get_num_iterations() -1; i++) // Runs clustering algorithim based on number of iterations 
		{
			 obj.distribute_points();
			 obj.reset_clusters();
		}
		 obj.distribute_points(); // Must re_distribute points final time, counts as the last iteration.
		 obj.print();
	} 
	catch(Exception e)
	{
		System.out.println("Unhandled exception thrown, program terminating.");
		System.out.println(e.getLocalizedMessage());
	}
		
	}
	
	public Kmain() // Default constructor
	{
		num_iterations = Kmain.NUMBER_ITERATIONS;
		clusters = new Vector<Kcluster>(Kmain.NUMBER_CLUSTERS);
		input_points = new Vector<Kpoint>();
		
		for(int i =0; i<Kmain.NUMBER_CLUSTERS; i++)
		{
			clusters.add(new Kcluster());
		}
	}
	
	public Kmain(int num_clusters, int number_iterations)// Constructor
	{
		num_iterations = number_iterations;
		clusters = new Vector<Kcluster>(num_clusters);
		input_points = new Vector<Kpoint>();
		
		for(int i = 0; i<num_clusters; i++)
		{
			clusters.add(new Kcluster());
		}
	}
	
	public void reset_clusters()
	{
		for(int i =0; i< clusters.size(); i++)
		{
			clusters.elementAt(i).calculate_centroid();
			clusters.elementAt(i).clear_cluster_list();
		}
	}
	
	public  void input_data( String file_path) throws Exception
	{
		try
		{
		System.out.println(file_path);
		BufferedReader input = new BufferedReader(new FileReader(file_path));
		while(input.ready())
		{
			String this_line = input.readLine(); // Grabs line from input file
			String[] data = new String[3]; // string array to hold output from 'split' method
			data = this_line.split(","); // split method returns an array of size two
			if(data.length == 2) // This is a 2D point
				input_points.add(new Kpoint(Integer.parseInt(data[0]),Integer.parseInt(data[1]))); // Push onto list	
			else
				input_points.add(new Kpoint(Integer.parseInt(data[0]),Integer.parseInt(data[1]), Integer.parseInt(data[2]) ));
			
			
		}
		input.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public  void initial_centroids()
	{
		Collections.shuffle(input_points); // Randomly shuffles the stack for initial centroid selection
		
		for(int i =0; i<clusters.size(); i++) // Since vector is randomly shuffled, we can now grab the first i points for our centroid
		{
			clusters.elementAt(i).set_centroid(input_points.elementAt(i));
		}
	}
	public  void distribute_points()
	{
		for(int i = 0; i<input_points.size(); i++) // iterates through each points.
		{	
			double min_distance = Double.MAX_VALUE; // Sets double to its largest value possible, any distance must be less then this
			int index =0; // used to track the cluster that a point is to be added to 
			
			for(int j = 0; j<clusters.size(); j++) // Iterates for each cluster.
			{
				// Gets distance between the point we are at, ant the centroid of the cluster we are at
				double this_distance = Kpoint.euclidean_distance(clusters.elementAt(j).get_centroid(), input_points.elementAt(i));
				if(this_distance < min_distance) // if the distance is smaller between this point and the cluster than the min distance
				{
					min_distance = this_distance; // new min distance
					index = j; // index of cluster with current smallest distnace
				}
			}
			clusters.elementAt(index).add_point(input_points.elementAt(i)); // final index will be shortest distance.
			
		}
	}
	public int get_num_iterations() // returns the number of iterations requested 
	{return num_iterations;}
	
	public int num_clusters() // Returns the number of clusters. 
	{return clusters.size();}
	
	public void push_point(Kpoint input) // adds a point to the Input point list.
	{input_points.add(input);}
	
	public void print() // Prints Clusters. i is the cluster number
	{
		for(int i=0; i<clusters.size(); i++)
		{
			clusters.elementAt(i).print(i);
		}
	}

}

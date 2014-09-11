import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 */

/**
 * @author burd691
 *
 */
public class KmainTest
{
// Tests to write:
//	Constructor
	@Test
	public void constructor_test()
	{
		try
		{
			Kmain tester = new Kmain(5,5); // num_clusters, num_iterations
			assertTrue("Kmain Construct. Falied",(tester.get_num_iterations()== 5 && tester.num_clusters() == 5));
			System.out.println("Kmain Constructor Test Passed!");
		}
		catch(AssertionError e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
//	Initial centroid ???
//	Distribute Points
	
	@Test
	public void centroid_distance_test() // Tests that each point in a cluster is closest to its centroid.
	{ // i.e. the algorithim has run correctly
		try
		{
			Kmain tester = new Kmain(5,10);
			tester.push_point(new Kpoint(10,4,6));
			tester.push_point(new Kpoint(6,5,0));
			tester.push_point(new Kpoint(188,45,90));
			tester.push_point(new Kpoint(15,78,13));
			tester.push_point(new Kpoint(98,34,65));
			tester.push_point(new Kpoint(87,76,11));
			tester.push_point(new Kpoint(20,16,72));
			tester.push_point(new Kpoint(1,1,16));
			tester.push_point(new Kpoint(67,90,34));
			tester.push_point(new Kpoint(12,30,22));
			tester.initial_centroids();
			tester.distribute_points();
			for(int i = 0; i<tester.num_clusters(); i++) // Iterates down each cluster
			{
				for(int j = 0; j<tester.clusters.elementAt(i).size(); j++) // For this cluster, iterate down each point.
				{ 
					// now test that for each point, it is closest to it's clusters' centroid
					Kpoint this_point = tester.clusters.elementAt(i).get_Kpoint(j); // The point to be tested
					Kpoint this_centroid = tester.clusters.elementAt(i).get_centroid(); // the centroid for this cluster
					double this_distance = Kpoint.euclidean_distance(this_point, this_centroid ); // distance between this point and its cluster.
					
					for(int k = 0; k<tester.num_clusters(); k++)
					{ // test this_distance against distance between itself and all other centroids.
						Kpoint other_centroid = tester.clusters.elementAt(k).get_centroid();
						if(this_distance > Kpoint.euclidean_distance(this_point, other_centroid))
							throw new Exception("Point: " + j + " in cluster" + i + "has failed the centroid distance test");
					}
					
				}
			}
			System.out.println("Centroid Distance Test has passed!");
		}
		catch(Exception e)
			{System.out.println(e.getMessage());}
	}
}

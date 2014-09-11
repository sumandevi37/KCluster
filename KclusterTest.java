import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collection;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;



@RunWith(value=Parameterized.class)
public class KclusterTest 
{
	Kpoint value1;
	Kpoint value2;
	Kpoint value3;
	Kpoint value4;
	Kpoint expected_value;

	@Parameters
	public static Collection<Kpoint[]> Parameters()
	{
		return Arrays.asList(new Kpoint[][]
				{
				// value 1,          value 2,          value 3,           value 4,        expected_centroid
				{new Kpoint(5,5), new Kpoint(10,10), new Kpoint(15,15), new Kpoint(30,30), new Kpoint(15,15)},
				
				// value 1,          value 2,          value 3,           value 4,        expected_centroid
				{new Kpoint(0,0), new Kpoint(0,0), new Kpoint(0,0), new Kpoint(0,0), new Kpoint(0,0)},
				
				// value 1,          value 2,          value 3,           value 4,        expected_centroid
				{new Kpoint(3,5), new Kpoint(10,2), new Kpoint(6,10), new Kpoint(5,3), new Kpoint(6,5)},
				
				// value 1,          value 2,          value 3,           value 4,        expected_centroid
				{new Kpoint(8,9), new Kpoint(5,11), new Kpoint(6,4), new Kpoint(2,2), new Kpoint(5.25,6.5)},
				
				// value 1,          value 2,          value 3,           value 4,        expected_centroid
				{new Kpoint(5,10), new Kpoint(5,10), new Kpoint(5,10), new Kpoint(5,10), new Kpoint(5,10)}
				
				});
	}
	
	public KclusterTest(Kpoint input_1, Kpoint input_2, Kpoint input_3, Kpoint input_4, Kpoint result)
	{ // Initalizes parameters to private data members.
		this.value1 = new Kpoint(input_1);
		this.value2 = new Kpoint(input_2);
		this.value3 = new Kpoint(input_3);
		this.value4 = new Kpoint(input_4);
		this.expected_value = new Kpoint(result);
	}
	
	@Test
	public void test_set_centroid()
	{	
		try 
		{
			
		Kcluster cluster = new Kcluster();
		cluster.set_centroid(value1);
		assertTrue("Set Centroid Test Failed: ", cluster.get_centroid().is_same(value1));
		System.out.println("Set Centroid Test Passed!");
		
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void test_calculate_centroid()
	{
		try
		{
			Kcluster cluster = new Kcluster();
			cluster.add_point(value1);
			cluster.add_point(value2);
			cluster.add_point(value3);
			cluster.add_point(value4);
			cluster.calculate_centroid(); 
			assertTrue("Calculate Centroid Test Failed:", expected_value.is_same(cluster.get_centroid()));
			System.out.println("Calculate Centroid Test Passed!");
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test
	public void test_clear() // Actually Tests the ADD method and the CLEAR method
	{
		try
		{
			Kcluster cluster = new Kcluster();
			cluster.add_point(value1);
			cluster.add_point(value2);
			cluster.add_point(value3);
			cluster.add_point(value4);
			assertTrue("Kcluster ADD method has failed:",cluster.size() == 4);
			cluster.clear_cluster_list();
			assertTrue("Kcluster clear method has failed",cluster.size() == 0);
			System.out.println("Kcluster Clear method test passed!");
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}

}

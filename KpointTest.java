import static org.junit.Assert.*;
import org.junit.*;
import java.util.Random;


public class KpointTest {

	
	@Test
	public void initilization_test() // Tests the constructor for K_point
	{
		try
		{
			Random rand = new Random(); // allocates random ints to bes tested
			int test_x = rand.nextInt();
			int test_y = rand.nextInt();
			int test_z = rand.nextInt();
			
			Kpoint tester = new Kpoint(test_x,test_y,test_z); // creates K points based on random ints
			
			assertEquals("Initilization test failed: X Values do not match",test_x,tester.get_x_coord(),0);
			assertEquals("Initilization test failed: Y Values do not match",test_y,tester.get_y_coord(),0);
			assertEquals("Initilization test failed: Z Values do not match",test_z,tester.get_z_coord(),0);
			
			System.out.println("Initilization Test Passed!");
		}
		
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}

	@Test //Tests the get and set methods
	public void set_tests()
	{
		try
		{
			Random rand = new Random(); // Generates two random integers to test Kpoint against
			int x_input = rand.nextInt();
			int y_input = rand.nextInt();
			
			Kpoint tester = new Kpoint(0,0); // new Kpoint
			
			tester.set_x_coord(x_input); // setting x coord
			tester.set_y_coord(y_input); // setting y coord
			
			assertEquals("Set X Test failed: X Value Set Test Failed",x_input,tester.get_x_coord(),0);
			assertEquals("Set Y Test failed: Y Value Set Test Failed",y_input,tester.get_y_coord(),0);
			
			System.out.println("Initilization Tests Passed");
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}
	@Test //tests euclidean method
	public void euclid_test()
	{ // testing distance of two 2D points.
		try
		{
			Kpoint test1 = new Kpoint(5,8);
			Kpoint test2 = new Kpoint(4,11);
			
			assertEquals("Ecludian Method Failed:", Kpoint.euclidean_distance(test1, test2), Math.sqrt(10),0);
			
			System.out.println("Euclidean Test Passed!");
			
		}
		catch(AssertionError e)
		{
			System.out.println(e.getMessage());
		}
	}
}

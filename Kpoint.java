import java.lang.Math;

public class Kpoint {

	/**
	 * @param args
	 */
	
	private double x_coord;
	private double y_coord;
	private double z_coord;
	
	public Kpoint() // Default constructor
	{
		x_coord = 0;
		y_coord = 0;
		z_coord = 0;
	}
	public Kpoint(final double input_x, final double input_y) //  2D Constructor;
	{
		x_coord = input_x;
		y_coord = input_y;
		z_coord = 0;
	}
	
	public Kpoint(final double input_x, final double input_y, final double input_z) // 3D constructor
	{
		x_coord = input_x;
		y_coord = input_y;
		z_coord = input_z;
	}
	public Kpoint( final Kpoint copy_me) // Copy Constructor
	{
		x_coord = copy_me.get_x_coord();
		y_coord = copy_me.get_y_coord();
		z_coord = copy_me.get_z_coord();
		
	}
	
	public double get_x_coord()
	{return x_coord;}
	
	public double get_y_coord()
	{return y_coord;}
	
	public double get_z_coord()
	{return z_coord;}

	public void set_x_coord(final double input) // sets x coordiante
	{x_coord = input;}
	
	public void set_y_coord(final double input) // sets y coordinate
	{y_coord = input;}
	
	public void set_z_coord(final double input) // sets z coordinate
	{z_coord = input;}
	
	
	public boolean is_same(final Kpoint input) // returns true if inpus matches calling Kpoint, false otherwise
	{
		if(this.x_coord == input.get_x_coord() && this.y_coord == input.get_y_coord() )
			return true;
		else
			return false;	
	}
	
	public static double euclidean_distance(final Kpoint input1, final Kpoint input2)
	{ // Takes two Kpoints and returns the euclidean distance between them as a double
		
		double distance = 0; // temp var
		distance = Math.pow((input1.get_x_coord()-input2.get_x_coord()),2); // add x distance
		distance = distance + Math.pow((input1.get_y_coord()-input2.get_y_coord()),2); // add y distance
		distance = distance + Math.pow((input1.get_z_coord()-input2.get_z_coord()),2); // add z distqnce
		distance = Math.sqrt(distance);
		
		return distance;
	}
	
	public void print() // Prints coordinates, if the z coordinate is 0 it is not printed.
	{
		if(z_coord != 0)
			System.out.println("("+ x_coord + "," + y_coord + "," + z_coord +")");
		else
			System.out.println("("+ x_coord + "," + y_coord +")");
	}
	
	

}

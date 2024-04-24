package ie.tudublin;


public class Main
{

	public void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Project());
    }

	
	public static void main(String[] args)
	{
	
		Main m = new Main();

	
		m.helloProcessing();
	}
	
}
package ie.tudublin;

import java.util.Scanner;

public class Menu {

    public void helloProcessing()
	{
		
        processing.core.PApplet.runSketch( null, new Project());
    }

    @SuppressWarnings("resource")
    public static void menu(String[] args)
    {
        Scanner key = new Scanner(System.in); 
        String input = key.nextLine();

        int ans = Integer.valueOf(input);

        switch (ans) {
            case 0:
                
                break;
        
            default:
                System.err.println("invalid options");
                break;
        }
        
        
    }
    
}

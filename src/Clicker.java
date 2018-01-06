import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Clicker {
private	String button_name;
private int x_axis, y_axis, delay_until_click, delay_after_click;

public Clicker(){
		this.delay_until_click = 0;
		this.delay_after_click = 0;
	}

public Clicker(String name, int x, int y){
	this.button_name = name;
	this.x_axis = x;
	this.y_axis = y;
}

public void set_button_name(String name){this.button_name = name;}
public void set_x_axis(int x){this.x_axis = x;}
public void set_y_axis(int y){this.y_axis = y;}

public String get_button_name(){return this.button_name;}
public int get_x_axis(){return this.x_axis;}
public int get_y_axis(){return this.y_axis;}


public void controller(){
//simulate_click_search(3295, 480, 700);
//pixel_rgb(3950, 675);


	for(int i = 0; i < 10000; i++) {
		int delay = 1000;
		simulate_click_search(3715, 990, delay);
		if (pixel_rgb(3950, 675) == -5460796) { //5460796  5592382
			System.out.println("True");
			simulate_click_search(3950, 675, delay); // click buy now
			simulate_click_search(3450, 645, delay);	//click ok button
			if (pixel_rgb(4050, 410) == -13329892) {
				simulate_click_search(2720, 150, delay); // back
			} else {
				simulate_click_search(3390, 642, delay); // not valid ok
				simulate_click_search(2720, 150, delay); // back
			}
		} else if (pixel_rgb(3515, 600) == -3202710) {
			simulate_click_search(3515, 600, delay); // modify search
		} else {
			simulate_click_search(2720, 150, delay); // back
		}
	}
}

/*
	modify search	// -3202710  // x 3515 y 600
	search button 					x 3715 y 990
	buy now            -3026459 	x 3950 y 675
	ok button       				x 3450 y 645
	valid 			   -13329892	x 4050 y 410
	not valid 		   -263172 		x 3295 y 480
	back 							x 2720 y 150
	not valid ok button  			x 3390 y 642
 */
public int pixel_rgb(int x, int y){
	try {
		Robot robot = new Robot();
		Color color = robot.getPixelColor(x,y);
//		System.out.println(color.getRed());
//		System.out.println(color.getGreen());
//		System.out.println(color.getBlue());
		System.out.print("-5460796");
		System.out.print(color.getRGB());
		return color.getRGB();
	} catch (AWTException e) {
		System.err.println("Failed instantiating Robot: " + e);
	}
	return 0;
}

private void make_a_decision(){
	
}

private void simulate_click_search(int x, int y, int delay){
	try {
		Robot bot = new Robot();
			bot.mouseMove(x,y);
		    bot.mousePress(InputEvent.BUTTON1_MASK);
		    bot.mouseRelease(InputEvent.BUTTON1_MASK);
		    bot.delay(delay);
	} catch (AWTException e) {
		 System.err.println("Failed instantiating Robot: " + e);
	}
}
}

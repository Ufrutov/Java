package restaraunt;

import menu.Cola;
import citckhen.Dish;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cola.info();
		
		Cola.order();
		
		Dish.print(Short.toString(Cola.amount));
	}

}

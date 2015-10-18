package main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Util {
	
	public static void print(Class<?> dish, int index) {
		Class<?> noparams[] = {};
		try {
			Method method = dish.getMethod("dishInfo", noparams);
			try {
				if(index != 0)
					System.out.print(index+": ");
				method.invoke(index, noparams);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
}

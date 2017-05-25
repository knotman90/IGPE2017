package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import algo.NQueen;

public class HelloReflection {


	public static void printClassInfo(Class c){
		System.out.println("Name :" + c.getName());
		//is it a primitive type?
		System.out.print("This class is");
		if(!c.isPrimitive())
			System.out.print(" not ");
		System.out.println(" of primitive type");

		//get list of methods
		System.out.println();
		System.out.println("Methods : ");
		Method[] methods = c.getMethods();
		for(Method m : methods){
			System.out.print("\t"+m.getName());
			// Parameters
			Parameter[] parameters = m.getParameters();
			if(parameters.length>0){
				System.out.print( "( " );
				// also method.getParameterCount() is possible
				for( Parameter parameter : parameters ){
					System.out.print(parameter.getName() + " - " +parameter.getType());
				}
				System.out.print(")");
			}
			System.out.println();
		}
		System.out.println();

		//get Annotations
		Annotation[] ann = c.getAnnotations();
		for(Annotation a : ann){
			System.out.print(a.toString());
		}

		//fields
		System.out.println();
		System.out.println("Fields:");
		Field[] fields = c.getDeclaredFields(); //public private and protected
		for(Field f : fields){
			System.out.print("\t"+f.toString()+ " -> ");
			if(!f.isAccessible())
				System.out.print(" NOT ");
			System.out.println("accessible");

			f.setAccessible(true);//now accessible via f.get(instance)

		}

		System.out.println("\nConstructors\n");
		//get constructors
		Constructor[] constructors = c.getConstructors();//only accesssible constructors
		for(Constructor cs : constructors){
			System.out.print(cs.getName()+ ":#params=" + cs.getParameterCount());
			
			
			
		}


	}
	public static void main(String[] args) {
		Class sc = NQueen.class;
		printClassInfo(sc);


	}

}

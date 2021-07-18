package coreJava.p05.reflection;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String name ;
        if(args.length > 0)name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("entry class name ");
            name = in.next();
        }

        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();

        String modifiers = Modifier.toString(cl.getModifiers());
        if(modifiers.length() > 0) System.out.println(modifiers+" ");
        System.out.println( name + "(");

        if(supercl != null && supercl != Object.class) System.out.println(" extends "+supercl.getName());

        System.out.println("--------------1--------------");
        printConstructors(cl);

        System.out.println("--------------2--------------");
        printFields(cl);

        System.out.println("-------------3--------------");
        printMethods(cl);


    }

    public static void printConstructors(Class cl){
        Constructor[] constructors = cl.getDeclaredConstructors();
        for(Constructor c : constructors){
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0) System.out.println(modifiers+" ");
            System.out.println(c.getName()+"(");

            Class[] param = c.getParameterTypes();
            for(int j = 0 ; j < param.length ; j++){
                if(j > 0) System.out.println(",");
                System.out.println(param[j].getName());
            }
            System.out.println(");");
        }
    }


    public static void printMethods(Class cl){
        Method[] methods = cl.getMethods();
        for(Method m : methods){
            Class retType = m.getReturnType();

            String name = m.getName();

            String modifiers = Modifier.toString(m.getModifiers());
            if(modifiers.length() > 0) System.out.println(modifiers+" ");
            System.out.println(retType.getName()+" "+ name + "(");

            Class[] param = m.getParameterTypes();
            for(int j = 0 ; j < param.length ; j++){
                if(j > 0) System.out.println(",");
                System.out.println(param[j].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl){
        Field[] fields = cl.getDeclaredFields();
        for(Field f: fields){
            Class type = f.getType();
            String name = f.getName();
            System.out.println("  ");
            String modifiers = Modifier.toString(f.getModifiers());
            if(modifiers.length() > 0) System.out.println(modifiers+" ");
            System.out.println(type.getName()+" "+ name + ";");
        }
    }


}

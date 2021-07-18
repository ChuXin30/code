package coreJava.p08.genericReflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Scanner;

public class GenericReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException {
        String name;
        if( args.length > 0 ) name = args[0];
        else {
            try(Scanner scanner = new Scanner(System.in)){
                System.out.println("enter class name ");
                name = scanner.next();
            }
        }


        Class<?> cl = Class.forName(name);
        printClass(cl);
        for(Method m : cl.getDeclaredMethods()){
            printMethod(m);
        }
    }

    public static void printClass(Class<?> cl){
        System.out.println(cl);
        printType(cl.getTypeParameters() , "<" , "," , ">" , true);
        Type sc = cl.getGenericSuperclass();
        if(sc != null){
            System.out.println(" extends ");
            printType(sc,  false);
        }
        printType(cl.getTypeParameters() , " implements " , "," , "" , true);
        System.out.println();
    }

    public static void printMethod(Method m){
        String name = m.getName();
        System.out.println(Modifier.toString(m.getModifiers()));
        System.out.print(" ");
        printType(m.getTypeParameters() , "<" , "," , ">" , true);

        printType(m.getReturnType(),  false);
        System.out.print(" ");
        System.out.print(name);
        System.out.print("(");

        printType(m.getTypeParameters() , "" , "" , "" , false);
        System.out.print(")");
    }

    public static void printType(Type[] types , String pre , String sep , String suf , boolean isDefinition ){
        if( pre.equals(" extends ") && Arrays.equals(types , new Type[] { Object.class }))
            return;

        if( types.length > 0 ) System.out.print(pre);

        for(int i = 0 ;  i < types.length ; i++){
            if(i > 0) System.out.print(sep);
            printType(types[i] , isDefinition);
        }
        if(types.length > 0 ) System.out.print(suf);

    }


    public static void printType(Type type , boolean isDefinition){
        if(type instanceof Class ){
            Class<?> t = (Class<?>)type;
            System.out.print(t.getName());
        }else if(type instanceof TypeVariable){
            TypeVariable typeVariable = (TypeVariable<?>) type;
            System.out.print(typeVariable.getName());
            if(isDefinition){
                printType(typeVariable.getBounds() , " extends " , " & " , "" , false );
            }
        }else if(type instanceof WildcardType){
            WildcardType t = (WildcardType) type;
            System.out.print("?");
            printType(t.getUpperBounds() , " extends " , " & " , "" , false);
            printType(t.getLowerBounds() , " super " , " & " , "" , false);
        }else if(type instanceof ParameterizedType ){
            ParameterizedType t = (ParameterizedType) type;
            Type owner = t.getOwnerType();
            if(owner != null){
                printType(owner,false);
                System.out.print(".");
            }
            printType(t.getRawType() , false);
            printType(t.getActualTypeArguments() , "<" , ", " , ">" , false);
        }else if(type instanceof GenericArrayType){
            GenericArrayType t = (GenericArrayType) type;
            System.out.print("");
            printType(t.getGenericComponentType() , isDefinition);
            System.out.print("[]");
        }
    }

}

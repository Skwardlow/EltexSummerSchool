package ru.skwardlow.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;

public class Reflection {

        public static void main(String[] args) {
            LinkedList<Double> list = new LinkedList<>();
            Class arraysInfo = list.getClass();

            System.out.println("Название класса: " + arraysInfo.getName());

            Field[] fields = arraysInfo.getFields();

            System.out.println("\nПоля класса:\n");

            for(Field field : fields) {
                System.out.println(field.getName());
            }

            System.out.println("\nМетоды класса:\n");

            Method[] methods = arraysInfo.getMethods();
            for(Method method : methods) {
                System.out.println(method.getName());
            }
        }
    }

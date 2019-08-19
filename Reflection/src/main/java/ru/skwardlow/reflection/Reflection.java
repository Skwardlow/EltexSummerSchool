package ru.skwardlow.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Reflection {

        public static void main(String[] args) {
            ArrayList<Double> list = new ArrayList<>();
            Class arraysInfo = list.getClass();

            System.out.println("Task 2: Java рефлексия");
            System.out.println("Название класса: " + arraysInfo.getName());
            Field[] fields = arraysInfo.getFields();

            System.out.println("Поля класса:");
            for(Field field : fields) {
                System.out.println(field.getName());
            }

            System.out.println("Методы класса:");
            Method[] methods = arraysInfo.getMethods();
            for(Method method : methods) {
                System.out.println(method.getName());
            }
        }
    }

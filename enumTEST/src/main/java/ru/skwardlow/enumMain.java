package ru.skwardlow;

import java.util.Scanner;

public class enumMain {
    public static void main(String[] args) {
        WorkDay workDay = WorkDay.FRIDAY;
        String str = " ";

        System.out.println("Tell me the day in UPPERCASE (idk why, but .toUpperCase doesn't work on my machine)");
        Scanner scanner = new Scanner(System.in);

        str = scanner.nextLine();
        try {
            workDay = WorkDay.valueOf(str);
        }
        catch (Exception e){
            workDay = WorkDay.FOO;
        }

        switch (workDay){
            case MONDAY:
                System.out.println("Uhh, it's monday again <_<");
                break;

            case THUESDAY:
                System.out.println("I hate my job, f*ck this thuesdays");
                break;

            case WEDNESDAY:
                System.out.println("It's wednesday, can't wait to my friday");
                break;

            case THURSDAY:
                System.out.println("Ooh! It's Thursday now, today is Luci's Birthday!");
                break;

            case FRIDAY:
                System.out.println("WHOOOAHOOOO, ITS FRIDAY!!!!");
                break;

            case SATURDAY:
                System.out.println("Today is the best Saturday ever");
                break;

            case SUNDAY:
                System.out.println("Hehe, i meet Julie today, but tomorrow is MONDAY!!11!");
                break;

            case FOO:
                System.out.println("Theres no " + str + " in week :/");
                break;
        }
        System.out.println("There's " + WorkDay.FOO.ordinal() + " days in week");
    }
}

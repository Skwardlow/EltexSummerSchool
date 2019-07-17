package ru.skwardlow;
import java.util.Scanner;
public class calc {
    public final static void main(String[] args){
        System.out.println("Simple two nubers calculator IN ABS");
        Scanner in = new Scanner(System.in);
        String buff = in.nextLine();
        String[] tempstr=buff.split(" ");

        Double FOperand = Double.valueOf(tempstr[0]);
        String Operation = tempstr[1];
        Double SOperand = Double.valueOf(tempstr[2]);

        double Result;



        switch (Operation){
            case "+":
                Result = FOperand + SOperand;
                break;

            case "-":
                Result=(FOperand-SOperand)<0 ? (SOperand-FOperand):(FOperand-SOperand);
                break;

            case "*":
                Result = FOperand * SOperand;
                break;

            case "/":
                Result = FOperand / SOperand;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + tempstr[1]);
        }

        System.out.println("The result is \n");
        System.out.print(Result);

        in.close();

    }
}

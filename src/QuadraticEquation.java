import java.util.Scanner;

//Ex7
public class QuadraticEquation {
    public static final int ARRAY_SIZE = 11;
    public static final int CHANGE_TO_NUMBER=48;
    public static void main(String[] args) {
        int paramA;
        int paramB;
        int paramC;
        char[] option =inArray("ax^2+bx+c=0");
        String userString = userString();
        if (userString.length()!=11|userString.length()!=12){
            System.out.println("Invalid input");
        }else {
        char[] userQuadratic=inArray(userString);
        if(isProper(userString,option)) {
            paramA = userQuadratic[10] - CHANGE_TO_NUMBER;
            paramB = userQuadratic[5] - CHANGE_TO_NUMBER;
            paramC = userQuadratic[2] - CHANGE_TO_NUMBER;
            solution(paramA, paramB, paramC);
        }
        }
    }

    public static String userString() {
        Scanner scanner = new Scanner(System.in);
        String userString;
        System.out.println("Here is a system for solving a quadratic equation.\n" +
                "Please write a quadratic equation that you want to solve\n" +
                "The equation should be in the following format: ax^2+bx+c=0");
        userString = scanner.nextLine();
        return userString;
    }
    public static char[] inArray (String str){

        char[] userQuadraticEquation = new char[ARRAY_SIZE];
        for (int i =0; i <ARRAY_SIZE; i++) {
          userQuadraticEquation[i]= str.charAt(str.length()-(i+1));
        }
        return userQuadraticEquation;
    }
    public static boolean isExists(char[] userQuadratic, int index){
        boolean isExists = false;
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        for (int i = 0; i < numbers.length; i++) {
            if (userQuadratic[index]==numbers[i]){
            isExists = true;
            }
        }
       return isExists;
    }

    public static boolean isProper(String userString , char[] option) {
        boolean isProper = true;
        char[] userQuadratic = inArray(userString);
        if (isExists(userQuadratic,2)){
            if (isExists(userQuadratic,5)){
                if (isExists(userQuadratic,10)){
                    for (int i = 0; i < userQuadratic.length; i++) {
                        if (i==2||i==5||i==10){
                            continue;
                        }else if (userQuadratic[i]!=option[i]){
                           isProper=false;
                           break;
                       }
                    }
                }
            }
        }
        return isProper;
    }

    public static double RootCalculation(int paramA, int paramB, int paramC) {
        double rootResult = Math.sqrt((paramB * paramB) - (4 * paramA * paramC));
        return rootResult;
    }

    public static void solution(int paramA, int paramB, int paramC) {
        if (RootCalculation(paramA, paramB, paramC) == 0) {
            System.out.println("There is one result x1 = " + (-paramB) / 2);
        } else {
            if (RootCalculation(paramA, paramB, paramC) > 0) {
                double resultOne = (((-paramB) + RootCalculation(paramA, paramB, paramC)) / 2);
                double resultTwo = (((-paramB) - RootCalculation(paramA, paramB, paramC)) / 2);
                System.out.println("There are two results. x1 = " + resultOne + " , x2 = " + resultTwo);
            } else {
                System.out.println("There is no solution");
            }
        }
    }
}

import java.util.Scanner;
//Ex9
public class GuessingGame {
    public static final int ARRAY_SIZE = 4;
    public static void main(String[]args){
        int [] password =new int[ARRAY_SIZE];
        password = inPassword(password,0);
        int[] guess = new int[ARRAY_SIZE];
        System.out.println("Break into the safe");
        printRullReturnDifficulty();
        int isAccurateGuessing = 0;
        int difficulty =userChoiseDifficult();
        int opportunities = opportunities(difficulty);
        numberGuess(opportunities,isAccurateGuessing,password,difficulty);
    }
    public static void printRullReturnDifficulty () {
        System.out.println("The safe box has a code of 4 different digits, from the number 1-6.\n" +
                "You have to guess the 4-digit code.");
        System.out.println("Please select the difficulty level:\n" +
                "1) Easy track: 20 opportunities\n" +
                "2. Medium track: 15 opportunities\n" +
                "3. Hard track: 10 opportunities\n" +
                "4. Surprising track: The number of opportunities is drawn between the values 5-25.");
    }
    public static int userChoiseDifficult(){
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        do {
            System.out.println("chose difficulty level between 1-4:");
            userChoice= scanner.nextInt();
        }while (isNotBetween(userChoice,5 , 0));
        return userChoice;
    }
    public static final int EZAY_MODE = 1;
    public static final int MEDIUM_MODE = 2;
    public static final int HARD_MODE = 3;
    public static final int SURPRISING_MODE = 4;
    public static int opportunities(int userChoise){
        int opportunities =0;
        switch (userChoise){
            case EZAY_MODE:
                opportunities=20;
                break;
            case MEDIUM_MODE:
                opportunities=15;
                break;
            case HARD_MODE:
                opportunities=10;
                break;
            case SURPRISING_MODE:
                opportunities = randomNumber(25,5);
                break;
        }
        return opportunities;
    }
    public static void numberGuess(int opportunities , int isAccurateGuessing , int[] password, int difficulty) {
        Scanner scanner = new Scanner(System.in);
        int[] userGuess = new int[ARRAY_SIZE];
        int numberChoise = 0;
        int accurateGuessing = 0;
        do {
                if (difficulty != 4) {
                    System.out.println("You have " + opportunities + " opportunities \n" +
                            "Choose a number with 4 digits\n" +
                            "The digits must be between 1-6");
                } else {
                    System.out.println("Choose a number with 4 digits\n" +
                            "The digits must be between 1-6");

                }
                numberChoise = scanner.nextInt();
                while (isDigitNotProper(userGuess,numberChoise)==false){
                    numberChoise = scanner.nextInt();
                }
           if (isProper(userGuess,numberChoise)){
                accurateGuessing = isAccurateGuessing(password,userGuess);
                opportunities=opportunities-1;
            }else{
                opportunities=opportunities-2;
            }
        }while (endGame(accurateGuessing,opportunities)==false);
    }
    public static boolean isDigitNotProper (int[] guessNumber, int numberGuess){
        guessNumber =  inUserGuess(guessNumber, numberGuess,3);
        String str = "Choose a number with 4 digits\n" +
               "The digits must be between 1-6";
        boolean isDigitProper = true;
        if(isNotBetween(numberGuess,6667,1110)){
            System.out.println(str);
        }else {
            for (int i = 0; i < guessNumber.length; i++) {
                if (isNotBetween(guessNumber[i], 7, 0)) {
                    isDigitProper = false;
                    System.out.println(str);
                    break;
                }
            }
        }
       return isDigitProper;
    }
    public static boolean endGame(int isAccurateGuessing, int opportunities){
        boolean endGame = false;
        if (opportunities<0 || isAccurateGuessing == 4){
            if (isAccurateGuessing!=4){
                System.out.println("Game Over");
            }
            endGame = true;
        }
        return endGame;
    }
    public static boolean isNotBetween(int userchoise, int highNumber , int lowNumber){
        boolean isNotBetween = true;
        if (userchoise>lowNumber && userchoise<highNumber){
            isNotBetween=false;
        }
        return isNotBetween;
    }
    public static int isAccurateGuessing(int[] password , int[] guess){
        int accurateGuessing = 0;
        int partialGuess = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (password[i]==guess[i]){
                accurateGuessing++;
            }else {
                for (int j = 0; j < ARRAY_SIZE; j++) {
                    if (guess[i]== password[j]){
                        partialGuess++;
                    }
                }
            }
        }
        if (accurateGuessing==4){
            System.out.println("You won well done $$$$");
        }else {
            System.out.println("You guessed "+ accurateGuessing+" accurate and "+ partialGuess+" partial");
            System.out.println("Try agian");
        }
        return accurateGuessing;
    }
    public static int randomNumber(int highNumber , int lowNumber){
        int randomNumber = (int) ((Math.random() * (highNumber - lowNumber + 1)) + lowNumber);
        return randomNumber;
    }
    public static boolean isExists (int[] password,int randomNumber){
        boolean isExists = false;
        for (int i = 0; i < password.length; i++) {
            if (randomNumber==password[i]){
                isExists=true;
            }
        }
        return isExists;
    }
    public static int[] inUserGuess (int[] userGuess,int numberGuess , int index){
        while (index>=0){
            userGuess[index]=numberGuess%10;
            numberGuess=numberGuess/10;
            index = --index;
            inUserGuess(userGuess,numberGuess,index);
        }
        return userGuess;
    }

    public static boolean isProper (int[] userGuess, int numberChoise) {
        userGuess =  inUserGuess(userGuess, numberChoise,3);
        boolean isProper = true;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            if (isNotBetween(userGuess[i], 7, 0) == false) {
                for (int j = i + 1; j < ARRAY_SIZE; j++) {
                    if (userGuess[i] == userGuess[j]) {
                        isProper = false;
                    }
                }
            }
        }
        return isProper;
    }
    public static int[] inPassword (int[] password , int index){
        int highNumber =6;
        int lowNumber = 1;
        if (index<ARRAY_SIZE) {
            int nextNumber=randomNumber(highNumber,lowNumber);
            while (isExists(password, nextNumber)){
                nextNumber=randomNumber(highNumber,lowNumber);
            }
            password[index] = nextNumber;
            inPassword(password, (index + 1));
        }
        return password;
    }
}

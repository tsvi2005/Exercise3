//Ex2
public class TheBestBrothersNumber {
    public static void main (String[]args){
        int[] arrayOne = {5,6,7,2};
        int[] arrayTwo = {1,2,3,4,2};
        System.out.println(indexOfTheBestBrother(arrayOne,arrayTwo));
    }
    public static int indexOfTheBestBrother(int[] arrayOne, int[] arrayTwo){
        int indexTheBestBrother = 0;
        for (int i = 0; i <arrayOne.length ; i++) {
            if (checkNumberOfBrother(arrayOne[i], arrayTwo) > checkNumberOfBrother(arrayOne[indexTheBestBrother],arrayTwo)) {
                indexTheBestBrother = i;
            }
        }
        return indexTheBestBrother;
    }
    public static int checkNumberOfBrother(int number , int[] arrayTwo){
       int numberOfBrother = 0;
       int sumNumberOne =sumDigitNumber(number,0);
        for (int i = 0; i <arrayTwo.length ; i++) {
         if(sumNumberOne == sumDigitNumber(arrayTwo[i],0)){
           numberOfBrother++;
         }
        }
        return numberOfBrother;
    }


    public static int sumDigitNumber(int number , int sumNumber){
        while (number>=1) {
            sumNumber=sumNumber+number%10;
            number=number/10;
            sumDigitNumber(number,sumNumber);
        }
        return sumNumber;
    }

}

//Ex1
public class IsNumberChange {
    public static void main(String[]args){
        System.out.println(isNumberChange(111));
        int[] lessNumberChage = {1212,0,12,32,45};
        System.out.println(lessNumberChange(lessNumberChage));
    }
    public static boolean isOdd(int digit){
        boolean isOdd = false;
        if (digit%2 == 1){
            isOdd=true;
        }
        return isOdd;
    }
    public static int digitCount (int number){
        int digits = 0;
        while (number > 0)
        {
            number = number / 10;
            digits++;
        }
        return digits;
    }
    public static int[] inDigitOfNumber(int[] digitOfNumber, int number , int digit){
        while (number>=1) {
            digitOfNumber[digit] = number % 10;
            digit++;
            number=number/10;
        }
        return digitOfNumber;
    }
    public static boolean isNumberChange(int number){
        int[] digitOfNumber = new int[digitCount(number)];
        boolean isNumberChange=true;
        if (digitCount(number)==1){
            isNumberChange = true;
        }else{
          int[] digitNumber = inDigitOfNumber(digitOfNumber,number,0);
            for (int i = 0; i < digitNumber.length-1; i++) {
              if (isOdd(digitNumber[i])== isOdd(digitNumber[i+1])){
                  isNumberChange = false;
              }
            }
        }
         return isNumberChange;
    }
   public static int lessNumberChange(int[] positiveNumber){
        int lessSumDigit=-1 ;
        int sum=0;
        for (int i = 0; i < positiveNumber.length; i++) {
            if(isNumberChange(positiveNumber[i]) == true){
                if (sum==0) {
                    sum = sumDigit(positiveNumber, i);
                    lessSumDigit=i;
                }else if (sum>sumDigit(positiveNumber,i)) {
                        sum = sumDigit(positiveNumber, i);
                        lessSumDigit = i;
                    }
            }
        }
        return lessSumDigit;
    }
    public static int sumDigit(int[] positiveNumber, int index){
        int[] digitOfNumber= new int[digitCount(positiveNumber[index])];
        int[] sumCalculation = inDigitOfNumber(digitOfNumber,positiveNumber[index],0);
        int sumDigit = 0;
        for (int i = 0; i < sumCalculation.length; i++) {
            sumDigit = sumDigit + sumCalculation[i];
        }
        return sumDigit;
   }
}

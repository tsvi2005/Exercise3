//Ex3
public class Factorization {
    public static void main (String[] args){
    int number = 121;
        int [] arr = factorizationNumbers(number);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

     public static int[] factorizationNumbers(int number){
        int[] factorizationNumbers = new int[number/2];
        int count=0;
            for (int i = 2; i <= factorizationNumbers.length; i++) {
               while (number %i ==0){
                   factorizationNumbers[count]=i;
                   count++;
                   number = number / i;
                   if (number==1){
                       break;
                   }
                }
            }
            return factorizationNumbersCount(factorizationNumbers,count);
        }
       public static int[] factorizationNumbersCount(int[] factorizationNumbers,int count){
        int[] factorizationNumbersCount = new int[count];
           for (int i = 0; i < factorizationNumbersCount.length; i++) {
               factorizationNumbersCount[i]=factorizationNumbers[i];
           }
           return factorizationNumbersCount;
       }
    }


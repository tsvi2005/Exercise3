import jdk.swing.interop.SwingInterOpUtils;

//Ex4
public class FullArray{
    public static void main (String[] args){
        int[] ssss = {123,122,121,120,116};
        System.out.println(isFullArraySort(ssss));
        int[] sss = {111};
        System.out.println(isFullArray(sss));
    }
    public static boolean isFullArraySort(int[] arraySortIntegers){
        boolean isFullArray = true;
        for (int i = 0; i < arraySortIntegers.length-1; i++) {
            if (arraySortIntegers[i]!=(arraySortIntegers[i+1]+1)){
                isFullArray = false;
                break;
            }
        }
        return isFullArray;
    }

    //בדיקה האם המערך הוא מלא כאשר הוא לא ממויין
    public static boolean isFullArray(int[] arrayIntegers){
    selectionSort(arrayIntegers);
    boolean isFullArray = true;
        for (int i = 0; i < arrayIntegers.length-1; i++) {
            if ((arrayIntegers[i]+1)!=arrayIntegers[i+1]){
               isFullArray = false;
              break;
            }
        }
        return isFullArray;
    }
    public static void selectionSort (int[] arrayIntegers)//מיון מערך בחירה
    {
        for (int i=0; i < arrayIntegers.length-1; i++)
        {
            int smallest = i;
            for (int j = i+1; j < arrayIntegers.length; j++)
                if (arrayIntegers[j] < arrayIntegers[smallest])
                    smallest = j;
            if (smallest != i)
            {
                int temp = arrayIntegers[smallest];
                arrayIntegers[smallest] = arrayIntegers[i];
                arrayIntegers[i] = temp;
            }
        }
    }
}




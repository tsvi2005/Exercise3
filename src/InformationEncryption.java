//Ex5
public class InformationEncryption {
    public static void main (String[]args){
    String toreplace = "eakt ehis etxe etse ie";
        System.out.println(letterReplacement(toreplace));
    }
    public static String letterReplacement (String toRplacement){
        String afterReplace ="";
    int[] twoHighIncidence = twoHighIncidence(toRplacement);
        for (int i = 0; i < toRplacement.length(); i++) {
            if(toRplacement.charAt(i)==toRplacement.charAt(twoHighIncidence[0])){
               afterReplace = afterReplace + toRplacement.charAt(twoHighIncidence[1]);
            }else if(toRplacement.charAt(i)==toRplacement.charAt(twoHighIncidence[1])){
                afterReplace = afterReplace + toRplacement.charAt(twoHighIncidence[0]);
            }else {
                afterReplace = afterReplace + toRplacement.charAt(i);
            }
        }
        return afterReplace;
    }
    public static int[] twoHighIncidence(String toCheck){
        int biggestCount = 0;
        int secondCount = 1;
            for (int j = 1; j < toCheck.length(); j++) {
                if (toCheck.charAt(j)==' '){
                    continue;
                }else if (checkIncidence(toCheck,j)>checkIncidence(toCheck,secondCount) && toCheck.charAt(biggestCount)!= toCheck.charAt(j)){
                   if (checkIncidence(toCheck,j)>checkIncidence(toCheck,biggestCount)){
                       secondCount=biggestCount;
                       biggestCount=j;
                   }else {
                       secondCount = j;
                   }
               }
            }
        int[] twoHighIncidence = {biggestCount,secondCount};
        return twoHighIncidence;
    }
    public static int checkIncidence (String toCheck,int index){
        int count = 0;
        for (int i = 0; i <toCheck.length() ; i++) {
             if (toCheck.charAt(i)==toCheck.charAt(index)){
                count++;
             }
        }
        return count;
    }
}

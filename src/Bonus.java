//EX6
public class Bonus {

        private static int applyOperator(char operand, int firstNum, int secondNum){
            switch (operand) {
                case '*':
                    firstNum *= secondNum;
                    break;
                case '^':
                    firstNum  = (int) Math.pow(firstNum, secondNum);
                    break;
                case '+':
                    firstNum = secondNum;
                    break;
                case '-':
                    firstNum = -secondNum;
                    break;
            }
            return firstNum;
        }

        public static int calc(String str){
            int sum = 0;
            int lastApplyOpRes = 0;
            int lastNum = 0;
            int len = str.length();
            char prevOperator = '+';

            for (int i = 0; i < len; i++) {
                char c = str.charAt(i);

                if (c >= '0' && c <= '9') {
                    lastNum = lastNum * 10 + c - '0';
                    continue;
                }

                lastApplyOpRes = applyOperator(prevOperator, lastApplyOpRes , lastNum);
                lastNum = 0;

                switch (c) {
                    case '+':
                    case '-':
                        sum += lastApplyOpRes;
                        lastApplyOpRes = 0;
                        break;
                }

                prevOperator = c;
            }

            lastApplyOpRes = applyOperator(prevOperator, lastApplyOpRes , lastNum);

            return sum + lastApplyOpRes;
        }

        public static void main(String[] args) {
            System.out.println(calc("5^2+3"));
        }
}


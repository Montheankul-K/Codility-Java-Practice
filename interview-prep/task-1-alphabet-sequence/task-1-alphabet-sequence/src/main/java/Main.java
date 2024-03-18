import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String inputString = mockString(randomNumber(1, 5));
        boolean havePairChar = solution(inputString);
        System.out.println(havePairChar);
    }

    public static int randomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static String mockString(int N) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int randomNumber = random.nextInt(2); // random 0 or 1
            char randomChar = (randomNumber == 0) ? 'a' : 'b';
            stringBuilder.append(randomChar);
        }

        return stringBuilder.toString();
    }

    public static boolean solution(String S) {
        char[] charArray = S.toCharArray();
        System.out.println(charArray);

        char beforeChar = charArray[0];
        char currentChar;
        boolean isB = false;

        if(beforeChar == 'b') {
            for(int i = 1; i < charArray.length; i++) {
                currentChar = charArray[i];
                if(currentChar != 'b') {
                    return false;
                }
            }
        }

        if(beforeChar == 'a') {
            for(int i = 1; i < charArray.length; i++) {
                currentChar = charArray[i];
                if(isB == true){
                    if(currentChar == 'a') {
                        return false;
                    }
                }
                if(currentChar == 'b' && isB == false) {
                    isB = true;
                }
            }
        }
        return true;
    }
}

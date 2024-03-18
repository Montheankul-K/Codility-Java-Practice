import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String inputString = mockString(randomNumber(1, 10));
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
        char nextChar;

        for (int i = 1; i < charArray.length; i++) {
            currentChar = charArray[i];
            if(currentChar == beforeChar) {
                if(i < 2) {
                    nextChar = charArray[i + 1];
                    if (nextChar != currentChar) {
                        return true;
                    }
                } else {
                    if (currentChar != charArray[i - 2]) {
                        if (i == charArray.length - 1) {
                            return true;
                        } else {
                            nextChar = charArray[i + 1];
                            if (nextChar != currentChar) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}

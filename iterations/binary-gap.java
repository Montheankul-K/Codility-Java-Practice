import java.util.*;

class Solution {
    public int solution(int N) {
        // Implement your solution here
        ArrayList<Integer> binaryNumber = new ArrayList<>();

        while (N > 0) {
            binaryNumber.add(N % 2);
            N = N / 2;
        }

        int max = 0;
        int newMax = 0;
        int count = 0;
        int gapCount = 0;
        for (int bit : binaryNumber) {
            if (bit == 0) {
                count += 1;
            } else {
                gapCount += 1;
                newMax = count;
                if (newMax > max) {
                    max = newMax;
                    newMax = 0;
                }
                count = 0;
            }
        }

        if (gapCount > 1) {
            return max;
        } else {
            return 0;
        }
    }
}

// score 86
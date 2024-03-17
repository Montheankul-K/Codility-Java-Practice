import java.util.*;

class Solution {
    public int solution(int N, int M) {
        // Implement your solution here
        int firstChocolate = 0;
        int lastChocolate = N - 1;
        int nextChocolate = 0;
        int nextOmitChocolate = 0 + (M - 1);

        ArrayList<Integer> eatChocolateNumber = new ArrayList<>();
        ArrayList<Integer> omitChocolateNumber = new ArrayList<>();

        eatChocolateNumber.add(firstChocolate);
        omitChocolateNumber.add(nextOmitChocolate);

        for (int i = firstChocolate + M; i < lastChocolate; i++) {
            int currentChocolate = i;
            if (currentChocolate == firstChocolate + M) {
                eatChocolateNumber.add(currentChocolate);
                nextOmitChocolate = currentChocolate + (M - 1);
            }

            if (currentChocolate == nextOmitChocolate) {
                omitChocolateNumber.add(currentChocolate);
            }

            if (currentChocolate == nextChocolate) {
                eatChocolateNumber.add(currentChocolate);
                nextOmitChocolate = currentChocolate + (M - 1);
            }

            if (currentChocolate != firstChocolate + M && currentChocolate != nextOmitChocolate
                    && currentChocolate != nextChocolate) {
                eatChocolateNumber.add(currentChocolate);
            }
            nextChocolate = currentChocolate + M;
        }

        int count = eatChocolateNumber.size();
        return count;
    }
}

// score 0
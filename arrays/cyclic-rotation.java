class Solution {
    public int[] solution(int[] A, int K) {
        // Implement your solution here
        int[] numArray = A;
        int count = 0;
        while (count != K) {
            int lastNum = numArray[numArray.length - 1];
            for (int i = numArray.length - 2; i >= 0; i--) {
                numArray[i + 1] = numArray[i];
            }
            numArray[0] = lastNum;
            count++;
        }

        return numArray;
    }
}

// score 86
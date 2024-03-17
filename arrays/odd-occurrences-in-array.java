class Solution {
    public int solution(int[] A) {
        // Implement your solution here
        int[] numArray = A;
        int count = 0;
        int unPairNum = 0;
        for (int i = 0; i < numArray.length; i++) {
            int num = numArray[i];
            int index = i;
            for (int j = 0; j < numArray.length; j++) {
                if (numArray[j] == num && j != index) {
                    count++;
                }
            }

            if (count > 0) {
                count = 0;
            } else {
                unPairNum = num;
            }
        }

        return unPairNum;
    }
}

// score 55
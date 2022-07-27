import java.util.HashMap;
import java.util.Map;

public class bruteForce {

    private static Map<String, Integer> maxSumSubArray(int[] array) {

        Map<String, Integer> output = new HashMap<>();
        int maxSum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;

        for (int i = 0; i < array.length - 1; i++) {
            int tempMaxSum = array[i];
            int tempEnd = i;
            int total = array[i];
            for (int j = i + 1; j < array.length; j++) {
                total += array[j];
                if (total > tempMaxSum) {
                    tempMaxSum = total;
                    tempEnd = j;
                }
            }

            if (maxSum < tempMaxSum) {
                maxSum = tempMaxSum;
                start = i;
                end = tempEnd;
            }
        }
        output.put("sum", maxSum);
        output.put("start", start);
        output.put("end", end);

        return output;
    }

    public static void main(String[] args) {

        int[] array = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
        Map<String, Integer> answer = maxSumSubArray(array);

        System.out.printf("Maximum sum: %d\nStart index: %d\nEnd index: %d\n",
                answer.get("sum"), answer.get("start"), answer.get("end"));
    }
}

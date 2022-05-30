import java.util.Arrays;

public class Lesson6_Triangle {
    public int solution(int[] A) {
        // correctness 100%, performance 100%, O(N * log(N))
        int result = 0;
        if (A.length < 3) {
            return result;
        }

        Arrays.sort(A);
        for (int i=0; i<A.length - 2; i++) {
            long P = A[i];
            long Q = A[i + 1];
            long R = A[i + 2];
            if (P + Q > R
                    && Q + R > P
                    && R + P > Q) {
                return 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        final Lesson6_Triangle solution = new Lesson6_Triangle();
//        solution.solution(new int[]{5, 3, 3});
        solution.solution(new int[]{10, 2, 5, 1, 8, 20});
    }
}



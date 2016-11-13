package classification;

import java.util.List;
import java.util.Set;

/**
 * 소수 구하기
 */
public class Prime {

    /**
     * 주어진 자연수가 소수인지 여부 판단
     * @param number 자연수
     * @return
     */
    public static boolean isPrime(int number) {
        Set<Integer> factors = Factors.of(number);
        return number > 1 &&
                factors.size() == 2 &&
                factors.contains(1) &&
                factors.contains(number);
    }
}

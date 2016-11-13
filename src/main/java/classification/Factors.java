package classification;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 약수 구하기
 */
public class Factors {

    /**
     * 주어진 자연수의 약수 여부 판단
     * @param number 자연수
     * @param potential 약수 후보
     * @return
     */
    public static boolean isFactor(int number, int potential) {
        // static으로 선언함에 따라 부수효과가 없는 순수함수가 되었다.
        return number % potential == 0;
    }

    /**
     * 주어진 자연수의 모든 약수 반환
     * @param number 자연수
     * @return
     */
    public static Set<Integer> of(int number) {
        return IntStream
                .rangeClosed(1, number)
                .filter(x -> isFactor(number, x))
                .boxed() // 아직 아무것도 실행되지 않았다. 게으른 평가이다.
                .collect(Collectors.toSet());
    }

}

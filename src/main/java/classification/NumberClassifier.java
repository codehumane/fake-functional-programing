package classification;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 자연수 분류 (number factor classifier)
 *
 * 닐 포드의 <함수형 사고>라는 책에 따르면 클래스를 좀 더 함수적으로 만들기 위해 모든 메서드를 정적 메서드로 만들라고 한다.<br/>
 * 이렇게 하면 상태를 가지지 않기 때문에, 상태를 가짐으로써 생기는 모든 문제(같은 코드이고 같은 입력 값을 가지는데 다른 값이 나온다)를 피할 수 있다.<br/>
 * 더불어 불필요할 수 있는 인스턴스 생성도 피할수 있다.<br/>
 * 물론 단점도 존재한다. 인자들의 수가 점점 늘어난다. 현재 클래스는 상관 없겠지만 말이다.<br/>
 * 조금 더 나아갈 수 있지만 이 클래스에서 고민할 내용은 아니므로 생략한다.
 */
public class NumberClassifier {

    /**
     * potential이 number의 약수인지 여부 판단
     * @param number 자연수
     * @param potential 약수
     * @return
     */
    public static boolean isFactor(int number, int potential) {
        // static으로 선언함에 따라 부수효과가 없는 순수함수가 되었다.
        return number % potential == 0;
    }

    /**
     * number의 모든 약수 반환
     * @param number 자연수
     * @return
     */
    public static List<Integer> factorsOf(int number) {
        return streamFactorsOf(number)
                .boxed()
                .collect(Collectors.toList());
    }

    private static IntStream streamFactorsOf(int number) {
        // 아직 아무것도 실행되지 않았다. 게으른 평가이다.
        return IntStream
                .rangeClosed(1, number)
                .filter(x -> isFactor(number, x));
    }

    /**
     * number의 모든 약수 합
     * @param number 자연수
     * @return
     */
    public static int sumFactors(int number) {
        return streamFactorsOf(number).sum();
    }

    /**
     * 완전수(자기 자신을 제외한 약수들의 합이 자기 자신과 같음) 여부 판단
     * @param number
     * @return
     */
    public static boolean isPerfect(int number) {
        // '자기 자신을 제외한'을 좀더 명시적으로 드러내기 위해 - 연산자를 사용함
        return sumFactors(number) - number == number;
    }

    /**
     * 과잉수 여부 판단
     * @param number
     * @return
     */
    public static boolean isAbundant(int number) {
        return sumFactors(number) - number > number;
    }

    /**
     * 부족수 여부 판단
     * @param number
     * @return
     */
    public static boolean isDeficient(int number) {
        return sumFactors(number) - number < number;
    }
}

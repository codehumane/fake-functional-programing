package classification;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * number factor classifier
 */
public class NumberClassifier {

    public boolean isFactor(int number, int potential) {
        return number % potential == 0;
    }

    public List<Integer> factorsOf(int number) {
        return IntStream.rangeClosed(1, number)
                .filter(x -> isFactor(number, x))
                .boxed()
                .collect(Collectors.toList());
    }
}

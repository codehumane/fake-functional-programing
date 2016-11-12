package structure;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Either 흉내내기 테스트
 */
public class EitherTest {

    @Test
    public void left_왼쪽에_예외를_담아_반환() throws Exception {
        // given
        IllegalArgumentException expected = new IllegalArgumentException();
        Either<IllegalArgumentException, String> either = Either.left(expected);

        // then
        Assert.assertTrue(either.hasLeft());
        Assert.assertFalse(either.hasRight());
        Assert.assertEquals(expected, either.left());
        Assert.assertNull(either.right());
    }

    @Test
    public void right_오른쪽에_결과를_담아_반환() throws Exception {
        // given
        String expected = "결과이지요.";
        Either<IllegalArgumentException, String> either = Either.right(expected);

        // then
        Assert.assertFalse(either.hasLeft());
        Assert.assertTrue(either.hasRight());
        Assert.assertNull(either.left());
        Assert.assertEquals(expected, either.right());
    }
}
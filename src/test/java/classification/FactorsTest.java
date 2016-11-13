package classification;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FactorsTest {

    @Test
    public void isFactor_1은_1의_인수이다() throws Exception {
        Assert.assertTrue(Factors.isFactor(1, 1));
    }

    @Test
    public void isFactor_2는_4의_인수이다() throws Exception {
        Assert.assertTrue(Factors.isFactor(4, 2));
    }

    @Test
    public void isFactor_3는_4의_인수가_아니다() throws Exception {
        Assert.assertFalse(Factors.isFactor(4, 3));
    }

    @Test
    public void isFactor_5는_4의_인수가_아니다() throws Exception {
        Assert.assertFalse(Factors.isFactor(5, 4));
    }

    @Test
    public void factorsOf_1의_인수목록은_1이다() throws Exception {
        // given
        Set<Integer> expected = new HashSet<>(Arrays.asList(1));

        // when
        Set<Integer> result = Factors.of(1);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void factorsOf_6의_인수목록은_1236이다() throws Exception {
        // given
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 2, 3, 6));

        // when
        Set<Integer> result = Factors.of(6);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void factorsOf_13의_인수목록은_1과_13이다() throws Exception {
        // given
        Set<Integer> expected = new HashSet<>(Arrays.asList(1, 13));

        // when
        Set<Integer> result = Factors.of(13);

        // then
        Assert.assertEquals(expected, result);
    }
}
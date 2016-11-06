package classification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NumberClassifierTest {

    @Test
    public void isFactor_1은_1의_인수이다() throws Exception {
        Assert.assertTrue(NumberClassifier.isFactor(1, 1));
    }

    @Test
    public void isFactor_2는_4의_인수이다() throws Exception {
        Assert.assertTrue(NumberClassifier.isFactor(4, 2));
    }

    @Test
    public void isFactor_3는_4의_인수가_아니다() throws Exception {
        Assert.assertFalse(NumberClassifier.isFactor(4, 3));
    }

    @Test
    public void isFactor_5는_4의_인수가_아니다() throws Exception {
        Assert.assertFalse(NumberClassifier.isFactor(5, 4));
    }

    @Test
    public void factorsOf_1의_인수목록은_1이다() throws Exception {
        // given
        List<Integer> expected = Arrays.asList(1);

        // when
        List<Integer> result = NumberClassifier.factorsOf(1);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void factorsOf_6의_인수목록은_1236이다() throws Exception {
        // given
        List<Integer> expected = Arrays.asList(1, 2, 3, 6);

        // when
        List<Integer> result = NumberClassifier.factorsOf(6);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void factorsOf_13의_인수목록은_1과_13이다() throws Exception {
        // given
        List<Integer> expected = Arrays.asList(1, 13);

        // when
        List<Integer> result = NumberClassifier.factorsOf(13);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void sumFactors_6의_인수_총합은_12이다() throws Exception {
        Assert.assertEquals(12, NumberClassifier.sumFactors(6));
    }

    @Test
    public void isPerfect_6은_완전수이다() throws Exception {
        Assert.assertTrue(NumberClassifier.isPerfect(6));
        Assert.assertFalse(NumberClassifier.isAbundant(6));
        Assert.assertFalse(NumberClassifier.isDeficient(6));
    }

    @Test
    public void isAbundant_12는_과잉수이다() throws Exception {
        Assert.assertFalse(NumberClassifier.isPerfect(12));
        Assert.assertTrue(NumberClassifier.isAbundant(12));
        Assert.assertFalse(NumberClassifier.isDeficient(12));
    }

    @Test
    public void isDeficient_8은_부족수이다() throws Exception {
        Assert.assertFalse(NumberClassifier.isPerfect(8));
        Assert.assertFalse(NumberClassifier.isAbundant(8));
        Assert.assertTrue(NumberClassifier.isDeficient(8));
    }
}
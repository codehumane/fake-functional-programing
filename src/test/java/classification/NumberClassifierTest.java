package classification;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NumberClassifierTest {

    private NumberClassifier classifier;

    @Before
    public void setUp() {
        this.classifier = new NumberClassifier();
    }

    @Test
    public void isFactor_1은_1의_인수이다() throws Exception {
        Assert.assertTrue(classifier.isFactor(1, 1));
    }

    @Test
    public void isFactor_2는_4의_인수이다() throws Exception {
        Assert.assertTrue(classifier.isFactor(4, 2));
    }

    @Test
    public void isFactor_3는_4의_인수가_아니다() throws Exception {
        Assert.assertFalse(classifier.isFactor(4, 3));
    }

    @Test
    public void isFactor_5는_4의_인수가_아니다() throws Exception {
        Assert.assertFalse(classifier.isFactor(5, 4));
    }

    @Test
    public void factorsOf_1의_인수목록은_1이다() throws Exception {
        // given
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);

        // when
        List<Integer> result = classifier.factorsOf(1);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void factorsOf_6의_인수목록은_1236이다() throws Exception {
        // given
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(6);

        // when
        List<Integer> result = classifier.factorsOf(6);

        // then
        Assert.assertEquals(expected, result);
    }

    @Test
    public void factorsOf_13의_인수목록은_1과_13이다() throws Exception {
        // given
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(13);

        // when
        List<Integer> result = classifier.factorsOf(13);

        // then
        Assert.assertEquals(expected, result);
    }
}
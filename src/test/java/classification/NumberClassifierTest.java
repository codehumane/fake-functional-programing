package classification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class NumberClassifierTest {

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
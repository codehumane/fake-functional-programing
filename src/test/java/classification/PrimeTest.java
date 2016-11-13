package classification;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeTest {

    @Test
    public void isPrime_1은_소수가_아니다() throws Exception {
        Assert.assertFalse(Prime.isPrime(1));
    }

    @Test
    public void isPrime_1과_자기자신만을_약수로_가지면_소수이다() throws Exception {
        Assert.assertTrue(Prime.isPrime(2));
        Assert.assertTrue(Prime.isPrime(3));
        Assert.assertFalse(Prime.isPrime(4));
        Assert.assertTrue(Prime.isPrime(5));
        Assert.assertFalse(Prime.isPrime(6));
        Assert.assertTrue(Prime.isPrime(7));
        Assert.assertFalse(Prime.isPrime(8));
    }
}
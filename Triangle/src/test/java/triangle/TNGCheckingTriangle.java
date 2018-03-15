package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.print.Doc;

public class TNGCheckingTriangle {
    Triangle triangle;

    @DataProvider(name = "checkingZeroAndNegativeProvider")
    public Object[][] checkingZeroNegativeProviderData() {
        return new Object[][]
                {
                        {0d, 1d, 1d, "a<=0"},
                        {-1d, 1d, 1d, "a<=0"},
                        {1d, 0d, 1d, "b<=0"},
                        {1d, -1d, 1d, "b<=0"},
                        {1d, 1d, 0d, "c<=0"},
                        {1d, 1d, -1d, "c<=0"},
                        {0d, 0d, 0d, "a<=0 & b<=0 & c<=0"},
                };
    }

    @DataProvider(name = "checkingSumSidesProvider")
    public Object[][] checkSumSidesProvider() {
        return new Object[][]
                {
                        {1d, 2d, 3d, "a+b<=c"},
                        {1d, 3d, 2d, "a+c<=b"},
                        {3d, 2d, 1d, "b+c<=a"},
                        {1d, 1d, 1d, ""},
                };
    }

    @Test(dataProvider = "checkingZeroAndNegativeProvider")
    public void tstCheckingZero(Double a, Double b, Double c, String expected_result)
    {
        this.triangle = new Triangle(a, b, c);
        this.triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), expected_result, "[Fail with: " + a + ", " + b + ", " + c +
                ". Expected [\"" + expected_result +"\"] ]");
    }

    @Test(dataProvider = "checkingSumSidesProvider")
    public void tstCheckingSumSides(Double a, Double b, Double c, String expected_result)
    {
        this.triangle = new Triangle(a, b, c);
        this.triangle.checkTriangle();
        Assert.assertEquals(triangle.getMessage(), expected_result, "[Fail with: " + a + ", " + b + ", " + c +
                ". Expected [\"" + expected_result +"\"] ]");
    }

}

package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TNGCalculatingSquare {
    Triangle triangle;

    @DataProvider(name = "calculatingSquareProvider")
    public Object[][] calculatingSquareProviderData() {
        return new Object[][]
                {
                        {3d, 4d, 5d, 6d},
                        {(Double.POSITIVE_INFINITY - 2), (Double.POSITIVE_INFINITY - 3), (Double.POSITIVE_INFINITY - 4), Double.POSITIVE_INFINITY},
                };
    }

    @Test(dataProvider = "calculatingSquareProvider")
    public void tstCalculatingSquare(Double a, Double b, Double c, Double expected_result)
    {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.getSquare(), expected_result, "[Fail with: " + a + ", " + b + ", " + c +
                ". Expected [" + expected_result +"] ]");
    }

}

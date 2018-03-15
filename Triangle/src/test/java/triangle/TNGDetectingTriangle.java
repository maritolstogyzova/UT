package triangle;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TNGDetectingTriangle {
    Triangle triangle;

    @DataProvider(name = "detectingTriangleProvider")
    public Object[][] detectingTriangleProviderData() {
        return new Object[][]
                {
                        {1d, 1d, 1d, 3},   //EQUILATERAL & ISOSCELES
                        {2d, 2d, 3d, 2},   //ISOSCELES
                        {2d, 3d, 4d, 4},   //ORDYNARY
                        {3d, 4d, 5d, 8},   //RECTANGULAR
                        {1d, 1d, Math.sqrt(2), 10},   //ISOSCELES & RECTANGULAR
                };
    }

    @Test(dataProvider = "detectingTriangleProvider")
    public void tstDetectingTriangle(Double a, Double b, Double c, Integer expected_result)
    {
        triangle = new Triangle(a, b, c);
        Assert.assertEquals(triangle.detectTriangle(), (int)expected_result, "[Fail with: " + a + ", " + b + ", " + c +
                ". Expected [" + expected_result +"] ]");
    }

}

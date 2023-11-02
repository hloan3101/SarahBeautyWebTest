package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.ReviewOrderPage;
import ultilites.TestListener;

@Listeners(TestListener.class)
public class VerifyReviewOrderTest {

    private ReviewOrderPage reviewOrderPage;

    @Test (description = "Verify that the review order")
    public void verifyReviewOrder () throws InterruptedException {
        reviewOrderPage = new ReviewOrderPage();

        Assert.assertTrue(reviewOrderPage.reviewOder());
    }

}

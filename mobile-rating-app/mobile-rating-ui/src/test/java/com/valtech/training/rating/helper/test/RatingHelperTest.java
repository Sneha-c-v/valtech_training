package com.valtech.training.rating.helper.test;

import org.junit.Assert;
import com.valtech.training.mobile.rating.ui.RatingHelper;
import junit.framework.TestCase;

public class RatingHelperTest extends TestCase {
	public void testGetRating() {
		RatingHelper helper = new RatingHelper();
		Assert.assertEquals(0, helper.getRanking("9898989898"));
	}

}

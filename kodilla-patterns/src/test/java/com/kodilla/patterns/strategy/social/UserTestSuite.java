package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies(){
        //Given
        User patryk = new Millenials("Patryk");
        User christopher = new YGeneratrion("Krzysiu");
        User raphael = new ZGeneration("Rafał");

        //When
        String patrykSocialMedia = patryk.sharePost();
        System.out.println( patryk.getName() + " używa: " + patrykSocialMedia);

        String christopherSocialMedia = christopher.sharePost();
        System.out.println( christopher.getName() + " używa: " + christopherSocialMedia);

        String raphaelSocialMedia = raphael.sharePost();
        System.out.println( raphael.getName() + " używa: " + raphaelSocialMedia);

        //Then
        Assert.assertEquals("TwitterPublisher", patrykSocialMedia);
        Assert.assertEquals("FacebookPublisher", christopherSocialMedia);
        Assert.assertEquals("SnapchatPublisher", raphaelSocialMedia);
    }

    @Test
    public void testIndividualSharingStrategy(){
        //Given
        User patryk = new Millenials("Patryk");

        //When
        String patrykSocialMedia = patryk.sharePost();
        System.out.println( patryk.getName() + " używa: " + patrykSocialMedia);
        patryk.setSocialPublisher(new SnapchatPublisher());
        patrykSocialMedia = patryk.sharePost();
        System.out.println( patryk.getName() + " używa: " + patrykSocialMedia);

        //Then
        Assert.assertEquals("SnapchatPublisher", patrykSocialMedia);
    }
}

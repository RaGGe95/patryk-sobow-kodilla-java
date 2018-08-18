package com.kodilla.stream.forumuser;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;

public class ForumTestSuite {

    @Test
    public void testMapOfUsersWithGenderConditions(){
        /*
        Testing gender criterion, every other criterion is achieved
        */

        //Given
        ForumUser user1 = new ForumUser(1, "Patryk", 'M', LocalDate.of(2005,1 ,1 ),0 );
        ForumUser user2 = new ForumUser(2, "Marek", 'M', LocalDate.of(2005,1 ,1 ),0 );
        ForumUser user3 = new ForumUser(3, "Kamila", 'F', LocalDate.of(2005,1 ,1 ),0 );
        ForumUser user4 = new ForumUser(4, "Ania", 'F', LocalDate.of(2005,8 ,19 ),0 );
        Forum forum = new Forum(user1,user2, user3, user4 );

        //When
        Map<Integer, ForumUser> resultMap = forum.returnMapOfUsersWithSpecialConditions();

        //Then
        Assert.assertEquals(2, resultMap.size());

        Assert.assertTrue(resultMap.containsKey(3) && resultMap.containsKey(4));
        Assert.assertFalse(resultMap.containsKey(1) && resultMap.containsKey(2));

    }

    @Test
    public void testMapOfUsersWithAgeConditions(){
        /*
        Testing age criterion, every other criterion is achieved
        */

        //Given
        ForumUser user1 = new ForumUser(1, "Patryk", 'F', LocalDate.of(1990,1 ,1 ),0 );
        ForumUser user2 = new ForumUser(2, "Marek", 'F', LocalDate.of(1990,1 ,1 ),0 );
        ForumUser user3 = new ForumUser(3, "Kamila", 'F', LocalDate.of(2005,1 ,1 ),0 );
        ForumUser user4 = new ForumUser(4, "Ania", 'F', LocalDate.of(2005,8 ,19 ),0 );
        Forum forum = new Forum(user1,user2, user3, user4 );

        //When
        Map<Integer, ForumUser> resultMap = forum.returnMapOfUsersWithSpecialConditions();

        //Then
        Assert.assertEquals(2, resultMap.size());

        Assert.assertTrue(resultMap.containsKey(3) && resultMap.containsKey(4));
        Assert.assertFalse(resultMap.containsKey(1) && resultMap.containsKey(2));

    }

    @Test
    public void testMapOfUsersWithPublishedPostConditions(){
        /*
        Testing published post criterion, every other criterion is achieved
        */

        //Given
        ForumUser user1 = new ForumUser(1, "Patryk", 'F', LocalDate.of(2005,1 ,1 ),1 );
        ForumUser user2 = new ForumUser(2, "Marek", 'F', LocalDate.of(2005,1 ,1 ),2 );
        ForumUser user3 = new ForumUser(3, "Kamila", 'F', LocalDate.of(2005,1 ,1 ),3 );
        ForumUser user4 = new ForumUser(4, "Ania", 'F', LocalDate.of(2005,8 ,19 ),0 );
        Forum forum = new Forum(user1,user2, user3, user4 );

        //When
        Map<Integer, ForumUser> resultMap = forum.returnMapOfUsersWithSpecialConditions();

        //Then
        Assert.assertEquals(1, resultMap.size());

        Assert.assertTrue(resultMap.containsKey(4) );
        Assert.assertFalse(resultMap.containsKey(1) && resultMap.containsKey(2));

    }

}

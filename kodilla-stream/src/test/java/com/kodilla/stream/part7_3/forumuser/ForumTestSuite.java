package com.kodilla.stream.part7_3.forumuser;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collectors;

public class ForumTestSuite {

    public Map<Integer, ForumUser> returnMapOfUsersWithSpecialConditions(Forum forum) {
        return forum.getUserList().stream()
                .filter(user -> user.getGender() == 'F')
                .filter(user -> user.isYoungerThan20Version2())
                .filter(user -> user.getQuantityOfPublishedPost() == 0)
                .collect(Collectors.toMap(ForumUser::getID, user -> user));
    }

    @Test
    public void exampleForum(){
        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMapOfForumUsers = forum.returnMapOfUsersWithSpecialConditions();

        System.out.println("# elements: " + resultMapOfForumUsers.size());

        resultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }

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
        Map<Integer, ForumUser> resultMap = returnMapOfUsersWithSpecialConditions(forum);

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
        Map<Integer, ForumUser> resultMap = returnMapOfUsersWithSpecialConditions(forum);

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
        Map<Integer, ForumUser> resultMap = returnMapOfUsersWithSpecialConditions(forum);

        //Then
        Assert.assertEquals(1, resultMap.size());

        Assert.assertTrue(resultMap.containsKey(4) );
        Assert.assertFalse(resultMap.containsKey(1) && resultMap.containsKey(2));

    }

}

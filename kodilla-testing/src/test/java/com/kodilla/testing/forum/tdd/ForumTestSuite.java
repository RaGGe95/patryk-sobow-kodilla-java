package com.kodilla.testing.forum.tdd;

import com.kodilla.testing.forum.*;
import org.junit.*;


//Test suite for classes of Forum
public class ForumTestSuite {
    private static int testCounter = 0;
    private Person person = new Person("John", "Smith", "mrsmith");

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    // Check quantity of posts after add first post
    public void testAddPost() {
        //Given
        ForumUser forumUser = new ForumUser(person);

        //When
        forumUser.addPost(person,
                "Hello everyone, this is my first contribution here!");

        //Then
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }

    @Test
    // Check quantity of comments after add first comment
    public void testAddComment() {
        //Given
        ForumUser forumUser = new ForumUser(person);
        ForumPost thePost = new ForumPost(person, "Hello everyone, " +
                "this is my first contribution here!");

        //When
        //forumUser.addComment(person, thePost, "Thank you for all good words!");
        forumUser.addComment(person, thePost,"Thanks for good words!" );
        //Then
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }

    @Test
    // Check content of post after add that post
    public void testGetPost() {
        //Given
        ForumUser forumUser = new ForumUser(person);
        ForumPost thePost = new ForumPost(person, "Hello everyone, " +
                "this is my first contribution here!");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        ForumPost retrievedPost = forumUser.getPost(0);

        //Then
        Assert.assertEquals(thePost, retrievedPost);
    }

    @Test
    // Check content of comment after add that comment
    public void testGetComment() {
        //Given
        ForumUser forumUser = new ForumUser(person);
        ForumPost thePost = new ForumPost(person, "Hello everyone, " +
                "this is my first contribution here!");
        ForumComment theComment = new ForumComment(person, thePost,
                "first comment");
        forumUser.addComment(theComment.getAuthor(), thePost,
                theComment.getCommentBody());

        //When
        ForumComment retrievedComment = forumUser.getComment(0);

        //Then
        Assert.assertEquals(theComment, retrievedComment);
    }

    @Test
    // Check removing non-existing post equals false
    public void testRemovePostNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser(person);
        ForumPost thePost = new ForumPost(person ,"Hello everyone, " +
                "this is my first contribution here!" );

        //When
        boolean result = forumUser.removePost(thePost);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    // Check removing non-existing comments equals false
    public void testRemoveCommentNotExisting() {
        //Given
        ForumUser forumUser = new ForumUser(person);
        ForumPost thePost = new ForumPost(person, "Hello everyone, " +
                "this is my first contribution here!");
        ForumComment theComment = new ForumComment(person ,thePost,
                "Thank you for all good words!");

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assert.assertFalse(result);
    }

    @Test
    // Check remove post ended successful and quantity of posts after remove one
    public void testRemovePost() {
        //Given
        ForumUser forumUser = new ForumUser(person);
        ForumPost thePost = new ForumPost(person, "Hello everyone, " +
                "this is my first contribution here!");
        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody());

        //When
        boolean result = forumUser.removePost(thePost);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getPostsQuantity());
    }

    @Test
    // Check remove comment ended successful and quantity of comments after remove one
    public void testRemoveComment() {
        //Given
        ForumUser forumUser = new ForumUser(person);
        ForumPost thePost = new ForumPost(person,"Hello everyone, " +
                "this is my first contribution here!");
        ForumComment theComment = new ForumComment(person, thePost,
                "Thank you for all good words!");
        forumUser.addComment( theComment.getAuthor(), thePost,
                theComment.getCommentBody());

        //When
        boolean result = forumUser.removeComment(theComment);

        //Then
        Assert.assertTrue(result);
        Assert.assertEquals(0, forumUser.getCommentsQuantity());
    }

}
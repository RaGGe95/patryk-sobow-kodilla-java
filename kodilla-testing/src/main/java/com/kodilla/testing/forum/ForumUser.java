package com.kodilla.testing.forum;

import java.util.ArrayList;
import java.util.LinkedList;

public class ForumUser {
    private final Person user;
    private ArrayList<ForumPost> posts = new ArrayList<ForumPost>();
    private LinkedList<ForumComment> comments = new LinkedList<ForumComment>();

    public ForumUser(Person user) {
        this.user = user;
    }

    public void addPost(Person author, String postBody){
        ForumPost thePost = new ForumPost(author, postBody);
        posts.add(thePost);
    }

    public void addComment(Person author, ForumPost thePost, String commentBody){
        ForumComment theComment = new ForumComment(author, thePost, commentBody);
        comments.add(theComment);
    }

    public int getPostsQuantity(){
        return posts.size();
    }

    public int getCommentsQuantity(){
        return comments.size();
    }

    public ForumPost getPost(int postNumber){
        ForumPost thePost = null;
        if (postNumber >= 0 && postNumber < posts.size()) {
            thePost = posts.get(postNumber);
        }
        return thePost;
    }

    public ForumComment getComment(int commentNumber){
        ForumComment theComment = null;
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            theComment = comments.get(commentNumber);
        }
        return theComment;
}

    public boolean removePost(ForumPost thePost){
        boolean result = false;
        if (posts.contains(thePost)){
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment){
        boolean result = false;
        if (comments.contains(theComment)){
            comments.remove(theComment);
            result = true;
        }
        return result;
    }

    public String getNickName() {
        return user.getNickName();
    }

    public String getRealName() {
        return user.getFirstName() + " " + user.getLastName();
    }
}
package com.kodilla.testing.forum.statistics;

import com.sun.org.glassfish.external.statistics.Statistic;

import java.util.List;

public class CalculateAdvStatistics {
    private int UsersQuantity;
    private int PostsQuantity;
    private int CommentsQuantity;
    private int AveragePostsOnUser = 0;
    private int AverageCommentsOnUser = 0;
    private int AverageCommentsOnPost = 0;

    public CalculateAdvStatistics(Statistics statistics) {
        List<String> usersNamesList = statistics.usersNames();
        UsersQuantity = usersNamesList.size();

        PostsQuantity = statistics.postsCount();

        CommentsQuantity = statistics.commentsCount();

        if (UsersQuantity != 0) {
            AveragePostsOnUser = PostsQuantity / UsersQuantity;
            AverageCommentsOnUser = CommentsQuantity / UsersQuantity;
        }

        if (PostsQuantity != 0) {
            AverageCommentsOnPost = CommentsQuantity / PostsQuantity;
        }
    }

    protected int getUsersQuantity() {
        return UsersQuantity;
    }

    protected int getPostsQuantity() {
        return PostsQuantity;
    }

    protected int getCommentsQuantity() {
        return CommentsQuantity;
    }

    protected int getAveragePostsOnUser() {
        return AveragePostsOnUser;
    }

    protected int getAverageCommentsOnUser() {
        return AverageCommentsOnUser;
    }

    protected int getAverageCommentsOnPost() {
        return AverageCommentsOnPost;
    }
}

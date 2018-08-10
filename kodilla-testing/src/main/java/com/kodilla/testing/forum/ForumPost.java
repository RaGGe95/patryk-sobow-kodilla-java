package com.kodilla.testing.forum;


public class ForumPost {
    private final Person author;
    private String postBody;


    public ForumPost( Person author, String postBody) {
        this.author = author;
        this.postBody = postBody;
    }

    public String getPostBody() {
        return postBody;
    }

    public Person getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumPost forumPost = (ForumPost) o;

        if (!getPostBody().equals(forumPost.getPostBody())) return false;
        return getAuthor().equals(forumPost.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = getPostBody().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }
}

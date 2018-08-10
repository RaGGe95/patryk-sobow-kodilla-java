package com.kodilla.testing.forum;

public class ForumComment {
    private final Person author;
    private final ForumPost forumPost;
    private String commentBody;


    public ForumComment(Person author, ForumPost forumPost, String commentBody ) {
        this.author = author;
        this.forumPost = forumPost;
        this.commentBody = commentBody;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public Person getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumComment that = (ForumComment) o;

        if (!getForumPost().equals(that.getForumPost())) return false;
        if (!getCommentBody().equals(that.getCommentBody())) return false;
        return getAuthor().equals(that.getAuthor());
    }

    @Override
    public int hashCode() {
        int result = getForumPost().hashCode();
        result = 31 * result + getCommentBody().hashCode();
        result = 31 * result + getAuthor().hashCode();
        return result;
    }
}

package com.kodilla.stream;


import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;


import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {



        Forum forum = new Forum();

        Map<Integer, ForumUser> resultMapOfForumUsers = forum.getUserList().stream()
                .filter(user -> user.getGender() == 'F')
                .filter(user -> user.isYoungerThan20())
                .filter(user -> user.getQuantityOfPublishedPost() == 0)
                .collect(Collectors.toMap(ForumUser::getID, user -> user));

        System.out.println("# elements: " + resultMapOfForumUsers.size());

        resultMapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);
    }
}
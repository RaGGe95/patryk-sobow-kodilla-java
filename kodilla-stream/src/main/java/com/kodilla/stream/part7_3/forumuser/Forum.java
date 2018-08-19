package com.kodilla.stream.part7_3.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Forum {
    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(1, "Patryk", 'M', LocalDate.of(1995,1 ,1 ),50 ));
        userList.add(new ForumUser(2, "Marek", 'M', LocalDate.of(2005,1 ,1 ),10 ));
        userList.add(new ForumUser(3, "Kasia", 'F', LocalDate.of(1990,1 ,1 ),100 ));
        userList.add(new ForumUser(4, "Basia", 'F', LocalDate.of(2005,1 ,1 ),1 ));
        userList.add(new ForumUser(5, "Ania", 'F', LocalDate.of(1999,8 ,19 ),0 ));
    }

    public Forum(ForumUser... users){

        userList.addAll( new ArrayList<>( Arrays.asList(users)) );
    }

    public List<ForumUser> getUserList() {

        return new ArrayList<>(userList);
    }

    public Map<Integer, ForumUser> returnMapOfUsersWithSpecialConditions() {
        return this.getUserList().stream()
                .filter(user -> user.getGender() == 'F')
                .filter(user -> user.isYoungerThan20Version2())
                .filter(user -> user.getQuantityOfPublishedPost() == 0)
                .collect(Collectors.toMap(ForumUser::getID, user -> user));
    }

}

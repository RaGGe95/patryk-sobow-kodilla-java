package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Forum {
    final List<ForumUser> userList = new ArrayList<>();

    public Forum() {
        userList.add(new ForumUser(0001, "Patryk", 'M', LocalDate.of(1995,1 ,1 ),50 ));
        userList.add(new ForumUser(0002, "Marek", 'M', LocalDate.of(2005,1 ,1 ),10 ));
        userList.add(new ForumUser(0003, "Kasia", 'F', LocalDate.of(1990,1 ,1 ),100 ));
        userList.add(new ForumUser(0004, "Ewa", 'F', LocalDate.of(2005,1 ,1 ),1 ));
        userList.add(new ForumUser(0005, "Ania", 'F', LocalDate.of(1998,8 ,19 ),0 ));
    }

    public List<ForumUser> getUserList() {
        return new ArrayList<>(userList);
    }

}

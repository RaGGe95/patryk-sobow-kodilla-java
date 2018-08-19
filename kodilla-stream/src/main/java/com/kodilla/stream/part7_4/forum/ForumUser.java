package com.kodilla.stream.part7_4.forum;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class ForumUser {
    private final String username;
    private final String realName;
    private final String location;
    private final Set<ForumUser> friends = new HashSet<>();

    public ForumUser(final String username, final String realName,
                     final String location) {
        this.username = username;
        this.realName = realName;
        this.location = location;
    }

    public void addFriend(ForumUser user) {
        friends.add(user);
    }

    public Set<String> getLocationsOfFriends() {
        return friends.stream()
                .map(friend -> friend.getLocation())
                .collect(Collectors.toSet());
    }

    public Set<String> getLocationsOfFriendsOfFriends() {
        return friends.stream()
                .flatMap(user -> user.getFriends().stream())
                .filter(user -> user != this)
                .map(ForumUser::getLocation)
                .collect(Collectors.toSet());
    }
    /*
    Poniżej krótka analiza działania tej metody:

W linii nr 31 tworzony jest i uruchamiany strumień na kolekcji friends.
W linii nr 32 dokonujemy spłaszczenia strumienia - dla każdego przyjaciela (user) pobieramy jego listę przyjaciół (user.getFriends())
i ją przekazujemy do dalszego przetwarzania w postaci nowego strumienia Stream.
Od tego momentu pracujemy nie na liście przyjaciół, lecz na liście "przyjaciół przyjaciół".

W linii nr 33 wykluczamy ze zbioru wynikowego odwołania do "samego siebie" - wiadomo,
że my też jesteśmy przyjacielem naszych przyjaciół, jednak interesują nas ich lokalizacje, a nie nasza własna.

W linii nr 34 transformujemy strumień tak, że zamiast obiektów ForumUser,
dalej będą już przez niego przepływały jedynie obiekty String będące lokalizacjami użytkowników (pobieramy je przy pomocy metody ForumUser::getLocation).

W linii nr 35 dokonujemy złożenia strumienia wynikowego w kolekcję typu Set zawierającą listę lokalizacji "przyjaciół przyjaciół".
     */

    public boolean removeFriend(ForumUser user) {
        return friends.remove(user);
    }

    public String getUsername() {
        return username;
    }

    public String getRealName() {
        return realName;
    }

    public String getLocation() {
        return location;
    }

    public Set<ForumUser> getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForumUser)) return false;
        ForumUser forumUser = (ForumUser) o;
        return username.equals(forumUser.username);
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }
}
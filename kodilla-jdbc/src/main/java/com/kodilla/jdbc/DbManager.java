package com.kodilla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbManager {
    private Connection conn;
    private static DbManager dbManagerInstance;

    private DbManager() throws SQLException {
        Properties connectionProps = new Properties();
        connectionProps.put("user", "kodilla_user");
        connectionProps.put("password", "kodilla_password");
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/kodilla_course?serverTimezone=Europe/Warsaw" +
                        "&useSSL=False",
                connectionProps);
    }

    public static DbManager getInstance() throws SQLException {
        if (dbManagerInstance == null) {
            dbManagerInstance = new DbManager();
        }
        return dbManagerInstance;
    }

    public Connection getConnection() {
        return conn;
    }
}
/*
    Przeanalizujmy powyższy kod:

    W liniach nr 9 i 10 znajdują się deklaracje pól klasy:
    pole conn typu Connection przechowujące referencję do obiektu reprezentującego połączenie do bazy danych.
    Connection jest interfejsem dostarczanym przez bibliotekę java.sql.
    Interfejs ten udostępnia szereg metod związanych z zadawaniem zapytań do bazy danych,
    oraz obsługą połączenia. Pełna lista metod jest dostępna tutaj.
    pole dbManagerInstance, które przechowuje referencję do instancji klasy DbManager - potrzebne jest nam ono po to,
    aby w pamięci komputera dostępna była zawsze tylko jedna instancja obiektu klasy DbManager.
    W razie wątpliwości sięgnij jeszcze raz do treści modułu 11.1, w którym opisany był wzorzec Singleton.

    W liniach od 12 do 19 znajduje się definicja konstruktora klasy DbManager.
    Konstruktor ten jest prywatny - nie ma więc możliwości wywołania go spoza metod klasy DbManager.
    Jest on celowo "ukryty", aby uniemożliwić użytkownikowi (w tym przypadku innemu programiście wykorzystującemu nasz kod)
    samodzielne jego wywoływanie - klasa DbManager sama zarządza powoływaniem do życia swojej instancji,
    przy pomocy metody getInstance() zdefiniowanej w liniach 21-26 (zgodnie ze wzorcem Singleton).
    Przyglądnijmy się teraz samemu konstruktorowi:

    W linii nr 13 tworzymy obiekt klasy Properties (dostarczanej przez bibliotekę java.util).
    Klasa Properties jest bardzo podobna do kolekcji HashMap - przechowuje pary wartości key-value (klucz-wartość).
    Jeżeli chcesz dowiedzieć się o niej więcej - sięgnij do dokumentacji.
    Przydatną cechą obiektów tej klasy jest możliwość zapisywania i odczytywania wartości właściwości z plików .properties.

    Linie nr 14 i nr 15 ustawiają wartość właściwości user oraz password
    - są to wartości zdefiniowane przez nas wcześniej - podczas tworzenia użytkownika kodilla w bazie danych.

    W linii nr 16 tworzymy połączenie do bazy danych przy pomocy statycznej metody getConnection(String url, Properties info)
    klasy DriverManager dostarczanej przez bibliotekę java.sql. Pierwszy parametr tej metody (url) to tak zwany "connection string".
    Poszczególne jego części oznaczają:
    stały tekst "jdbc:mysql://" mówiący o tym, że korzystamy ze sterownika jdbc właściwego dla bazy danych MySQL.
    następnie wskazujemy serwer i port: "localhost:3306/"
    kolejny fragment wskazuje, o którą bazę danych na tym serwerze nam chodzi: "kodilla_course"
    i wreszcie musimy wskazać strefę czasową, w jakiej działa serwer: "?serverTimezone=Europe/Warsaw"
    na końcu dodajemy jeszcze parametr "&useSSL=False", który wyłącza używanie protokołu SSL (w przeciwnym razie potrzebowalibyśmy certyfikatów do nawiązania połączenia).
    Drugi z parametrów - info to obiekt typu Properties. Obiekt ten w najprostszej, używanej przez nas, postaci zawiera nazwę i hasło użytkownika.

    W liniach od 21 do 25 znajduje się definicja metody getInstance(),
    która tworzy (w razie potrzeby - gdy nie był wcześniej utworzony) i udostępnia obiekt klasy DbManager.
    Metoda ta stosuje podejście lazy instantiating,
    czyli tworzy obiekt dopiero wtedy gdy jest on potrzebny (czyli przy pierwszym wywołaniu tej metody)

    W liniach od 28 do 30 znajduje się definicja metody getConnection(), która zwraca obiekt klasy Connection,
    czyli obiekt przechowujący połączenie z bazą danych - będziemy używali go do tworzenia zapytań do bazy danych.
    */
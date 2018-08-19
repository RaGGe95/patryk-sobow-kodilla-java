package com.kodilla.stream.part7_2.iterate;

import java.util.stream.*;

public final class NumbersGenerator {
    public static void generateEven(int max) {
        Stream.iterate(1, n -> n + 1)
                .limit(max)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

    }
}
/*
Wyjaśnijmy teraz co dzieje się w klasie NumbersGenerator - będzie to skrótowy opis, ponieważ szczegółowe wyjaśnienie metod interfejsu Stream znajduje się w kolejnych submodułach:

W linii nr 3 importujemy bibliotekę java.util.stream
W linii nr 6 tworzymy statyczną metodę generateEven(int max),
której zadaniem jest wygenerowanie kolejnych liczb parzystych.
Metoda otrzymuje jeden argument wejściowy max mówiący o tym ile liczb 'pozwalamy' wygenerować naszemu strumieniowi Stream.

W linii nr 7 wywołujemy metodę statyczną iterate(Integer seed, UnaryOperator f) interfejsu Stream.
Metoda ta tworzy strumień obiektów typu Integer, o wartości początkowej określonej przez argument seed.
Wartości kolejnych obiektów w strumieniu wyznaczane są przez wyrażenie lambda f (lub referencję do metody).
Wyrażenie to otrzymuje jeden argument wejściowy - aktualną wartość obiektu w strumieniu - a jego zadaniem jest zwrócenie wartości kolejnej.
W naszym przykładzie, wyrażenie lambda inkrementuje otrzymany argument,
więc kolejne obiekty w strumieniu będą miały wartość o jeden większą od poprzedniego:
n -> n + 1

W linii nr 8 wywołujemy metodę limit(long maxSize) interfejsu Stream,
która ogranicza wielkość strumienia do maxSize obiektów (jest to operacja filtrująca)
W wyniku działania linii nr 8 powstaje nowy Stream, na którym w linii nr 9 wywołujemy metodę filter(Predicate predicate),
gdzie predicate jest wyrażeniem lambda, które powinno zwracać true, gdy obiekt ma pozostać w strumieniu oraz wartość false,
gdy obiekt powinien zostać "odrzucony" i nie przekazany do strumienia wyjściowego metody filter(Predicate predicate) - jak wskazuje nazwa metody, jest to operacja filtrująca

Na dwukrotnie przefiltrowanym strumieniu danych (wpierw przez metodę limit(Long maxSize),
a następnie przez metodę filter(Predicate predicate) uruchamiana jest kolejna funkcja

w linii 10 - metoda forEach(Consumer action). Metoda ta jest operacją terminalną,
która zamyka strumień i przekształca go w końcowy typ konkretny.
Działanie tej metody polega na wykonaniu dla każdego obiektu w strumieniu wyrażenia lambda action (może też być to referencja do metody).
Typem zwracanym przez forEach(Consumer action) jest typ void,
więc tak naprawdę nie powstaje żadna kolekcja czy finalny zbiór danych - obiekty są niszczone.
Możemy tę metodę wykorzystać jednak na przykład do wyświetlenia na ekranie konsoli wszystkich obiektów ze strumienia i tak też zrobiliśmy,
wskazując metodę System.out::println jako metodę, która ma być wykonana na każdym obiekcie w strumieniu (jest to operacja terminalna - kolektor).
 */
package com.kodilla.spring.shape;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ShapesFactory {
    @Bean
    public Square createSquare() {
        return new Square();
    }

    @Bean
    public Shape chosenShape() {
        Shape theShape;
        Random generator = new Random();
        int chosen = generator.nextInt(3);
        if (chosen == 0) {
            theShape = new Triangle();
        } else if (chosen == 1) {
            theShape = new Circle();
        } else {
            theShape = new Square();
        }
        return theShape;
    }
}

/*
Adnotacja @Component służy do oznaczania klas, przy pomocy których Spring ma utworzyć Beany.

Adnotacja @Bean służy do oznaczania metod produkujących obiekty, które mają stać się Beanami.

Aby adnotacje @Bean zadziałały, klasa, która zawiera metody tworzące Beany, musi być dodatkowo oznaczona adnotacją @Configuration.
 */

/*
Każdy Bean posiada nazwę:

W przypadku Beanów tworzonych przy pomocy adnotacji @Component, domyślną nazwą Beana jest nazwa klasy (ale pisana małą literą), np: "circle".
W przypadku Beanów tworzonych przy pomocy adnotacji @Bean, domyślną nazwą Beana jest nazwa metody tworzącej Beana, np. "chosenShape".

Wynikiem metody wyszukującej Beany na podstawie nazwy jest obiekt typu Object (a nie obiekt konkretnej klasy, na przykład Circle),
dlatego też konieczne było zastosowanie rzutowania typów na typ Shape dla zwracanych Beanów:
 */
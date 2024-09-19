package homework3.ex5;

import java.time.LocalDateTime;
import java.util.*;

public class Runner {
    public static void main(String[] args) {
        //Задание №5: сортировка отзывов
        //Создать класс отзыв с полями: id отзыва, текст отзыва, количество лайков,
        // дата + время отзыва (LocalDateTime)  - НЕ ИСПОЛЬЗОВАТЬ COMPARABLE!
        //Создать коллекцию, которая хранит отсортированные отзывы по:
        // 1.лайкам
        // 2.(Если лайки совпадают) дата + время отзыва
        // 3.(Если лайки и дата + время отзыва совпадают) id

        //Уникальность определяется на основе сортировки.
        //Создать comparator через лямбда выражение, для сортировки отзывов:

        //Пример, отсортированный :
        //          (id, текст, кол-во лайков, дата+время)
        //отзыв №1: 1, отличный товар, 200, 25.01.2024 13:37
        //отзыв №2: 2, так себе товар, 100, 25.01.2024 16:37
        //отзыв №4: 4, плохой товар, 100, 25.01.2024 13:37
        //отзыв №3: 3, плохой товар, 100, 25.01.2024 13:37

        Comparator<Review> sortReview = (reviewFirst, reviewSecond) -> {
            //сортировка сначала по лайкам
            if (reviewFirst.getLike().compareTo(reviewSecond.getLike()) == 0) {
                //сортировка по дате и времени
                if (reviewFirst.getDateTime().compareTo(reviewSecond.getDateTime()) == 0) {
                    //сортировка оп id
                    return reviewFirst.getId().compareTo(reviewSecond.getId());
                } else {
                    return reviewFirst.getDateTime().compareTo(reviewSecond.getDateTime());
                }
            } else {
                return reviewFirst.getLike().compareTo(reviewSecond.getLike());
            }
        };

        TreeSet<Review> reviews = new TreeSet<>(sortReview.reversed());

        reviews.add(new Review(1, "отличный товар", 200,
                LocalDateTime.of(2024, 1, 25, 13, 37)));
        reviews.add(new Review(2, "так себе товар", 100,
                LocalDateTime.of(2024, 1, 25, 16, 37)));
        reviews.add(new Review(3, "плохой товар", 100,
                LocalDateTime.of(2024, 1, 25, 13, 37)));
        reviews.add(new Review(4, "плохой товар", 100,
                LocalDateTime.of(2024, 1, 25, 13, 37)));
        //проверка
        for (Review review : reviews) {
            System.out.println(review);
        }
    }
}

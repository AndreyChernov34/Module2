package homework3.ex5;

import java.time.LocalDateTime;

/*
класс отзывы
 */

public class Review {
    Integer id;
    String text;
    Integer like;
    LocalDateTime dateTime;

    public Review(Integer number, String text, Integer like, LocalDateTime dateTime) {
        this.id = number;
        this.text = text;
        this.like = like;
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Integer getLike() {
        return like;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {

        return "Review{" +
                "Отзыв №" + id +
                "; " + text +
                "; " + like +
                "; " + dateTime +
                '}';
    }
}

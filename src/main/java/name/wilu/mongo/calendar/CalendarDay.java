package name.wilu.mongo.calendar;

import org.mongodb.morphia.annotations.Converters;
import org.mongodb.morphia.annotations.Embedded;

import java.time.LocalDate;

@Embedded
@Converters(LocalDateConverter.class)
public class CalendarDay {

    private LocalDate date;

    public CalendarDay date(LocalDate date) {
        this.date = date;
        return this;
    }
}

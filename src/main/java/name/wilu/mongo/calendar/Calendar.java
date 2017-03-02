package name.wilu.mongo.calendar;

import org.mongodb.morphia.annotations.Converters;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.converters.UUIDConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity("calendars")
@Converters(UUIDConverter.class)
public class Calendar {

    private @Id UUID id;
    private String name;
    private List<CalendarDay> days = new ArrayList<>();

    @SuppressWarnings("unused") private Calendar() {}

    public Calendar(UUID id) {
        this.id = id;
    }

    public Calendar name(String name) {
        this.name = name;
        return this;
    }

    public Calendar addDay(CalendarDay day) {
        days.add(day);
        return this;
    }
}

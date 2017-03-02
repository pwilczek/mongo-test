package name.wilu.mongo.calendar;

import org.mongodb.morphia.Datastore;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.util.UUID.randomUUID;

@Service
public class CalendarService {

    private final Datastore ds;

    public CalendarService(Datastore ds) {this.ds = ds;}


    public Object mock() {
        Calendar cal = new Calendar(randomUUID())
                .name("some silly name!")
                .addDay(new CalendarDay().date(LocalDate.now()));
        return ds.save(cal).getId();
    }

    public List<Calendar> all() {
        return ds.find(Calendar.class).asList();
    }
}

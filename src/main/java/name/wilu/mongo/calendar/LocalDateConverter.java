package name.wilu.mongo.calendar;

import org.mongodb.morphia.converters.TypeConverter;
import org.mongodb.morphia.mapping.MappedField;

import java.time.LocalDate;

public class LocalDateConverter extends TypeConverter {

    public LocalDateConverter() {
        super(LocalDate.class);
    }

    @Override public Object decode(Class<?> clazz, Object o, MappedField mf) {
        return o == null ? null : LocalDate.parse(o.toString());
    }

    @Override public Object encode(Object o, MappedField mf) {
        return o == null ? null : o.toString();
    }
}
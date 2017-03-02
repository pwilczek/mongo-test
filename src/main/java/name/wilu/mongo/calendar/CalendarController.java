package name.wilu.mongo.calendar;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CalendarController {

    private final CalendarService service;

    public CalendarController(CalendarService service) {this.service = service;}

    @GetMapping(value = "/calendars", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> all() {
        return ResponseEntity.ok(service.all());
    }

    @GetMapping(value = "/mock", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<?> mock() {
        return ResponseEntity.ok(service.mock());
    }
}

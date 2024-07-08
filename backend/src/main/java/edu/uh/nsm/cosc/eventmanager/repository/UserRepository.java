package edu.uh.nsm.cosc.eventmanager.repository;

import java.util.Arrays;
import java.util.Date;
import java.time.Instant;

import org.springframework.stereotype.Service;

import edu.uh.nsm.cosc.eventmanager.model.User;
import edu.uh.nsm.cosc.eventmanager.model.User.Sex;

@Service
public class UserRepository {
    public User userInformationById(long id) {
        User user = new User();
        user.setId(1L);
        user.setFirstName("first");
        user.setLastName("last");
        user.setMiddleInitial("i");
        user.setEmail("test@eventmanager.org");
        user.setPassword("testpass");
        user.setBirthdate(Date.from(Instant.now()));
        user.setCellPhone("555-555-5555");
        user.setWorkPhone("222-222-2222");
        user.setSex(Sex.female);
        user.setAddress("1 1st Rd");
        user.setAddress2(null);
        user.setCity("Houston");
        user.setState(Arrays.asList("Texas"));
        user.setZipcode("10000");
        user.setSkills(Arrays.asList("Database Management"));
        user.setPreferences(null);
        user.setSelectedDates(Arrays.asList(
            "2025-07-01", "2025-07-02", "2025-07-03", "2025-07-04", "2025-07-05"
        ));

        return user;
    }
}
        

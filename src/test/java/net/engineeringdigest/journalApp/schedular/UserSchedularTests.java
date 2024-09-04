package net.engineeringdigest.journalApp.schedular;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedularTests {

    @Autowired
    private UserSchedular userSchedular;
    @Test
    public void testFetchUsersAndSendMail(){
        userSchedular.fetchUsersAndSendMail();
    }
}

package net.engineeringdigest.journalApp.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.convert.ValueConverter;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserService userService;


//    @BeforeEach
//    void setUp() {}   //run this code before any test (we can initialize it in here in anything)  @AfterEach
//
//    @BeforeAll
//    static void beforeAll() {}   //run this block before all test   @AfterAll
//

    @Test
    public void testFindUserName(){
//        assertEquals(4, 2+2);
        assertNotNull(userService.findByUsername("Ram"));
        assertTrue(!userService.findByUsername("Ram").getJournalEntries().isEmpty());
    }

//    @ValueSource(strings = {})
//    @EnumSource
//    @ArgumentsSource()

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,2,4"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected, a+b);
    }
}

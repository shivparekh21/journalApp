package net.engineeringdigest.journalApp.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @Test
    public void testEmailService() {
        emailService.sendEmail("shivparekh21@gmail.com", "Testing", "MailSender");
    }
}

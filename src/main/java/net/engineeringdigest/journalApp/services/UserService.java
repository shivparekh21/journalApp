package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    public boolean saveNewUser(User user) {
        try{
            user.setUserName(user.getUserName());
            user.setPassword(passwordEncoder.encode(user.getPassword())); // save updated password back to hash
            user.setRoles(Arrays.asList("USER"));
            userRepository.save(user);
            return true;
        } catch (Exception e){
            logger.info("hahahaahah");
            logger.warn("hahahaahah");
            logger.error("Error occured for {}",user.getUserName());
            logger.debug("hahahha");
            return false;
        }
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void saveAdmin(User user) {
        user.setUserName(user.getUserName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER", "Admin"));
        userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUsername(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void deleteUsersByUsername(String userName) {
        userRepository.deleteUsersByUserName(userName);
    }

}


// @Slf4j (annotation)     use    (log.info()) statement
// no need for   (private static final Logger logger = LoggerFactory.getLogger(UserService.class);)
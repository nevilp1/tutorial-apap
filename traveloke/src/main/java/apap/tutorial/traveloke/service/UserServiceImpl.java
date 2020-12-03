package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    public boolean validatePassword(String password){
        char[] check = password.toCharArray();
        boolean haveDigit = false;
        boolean haveAlphabet = false;
        boolean sizeCheck = password.length() >= 8;
        if(sizeCheck){
            for (char c : check) {
                if (Character.isDigit(c)) haveDigit = true;
                if (Character.isAlphabetic(c)) haveAlphabet = true;
            }
        }
        if(sizeCheck && haveAlphabet && haveDigit) return true;
        return false;
    }

    @Override
    public UserModel addUser(UserModel user) {
        if(validatePassword(user.getPassword())) {
            String pass = encrypt(user.getPassword());
            user.setPassword(pass);
            return userDb.save(user);
        }
        return null;

    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public boolean updatePassword(String username, String[] password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserModel user = userDb.findByUsername(username);
        boolean matchPassword = passwordEncoder.matches(password[0], user.getPassword());
        boolean confirmPassword = password[1].equals(password[2]);

        if(matchPassword && confirmPassword && validatePassword(password[1])) {
            user.setPassword(encrypt(password[1]));
            userDb.save(user);
            return true;
        }

        return false;
    }
}

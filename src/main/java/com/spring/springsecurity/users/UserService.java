package com.spring.springsecurity.users;

import com.spring.springsecurity.otp.Otp;
import com.spring.springsecurity.users.User;
import com.spring.springsecurity.otp.OtpRepository;
import com.spring.springsecurity.users.UserRepository;
import com.spring.springsecurity.utils.GenerateCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final OtpRepository otpRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository, OtpRepository otpRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.otpRepository = otpRepository;
    }

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        System.out.println(user);
        return userRepository.save(user);
    }

    public void auth(User user) {
        System.out.println("incoming user : "+user);
        Optional<User> o =userRepository.findUserByUsername(user.getUsername());
        if(o.isPresent()){
            User u = o.get();
            log.info("here is the user {}",o);

            if(passwordEncoder.matches(user.getPassword(),u.getPassword())){
                renewOtp(u);
            } else {
                throw new BadCredentialsException("Bad credentials.");
            }
        }else {
            throw new BadCredentialsException("Bad credentials.");
        }

    }

    private void renewOtp(User u) {
        String code = GenerateCodeUtil.generateCode();
        Optional<Otp> userOtp = otpRepository.findOtpByUsername(u.getUsername());
        if(userOtp.isPresent()){
            Otp otp = userOtp.get();
            otp.setCode(code); //Todo test this scenario
        }
        else {
            Otp otp = new Otp();
            otp.setUsername(u.getUsername());
            otp.setCode(code);
            otpRepository.save(otp);
        }
        System.out.println(otpRepository.findOtpByUsername(u.getUsername()));
    }

    public boolean check(Otp otpToValidate) {
            Optional<Otp> userOtp =
                    otpRepository.findOtpByUsername(
                            otpToValidate.getUsername());
        if (userOtp.isPresent()) {
            Otp otp = userOtp.get();
            if (otpToValidate.getCode().equals(otp.getCode())) {
                return true;
            }
        }
        return false;
    }
}

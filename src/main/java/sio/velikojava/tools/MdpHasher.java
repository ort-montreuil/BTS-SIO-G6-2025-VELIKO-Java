package sio.velikojava.tools;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class MdpHasher {

    public boolean verifyPassword(String hash, String password) {
        return BCrypt.checkpw(password, hash);
    }

}
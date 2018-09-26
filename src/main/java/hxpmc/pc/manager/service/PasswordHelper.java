package hxpmc.pc.manager.service;

import hxpmc.pc.manager.pojo.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Service;

@Service
public class PasswordHelper {
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public String getAlgorithmName() {
        return algorithmName;
    }

    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    public int getHashIterations() {
        return hashIterations;
    }

    public void setHashIterations(int hashIterations) {
        this.hashIterations = hashIterations;
    }
    public void encryptPassword(User user){
        String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
        user.setSalt(salt);
        SimpleHash newPassword = new SimpleHash(algorithmName,user.getPassword(),user.getUsername()+salt,hashIterations);
        user.setPassword(newPassword.toString());
    }
}

package ac.sict.yulong.service;

import ac.sict.yulong.pojo.Admin;
import ac.sict.yulong.pojo.AdminLoginStatue;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class LoginCheck {

    static private String KEY_WORD = "871e40437a3a623530d807586fdda8ac";

    public String passwordChangeToMd5(String password) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        return Hex.encodeHexString(md5.digest(password.getBytes(StandardCharsets.UTF_8)));
    }

    public AdminLoginStatue loginCheck(String password, Admin admin) throws NoSuchAlgorithmException {
        String passwd = passwordChangeToMd5(password);
        if (admin.getKeyword().equals(passwd)){
            if (passwd.equals(KEY_WORD)){
                return new AdminLoginStatue(admin.getId(),2,admin.getStatus());
            }
            else{
                return new AdminLoginStatue(admin.getId(),1,admin.getStatus());
            }
        }
        else return new AdminLoginStatue(null,0,0);
    }
}

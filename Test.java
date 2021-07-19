import java.security.*;

class Test {

  
  public void IP(byte[] salt) {
    encrypt(salt, "SHA-1");
  } 

  public void encrypt(byte[] salt, String crypto) {
    MessageDigest digest = MessageDigest.getInstance(crypto);
    digest.reset();
    digest.update(salt);
    digest.digest();
  }
}

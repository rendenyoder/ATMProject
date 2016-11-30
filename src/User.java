import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class User {
    private int attempts;
    private double balance;
    private String pin;

    public User(double balance, String pin){
        this.attempts = 0;
        this.balance = balance;
        this.pin = pin;
    }

    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    //Create hash of entered pin
    protected static String hashPin(String pinNumber){
        try {
            byte[] bytesOfMessage = pinNumber.getBytes("UTF-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            return new String(thedigest, StandardCharsets.UTF_8);
        }catch (Exception e){
            return null;
        }
    }
}

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.ArrayList;

public class User {
    private int attempts;
    private double balance;
    private String pin;

    public User(double balance, String pin){
        this.attempts = 0;
        this.balance = balance;
        this.pin = hashPin(pin);
    }

    //Getters
    public int getAttempts() {
        return attempts;
    }
    public double getBalance() {
        return balance;
    }
    public String getPin() {
        return pin;
    }

    //Setters
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setPin(String pin) {
        this.pin = hashPin(pin);
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

    //Get current list of users
    protected static ArrayList<User> getUserList(){
        //Create new array
        ArrayList<User> userList = new ArrayList<>();
        //Read users in from file
        try {
            int lineNum = 1;
            for (String line : Files.readAllLines(Paths.get("userList.txt"))) {
                String[] parts = line.split(", ", -1);
                userList.add(new User(Integer.parseInt(parts[0]), parts[1]));
                System.out.println("User #" + lineNum++ + " - pin: " + parts[1]);
            }
        }catch (Exception e){
            System.out.println("FILE NOT FOUND");
            return null;
        }
        //Return list
        return userList;
    }
}

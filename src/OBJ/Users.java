package OBJ;

public class Users {
    String account;
    int passward;

    public Users(String account, int passward) {
        this.account = account;
        this.passward = passward;
    }

    @Override
    public String toString() {
        return "Users{" +
                "account=" + account +
                ", passward=" + passward +
                '}';
    }

    public String getAccount() {
        return account;
    }

    public int getPassward() {
        return passward;
    }
}

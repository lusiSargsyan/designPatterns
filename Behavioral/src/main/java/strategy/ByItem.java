package strategy;

public class ByItem {
   private String mail;
   private String name;

    public ByItem(String mail, String name) {
        this.mail = mail;
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }
}

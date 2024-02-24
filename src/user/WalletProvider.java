package user;

public class WalletProvider {
  private int id;
  private String name;

  public WalletProvider(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() { return id; }
  public String getName() { return name; }
}

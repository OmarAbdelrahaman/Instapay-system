package user;

public class User {
  private int id;
  private String username;
  private String password;

  public User(String username, String password) {
    this.id = 0;
    this.username = username;
    this.password = password;
  }

  protected User(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;
  }

  protected void setId(int id) { this.id = id; }
  public int getId() { return id; }
  public String getUsername() { return username; }
  public String getPassword() { return password; }
}

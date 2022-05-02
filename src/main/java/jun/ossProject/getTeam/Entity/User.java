package jun.ossProject.getTeam.Entity;


import lombok.extern.log4j.Log4j;

public class User {
    String id;
    String nickname;

    public User(String id, String nickname) {
        this.id = id;
        this.nickname = nickname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}

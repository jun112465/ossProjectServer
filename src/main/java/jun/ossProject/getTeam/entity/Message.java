package jun.ossProject.getTeam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    int id;
    String type;
    String from;
    String to;
    String content;

    //type = inviteLink 인 경우 아래 값들이 채워져있어야 한다.
    String teamId;
    String teamName;
}

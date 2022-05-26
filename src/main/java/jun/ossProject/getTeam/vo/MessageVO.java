package jun.ossProject.getTeam.vo;

import lombok.Data;
import lombok.Getter;

@Data
public class MessageVO {
    String fromId;
    String toId;
    String content;
}

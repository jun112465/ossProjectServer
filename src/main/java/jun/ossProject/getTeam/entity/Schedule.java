package jun.ossProject.getTeam.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Schedule {
    int id;
    String teamId;
    String userId;
    String content;
    String date;
}

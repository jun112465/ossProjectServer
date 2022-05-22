package jun.ossProject.getTeam.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {
    int id;
    String teamId;
    String userId;
    String content;
    String date;
}

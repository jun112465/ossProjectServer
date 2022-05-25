package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.Entity.Schedule;
import jun.ossProject.getTeam.Entity.Team;
import jun.ossProject.getTeam.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class SchedulerController {

    // 스케줄 목록 가져오기
    @ResponseBody
    @GetMapping(value = "/get")
    public HashMap<String, List<Schedule>> getSchedules(@RequestParam (value = "team_id")String teamId){
        // 팀에 해당하는 모든 스케쥴 가져오기

        HashMap<String, List<Schedule>> item = new HashMap<>();
        List<Schedule> schedulesList = new ArrayList<>();
        schedulesList.add(new Schedule(1, "team1", "user1", "content1", "2022-05-18"));
        schedulesList.add(new Schedule(2, "team2", "user2", "content2", "2022-05-18"));
        schedulesList.add(new Schedule(4, "team2", "user4", "content4", "2022-05-18"));
        item.put("2022-05-18", schedulesList);

        return item;
    }

    // 스케줄 추가
    public void addSchedule(Schedule schedule, Team team, User user){

    }

    // 스케줄 삭제
    public void deleteSchedule(Schedule schedule, Team team, User user){

    }
}

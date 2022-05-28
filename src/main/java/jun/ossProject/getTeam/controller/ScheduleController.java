package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.entity.Schedule;
import jun.ossProject.getTeam.entity.Team;
import jun.ossProject.getTeam.entity.User;
import jun.ossProject.getTeam.repository.ScheduleRepository;
import jun.ossProject.getTeam.vo.ScheduleDeleteVO;
import jun.ossProject.getTeam.vo.ScheduleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    ScheduleRepository scheduleRepository;

    @Autowired
    ScheduleController(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    // 스케줄 목록 가져오기
    @ResponseBody
    @GetMapping(value = "/get")
    public HashMap<String, List<Schedule>> getSchedules(@RequestParam (value = "team_id")String teamId) throws SQLException {

        System.out.println("ScheduleController : getSchedules");
        // 팀에 해당하는 모든 스케쥴 가져오기
        HashMap<String, List<Schedule>> item = new HashMap<>();
        List<Schedule> scheduleList = scheduleRepository.getSchedule(teamId);

        for(Schedule s : scheduleList){
            String date = s.getDate();
            if(item.containsKey(date)){
                item.get(date).add(s);
            }else{
                List<Schedule> list = new ArrayList<>();
                list.add(s);
                item.put(date, list);
            }
        }

//        List<Schedule> schedulesList = new ArrayList<>();
//        schedulesList.add(new Schedule(1, "team1", "user1", "content1", "2022-05-18"));
//        schedulesList.add(new Schedule(2, "team2", "user2", "content2", "2022-05-18"));
//        schedulesList.add(new Schedule(4, "team2", "user4", "content4", "2022-05-18"));
//        item.put("2022-05-18", schedulesList);

        return item;
    }

    // 스케줄 추가
    @PostMapping("/add")
    @ResponseBody
    public void addSchedule(@RequestBody ScheduleVO vo) throws SQLException {
        System.out.println(vo);
        scheduleRepository.addSchedule(vo);
    }

    // 스케줄 삭제
    @PostMapping("/delete")
    @ResponseBody
    public void deleteSchedule(@RequestBody ScheduleDeleteVO vo) throws SQLException {
        System.out.println("ScheduleController : deleteSchedule");
//        System.out.println(vo.toString());
        scheduleRepository.deleteSchedule(Integer.parseInt(vo.getId()));
    }
}

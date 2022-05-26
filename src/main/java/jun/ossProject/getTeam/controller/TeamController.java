package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.entity.Team;
import jun.ossProject.getTeam.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    @ResponseBody
    @PostMapping("/create")
    public void createTeam(User user){
        // Team DB에 팀 추가

        // 해당하는 User 정보에 TeamId 추가

        // 성공 시 성공코드 반환

        // 실패 시 실패코드 반환
    }

    @ResponseBody
    @GetMapping(value  = "/get")
    public HashMap<String, List<Team>> getTeams(@RequestParam(name="user_id") String userId){
        // 유저가 소속돼 있는 팀 목록 호출

        // 팀 목록 반환

        HashMap<Integer, String> items = new HashMap<>();
        items.put(1, "team1");
        items.put(2, "team2");

        List<Team> teamList = new ArrayList<>();
        teamList.add(new Team(1, "team1"));
        teamList.add(new Team(2, "team2"));
        teamList.add(new Team(3, "team3"));

        HashMap<String, List<Team>> json = new HashMap<>();
        json.put("teamList", teamList);
        return json;
    }

    @ResponseBody
    @PostMapping("/delete")
    public void deleteTeam(Team team){
        // Team table에서 해당 팀 삭제

        // 모든 유저의 팀 목록에서 teamId 삭제
    }

    // 팀원 추가
    public void addTeamMember(){
        // 팀원 초대 방식은 메세지 전송을 통해 초대하게됨
        // 메세지로 팀 초대 문구와 (수락,거절) 버튼 2개 넣어서 보낸다
    }

    @ResponseBody
    @GetMapping("/get_members")
    public HashMap<String, List<User>> getTeamMembers(@RequestParam (value="team_id") String team_id){
        List<User> userList = new ArrayList<>();
        userList.add(new User("12312", "wefweio"));
        userList.add(new User("123124", "weoijeoif"));
        HashMap<String, List<User>> json = new HashMap<>();
        json.put("userList", userList);
        return json;
    }

}

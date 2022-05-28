package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.entity.Team;
import jun.ossProject.getTeam.entity.User;
import jun.ossProject.getTeam.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/team")
public class TeamController {

    TeamRepository teamRepository;

    @Autowired
    TeamController(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @ResponseBody
    @GetMapping("/add")
    public void createTeam(
            @RequestParam (value="team_name")String teamName,
            @RequestParam(value="user_id")String userId)
            throws SQLException {
        System.out.println("TeamController : createTeam : " + userId);
        teamRepository.createTeam(userId, teamName);
    }

    @ResponseBody
    @GetMapping(value  = "/get")
    public HashMap<String, List<Team>> getTeams(@RequestParam(name="user_id") String userId) throws SQLException {
        // user 가 소속되어 있는 team 목록을 반환한다.
        List<Team> teamList = teamRepository.getTeam(userId);
        HashMap<String, List<Team>> json = new HashMap<>();
        json.put("teamList", teamList);
        return json;
    }

    @ResponseBody
    @GetMapping ("/exit")
    public void deleteTeam(@RequestParam(value="team_id")String teamId, @RequestParam(value="user_id")String userId) throws SQLException {
        System.out.println(teamId + userId);
        teamRepository.exitTeam(teamId, userId);
    }

    // 팀원 추가
    @GetMapping("/invite_code")
    public String addTeamMember(@RequestParam(value="team_id")String teamId, @RequestParam(value="user_id")String userId) throws SQLException {
        // 팀원 초대 방식은 메세지 전송을 통해 초대하게됨
        teamRepository.addUserToTeam(userId, teamId);
        return "memberAddPage";
    }

    @ResponseBody
    @GetMapping("/get_members")
    public HashMap<String, List<User>> getTeamMembers(@RequestParam (value="team_id") String team_id) throws SQLException {
        System.out.println("TeamController : getTeamMembers : " + team_id);
        List<User> userList = teamRepository.getTeamMembers(team_id);
        HashMap<String, List<User>> json = new HashMap<>();
        json.put("userList", userList);

        return json;
    }

}

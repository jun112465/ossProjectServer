package jun.ossProject.getTeam.controller;

import jun.ossProject.getTeam.Entity.Team;
import jun.ossProject.getTeam.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/team")
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
    @PostMapping("/get")
    public void getTeams(User user){
        // 유저가 소속돼 있는 팀 목록 호출

        // 팀 목록 반환

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

}

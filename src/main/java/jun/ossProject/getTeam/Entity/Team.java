package jun.ossProject.getTeam.Entity;

public class Team {
    int teamId;
    String teamName;

    public Team(int teamId, String teamName){
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }
}

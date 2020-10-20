public class TeamService {
    @Di
    private TeamRepository teamRepository;

    public TeamRepository getTeamRepository() {
        return teamRepository;
    }
}

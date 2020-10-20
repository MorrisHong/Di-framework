import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiTeamTest {
    @Test
    void test() {
        TeamService teamService = DiService.getObject(TeamService.class);
        Assertions.assertNotNull(teamService);
        Assertions.assertNotNull(teamService.getTeamRepository());
    }
}

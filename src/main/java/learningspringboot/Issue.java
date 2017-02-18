package learningspringboot;

/**
 * Created by mikeyb on 1/28/17.
 */
import org.springframework.social.github.api.GitHubIssue;
public class Issue {
    private String repo ;
    private GitHubIssue gitHubIssue;
    public Issue(String repo,GitHubIssue gitHubIssue){
        this.repo = repo ;
        this.gitHubIssue = gitHubIssue ;
    }
    public String getRepo(){
        return repo ;
    }
    public GitHubIssue getGitHubIssue(){
        return gitHubIssue ;
    }
}

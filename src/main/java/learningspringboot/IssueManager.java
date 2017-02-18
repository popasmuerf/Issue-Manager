package learningspringboot;

/**
 * Created by mikeyb on 1/28/17.
 */
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.api.GitHubIssue ;
import org.springframework.social.github.api.impl.GitHubTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.InitializingBean ;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IssueManager implements InitializingBean{
    /**
    String gitHubToken = "e4ea20b11775ede810f30a3fc8d5bcbb70e765fb";
    String org = "spring-projects";
    String [] repos = new String[]{"spring-boot","spring-boot-issues"};
    GitHubTemplate gitHubTemplate = new GitHubTemplate(gitHubToken);
     **/
    @Value("${github.token}")
    String gitHubToken ;
    @Value("${org}")
    String org ;
    @Value("${repos}")
    String [] repos ;
    GitHubTemplate gitHubTemplate = new GitHubTemplate(gitHubToken);

    public List<Issue> findOpenIssues(){
        List<Issue> openIssues = new ArrayList<>();
        for(String repo: repos){
            final List<GitHubIssue> issues = gitHubTemplate.repoOperations().getIssues(org,repo);
            for(GitHubIssue issue : issues){
                if(issue.getState().equals("open")){
                    openIssues.add(new Issue(repo,issue));
                }
            }
        }
        return openIssues ;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        this.gitHubTemplate = new GitHubTemplate(gitHubToken);

    }
}
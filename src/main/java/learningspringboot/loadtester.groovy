package learningspringboot
@Grab('org.codehaus.gpars:gpars:1.1.0')
import groovyx.gpars.GParsPool
import groovy.util.logging.*
import org.springframework.boot.CommandLineRunner

/**
 * Created by mikeyb on 3/4/17.
 */
@Slf4j
class LoadTester implements CommandLineRunner {
    void run(String[] args){
        GParsePool.withPool(4){
            def loadset = ["http://localhost:8080"] * 100
            loadset.eachParallel{
                url ->
                    def results = url.toURL().text
                    log.info("Hit ${url}")
            }
        }
    }
}

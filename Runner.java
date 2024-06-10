package runners;


import com.intuit.karate.junit5.Karate;

public class Runner {

    String projectPath = System.getProperty("user.dir").toString();

    @Karate.Test
    Karate runFeatureFile() {
        return Karate.run(projectPath+"/src/test/featureFiles/petReadXl.feature");
    }

}




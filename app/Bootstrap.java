import play.*;
import play.jobs.*;
import play.test.*;

import models.*;

import java.util.List;

@OnApplicationStart
public class Bootstrap extends Job {

    public void doJob() {
        // Check if the database is empty
        if(Cat.count() == 0) {
            Fixtures.loadModels("test-datas.yml");
        }
        Logger.info("Cats in the box "+Cat.count());

        List<Cat> cats=Cat.findAll();
        for(Cat cat:cats){
            Logger.info("cat "+cat);
        }
    }

}
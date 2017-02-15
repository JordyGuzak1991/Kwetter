package service;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Created by Jordy on 15-2-2017.
 */
@Singleton
@Startup
public class StartUp {

    public StartUp() {}

    @PostConstruct
    public void initData() {
        //TODO
    }
}

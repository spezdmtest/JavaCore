package com.spezdmtest.javacore.module1_5_1.AbstractFactory.website;

import com.spezdmtest.javacore.module1_5_1.AbstractFactory.Developer;
import com.spezdmtest.javacore.module1_5_1.AbstractFactory.ProjectManager;
import com.spezdmtest.javacore.module1_5_1.AbstractFactory.ProjectTeamFactory;
import com.spezdmtest.javacore.module1_5_1.AbstractFactory.Tester;

public class WebsiteTeamFactory implements ProjectTeamFactory {
    @Override
    public Developer getDeveloper() {
        return new PhpDeveloper();
    }

    @Override
    public Tester getTester() {
        return new ManualTester();
    }

    @Override
    public ProjectManager getProjectManager() {
        return new WebsitePM();
    }
}

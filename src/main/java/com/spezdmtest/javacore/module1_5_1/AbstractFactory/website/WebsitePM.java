package com.spezdmtest.javacore.module1_5_1.AbstractFactory.website;

import com.spezdmtest.javacore.module1_5_1.AbstractFactory.ProjectManager;

public class WebsitePM implements ProjectManager {
    @Override
    public void manageProject() {
        System.out.println("Website PM manages Website project...");
    }
}

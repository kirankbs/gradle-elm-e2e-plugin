package com.zeroplay.elm.tasks

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Before

/**
 * Created by kirankumarbs on 9/20/2016.
 */
class ElmProjectbuildTaskTest {

    Project project;
    @Before
    public void setUp(){
        project  = ProjectBuilder.builder().build();
        project.apply plugin: 'com.zeroplay.elm-e2e'
    }

}

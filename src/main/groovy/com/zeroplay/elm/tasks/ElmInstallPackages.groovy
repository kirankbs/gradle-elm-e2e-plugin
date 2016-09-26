package com.zeroplay.elm.tasks

import org.gradle.api.artifacts.Dependency
import org.gradle.api.tasks.TaskAction

/**
 * Created by kirankumar on 21-09-2016.
 */
class ElmInstallPackages extends BaseTask{


    @TaskAction
    def setUp(){
        installPackage("");
        project.configurations.elm.dependencies.collect().each {
            installPackage(it.group+"/"+it.name);
        }
    }

    def installPackage(String elmPackage){
        ProcessBuilder pBuilder = new ProcessBuilder(Arrays.asList("elm","package","install",elmPackage,"--yes"));
        pBuilder.redirectErrorStream(true);

        //remove this line also
        def line
        def reader = new BufferedReader(new InputStreamReader(pBuilder.start().getInputStream()))

        while((line = reader.readLine()) != null ){
            println(line);
        }
    }
}

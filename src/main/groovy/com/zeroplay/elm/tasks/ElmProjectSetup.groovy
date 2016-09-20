package com.zeroplay.elm.tasks

import com.zeroplay.elm.tasks.BaseTask
import org.gradle.api.DefaultTask
import org.gradle.api.artifacts.Dependency
import org.gradle.api.tasks.TaskAction

/**
 * Created by kirankumarbs on 9/15/2016.
 */
class ElmProjectSetup extends BaseTask{

    @TaskAction
    def setUp(){
        createSourceDirectory(project.extensions.elm.source_directory);
        createTestDirectory(project.extensions.elm.test_directory);
        installAllPackages(project.configurations.elm.dependencies.collect());
    }

    def createSourceDirectory(String src_dir){
        println(src_dir);
        if(! new File(src_dir).exists())
            new File(src_dir).mkdirs()
    }

    def createTestDirectory(String test_dir){
        if(! new File(test_dir).exists())
            new File(test_dir)
    }

    def installAllPackages(List<Dependency> elmPackages){
        installPackage("");
        elmPackages.each {
            installPackage(it.group+"/"+it.name);
        }
    }

    def installPackage(String elmPackage){
        final List<String> pkg_install_cmd = Arrays.asList("elm","package","install",elmPackage,"--yes");
        ProcessBuilder pBuilder = new ProcessBuilder(pkg_install_cmd);
        pBuilder.redirectErrorStream(true);
        Process process = pBuilder.start();

        def line
        def reader = new BufferedReader(new InputStreamReader(process.getInputStream()))

        while((line = reader.readLine()) != null ){
            println(line);
        }
    }

}

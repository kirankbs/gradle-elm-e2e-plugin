package com.zeroplay.elm.tasks

import com.zeroplay.elm.tasks.BaseTask
import org.gradle.api.DefaultTask
import org.gradle.api.artifacts.Dependency
import org.gradle.api.tasks.TaskAction

import java.nio.file.Path

/**
 * Created by kirankumarbs on 9/15/2016.
 */
class ElmProjectSetup extends BaseTask{

    @TaskAction
    def setUp(){
        createSourceDirectory(project.extensions.elm.source_directory);
        createMainSourceModule(project.extensions.elm.source_directory+"/"+project.extensions.elm.mainModule);
        createTestDirectory(project.extensions.elm.test_directory);
    }

    def createSourceDirectory(String src_dir){
        if(! new File(src_dir).exists())
            new File(src_dir).mkdirs()
    }

    def createMainSourceModule(String mainModule){
/*        File file = new File("src/main/repository/Main.elm")
        println("************"+file.getPath());
        println("************"+file.getAbsolutePath());
        println("************"+file.getCanonicalPath());
        def reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));*/
        if(! new File(mainModule) != null )
        {
            new File(mainModule).createNewFile();
/*            File mainM = new File(mainModule);
            def writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mainM)));

            def line;
            while((line = reader.readLine()) != null ){
                writer.writeLine(line);
            }*/
        }
    }

    def createTestDirectory(String test_dir){
        println(test_dir)
        if(! new File(test_dir).exists())
            new File(test_dir).mkdirs()
    }


}

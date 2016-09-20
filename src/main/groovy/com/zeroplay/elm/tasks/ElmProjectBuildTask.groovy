package com.zeroplay.elm.tasks

import com.zeroplay.elm.ElmPluginExtension
import org.gradle.api.DefaultTask
import org.gradle.api.plugins.ExtensionContainer
import org.gradle.api.tasks.TaskAction

/**
 * Created by kirankumarbs on 9/19/2016.
 */
class ElmProjectBuildTask extends BaseTask{
    private final String elm_make  =   "elm-make";

    @TaskAction
    def build(){
        String source_directory    = project.extensions.elm.source_directory;
        String build_directory     = project.extensions.elm.build_directory;
        String mainModule          = project.extensions.elm.mainModule;
        String targetModule        = project.extensions.elm.targetModule;

        createBuildDirectory(build_directory);
        List<String> elm_make_cmds =
                Arrays.asList(elm_make,source_directory+"/"+mainModule,"--output",build_directory+"/"+targetModule);
        buildElmProject(elm_make_cmds);
    }

    def createBuildDirectory(String build_dir){
        if(! new File(build_dir).exists())
            new File(build_dir).mkdirs()
    }

    def buildElmProject(List<String> make_cmd){
        ProcessBuilder pBuilder = new ProcessBuilder(make_cmd);
        pBuilder.redirectErrorStream(true);
        Process process = pBuilder.start();

        def line;
        def reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        while((line = reader.readLine()) != null ){
            println(line);
        }
    }
}

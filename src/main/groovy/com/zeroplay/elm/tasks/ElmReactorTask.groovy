package com.zeroplay.elm.tasks

import org.gradle.api.tasks.TaskAction

/**
 * Created by kirankumarbs on 9/26/2016.
 */
class ElmReactorTask {

    @TaskAction
    def setUp(){
        startElmReactor();
    }

    def startElmReactor(){
        ProcessBuilder pBuilder = new ProcessBuilder(Arrays.asList("elm","reactor","install",elmPackage,"--yes"));
        pBuilder.redirectErrorStream(true);

        //remove this line also
        def line
        def reader = new BufferedReader(new InputStreamReader(pBuilder.start().getInputStream()))

        while((line = reader.readLine()) != null ){
            println(line);
        }
    }
}

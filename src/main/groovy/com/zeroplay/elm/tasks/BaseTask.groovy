package com.zeroplay.elm.tasks

import org.gradle.api.DefaultTask

/**
 * Created by kirankumarbs on 9/19/2016.
 */
class BaseTask extends DefaultTask{

    public List<String> getMakeCommand(){ return make_cmd; }

}

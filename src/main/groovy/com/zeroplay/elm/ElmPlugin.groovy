package com.zeroplay.elm

import com.zeroplay.elm.tasks.ElmInstallPackages
import com.zeroplay.elm.tasks.ElmProjectBuildTask
import com.zeroplay.elm.tasks.ElmProjectSetup
import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * Created by kirankumarbs on 9/19/2016.
 */
class ElmPlugin implements Plugin<Project>{


    @Override
    void apply(Project project) {
        project.extensions.elm = new ElmPluginExtension();
        project.configurations {
            elm
        }

        project.task('buildElm', type: ElmProjectBuildTask );
        project.task('installElmPackages', type: ElmInstallPackages);
        project.task('setupElm', type: ElmProjectSetup, dependsOn: 'installElmPackages');
        project.task('elmReactor',type: ElmReactorTask)
    }
}

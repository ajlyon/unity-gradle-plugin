package com.scopely.build

import com.scopely.build.unity.UnityExec
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class UnityPluginTest {
    @Test
    public void unityPluginAddsUnityTaskToProject() {
        Project project = ProjectBuilder.builder().build()

        project.apply plugin: 'unity'

        assert project.tasks.unity instanceof UnityExec

        project.tasks.unity.configure({
            buildMethod = 'WBBuild.Build'
        })


        assert project.tasks.unity.buildMethod.equals('WBBuild.Build')
    }
}

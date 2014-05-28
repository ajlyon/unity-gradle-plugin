package com.scopely.build.unity

import org.gradle.api.Plugin
import org.gradle.api.Project


class UnityPlugin implements Plugin<Project> {
    private static final String UNITY_DIR = 'unity'
    private static final String UNITY_TASK_NAME = 'unity'
    private static final String UNITY_OUTPUT_DIR = "$UNITY_DIR-output"

    @Override
    void apply(Project project) {
        project.extensions.create("unity", UnityPluginExtension)

        def unityBuildTask = project.tasks.create(UNITY_TASK_NAME, UnityExec)
        unityBuildTask.description = "Build Unity project"
    }
}

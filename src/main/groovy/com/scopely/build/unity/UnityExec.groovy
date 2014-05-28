package com.scopely.build.unity

import org.gradle.api.internal.ConventionTask
import org.gradle.api.internal.file.FileResolver
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecResult
import org.gradle.process.internal.DefaultExecAction
import org.gradle.process.internal.ExecAction

public class UnityExec extends ConventionTask {
    private static final String PROP_UNITY_PROJECT = 'unityProject'
    private static final String PROP_BUILD_METHOD = 'buildMethod'
    private static final String PROP_STRIPPING_LEVEL = 'buildMethod'
    private static final String PROP_SUBTARGET = 'buildMethod'
    private static final String PROP_UNITY_VERSION = 'unityVersion'

    private ExecAction execAction;
    private ExecResult execResult;

    @InputDirectory
    File unityProject;

    @OutputFile
    File unityBuild;

    @OutputFile
    File unityBuildLog;

    public UnityExec() {
        this.execAction = new DefaultExecAction((FileResolver) getServices().get(FileResolver.class));
        unityProject = property(PROP_UNITY_PROJECT) as File

    }

    @TaskAction
    void exec() {
        this.execAction.commandLine "/Applications/Unity_${property(PROP_UNITY_VERSION)}/Unity.app/Contents/MacOS/Unity", "-projectPath", unityProject.absolutePath, '-executeMethod', property(PROP_BUILD_METHOD), '-quit', '-nographics', '-batchmode', '--strippingLevel', property(PROP_STRIPPING_LEVEL), '--androidSubTarget', property(PROP_SUBTARGET)
        this.execResult = this.execAction.execute()

        unityBuild = project.file('UnityBuild.apk')
        unityBuildLog = project.file('UnityAndroidAssetBuild.log')

        this.execResult.assertNormalExitValue()
    }

    public UnityExec setIgnoreExitValue(boolean ignoreExitValue) {
        this.execAction.setIgnoreExitValue(ignoreExitValue);
        return this;
    }

    public boolean isIgnoreExitValue() {
        return this.execAction.isIgnoreExitValue();
    }

    public ExecResult getExecResult() {
        return this.execResult;
    }
}

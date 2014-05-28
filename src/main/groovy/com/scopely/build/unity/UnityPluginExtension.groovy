package com.scopely.build.unity


class UnityPluginExtension {


    /**
     * Version of unity to use
     */
    String unityVersion = "4.2.1"
    /**
     * Reference to Unity project directory
     */
    File unityProject
    /**
     * Level of byte code stripping to apply
     */
    String strippingLevel = 'Disabled'
    /**
     * Sub-target for texture formats
     */
    String subTarget = 'Generic'

    /**
     * Build command to execute
     */
    String buildMethod;
}

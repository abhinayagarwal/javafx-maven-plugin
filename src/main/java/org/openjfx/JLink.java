package org.openjfx;

import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.Parameter;
import org.codehaus.plexus.archiver.Archiver;
import org.codehaus.plexus.archiver.zip.ZipArchiver;

import java.util.List;

public class JLink {
    /**
     * Strips debug information out, equivalent to <code>-G, --strip-debug</code>,
     * default false
     */
    @Parameter(defaultValue = "false")
    boolean stripDebug;

    /**
     * Strip Java debug attributes out, equivalent to <code>--strip-java-debug-attributes</code>,
     * default false
     */
    @Parameter(defaultValue = "false")
    boolean stripJavaDebugAttributes;

    /**
     * Compression level of the resources being used, equivalent to:
     * <code>-c, --compress=level</code>. Valid values: <code>0, 1, 2</code>,
     * default 0
     */
    @Parameter(defaultValue = "0")
    Integer compress;

    /**
     * Remove the <code>includes</code> directory in the resulting runtime image,
     * equivalent to: <code>--no-header-files</code>, default false
     */
    @Parameter(defaultValue = "false")
    boolean noHeaderFiles;

    /**
     * Remove the <code>man</code> directory in the resulting Java runtime image,
     * equivalent to: <code>--no-man-pages</code>, default false
     */
    @Parameter(defaultValue = "false")
    boolean noManPages;

    /**
     * Add the option <code>--bind-services</code> or not, default false.
     */
    @Parameter(defaultValue = "false")
    boolean bindServices;

    /**
     * <code>--ignore-signing-information</code>, default false
     */
    @Parameter(defaultValue = "false")
    boolean ignoreSigningInformation;

    /**
     * Turn on verbose mode, equivalent to: <code>--verbose</code>, default false
     */
    @Parameter(defaultValue = "false")
    boolean verbose;

    /**
     * Add a launcher script, equivalent to:
     * <code>--launcher &lt;name&gt;=&lt;module&gt;[/&lt;mainclass&gt;]</code>.
     */
    @Parameter
    String launcher;

    /**
     * The name of the folder with the resulting runtime image,
     * equivalent to <code>--output &lt;path&gt;</code>
     */
    @Parameter(property = "jlink.imageName", defaultValue = "image")
    String imageName;

    /**
     * When set, creates a zip of the resulting runtime image.
     */
    @Parameter(property = "zipName")
    String zipName;

    /**
     * <p>
     * The executable. Can be a full path or the name of the executable.
     * In the latter case, the executable must be in the PATH for the execution to work.
     * </p>
     */
    @Parameter(property = "executable", defaultValue = "jlink")
    String executable;

    /**
     * Optional jmodsPath path for local builds.
     */
    @Parameter(property = "jmodsPath")
    String jmodsPath;

    /**
     * The JAR archiver needed for archiving the environments.
     */
    @Component(role = Archiver.class, hint = "zip")
    ZipArchiver zipArchiver;

    /**
     * A list of options passed to the jlink {@code executable}.
     */
    @Parameter(property = "options")
    List<?> options;
}

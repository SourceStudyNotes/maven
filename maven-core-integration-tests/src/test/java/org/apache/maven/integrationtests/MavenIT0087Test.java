package org.apache.maven.integrationtests;
import java.io.*;
import java.util.*;

import junit.framework.*;

import org.apache.maven.it.*;
import org.apache.maven.it.util.*;

public class MavenIT0087Test extends TestCase /*extends AbstractMavenIntegrationTest*/ {    

/** Verify that a project-level plugin dependency class can be loaded from both the plugin classloader
        and the context classloader available to the plugin. */
public void testit0087() throws Exception {
String basedir = System.getProperty("maven.test.tmpdir", System.getProperty("java.io.tmpdir"));
File testDir = new File(basedir, getName());
FileUtils.deleteDirectory(testDir);
System.out.println("Extracting it0087 to " + testDir.getAbsolutePath());
ResourceExtractor.extractResourcePath(getClass(), "/it0087", testDir);
Verifier verifier = new Verifier(testDir.getAbsolutePath());
verifier.deleteArtifact("org.apache.maven.plugins", "maven-core-it-plugin", "1.0", "maven-plugin");
verifier.executeGoal("validate");
verifier.verifyErrorFreeLog();
verifier.resetStreams();
System.out.println("PASS");
}}


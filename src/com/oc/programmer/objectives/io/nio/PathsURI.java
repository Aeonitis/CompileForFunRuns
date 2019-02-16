package com.oc.programmer.objectives.io.nio;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Path get(URI uri) Converts the given URI to a Path object. This method iterates over the
 * installed providers to locate the provider that is identified by the URI scheme of the given URI.
 * URI schemes are compared without regard to case. If the provider is found then its getPath method
 * is invoked to convert the URI.
 *
 * In the case of the default provider, identified by the URI scheme "file",
 * the given URI has a non-empty path component, and undefined query and fragment
 * components. Whether the authority component may be present is platform specific. The returned
 * Path is associated with the default file system.
 *
 * The default provider provides a similar round-trip guarantee to the File class.
 * For a given Path p it is guaranteed that Paths.get(p.toUri()).equals( p.toAbsolutePath()) so long as
 * the original Path, the URI, and the new Path are all created in (possibly different invocations of) the same Java virtual machine.
 * Whether other providers make any guarantees is provider specific and therefore unspecified.
 * Parameters: uri - the URI to convert
 *
 * Throws:
 *
 * IllegalArgumentException - if preconditions on the uri parameter do not hold. The format of the
 * URI is provider specific.
 *
 * FileSystemNotFoundException - The file system, identified by the URI,
 * does not exist and cannot be created automatically, or the provider identified by the URI's
 * scheme component is not installed
 *
 * SecurityException - if a security manager is installed and it denies an unspecified permission to access the file system
 */
public class PathsURI {

  public static void main(String[] args) throws URISyntaxException {
    Path pathURI = Paths.get(new URI("file://e:/temp/records"));
  }
}

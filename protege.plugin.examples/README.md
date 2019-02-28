# Protege Plugin Pattern Extraction and Validation


#### Prerequisites

To build and run this code, you must have the following items installed:

+ Apache's [Maven](http://maven.apache.org/index.html).
+ A tool for checking out a [Git](http://git-scm.com/) repository.
+ A Protege distribution (5.0.0 or higher).  The Protege 5.2.0 release is [available](http://protege.stanford.edu/products.php#desktop-protege) from the main Protege website. 

#### Build and install plugin

1. Get a copy of the code.

2. Change into the protege-plugin directory.

3. Type mvn clean package.  On build completion, the "target" directory will contain a protege.plugin.pattern-${version}.jar file.

4. Copy the JAR file from the target directory to the "plugins" subdirectory of your Protege distribution.

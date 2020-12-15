# mastery-4-3 - Mastery Module 4.3. Modularity - Exercise 7

Exercise 7 - Investigating jdeps

## How to run

If we run this way:

```bash
javac --module-source-path ./family -m family -d ./out
```

We will be missing the modules.
So we have to include the jars and turn them int automatic modules:

## Exercise 7

```bash
mkdir out
javac --module-path cousins/target/cousins-1.0.0-SNAPSHOT.jar:your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar:../../../jtd-the-factory/consolerizer/target/consolerizer-1.0.0-SNAPSHOT.jar --module-source-path family -m family -d ./out
mkdir jars
jar --create --file ./jars/family.jar --main-class org.jesperancinha.ocp11.mastery4dot3.family.FamilyRunner -C ./out/family .
java -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar --module-path jars:cousins/target/cousins-1.0.0-SNAPSHOT.jar:your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar:../../../jtd-the-factory/consolerizer/target/consolerizer-1.0.0-SNAPSHOT.jar --module family/org.jesperancinha.ocp11.mastery4dot3.family.FamilyRunner
jdeps --module-path cousins/target/cousins-1.0.0-SNAPSHOT.jar:your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar:../../../jtd-the-factory/consolerizer/target/consolerizer-1.0.0-SNAPSHOT.jar jars/family.jar
jdeps -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar --module-path cousins/target/cousins-1.0.0-SNAPSHOT.jar:your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar:../../../jtd-the-factory/consolerizer/target/consolerizer-1.0.0-SNAPSHOT.jar jars/family.jar
jdeps cousins/target/cousins-1.0.0-SNAPSHOT.jar
jdeps -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar cousins/target/cousins-1.0.0-SNAPSHOT.jar
jdeps your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar
```

```bash
jdeps -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar cousins/target/cousins-1.0.0-SNAPSHOT.jar
jdeps --class-path cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar cousins/target/cousins-1.0.0-SNAPSHOT.jar
jdeps -classpath cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar cousins/target/cousins-1.0.0-SNAPSHOT.jar
```

## Exercise 17

```bash
jdeps -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar:cousins/target/cousins-1.0.0-SNAPSHOT.jar:your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar:../../../jtd-the-factory/consolerizer/target/consolerizer-1.0.0-SNAPSHOT.jar jars/family.jar
jdeps -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar:cousins/target/cousins-1.0.0-SNAPSHOT.jar:your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar:jars/family.jar ../../../jtd-the-factory/consolerizer/target/consolerizer-1.0.0-SNAPSHOT.jar
```

## Output

```text
java -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar --module-path jars:cousins/target/cousins-1.0.0-SNAPSHOT.jar:your.cousins/target/your.cousins-1.0.0-SNAPSHOT.jar:../../../jtd-the-factory/consolerizer/target/consolerizer-1.0.0-SNAPSHOT.jar --module family/org.jesperancinha.ocp11.mastery4dot3.family.FamilyRunner
Let's start a family party!
We start with their cousins!
They have 86 cousins of cousins
They have 75 cousins
And now we start with our cousins!
You have 14 cousins 

jdeps -cp cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar cousins/target/cousins-1.0.0-SNAPSHOT.jar
cousins-1.0.0-SNAPSHOT.jar -> cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar
cousins-1.0.0-SNAPSHOT.jar -> java.base
   org.jesperancinha.ocp11.mastery4dot3.cousins       -> java.lang                                          java.base
   org.jesperancinha.ocp11.mastery4dot3.cousins       -> org.jesperancinha.ocp11.mastery4dot3.cousins.of.cousins cousins.of.cousins-1.0.0-SNAPSHOT.jar

jdeps --class-path cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar cousins/target/cousins-1.0.0-SNAPSHOT.jar
cousins-1.0.0-SNAPSHOT.jar -> cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar
cousins-1.0.0-SNAPSHOT.jar -> java.base
   org.jesperancinha.ocp11.mastery4dot3.cousins       -> java.lang                                          java.base
   org.jesperancinha.ocp11.mastery4dot3.cousins       -> org.jesperancinha.ocp11.mastery4dot3.cousins.of.cousins cousins.of.cousins-1.0.0-SNAPSHOT.jar

jdeps -classpath cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar cousins/target/cousins-1.0.0-SNAPSHOT.jar
cousins-1.0.0-SNAPSHOT.jar -> cousins.of.cousins/target/cousins.of.cousins-1.0.0-SNAPSHOT.jar
cousins-1.0.0-SNAPSHOT.jar -> java.base
   org.jesperancinha.ocp11.mastery4dot3.cousins       -> java.lang                                          java.base
   org.jesperancinha.ocp11.mastery4dot3.cousins       -> org.jesperancinha.ocp11.mastery4dot3.cousins.of.cousins cousins.of.cousins-1.0.0-SNAPSHOT.jar
```

## References

-   [OCP11 1z0-817](https://education.oracle.com/upgrade-ocp-java-6-7-8-to-java-se-11-developer/pexam_1Z0-817)
-   [OCP11 1z0-819](https://education.oracle.com/java-se-11-developer/pexam_1Z0-819)
-   [Enthuware](https://enthuware.com/)
-   [OCP 11 study guide](https://www.goodreads.com/book/show/51132641-ocp-oracle-certified-professional-java-se-11-programmer-i-study-guide)
-   [A JDeps Tutorial - Analyze Your Project's Dependencies](https://nipafx.dev/jdeps-tutorial-analyze-java-project-dependencies)
-   [Whizlabs](https://www.whizlabs.com/)

---

## Java 11 Specs

-   [Qualified Exports](https://www.logicbig.com/tutorials/core-java-tutorial/modules/qualified-exports.html)
-   [The modular JDK](https://openjdk.java.net/jeps/200)
-   [JLink](https://docs.oracle.com/javase/9/tools/jlink.htm)

---

## The module graph

[![alt text](https://bugs.openjdk.java.net/secure/attachment/72525/jdk.png "The module graph")](https://openjdk.java.net/jeps/200)
 
---

## Achievements

[![alt text](../../../../badges/oracle-certified-foundations-associate-java-100.png "OCJA SE 8")](https://www.youracclaim.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794/public_url)
[![alt text](../../../../badges/oracle-certified-associate-java-se-7-programmer-100.png "OCA SE 7")](https://www.youracclaim.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225/public_url)
[![alt text](../../../../badges/oracle-certified-associate-java-se-8-programmer-100.png "OCA SE 8")](https://www.youracclaim.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7/public_url)
[![alt text](../../../../badges/oracle-certified-professional-java-se-8-programmer-100.png "OCP SE 8")](https://www.youracclaim.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074/public_url)
  
---

## About me 👨🏽‍💻🚀

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/JEOrgLogo-20.png "João Esperancinha Homepage")](http://joaofilipesabinoesperancinha.nl)
[![Twitter Follow](https://img.shields.io/twitter/follow/joaofse?label=João%20Esperancinha&style=social "Twitter")](https://twitter.com/joaofse)
[![GitHub followers](https://img.shields.io/github/followers/jesperancinha.svg?label=jesperancinha&style=social "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/medium-20.png "Medium")](https://medium.com/@jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/google-apps-20.png "Google Apps")](https://play.google.com/store/apps/developer?id=Joao+Filipe+Sabino+Esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/sonatype-20.png "Sonatype Search Repos")](https://search.maven.org/search?q=org.jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/docker-20.png "Docker Images")](https://hub.docker.com/u/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/stack-overflow-20.png)](https://stackoverflow.com/users/3702839/joao-esperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/reddit-20.png "Reddit")](https://www.reddit.com/user/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/acclaim-20.png "Acclaim")](https://www.youracclaim.com/users/joao-esperancinha/badges)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/devto-20.png "Dev To")](https://dev.to/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackernoon-20.jpeg "Hackernoon")](https://hackernoon.com/@jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeproject-20.png "Code Project")](https://www.codeproject.com/Members/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/github-20.png "GitHub")](https://github.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bitbucket-20.png "BitBucket")](https://bitbucket.org/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/gitlab-20.png "GitLab")](https://gitlab.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/bintray-20.png "BinTray")](https://bintray.com/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/free-code-camp-20.jpg "FreeCodeCamp")](https://www.freecodecamp.org/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hackerrank-20.png "HackerRank")](https://www.hackerrank.com/jofisaes)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codeforces-20.png "Code Forces")](https://codeforces.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codebyte-20.png "Codebyte")](https://coderbyte.com/profile/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codewars-20.png "CodeWars")](https://www.codewars.com/users/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/codepen-20.png "Code Pen")](https://codepen.io/jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/coursera-20.png "Coursera")](https://www.coursera.org/user/da3ff90299fa9297e283ee8e65364ffb)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/hacker-news-20.png "Hacker News")](https://news.ycombinator.com/user?id=jesperancinha)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/infoq-20.png "InfoQ")](https://www.infoq.com/profile/Joao-Esperancinha.2/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Articles&message=Across%20The%20Web&color=purple)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Articles.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Time%20Disruption%20Studios&color=6495ED)](http://tds.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=Image%20Train%20Filters&color=6495ED)](http://itf.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Homepage&message=MancalaJE&color=6495ED)](http://mancalaje.joaofilipesabinoesperancinha.nl/)
[![Generic badge](https://img.shields.io/static/v1.svg?label=All%20Badges&message=Badges&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Badges.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=Status&message=Project%20Status&color=red)](https://github.com/jesperancinha/project-signer/blob/master/project-signer-templates/Status.md)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Android&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-android)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20Java&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate-modules/tree/master/itf-chartizate-java)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=ITF%20Chartizate%20API&color=yellow)](https://github.com/JEsperancinhaOrg/itf-chartizate/tree/master/itf-chartizate-api)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Core&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-core)
[![Generic badge](https://img.shields.io/static/v1.svg?label=GitHub&message=Markdowner%20Filter&color=yellow)](https://github.com/jesperancinha/markdowner/tree/master/markdowner-filter)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/linkedin-20.png "LinkedIn")](https://www.linkedin.com/in/joaoesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/xing-20.png "Xing")](https://www.xing.com/profile/Joao_Esperancinha/cv)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/instagram-20.png "Instagram")](https://www.instagram.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/tumblr-20.png "Tumblr")](https://jofisaes.tumblr.com/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/pinterest-20.png "Pinterest")](https://nl.pinterest.com/jesperancinha/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-20/quora-20.png "Quora")](https://nl.quora.com/profile/Jo%C3%A3o-Esperancinha)
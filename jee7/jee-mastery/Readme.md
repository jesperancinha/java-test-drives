# jee-mastery

---

[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/java-50.png "Java")](https://www.oracle.com/nl/java/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/lombok-50.png "Lombok")](https://projectlombok.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/openjdk-50.png "OpenJDK")](https://openjdk.java.net/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/sdk-man-50.png "SdkMAN!")](https://sdkman.io/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/wild-fly-50.png "WildFly")](https://www.wildfly.org/)
[![alt text](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/icons-50/arquillian-50.png "Arquillian")](https://github.com/arquillian)

---

## Introduction

To further deepen our understanding of JEE7, we will go through mastery modules.
These modules serve the purpose of exploring in depth, the knowledge acquired from buiilding the [jee-apps](../jee-apps).

</i>João Esperancinha, on the 17th of January 2021</i>

## Prepare the environment

### Wildfly 16.0

1. Download [Wilfly 16](https://www.wildfly.org/downloads/)
2. Unpack the contents of that package to this root.

You can also just run the [Bash script file](installWildFly.sh) and hope that it works on your computer:

### End Installation notes

This should be enough. Maven files inside the application list will refer to this folder in order to start the server.

Important to take note is that none of the modules is static. The ones marked with <b>(coming soon...)</b>, aren't ready to be used, but you can take a peek.
The ones without any notice, are considered done, but they will be subject to improvements from time to time.

## Mastery Apps

### [jee-mastery-app-1](./jee-mastery-app-1) - PRIDE Edition 1 🏳️‍🌈

#### Subjects:

---
1. `<h:panelGrid`, `<c:forEach`, `<h:outputLabel`, `<h:inputText`
2. `@SessionScoped`, `@Named`, `@Local`, `@LocalBean`, `@Stateless`
3. `@Transactional`, `@RequestScoped`, `@Dependent`, `SessionScoped`, `Serializable`
4. `@Inject`, `setter`, `getter`
5. `@MessageDriven`, ` @ActivationConfigProperty`, `acknowledgeMode`, `destinationType`, `destination`, `Topic`
6. `ApplicationException`, `interface`, `rollback`, `@SessionScoped`, `@Named`,
7. `@TransactionAttribute`,  `TransactionAttributeType.REQUIRED`, `TransactionManagementType.CONTAINER`, `@TransactionManagement`
8. `ExternalContext`, `redirect`, `FacesContext`, `getCurrentInstance`
9. `jar -cvf jee-mastery-app-1-1.0.0-SNAPSHOT.war *`
10. `xmlns="http://www.w3.org/1999/xhtml"`, `xmlns:h="http://java.sun.com/jsf/html`, `xmlns:ui="http://java.sun.com/jsf/facelets"`, `xmlns:pt="http://xmlns.jcp.org/jsf/passthrough"` `xmlns:f="http://xmlns.jcp.org/jsf/core"` `xmlns:jsf="http://xmlns.jcp.org/jsf"`
11. `JsonGenerator`, `Json`. `createGenerator`, `JsonArrayBuilder`, `createArrayBuilder`, `createObjectBuilder`
12. `@GET`, `@HEAD`
13. `Serializable`, ` @TransactionAttribute`, `TransactionAttributeType.REQUIRES_NEW`, `@IdClass`, `@Id`, `@Identity`, `@Column`, `@NonNull`
14. `@Embeddable`, `@Entity`, `@Table`, `@Embedded`, `@EmbeddedId`, `@IdClass`
15. `createDurableConsumer`, `receive`, `ObjectMessage`
16. `@Singleton`,  `@Schedule`, `second`, `minute`, `hour`, `month`, `dayOfMonth`, `dayOfWeek`, `year`, `timezone`, `info`, `persistent`
17. `HttpServletRequest`, `HttpServletResponse`, `@WebServlet`, `service`, `doGet`
18. `http://java.sun.com/jsp/jstl/sql`, `<sql:setDataSource`, `<sql:query`
19. `JspWriterImpl`, `out`, `<% %>`, `<%= %>`
20. `<f:view locale="de_DE">`, `<f:loadBundle basename="messages" var="msg"/>`
21.  `<application>`, `<locale-config>`, `<default-locale>`, `<resource-bundle>`,` <base-name>`, `<h:outputText value="#{bundle['title']}"/>`
22. `<servlet>`, `<init-param>`, `<param-name>`, `<param-value>`, `ServletConfig`, `ServletContext`
23. `@AccessTimeout(0)`, `@AccessTimeout(-1)`, `@AccessTimeout(1)`

---

## Extra notes

1. We can use POJO's to implement a REST resource. The only requirement is for it top be annotated with at least one @Path


## References

-   [Java EE 7 full platform and Web Profile](https://www.ibm.com/support/knowledgecenter/SSEQTP_9.0.5/com.ibm.websphere.base.doc/ae/covr_javaee7.html)
-   [JSR 342: JavaTM Platform, Enterprise Edition 7 (Java EE 7) Specification](https://jcp.org/en/jsr/detail?id=342)
-   [JEE7 Spec document](https://download.oracle.com/otn-pub/jcp/java_ee-7-fr-spec/JavaEE_Platform_Spec.pdf?AuthParam=1610297053_dc338cf9ac2f643c005b280582ab4052)
-   [Oracle 1Z0-900 Exam: Rise and Shine as an Application Developer with Oracle Certification](https://www.dbexam.com/blog/oracle-1z0-900-exam-rise-and-shine-application-developer-oracle-certification)
-   [1Z0-900: Java EE 7 Application Developer](https://www.dbexam.com/oracle/1z0-900-java-ee-7-application-developer)
-   [Pluralsight](https://www.pluralsight.com/)
-   [Whizlabs](https://www.whizlabs.com/)
-   [Enthuware](https://enthuware.com/)
-   [Building and Running a Java EE Application by Using Maven](https://www.oracle.com/webfolder/technetwork/tutorials/obe/java/Maven_EE/MavenEE.html)
-   [Run Maven Java Web Application in Jetty Maven Plugin](https://o7planning.org/en/10335/run-maven-java-web-application-in-jetty-maven-plugin)
-   [Getting Started With Jetty Server](https://www.jrebel.com/blog/jetty-server)
-   [jetty Maven Jetty plugin](https://riptutorial.com/jetty/example/22209/maven-jetty-plugin)
-   [Chapter 6. Getting started with Weld](https://docs.jboss.org/weld/reference/3.0.0.CR1/en-US/html/gettingstarted.html)
-   [Creating a Chat Application using Java EE 7, Websockets and GlassFish 4](https://www.hascode.com/2013/08/creating-a-chat-application-using-java-ee-7-websockets-and-glassfish-4/)
-   [JAVA EE 7 – THE STANDARD FOR ENTERPRISE JAVA](https://turngeek.github.io/javaee7inaweek/chapter/i-1-java-ee-7-the-standard-for-enterprise-java/)
-   [Java Platform, Enterprise Edition (Java EE) 7](https://docs.oracle.com/javaee/7/index.html)

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

## Achievements

[![Oracle Certified Professional, Java SE 11 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-11-developer-100.png "Oracle Certified Professional, Java SE 11 Programmer")](https://www.youracclaim.com/badges/87609d8e-27c5-45c9-9e42-60a5e9283280/public_url)
[![Oracle Certified Professional, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-professional-java-se-8-programmer-100.png "Oracle Certified Professional, Java SE 8 Programmer")](https://www.youracclaim.com/badges/92e036f5-4e11-4cff-9935-3e62266d2074/public_url)
[![Oracle Certified Associate, Java SE 8 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-8-programmer-100.png)](https://www.youracclaim.com/badges/a206436d-6fd8-4ca1-8feb-38a838446ee7/public_url)
[![Oracle Certified Associate, Java SE 7 Programmer](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-associate-java-se-7-programmer-100.png)](https://www.youracclaim.com/badges/f4c6cc1e-cb52-432b-904d-36d266112225/public_url)
[![Oracle Certified Juninor Associate](https://raw.githubusercontent.com/jesperancinha/project-signer/master/project-signer-templates/badges/oracle-certified-foundations-associate-java-100.png)](https://www.youracclaim.com/badges/6db92c1e-7bca-4856-9543-0d5ed0182794/public_url)
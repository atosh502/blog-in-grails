package blog2

class BootStrap {

    def encryptionService

    def init = { servletContext ->
        if (!Post.count())
            loadDatabase()
    }

    private loadDatabase(){
        println "Loading posts"

        User user = new User(userName: "103872972246406021412", fullName: "Aashutosh Poudel")
                .save(failOnError: true, flush: true)

        Tag java = new Tag(name: "java").save(failOnError: true, flush: true)
        Tag groovy = new Tag(name: "groovy").save(failOnError: true, flush: true)
        Tag web_framework = new Tag(name: "web-framework").save(failOnError: true, flush: true)
        Tag grails = new Tag(name: "grails").save(failOnError: true, flush: true)

        new Post(title: "Learning Groovy",
                text: "Groovy is a JVM based language that extends the core Java libraries.",
                user: user, tags: [java, groovy])
                .save(failOnError: true, flush: true)

        new Post(title: "Learning Grails",
                text: "Grails is a complete web application framework that aims to simplify web development with Java.",
                user: user, tags: [grails, web_framework])
                .save(failOnError: true, flush: true)

        new Post(title: "Groovy on Grails", text: "Grails is inspired from Rails.",
                user: user, tags: [grails, web_framework, groovy])
                .save(failOnError: true, flush: true)

    }
}

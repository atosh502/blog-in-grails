package blog2

class BootStrap {

    def init = { servletContext ->
        if (!Post.count())
            loadDatabase()
    }

    private loadDatabase(){
        println "Loading posts"

        User user = new User(userName: "admin", password: "admin").save(failOnError: true, flush: true)

        new Post(title: "Learning Groovy",
                text: "Groovy is a JVM based language that extends the core Java libraries.",
                user: user).save(failOnError: true, flush: true)

        new Post(title: "Learning Grails",
                text: "Groovy is a complete web application framework that aims to simplify web development with Java.",
                user: user).save(failOnError: true, flush: true)

        new Post(title: "Groovy on Grails", text: "Grails is inspired from Rails.",
                user: user).save(failOnError: true, flush: true)

    }
}

package blog2

class BootStrap {

    def init = { servletContext ->
        if (!Post.count())
            loadDatabase()
    }

    private loadDatabase(){
        println "Loading posts"

        new Post(title: "Learning Groovy", text: "Groovy is a JVM based language that extends the core Java libraries.").save(failOnError: true)
        new Post(title: "Learning Grails", text: "Groovy is a complete web application framework that aims to simplify web development with Java.").save(failOnError: true)
        new Post(title: "Groovy on Grails", text: "Grails is inspired from Rails.").save(failOnError: true)
    }

    def destroy = {
    }
}

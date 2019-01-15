package blog2

class BootStrap {

    def init = { servletContext ->
        if (!Post.count())
            loadDatabase()
    }

    private loadDatabase(){
        println "Loading posts"

        Post p1 = new Post(title: "Learning Groovy", text: "Groovy is a JVM based language that extends the core Java libraries.")
        Post p2 = new Post(title: "Learning Grails", text: "Groovy is a complete web application framework that aims to simplify web development with Java.")
        Post p3 = new Post(title: "Groovy on Grails", text: "Grails is inspired from Rails.")

        User user = new User(userName: "admin", password: "admin")

        // this automatically saves the posts, ie. first create a user and then add posts to the user
        // but creating the posts and adding a new user into the post will not save the user
        user.addToPosts(p1)
        user.addToPosts(p2)
        user.addToPosts(p3)

        user.save(failOnError: true, flush: true)
    }
}

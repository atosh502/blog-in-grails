package blog2

class BootStrap {

    def encryptionService

    def init = { servletContext ->
        if (!Post.count())
            loadDatabase()
    }

    private loadDatabase(){
        println "Loading posts"

//        User user = new User(userName: "admin", password: encryptionService.encrypt("admin"))
//                .save(failOnError: true, flush: true)
//
//        new User(userName: "test", password: encryptionService.encrypt("test"))
//                .save(failOnError: true, flush: true)

        // we have a user with userId = 103872972246406021412

        String userId = 103872972246406021412
        new Post(title: "Learning Groovy",
                text: "Groovy is a JVM based language that extends the core Java libraries.",
                userId: userId).save(failOnError: true, flush: true)

        new Post(title: "Learning Grails",
                text: "Groovy is a complete web application framework that aims to simplify web development with Java.",
                userId: userId).save(failOnError: true, flush: true)

        new Post(title: "Groovy on Grails", text: "Grails is inspired from Rails.",
                userId: userId).save(failOnError: true, flush: true)

    }
}

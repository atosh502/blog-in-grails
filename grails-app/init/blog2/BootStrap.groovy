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

        Board weeklyBoard = new Board(boardName: "My Weekly Board").save(failOnError: true, flush: true)

        List todo = new List(listName: "todo", board: weeklyBoard)
                .save(failOnError: true, flush: true)
        List done = new List(listName: "done", board: weeklyBoard)
                .save(failOnError: true, flush: true)

        Card homework = new Card(cardName: "Homework", cardDescription: "Complete homeworks of DSAP.", list: todo)
                .save(failOnError: true, flush: true)
        Card lab = new Card(cardName: "Practical", cardDescription: "Do lab exercises.", list: done)
                .save(failOnError: true, flush: true)
        Card travel = new Card(cardName: "Travel", cardDescription: "Visit a new place.", list: todo)
                .save(failOnError: true, flush: true)
        Card book = new Card(cardName: "Book", cardDescription: "Read a book.", list: done)
                .save(failOnError: true, flush: true)

        todo.addToCards(homework)
        todo.addToCards(travel)
        done.addToCards(lab)
        done.addToCards(book)

        weeklyBoard.addToLists(todo)
        weeklyBoard.addToLists(done)
    }
}

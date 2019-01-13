package blog2

class Post {

    String title
    String text

    static constraints = {
        title(blank: false)
        text(blank: false)
    }
}

package blog2

class UpdatedPost {

    String title
    String text
    Date date
    String path

    static belongsTo = [user: User]

    static constraints = {
        title(nullable: false, blank: false, maxSize: 1000)
        text(nullable: false, blank: false)
        date(blank: false, nullable: false)
        path(blank: false, nullable: false)
    }
}

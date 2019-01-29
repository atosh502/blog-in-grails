package blog2

class UpdatedPost {

    String title
    String text
    String userId
    Date date
    String path

    static constraints = {
        title(nullable: false, blank: false, maxSize: 1000)
        text(nullable: false, blank: false)
        userId(blank: false, nullable: false)
        date(blank: false, nullable: false)
        path(blank: false, nullable: false)
    }
}

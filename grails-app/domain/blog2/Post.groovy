package blog2

class Post {

    String title
    String text

    // belongTo ensures that not only create and update are cascaded but delete is also cascaded
    // i.e. whenever user is deleted the corresponding posts are also deleted
    // bidirectional mapping
    static belongsTo = [user: User]

    static constraints = {
        title(blank: false)
        text(blank: false)
    }
}

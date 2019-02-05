package blog2

class Tag {
    String name

    static hasMany = [posts: Post]
    static belongsTo = Post // if the post is deleted tags are also removed

    static constraints = {
        name(nullable: false, blank: false)
    }
}

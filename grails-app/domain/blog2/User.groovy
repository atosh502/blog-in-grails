package blog2

class User {
    String userName
    String fullName

    static hasMany = [posts: Post, updatedPosts: UpdatedPost]

    static constraints = {
        userName(nullable: false, blank: false)
        fullName(nullable: false, blank: false)
    }
}


package blog2

class User {
    String userName
    String password

    static hasMany = [posts: Post]

    static constraints = {
        userName(blank: false, unique: true, min: 4)
        password(blank: false, size: 4..20)
    }
}

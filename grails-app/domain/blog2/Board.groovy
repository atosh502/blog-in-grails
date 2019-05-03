package blog2

class Board {

    String boardName

    static hasMany = [lists: List]

    static constraints = {
        boardName(blank: false)
    }
}

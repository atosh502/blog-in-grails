package blog2

class List {

    String listName

    static hasMany = [cards: Card]
    static belongsTo = [board: Board] // this will cascade delete as well

    static constraints = {
    }
}

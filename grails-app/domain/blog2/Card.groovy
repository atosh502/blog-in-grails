package blog2

class Card {

    String cardName
    String cardDescription

    static belongsTo = [list: List]

    static constraints = {
    }
}

package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class CardController {

    def index() {
        render "Show me all the cards you have!"
    }

    def editCard(){
        Card card = Card.get(params.long("cardId"))
        card.cardName = params.cardName
        card.cardDescription = params.cardDesc
        card.save(failOnError: true, flush: true)

        redirect(controller: 'board', action: 'show', id: card.list.board.id)
    }

    def moveCard(){
        Card card = Card.get(params.long("cardId"))
        List oldList = card.list
        List newList = List.findByListName(params.moveToList)
        oldList.removeFromCards(card)
        newList.addToCards(card)
        oldList.save(failOnError: true, flush: true)
        newList.save(failOnError: true, flush: true)

        redirect(controller: 'board', action: 'show', id: card.list.board.id)
    }
}

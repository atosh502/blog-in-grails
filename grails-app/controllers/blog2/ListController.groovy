package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class ListController {

    def index() {
        render "Show me all the lists you have!"
    }

    def addCard(){
        List list = List.get(params.long("listId"))

        Card card = new Card(cardName: params.cardName, cardDescription: params.cardDesc, list: list)
                    .save(failOnError: true, flush: true)
        list.addToCards(card)

        redirect(controller: 'board', action: 'show', id: list.getBoard().id)
    }
}

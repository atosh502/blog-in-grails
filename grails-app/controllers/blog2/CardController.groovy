package blog2

import grails.plugin.springsecurity.annotation.Secured


class CardController {

    @Secured('permitAll')
    def index() {
        render "Show me all the cards you have!"
    }
}

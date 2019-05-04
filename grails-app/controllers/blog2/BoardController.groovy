package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class BoardController {

    def index() {
        respond Board.list()
    }

    def show(Long id){
        respond Board.get(id)
    }

    def addList(){
        Board board = Board.get(params.long("boardId"))

        List list = new List(listName: params.listName, board: board).save(failOnError: true, flush: true)
        board.addToLists(list)

        redirect(action: 'show', id: board.id)
    }

    def addBoard(){
        Board board = new Board(boardName: params.boardName).save(failOnError: true, flush: true)

        redirect(action: 'index')
    }
}

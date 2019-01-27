package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class PostController {

    def postService // dependency injection

    def index() {
        respond postService.list()
    }

    def show(Long id){
        respond postService.get(id)
    }

    def create(){
        respond new Post(params)
    }

    def save(){
//        println params
        String userId = params.id
        String title = params.title
        String text = params.text
        postService.save(userId, title, text)
        redirect(action: "index", method: "GET")
    }

    def edit(){
//        println params
        postService.edit(params.long("postId"), params.title, params.text)
        redirect(action: "index", method: "GET")
    }

    def delete(Long id){
        postService.delete(id)
        redirect(action: "index", method: "GET")
    }

    def update(Long id){
        respond postService.get(id)
    }
}

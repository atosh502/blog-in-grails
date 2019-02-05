package blog2

import grails.plugin.springsecurity.annotation.Secured

@Secured('isAuthenticated()')
class PostController {

    def postService

    def index() {
        respond postService.list()
    }

    def tag(String tag){
        respond postService.getPostsByTag(tag)
    }

    def show(Long id){
        respond postService.get(id)
    }

    def create(){
        respond new Post(params)
    }

    def save(){
        String userName = params.id
        String title = params.title
        String text = params.text
        String tags = params.tags

        User user = User.findByUserName(userName)
        postService.save(user.id, title, text, tags)
        redirect(action: "index", method: "GET")
    }

    def edit(){
        postService.edit(params.long("postId"), params.title, params.text)
        redirect(action: "index", method: "GET")
    }

    def delete(Long id){
        postService.delete(id)
        redirect(action: "index", method: "GET")
    }

    def archived(){
        // return only the Posts that were deleted
        respond postService.archived()
    }

    def update(Long id){
        respond postService.get(id)
    }
}

package blog2

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

    def save(Post post){
        postService.save(post)
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

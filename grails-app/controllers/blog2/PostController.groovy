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

    def save(){
//        println params
        Long id = params.long("id") // groovy cannot cast params.id automatically into a long
        String title = params.title
        String text = params.text
        postService.save(id, title, text)
        redirect(action: "index", method: "GET")
    }

    def edit(){
        println params
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

package blog2

import grails.gorm.transactions.Transactional

@Transactional
class PostService {

    def userService

    def get(Long id){
        Post.get(id)
    }

    def list(){
        Post.list()
    }

    def edit(Long postId, String title, String text){
        Post post = Post.get(postId)
        post.title = title
        post.text = text
        post.save(failOnError: true, flush: true)
    }

    def save(Long id, String title, String text){
        User user = userService.get(id)
//        println user.id
        new Post(user: user, title: title, text: text).save(failOnError: true, flush: true)
    }

    def delete(Long id){
        Post.get(id).delete()
    }

    def update(Post post){
        post.save()
    }
}

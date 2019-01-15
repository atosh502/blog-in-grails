package blog2

import grails.gorm.transactions.Transactional

@Transactional
class PostService {

    def get(Long id){
        Post.get(id)
    }

    def list(){
        Post.list()
    }

    def edit(Long userId, Post post){
        post.save(failOnError: true, flush: true)
    }

    def save(Post post){
        User user = User.findByUserName("admin")
        user.addToPosts(post)
        user.save(failOnError: true, flush: true)
    }


    def delete(Long id){
        Post.get(id).delete()
    }

    def update(Post post){
        post.save()
    }
}

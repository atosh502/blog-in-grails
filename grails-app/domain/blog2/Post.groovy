package blog2

import gorm.logical.delete.LogicalDelete

class Post implements LogicalDelete<Post>{

    String title
    String text

    // belongTo ensures that not only create and update are cascaded but delete is also cascaded
    // i.e. whenever user is deleted the corresponding posts are also deleted
    // bidirectional mapping

    static belongsTo = [user: User]
    static hasMany = [tags: Tag]

    static constraints = {
        title(blank: false)
        text(blank: false)
    }
}

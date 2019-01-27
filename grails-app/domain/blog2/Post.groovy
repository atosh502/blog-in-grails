package blog2

import gorm.logical.delete.LogicalDelete

class Post implements LogicalDelete<Post>{

    String title
    String text
    String userId

    // belongTo ensures that not only create and update are cascaded but delete is also cascaded
    // i.e. whenever user is deleted the corresponding posts are also deleted
    // bidirectional mapping

    // don't need mapping now, since we are authenticating through google
    // static belongsTo = [user: User]

    static constraints = {
        title(blank: false)
        text(blank: false)
        userId(blank: false)
    }
}

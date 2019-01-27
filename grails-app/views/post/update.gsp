<!DOCTYPE html>
<html>

    <head>
        <meta name="layout" content="cleanMain" />
        <title>Update a Post</title>
    </head>

    <body>

        <div class="container-fluid">
            <nav class="navbar navbar-default">
                <div class="container-fluid">

                    <div class="navbar-header">
                        <a class="navbar-brand" href="/post/index">Blog</a>
                    </div>

                </div>
            </nav>

            <form action="/post/edit?postId=${post.id}" method="post">

                <div class="form-group">
                    <label for="post-title">Title:</label>
                    <input type="text" class="form-control" id="post-title" name="title" value="${post.title}">
                </div>

                <div class="form-group">
                    <label for="post-text">Text:</label>
                    <textarea class="form-control" id="post-text" name="text">${post.text}</textarea>
                </div>

                <input class="btn btn-primary" type="submit" value="Update" name="edit">

            </form>

        </div>

        <div class="myFooter container-fluid">

            <sec:ifLoggedIn>
                Currently logged in as: ${blog2.PostService.getLoggedUserFullName()}
                <form id="myForm" action="/logout/index" method="post" style="display: inline;">
                    <input type="hidden" name="hiddenField" value="doesnt_matter" />
                    <a href="#" onclick="document.getElementById('myForm').submit();">Logout</a>
                </form>
            </sec:ifLoggedIn>

        </div>

    </body>
</html>
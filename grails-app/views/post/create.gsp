<!DOCTYPE html>
<html>

    <head>
        <meta name="layout" content="cleanMain" />
        <title>Create new Post</title>
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

            <form action="/post/save?id=1" method="post">

                <div class="form-group">
                    <label for="post-title">Title:</label>
                    <input type="text" class="form-control" id="post-title" placeholder="Enter title of post" name="title">
                </div>

                <div class="form-group">
                    <label for="post-text">Text:</label>
                    <textarea class="form-control" id="post-text" placeholder="" name="text">
                    </textarea>
                </div>

                <input class="btn btn-primary" type="submit" value="Create" name="create">

            </form>

        </div>

    </body>
</html>
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

                    <ul class="nav navbar-nav">
                        <li>
                            <sec:ifLoggedIn>
                                <form id="myForm" action="/logout/index" method="post" style="display: inline;">
                                    <input type="hidden" name="hiddenField" value="doesnt_matter" />
                                    <a href="#" onclick="document.getElementById('myForm').submit();">Logout</a>
                                </form>
                            </sec:ifLoggedIn>
                        </li>
                    </ul>

                </div>
            </nav>

            <form action="/post/save?id=${session.user.id}" method="post">

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
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="cleanMain" />
        <title>Show all Posts</title>
    </head>

    <body>

        <div class="container-fluid">
            <nav class="navbar navbar-default">
                <div class="container-fluid">

                    <div class="navbar-header">
                        <a class="navbar-brand" href="/post/index">Blog</a>
                    </div>

                    <ul class="nav navbar-nav">
                        <li><a href="/post/create">Create Post</a></li>
                    </ul>
                </div>
            </nav>

            <table class="table">
                <thead>
                    <tr>
                        <th>Title</th>
                        <th>Text</th>
                    </tr>
                </thead>

                <tbody>
                    <g:each in="${postList}" var="post">
                        <tr>
                            <td><g:link action="show" id="${post.id}">${post.title}</g:link></td>
                            <td>${post.text}</td>
                        </tr>
                    </g:each>
                </tbody>
            </table>
        </div>
    </body>
</html>
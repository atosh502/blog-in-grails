<html>
    <head>
        <meta name="layout" content="cleanMain" />
        <title>Login</title>
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

            <form action="/user/authenticate" method="post">

                <div class="form-group">
                    <label for="userName">Username:</label>
                    <input type="text" class="form-control" id="userName" placeholder="Username" name="userName">
                </div>

                <div class="form-group">
                    <label for="password">Password:</label>
                    <input class="form-control" id="password" placeholder="Password" name="password" type="password">
                </div>

                <input class="btn btn-primary" type="submit" value="Submit" name="submit">

            </form>

        </div>

    </body>

</html>
<%--
  Created by IntelliJ IDEA.
  User: mrbean
  Date: 5/1/19
  Time: 11:31 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta name="layout" content="cleanMain" />
        <title>Boards</title>
    </head>

    <body>
        <div class="container-fluid">
            <nav class="navbar navbar-default">
                <div class="container-fluid">

                    <div class="navbar-header">
                        <a class="navbar-brand" href="/board/index">Boards</a>
                    </div>

                </div>
            </nav>

            <h4><b>Boards</b></h4>

            <input class="btn btn-primary" type="submit" value="Add Board" name="showAddBoardForm"
                   onclick="displayForm('addBoardForm', 'addBoardButton')" id="addBoardButton">

            <form action="/board/addBoard" method="post" class="form-inline" hidden="hidden"
                  id="addBoardForm">

                <div class="form-group">
                    <input type="text" class="form-control" id="board-name" placeholder="Add Board Name" name="boardName">
                    <input class="btn btn-primary" type="submit" value="Add Board" name="addBoard">
                </div>

            </form>

            <ol>
                <g:each in="${boardList}" var="board">
                    <li>
                        <g:link controller="board" action="show" id="${board.id}">
                            ${board.boardName}
                        </g:link>
                    </li>
                </g:each>
            </ol>

        </div>

        <div class="myFooter container-fluid">
            <sec:ifLoggedIn>
                Currently logged in as: ${applicationContext.springSecurityService.principal.userProfile.displayName}
                <form id="myForm" action="/logout/index" method="post" style="display: inline;">
                    <input type="hidden" name="hiddenField" value="doesnt_matter" />
                    <a href="#" onclick="document.getElementById('myForm').submit();">Logout</a>
                </form>

            </sec:ifLoggedIn>
        </div>

        <script>
            function displayForm(formId, buttonId) {
                console.log(formId, buttonId);
                var form = document.getElementById(formId);
                var button = document.getElementById(buttonId);
                button.style.display = "none";
                form.style.display = "block";
            }

        </script>

    </body>
</html>
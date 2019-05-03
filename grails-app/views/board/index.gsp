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

            <table class="table">
                <thead>
                <tr>
                    <th>Boards</th>
                </tr>
                </thead>

                <tbody>
                <g:each in="${boardList}" var="board">
                    <tr>
                        <td>
                            <g:link controller="board" action="show" id="${board.id}">
                                ${board.boardName}
                            </g:link>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>

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
    </body>
</html>
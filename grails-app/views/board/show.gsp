<%--
  Created by IntelliJ IDEA.
  User: mrbean
  Date: 5/1/19
  Time: 11:41 AM
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

            <h3>${board.boardName}</h3>

            <input class="btn btn-primary" type="submit" value="Add List" name="showAddListForm"
                   onclick="displayForm('addListForm', 'addListButton')" id="addListButton">

            <form action="/board/addList?boardId=${board.id}" method="post" class="form-inline" hidden="hidden"
                  id="addListForm">

                <div class="form-group">
                    <input type="text" class="form-control" id="list-name" placeholder="Add new List" name="listName">
                    <input class="btn btn-primary" type="submit" value="Add List" name="addList">
                </div>

            </form>

            <h4><b>Lists</b></h4>

            <ol>

                <g:each in="${board.lists}" var="list">
                    <li>

                        <p><h4>${list.listName}</h4></p>

                        <h5><b>Cards</b></h5>

                            <small hidden> <!-- just some variables -->
                                ${addCardFormId = 'addCardForm' + String.valueOf(list.id)}
                                ${addCardButtonId = 'addCardButton' + String.valueOf(list.id)}
                            </small>

                        <input class="btn btn-primary" type="submit" value="Add Card" name="showAddCardForm"
                               onclick="displayFormCard(${list.id})" id="${addCardButtonId}">

                        <form action="/list/addCard?listId=${list.id}" method="post" class="form-inline" hidden="hidden"
                            id="${addCardFormId}">

                            <div class="form-group">
                                <input type="text" class="form-control" id="card-name" placeholder="Add Card Name" name="cardName">
                                <input type="textarea" class="form-control" id="card-desc" placeholder="Add Card Description" name="cardDesc">
                                <input class="btn btn-primary" type="submit" value="Add Card" name="addCard">
                            </div>

                        </form>

                        <ul>
                            <g:each in="${list.cards}" var="card">
                                <li>

                                    <p><b>Name:</b> ${card.cardName}</p>
                                    <p><b>Description:</b> ${card.cardDescription}</p>

                                </li>
                            </g:each>
                        </ul>


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

            function displayFormCard(id){
                displayForm('addCardForm' + id, 'addCardButton' + id)
            }
        </script>

    </body>
</html>
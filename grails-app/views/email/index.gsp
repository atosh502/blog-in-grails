<!DOCTYPE html>

<html>
    <head>
        <meta name="layout" content="cleanMain" />
        <title>Email</title>
    </head>

    <body>

            <div class="container-fluid">
                <g:if test="${flash.message}">
                    <div class="message" role="alert">
                        ${flash.message}
                    </div>
                </g:if>

                <h3>Email Sender Form</h3>

                    <form action="/email/send" method="post" enctype="multipart/form-data">

                        <div class="form-group">
                            <label for="receiverEmail">To:</label>
                            <input type="email" class="form-control" id="receiverEmail" aria-describedby="emailHelp"
                                   placeholder="Enter email" name="address">
                        </div>

                        <div class="form-group">
                            <label for="emailSubject">Subject:</label>
                            <input type="text" class="form-control" id="emailSubject" placeholder="Email Subject"
                                    name="subject">
                        </div>

                        <div class="form-group">
                            <label for="emailBody">Message:</label>
                            <textarea rows="4" cols="50" id="emailBody" placeholder="Message body" name="body">
                            </textarea>
                        </div>

                        <div class="form-group">
                            <input type="file" name="attachment" />
                        </div>

                        <button type="submit" class="btn btn-primary">Send</button>

                    </form>
            </div>
    </body>
</html>
<html>
<body>
    <p>Send <b>GET request</b> to:
    <ul>
        <li>/messages
            <ul>
                <li><a href="webapi/messages">/messages</a> (all)
                <li><a href="webapi/messages/1">/messages/1</a> (exist)
                <li><a href="webapi/messages/3">/messages/3</a> 
                    (not exist. Default response: 204 No Content)
            </ul>
        <li>/others
            <ul>
                <li>/context
                    <ul>
                        <li><a href="webapi/others/context/abspath">
                                /others/context/abspath</a> (Absolute path)
                        <li><a href="webapi/others/context/request">
                                /others/context/request</a> (Request)
                    </ul>
                <li>/query
                    <ul>
                        <li><a href="webapi/others/query">
                                /others/query</a> (default)
                        <li><a href="webapi/others/query?param=3">
                                /others/query?param=3</a> (param: int)
                        <li><a href="webapi/others/query?param=abc">
                                /others/query?param=abc</a> (Can't cast to int. 
                                Default response: 404 Not Found)
                    </ul>
            </ul>
    </ul>
</body>
</html>

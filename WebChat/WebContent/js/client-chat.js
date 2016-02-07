// Handle click event
$("#send-message").click( sendMessage );

function sendMessage() {
	var message = $("#message"),
		name = $("#username");
	
	if( message.val().length > 0 && name.val().length > 0 ) {
		send(JSON.stringify( { message: message.val(), user: name.val() } ));
		$("#message").val('');
	}
	return false;
}

function sendMessageCallback(response) {
	var result = JSON.parse(response);
	if( result.hasOwnProperty( "user" ) ) {
		var date            = new Date(),
        	timestamp       = date.getTime();

		var parsedDate = $.format.date(timestamp, "H:mm:ss dd/MM/yyyy");
		
		$(".direct-chat-messages").loadTemplate(
				$("#chat-message-left"),
				{ name: result.user, text: result.message, date: parsedDate },
				{ append: true, complete: function() {
					console.log("[complete]");
					var scroll = 0;
					$(".direct-chat-msg").each(function(i, value){
						scroll += parseInt($(this).height());
					});
					if( scroll > 230 )
						$('.direct-chat-messages').animate({scrollTop: scroll});
				} }
			);
		console.log(result);
	}
}

function openSocket(){
    // Ensures only one connection is open at a time
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
       writeResponse("WebSocket is already opened.");
        return;
    }
    // Create a new instance of the websocket
    webSocket = new WebSocket("ws://localhost:8080/WebChat/chatsocket");
     
    webSocket.onopen = function(event){
        if(event.data === undefined)
            return;

        console.log(event.data);
    };

    webSocket.onmessage = function(event){
    	console.log(event.data);
    	sendMessageCallback(event.data);
    };

    webSocket.onclose = function(event){
    	console.warn("Connection closed");
    	if (window.confirm("Chat connection was closed. Reconnect?")) { 
    		openSocket();
		}
    };
}

function send(text){
    webSocket.send(text);
}

function closeSocket(){
    webSocket.close();
}

var webSocket;

$(document).ready(function() {
	console.log("[ Document ready ]");

	openSocket();
});
// Handle click event
$("#send-message").click( runSend );
var ip;

function runSend() {
	if( ip )
		sendMessage();
	else
		getIp( sendMessage );
}

function sendMessage() {
	var message = $("#message"),
		url = window.location.href.split('#')[0];
	
	if( message.val().length > 0 )
		$.get( url+"client", { message: message.val(), ip: ip } )
		.done( function(response) {
			sendMessageCallback()
		});
}

function sendMessageCallback(response) {
	$(".direct-chat-messages").append(
		"<!-- Message to the right -->" +
        "<div class=\"direct-chat-msg right\">" +
          "<div class=\"direct-chat-info clearfix\">" +
            "<span class=\"direct-chat-name pull-right\">Sarah Bullock</span>" +
            "<span class=\"direct-chat-timestamp pull-left\">23 Jan 2:05 pm</span>"+
          "</div><!-- /.direct-chat-info -->"+
          "<img class=\"direct-chat-img\" src=\"AdminLTE-2.3.0/dist/img/user3-128x128.jpg\" alt=\"message user image\"><!-- /.direct-chat-img -->"+
          "<div class=\"direct-chat-text\">"+
           ( response ) ? $("#message").val() : response+
          "</div><!-- /.direct-chat-text -->"+
        "</div><!-- /.direct-chat-msg -->"
	);
	$("#message").val('');
	console.log(response);
}

function getIp( callback ) {
	$.get('http://jsonip.com', function (res) {
		ip = res.ip
		callback.call();
	});
}

function openSocket(){
    // Ensures only one connection is open at a time
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
       writeResponse("WebSocket is already opened.");
        return;
    }
    // Create a new instance of the websocket
    webSocket = new WebSocket("ws://localhost:8080/WebChat/chatsocket");
     
    /**
     * Binds functions to the listeners for the websocket.
     */
    webSocket.onopen = function(event){
        // For reasons I can't determine, onopen gets called twice
        // and the first time event.data is undefined.
        // Leave a comment if you know the answer.
        if(event.data === undefined)
            return;

        console.log(event.data);
    };

    webSocket.onmessage = function(event){
    	console.log(event.data);
    	sendMessageCallback();
    };

    webSocket.onclose = function(event){
    	console.log("Connection closed");
    };
}

function send(){
    webSocket.send("Send");
}

function closeSocket(){
    webSocket.close();
}

function writeResponse(text){
	console.log("writeResponse", text);
}
var webSocket;

$(document).ready(function() {
	console.log("[ Document ready ]");

	openSocket();
});
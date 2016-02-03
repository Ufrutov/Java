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
			sendMessageCallback(response)
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
           $("#message").val()+
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
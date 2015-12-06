/**
 * Created by matt on 05/12/2015.
 */

var stompClient = null;

function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('dateDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}

function connect() {
    var socket = new SockJS('/dashboard');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/dashboardEntries', function(message){
            //showGreeting(JSON.parse(message.body).jobInstanceId);
            showGreeting(message);
        });
    });
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }

    setConnected(false);
    console.log("Disconnected");
}


function sendDate() {
    var date = document.getElementById('date').value;
    stompClient.send("/app/dashboard", {}, JSON.stringify({ 'date': date }));
}

function showGreeting(dashboardEntries) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(dashboardEntries));
    response.appendChild(p);
}
window.onload=function () {
    var request = new XMLHttpRequest();
    request.open("POST","/user/getUser",true);
    request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    request.send("id=1");
    request.onreadystatechange=function () {
        if(request.status==200&&request.readyState==4){
            document.getElementById("user").innerText=request.responseText;
        }
    }
}
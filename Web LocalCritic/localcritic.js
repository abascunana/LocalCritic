

function enviar (){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
           
        }
    }

    http.open("POST","http://localhost:8080/Localcritic/login",true);
    http.send("password="+document.getElementById("password").value+"&&username="+document.getElementById("username").value);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
  
}

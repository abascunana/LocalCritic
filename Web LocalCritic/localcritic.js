function enviar (){
    var http;
    http = new XMLHttpRequest;
    var usernamerg;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            if(http.responseText == 1){
                alert("usuario correcto");
                usernamerg = document.getElementById("username").value;
                localStorage.setItem("username", usernamerg);
                alert("bienvenido, "+usernamerg);
                window.location.href = "index.html";
            }
           else{
            alert("usuario incorrecto");
           }
        }
    }
    http.open("POST","http://localhost:8080/Localcritic/login",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("username="+document.getElementById("username").value+"&&password="+document.getElementById("password").value);
   
    return usernamerg;
  
 
}

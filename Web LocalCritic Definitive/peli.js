//Funció que s'executa amb onload del body
function actualitzar(){
    textoPelis();
    lista();
    PredecirResultado()
}


//Funció que sol·licita el select amb les opcions de paisos disponibles a la BBDD
function textoPelis(){
    var peliHttp;
    peliHttp = new XMLHttpRequest;

    peliHttp.onreadystatechange = function (){
        if (peliHttp.readyState==4 && peliHttp.status==200){
            document.getElementById("wrapper").innerHTML=peliHttp.responseText;
        }
    }

    peliHttp.open("GET","http://localhost:8081/localCritic/peli1",false);
    peliHttp.send();
    
}

//Funció per sol·licitar la llista d'usuaris filtrat per l'opció triada al select
function cercar(){
    localStorage.setItem("peli",document.getElementById("llistat").value)
    var http;
    http = new XMLHttpRequest;
    var prueba = null;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            alert(http.responseText);
            document.getElementById("usuaris").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8081/localCritic/peli2?titulo="+document.getElementById("llistat").value,true);
    prueba = http.responseText;
    http.send();
}
function cercarConLike(){
    var http;
    http = new XMLHttpRequest;
    var prueba = null;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("usuaris").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8081/localCritic/peli2?titulo="+localStorage.getItem("peli"),true);
    prueba = http.responseText;
    http.send();
}
function dividirCadena(cadenaADividir,separador) {
    let arrayDeCadenas = cadenaADividir.split(separador);
    return arrayDeCadenas;
 }
 function lista(){
    var http;
    http = new XMLHttpRequest;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){   
            document.getElementById("lista").innerHTML=http.responseText;
        }
    }
    var lalista = [];
    var lalista = dividirCadena(document.getElementById("lista").innerText,",");
    http.open("GET","http://localhost:8081/localCritic/lista",true);
    http.send();
    return(lalista);
}
function PredecirResultado(){
    const buscarInput = document.getElementById ('llistat');
    buscarInput.addEventListener('keyup',()=>{
        opciones = lista();
        let resultados = [];
        let input = buscarInput.value;
        if(input.length){
            resultados = opciones.filter((item)=>{
                return item.toLowerCase().includes(input.toLowerCase())
            });
            }
            conseguirResultados(resultados);
            
        });
}
function conseguirResultados(resultados){
    var aEnviar = "";
    for(let i = 0;i<resultados.length;i++){
        aEnviar = aEnviar + "<li>"+resultados[i]+"</li>";
        if(resultados[0] = ""){
            aEnviar = "";
            document.getElementById('loco').innerHTML = aEnviar
        }
    }
   document.getElementById('loco').innerHTML = aEnviar;
    }
    function Criticas(){
        var http;
        http = new XMLHttpRequest;
        var prueba = null;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
                alert(http.responseText);
                document.getElementById("usuaris").innerHTML=http.responseText;
            }
        }
    
        http.open("GET","http://localhost:8081/localCritic/RecogerCritica",true);
        prueba = http.responseText;
        http.send();
    }
    function Upvotes(id){
        var http;
        http = new XMLHttpRequest;
        var prueba = null;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
                alert(http.responseText);
            }
        }    
        http.open("GET","http://localhost:8081/localCritic/Upvote?ID="+id,true);
        prueba = http.responseText;
        http.send();
        cercarConLike();
    }
    function Downvotes(id){
        var http;
        http = new XMLHttpRequest;
        var prueba = null;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
                alert(http.responseText);
            }
        }    
        http.open("GET","http://localhost:8081/localCritic/Downvote?ID="+id,true);
        prueba = http.responseText;
        http.send();
        cercarConLike();
    }
    function UpvoteRefresh(id){
        Upvotes(id)
        cercarConLike()
    }
    function DownvoteRefresh(id){
        Downvotes(id);
        cercarConLike();
    }
    function UpvotePerfil(id){
        Upvotes(id)
        Perfil()
    
    }
    function DownvotePerfil(id){
        Downvotes(id)
        Perfil()    
    }
    function Perfil(){
        var http;
        var usuario = localStorage.getItem("usernamerg");
        http = new XMLHttpRequest;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
                document.getElementById("usuaris").innerHTML=http.responseText;
            }
        }
    
        http.open("GET","http://localhost:8081/localCritic/perfil?usuario="+usuario,true);
        http.send();
    }
    function enviar (){
        var http;
        http = new XMLHttpRequest;
        
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
                if(http.responseText == 1){
                    alert("usuario correcto")
                    localStorage.setItem("usernamerg", document.getElementById("username").value);
                    alert("bienvenido, "+ localStorage.getItem("usernamerg"))
                    alert(localStorage.getItem("usernamerg"))
                    window.location.href = "index.html"; 
                }
               else{
                alert("usuario incorrecto")
               }
            }   
        }
        http.open("POST","http://localhost:8081/localCritic/login",true);
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send("username="+document.getElementById("username").value+"&&password="+document.getElementById("password").value);       
    }
    
    
    function mostrarus (){
        var x = localStorage.getItem("usernamerg");
        document.getElementById("opciones2").innerHTML='<li>'+x+'</li>'
         if(x == "messi"){
           
            document.getElementById("opciones3").innerHTML='<li><a href="insertpeliculas.html">Insertar obras</a></li>'  
        }
      
      
    }
      
      
    

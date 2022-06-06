function actualitzar(){
    textoPelis();
    lista();
    PredecirResultado()   
    ConseguirTitulo()

    }

function actualitzarObras(){
    actualitzar()
    cercarConLike()
}
function actualitzarPerfil(){
    actualitzar()
    Perfil()
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

    peliHttp.open("GET","http://localhost:8080/LocalCritic/peli1",false);
    peliHttp.send();
    
}

//Funció per sol·licitar la llista d'usuaris filtrat per l'opció triada al select
function cercar(){
    localStorage.setItem("peli",document.getElementById("llistat").value)
    var http;
    http = new XMLHttpRequest;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("usuaris").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8080/LocalCritic/peli2?titulo="+document.getElementById("llistat").value,true);
    http.send();
    window.location.href = "VerObras.html"
}
function cercarConLike(){
    var http;
    http = new XMLHttpRequest;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("usuaris").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8080/LocalCritic/peli2?titulo="+localStorage.getItem("peli"),true);
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
    http.open("GET","http://localhost:8080/LocalCritic/lista",true);
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
    function tituloyusuario(){
        var titulo = localStorage.getItem("peli");
        var usuario = localStorage.getItem("usernamerg")
        document.getElementById("nombreusuario1").innerHTML='<input type="text" name="nombreusuario" id="nombreusuario" value="'+usuario+'">' 
        document.getElementById("titulo1").innerHTML='<input type="text" name="titulo" id="titulo" value="'+titulo+'">'  
    }
    function ConseguirTitulo2(id){
        if(localStorage.getItem("usernamerg")!= "null"){
        var http;
        http = new XMLHttpRequest;
        var resultado = null;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
                resultado = http.responseText
                localStorage.setItem("peli",resultado);
                window.location.href = "critica.html"
            }
        } 
        http.open("GET","http://localhost:8080/LocalCritic/ConseguirTitulo?ID="+id,true);
        prueba = http.responseText;
        http.send();
    }else{
        alert("Debes estar registrado")
    }
}
    function Upvotes(id){
        var http;
        http = new XMLHttpRequest;
        var prueba = null;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }    
        http.open("GET","http://localhost:8080/LocalCritic/Upvote?ID="+id,true);
        prueba = http.responseText;
        http.send();
    }
    function Downvotes(id){
        var http;
        http = new XMLHttpRequest;
        var prueba = null;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }    
        http.open("GET","http://localhost:8080/LocalCritic/Downvote?ID="+id,true);
        prueba = http.responseText;
        http.send();
    }
    function UpvoteRefresh(id){
        if(localStorage.getItem("usernamerg") != "null"){
            Upvotes(id);
            cercarConLike();
        }else{
            alert("Debes haber iniciado sesión")
            }
        }
    
    function DownvoteRefresh(id){
        if(localStorage.getItem("usernamerg") != "null"){
        Downvotes(id);
        cercarConLike();
    }else{
        alert("Debes haber iniciado sesión")
        }
    }
    function UpvotePerfil(id){
        if(localStorage.getItem("usernamerg") != "null"){
            Upvotes(id)
            Perfil()    
        }else{
            alert("Debes haber iniciado sesión")
            }
    }
    function DownvotePerfil(id){
        if(localStorage.getItem("usernamerg") != "null"){
        Downvotes(id)
        Perfil()    
        }else{
            alert("Debes haber iniciado sesión")
        }
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
    
        http.open("GET","http://localhost:8080/LocalCritic/perfil?usuario="+usuario,true);
        http.send();
    }
    function registrar() {
        var http;
        http = new XMLHttpRequest;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }
        http.open("POST","http://localhost:8080/LocalCritic/registroUsuario?username="+document.getElementById("username").value+"&&password="+document.getElementById("password1").value+"&&email="+document.getElementById("email1").value+"&&tipoUsuario="+document.getElementById("tipoUsuario1").value,true)
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send();
        window.location.href = "index.html"; 
    
      }
      function registrarPeli() {
        var http;
        http = new XMLHttpRequest;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }
        http.open("POST","http://localhost:8080/LocalCritic/registroPelicula?titulo="+document.getElementById("titulo").value+"&&sinopsis="+document.getElementById("sinopsis").value+"&&genero="+document.getElementById("genero").value+"&&actor="+document.getElementById("actor").value+"&&fecha="+document.getElementById("fecha").value+"&&duracion="+document.getElementById("duracion").value+"&&director="+document.getElementById("director").value+"&&productora="+document.getElementById("productora").value,true)
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send();
        window.location.href = "index.html"; 
      }
    function Critica() {
        var http;
        http = new XMLHttpRequest;
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
            }
        }
        http.open("POST","http://localhost:8080/LocalCritic/critic?titulo="+document.getElementById("titulo").value+"&&nombreusuario="+document.getElementById("nombreusuario").value+"&&textoCritica="+document.getElementById("textoCritica").value+"&&valCritica="+document.getElementById("valCritica").value,true)
        http.send();
        window.location.href = "index.html"; 
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
                    ConseguirTitulo()
                    window.location.href = "index.html"; 
                }
               else{
                alert("usuario incorrecto")
               }
            }   
        }
        http.open("POST","http://localhost:8080/LocalCritic/login",true);
        http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        http.send("username="+document.getElementById("username").value+"&&password="+document.getElementById("password").value);       
    }
    
    function mostrarus (){
       
        var nombre = localStorage.getItem("usernamerg")
        var x = localStorage.getItem("tipousuario");
        if (nombre != "null"){
        document.getElementById("registro").innerHTML='<li class="itemNav" onclick="Cerrarsesion()"><a href="index.html">Cerrar sesión</a></li>'
        document.getElementById("opciones2").innerHTML='<li class="itemNav">'+nombre+'</li>'
        
        }
        if(nombre == "null"){
            document.getElementById("perfil").innerHTML=""
        }
        if(x == "Admin"){
            document.getElementById("opciones3").innerHTML='<li><a href="InsertarObra.html">Insertar obras</a></li>'  
        }
    }
    function ConseguirTitulo(){
        var http;
        http = new XMLHttpRequest;
        var resultado = null;
        nombre = localStorage.getItem("usernamerg")
       
        http.open("GET","http://localhost:8080/LocalCritic//TipoUsuarioServlet?nombre="+nombre,true);
        http.send();
        http.onreadystatechange = function (){
            if (http.readyState==4 && http.status==200){
                resultado = http.responseText
                localStorage.setItem("tipousuario",resultado);
                mostrarus ()
            }
        } 
   
    }
    function Cerrarsesion(){
        localStorage.setItem("usernamerg",null)
        localStorage.setItem("tipousuario",null)
        window.location.href = "index.html"; 
    }
      
      
    

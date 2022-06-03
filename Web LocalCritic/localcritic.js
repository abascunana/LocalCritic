function actualitzar(){
    textoPelis();
    lista();
    PredecirResultado()
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
                
                window.location.href = "index.html";
              
            }
            
           else{
            alert("usuario incorrecto")
           }
         
        }
        
        
    }
    
    http.open("POST","http://localhost:8080/Localcritic/login",true);
    http.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    http.send("username="+document.getElementById("username").value+"&&password="+document.getElementById("password").value);
  
   
}


function mostrarus (){
    var x = localStorage.getItem("usernamerg");
    if(x != null){
        document.getElementById("nombreusuario").innerHTML=x;
       
      }
     if(x == "admin"){
        document.getElementById("opciones").innerHTML='<li><a href="insertpeliculas.html">Insert</a></li>'  
    }
  
  
}
  
  
}

function textoPelis(){
    var peliHttp;
    peliHttp = new XMLHttpRequest;
    peliHttp.onreadystatechange = function (){
        if (peliHttp.readyState==4 && peliHttp.status==200){
            document.getElementById("selector").innerHTML=peliHttp.responseText;
        }
    }

    peliHttp.open("GET","http://localhost:8080/Localcritic/peli1",false);
    peliHttp.send();
    
}

function cercar(){
    var http;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("usuaris").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8080/LocalCritic/peli2?titulo="+document.getElementById("llistat").value,true);
    http.send();
}
function lista(){
    var http;
    var rawlista;
    let lista;
    http = new XMLHttpRequest;

    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            document.getElementById("usuaris").innerHTML=http.responseText;
        }
    }
    var coma = ",";
   http.open("GET","http://localhost:8080/LocalCritic/lista");
   rawlista = http;
  dividirCadena(rawlista,coma);
    http.send();
}
function dividirCadena(cadenaADividir,separador) {
    let arrayDeCadenas = cadenaADividir.split(separador);
    for (var i=0; i < arrayDeCadenas.length; i++) {
       document.write(arrayDeCadenas[i] + " / ");
    }
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
    const buscarWrapper = document.getElementsByClassName('wrapper'); 
    var resultadosWrapper = document.getElementById('loco');
    var aneviar = "";
    for(let i = 0;i<resultados.length;i++){
        aneviar = aneviar + "<li>"+resultados[i]+"</li>";
        if(resultados[0] = ""){
            aneviar = "";
            document.getElementById('loco').innerHTML = aneviar
        }
    }
   document.getElementById('loco').innerHTML = aneviar;

    //alert(aneviar);
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
    
        http.open("GET","http://localhost:8080/LocalCritic/RecogerCritica",true);
        prueba = http.responseText;
        http.send();
    }

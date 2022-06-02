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

    peliHttp.open("GET","http://localhost:8080/LocalCritic/peli1",false);
    peliHttp.send();
    
}

//Funció per sol·licitar la llista d'usuaris filtrat per l'opció triada al select
function cercar(){
    var http;
    http = new XMLHttpRequest;
    var prueba = null;
    http.onreadystatechange = function (){
        if (http.readyState==4 && http.status==200){
            alert(http.responseText);
            document.getElementById("usuaris").innerHTML=http.responseText;
        }
    }

    http.open("GET","http://localhost:8080/LocalCritic/peli2?titulo="+document.getElementById("llistat").value,true);
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
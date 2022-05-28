//Funció que s'executa amb onload del body
function actualitzar(){
    textoPelis();
    var cadenaADividir = "aa,s,f,aw,e";
    var separador = ",";
    let arrayDeCadenas = cadenaADividir.split(separador);
    for (var i=0; i < arrayDeCadenas.length; i++) {
       document.write(arrayDeCadenas[i] + " / ");
    }
    alert(arrayDeCadenas);
}


//Funció que sol·licita el select amb les opcions de paisos disponibles a la BBDD
function textoPelis(){
    var peliHttp;
    peliHttp = new XMLHttpRequest;

    peliHttp.onreadystatechange = function (){
        if (peliHttp.readyState==4 && peliHttp.status==200){
            document.getElementById("selector").innerHTML=peliHttp.responseText;
        }
    }

    peliHttp.open("GET","http://localhost:8080/LocalCritic/peli1",false);
    peliHttp.send();
    
}

//Funció per sol·licitar la llista d'usuaris filtrat per l'opció triada al select
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
    //lista.open("GET","http://localhost:8080/LocalCritic/lista")
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
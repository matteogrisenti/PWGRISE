
let frasi = [];             // array delle frasi
let cits = [];              // array delle citazioni

let nodoFrase = document.getElementById("frase")
let nodeCit = document.getElementById("cit")


function getFrasi(){            // Richiesta al Server delle frasi (più precisamente alla servlet GestoreFrasi

    // Preparo la richiesta
    let xhttp = new XMLHttpRequest();   //Creo la richiesta
    xhttp.responseType = "json";        //specifico che voglio una risposta in JSON
    xhttp.open("GET","/PW2_war_exploded/GestoreFrasi", true );
    //xhttp.open("GET","/PW2/GestoreFrasi", true );

    //Invio richiesta
    xhttp.send();

    //Callback
    xhttp.onreadystatechange = function (){
        //Controllo lo stato della risposta
        let done=4, ok=200;
        if(xhttp.readyState === done && xhttp.status===ok){

            // prendo il contenuto della risposta e lo salvo nei relativi array
            frasi=this.response.frasi;
            cits=this.response.cit;

            //console.log(this.response)
            //console.log(frasi)
            //console.log(cits)

            initFrase();
        }
    }


}

function initFrase(){                                           //funzione per inizializzare la fascia

    //console.log(frasi)
    //console.log(cits)

    let index = Math.floor(Math.random()*frasi.length);
    let nextFrase = frasi[index];
    let nextCit = cits[index]

    nodoFrase.innerText = nextFrase;
    nodeCit.innerText = nextCit;

}

function aggiornaFrase(){

    let nextFrase, nextCit;
    let frasePresente = nodoFrase.innerText; // prendo la frase presente
    //console.log(frasePresente)
    do{
        let index = Math.floor(Math.random()*frasi.length);         // ritorna un intero casuale
        nextFrase = frasi[index];                                  // estraggo la prossima frase dall'array delle frasi
        nextCit = cits[index];                                     // estraggo la prossima citazione dall'array delle citazioni
        //console.log(nextFrase)
    }while(nextFrase === frasePresente)                                   // se la frase successiva è uguale a quella presente rifaccio l'estrazione finché non sono diverse

    nodoFrase.innerText = nextFrase;                                   // aggiorno il testo del nodo Frase
    nodeCit.innerText = nextCit;                                       // aggiorno il testo del nodo Cit
    //console.log("CAMBIO")
}



function main(){
    getFrasi()
    setInterval(aggiornaFrase,20000)
}

main()



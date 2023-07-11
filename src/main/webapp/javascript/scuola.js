let myButtonCards = document.getElementsByClassName("button-standard");
let section = document.getElementsByTagName("section")[0];

// Aggiungo il listener del click
for (let myButtonCard of myButtonCards) {
    myButtonCard.addEventListener("click", popUpTesto,true)
}

function popUpTesto(e){

    /* Scelgo quale testo mostrare in base a che bottone premo*/
    let indicatoreTesto = e.target.getAttribute("value")        //prendo dall'attributo value del bottone cliccato l'indicatore di quale testo mostrare
    let testoDescrizione = setDescrizione(indicatoreTesto)                  //funziona che ritorna effettivamente il testo in base all'indicatore di testo passato

    // definisco la nuova finestra di descrizione del corso
    let finestra = document.createElement("div")            // crea il div contenente la nuova finestra, creo un tag div
    let descrizione = document.createTextNode(testoDescrizione)     // definisco il testo da inserire nel nuovo div
    finestra.appendChild(descrizione);                              // inserisco il testo nel div


    /* controlla se ci sono già delle finestre corso a schermo */
    if(section.getElementsByClassName("descrizioneCorso").length !== 0){        //controllo che l'array ritornato da getClassName non sia vuoto
        let finestraPrecedente = document.getElementsByClassName("descrizioneCorso")[0];  //prendo il primo elemento (e teoricamente unico) elemento di classe descrizioneCorso
        section.removeChild(finestraPrecedente)                                                  //rimozione elemento precedente
    }



    /* definisco la classe del div per definire il CSS della finestra*/
    if(indicatoreTesto === "chimica"){
        finestra.setAttribute("class","descrizioneCorso  sfondoGiallo")
    }
    else if(indicatoreTesto === "meccanica"){
        finestra.setAttribute("class","descrizioneCorso  sfondoRed")
    }
    else if(indicatoreTesto === "informatica"){
        finestra.setAttribute("class","descrizioneCorso  sfondoBlu")
    }
    else if(indicatoreTesto === "alberghiero"){
        finestra.setAttribute("class","descrizioneCorso  sfondoVerde")
    }


    // aggiungo la finestra cosi definita nel main scuola, essa sara aggiunta in coda
    section.appendChild(finestra);
}

function setDescrizione(testo){

    let text;

    if(testo === 'informatica'){
        text = "Il corso di informatica prevede un ciclo di 5 anni; che verrà concluso dall'esame di stato. Questo corso " +
            "fornisce ai ragazzi ottime basi sul mondo informatico, competenza molto spendibile sul mercato del lavoro";
    }

    else if(testo === 'alberghiero'){
        text = "Il corso alberghiero prevede un ciclo di 3 anni, estendibile a 4 con una specializzazione come cuoco. " +
            "Il corso è specializzato nel servizio in sala. L'alberghiero permette molti sbocchi lavorativi anche all'estero"
    }

    else if(testo === 'chimica'){
        text = "Il corso di chimica prevede un ciclo di 5 anni, che verrà concluso dall'esame di stato. Questo corso, piu" +
            "teorico rispetto agli altri, fornisce delle ottime basi per un eventuale prosecuzione universitaria nell'ambito chimico"
    }

    else if(testo === 'meccanica'){
        text = "Il corso di meccanica prevede un ciclo di 3 anni. Questo corso ha una grande componente di pratica che permette ai" +
            " ragazzi frequentanti di sviluppare delle ottime skill pratiche subito spendibili nel mondo lavorativo"
    }

    return text;
}

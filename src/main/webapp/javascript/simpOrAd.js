function effettuaDonazione(username){
    var tmp = document.getElementById("idImportoDonazione").value;
    var message = document.getElementById("idMessaggioDonazione").value;
    let importo = Number(tmp);


    if(Number.isInteger(importo)){
        let xhr = new XMLHttpRequest();
        let url = "/PW2_war_exploded/DonazioniUtenti";

        // Imposta il callback per gestire la risposta
        xhr.onload = function () {
            if (xhr.status === 200) {
                // La richiesta è stata completata con successo
                //console.log(xhr.responseText);
                alert(xhr.getResponseHeader("message"));
                document.getElementById("idImportoDonazione").value = ""
                document.getElementById("idMessaggioDonazione").value = ""
            }
            else {
                // Si è verificato un errore nella richiesta
                //console.error(xhr.status);
                alert(xhr.getResponseHeader("message"));
            }
        }

        // Imposta il metodo e l'URL di destinazione
        xhr.open("POST", url, true);

        // Imposta l'header Content-Type per indicare che si invia un form
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

        // Crea i dati da inviare come stringa nel formato chiave=valore
        let data = "username=" + username + "&importoDonazione=" + importo + "&messaggioDonazione=" + message;

        // Invia la richiesta
        xhr.send(data);
    }
    else {
        alert("21: Errore, inserito un importo non numerico");
    }
}

function eliminaAccount(id){
    let xhr = new XMLHttpRequest();
    xhr.open("GET", "/PW2_war_exploded/eliminaAccount?id=" + id, true);
    xhr.onload = function () {
        if (xhr.status === 200) {
            //console.log("Account eliminato correttamente");
            alert(xhr.getResponseHeader("message"));
            window.location.href = "login.jsp";
        }
        else {
            console.log("Errore nell'eliminazione dell'account");
            alert(xhr.getResponseHeader("message"));
        }
    }
    // Invia la richiesta
    xhr.send();
}
function iscriviti(attivita, id, username){
    let xhr = new XMLHttpRequest();
    let url = "/PW2_war_exploded/iscrizioneAttivita";
    let attività_box = document.getElementById(attivita.toString())
    let paragrafo_sostitutivo = document.createElement("p");
    paragrafo_sostitutivo.innerText="Sei già iscritto a questa attivita"

    // Imposta il callback per gestire la risposta
    xhr.onload = function () {
        if (xhr.status === 200) {
            // La richiesta è stata completata con successo
            console.log(xhr.responseText);
            alert(xhr.getResponseHeader("message"));
            attività_box.removeChild(attività_box.getElementsByTagName("button")[0])
            attività_box.appendChild(paragrafo_sostitutivo)
        }
        else {
            // Si è verificato un errore nella richiesta
            console.error(xhr.status);
            alert(xhr.getResponseHeader("message"));
        }
    }

    // Imposta il metodo e l'URL di destinazione
    xhr.open("POST", url, true);

    // Imposta l'header Content-Type per indicare che si invia un form
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

    // Crea i dati da inviare come stringa nel formato chiave=valore
    let data = "id=" + id + "&username=" + username + "&attivita=" + attivita;

    // Invia la richiesta
    xhr.send(data);
}




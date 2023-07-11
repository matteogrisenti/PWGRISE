colContForm = document.getElementById("colContForm");

main_page = document.getElementById("mainContatti")
pop_up = document.getElementById("finestra-Ricontattami");
section = document.getElementById("sectionContatti");
footer = document.getElementById("divFooter")

pop_up_element = document.getElementById("Pop-Up-Ricontattami");
form = document.getElementById("formRicontattami");
finestra_conferma = document.getElementById("finestra-invioConfermato");



titolo_errore = document.createElement("h3")
titolo_errore.style.color = "red"
titolo_errore.style.marginTop = "10px"
titolo_errore.style.marginBottom = "0"

testo_errore = document.createElement("p")
testo_errore.style.color = "red"
testo_errore.style.margin ="0"


/* SHOW POP-UP */

main_page.removeChild(pop_up);

colContForm.addEventListener("click", showFormRicontattami);

function showFormRicontattami(){
    main_page.removeChild(section);
    main_page.insertBefore(pop_up,footer)
    auto_fill()                                                               //imposto automaticamente gli input in base ai cookies
}

function closeFormRicontattami(){
    main_page.removeChild(pop_up);
    main_page.insertBefore(section,footer)
}


//AUTO FILL: compila automaticamente i campi nome ed email se trova i corrispettivi cookies
function auto_fill(){

    if (document.cookie !== ""){                                 //controllo che ci siano dei cookies

        //Dato che i cookie sono salvati come una stringa definisco un array di cookie separando la stringa;
        let cookies = document.cookie.split(";");

        // Passo tutti i cookie alla ricerca di "nome_cognome" e "mail"
        for (let i = 0; i < cookies.length; i++) {
            form.nome_cognome = undefined;
            form.mail = undefined;
            let cookie = cookies[i].trim().split("=");      // divido nome e valore del cookie togliendo eventuali spazi
            if (cookie[0] === 'nome_cognome') {
                form.nome_cognome.value = cookie[1];
            }
            if (cookie[0] === 'mail') {
                form.mail.value = cookie[1];
            }
        }
    }

}



//INVIO MAIL: abbiamo deciso che tutta l'operazione d'invio email sarà implementata nel front-end.
function inviaMail(){

    let nome_cognome = form.nome_cognome.value;
    let mail = form.mail.value;
    let motivo = form.motivo.value;
    let argomentazione = form.argomentazione.value;

    reset_style()

    let check = controllaCampi(nome_cognome,mail);

    if(check){
        Email.send({
            Host : "smtp.elasticemail.com",
            Username : nome_cognome,
            Password : "password",
            To : 'tum4world@nessunonoluogonoesiste.com',
            From : mail,
            Subject : motivo,
            Body : argomentazione
        }).then(
            //setTimeout(()=>{console.log("email inviata")}, 20000)  //Riga usata per testare il funzionamento asincrono
            window.location.assign("invioConfermato.jsp")
        );

        form.reset();
        closeFormRicontattami()

    }else{
        console.log("ERRORE INVIO")
        //event.preventDefault();
    }


}

function controllaCampi(nome_cognome,mail){

    let check = true

    if(!controlloNomeCognome(nome_cognome)){
        //console.log("Il campo nome e cognome inserito ha un formato non valido");
        document.getElementById("nome_cognome").setAttribute("class","inputError")
        document.getElementById("label_nome_cognome").setAttribute("class","labelError")
        //window.alert("Errore: nome e cognome inserito con un formato invalido");
        titolo_errore.innerText = "Errore nome cognome"
        testo_errore.innerText = "il nome e cognome possono contenere solo lettere e spazi"
        pop_up_element.appendChild(titolo_errore)
        pop_up_element.appendChild(testo_errore)

        check=false
    }
    if(!controlloMail(mail)){
        //console.log("La mail inserita ha un formato non valido");
        document.getElementById("label_contatti-mail").setAttribute("class","labelError")
        document.getElementById("contatti-mail").setAttribute("class","inputError")
        //window.alert("Errore: mail inserita con un formato invalido");
        titolo_errore.innerText = "Errore mail"
        pop_up_element.appendChild(titolo_errore)

        check=false
    }

    return check;

}

function controlloNomeCognome(nome_cognome){
    const patternNomeCognome = /^[A-Za-z\s]*$/      //String composta da soli caratteri e spazi
    return patternNomeCognome.test(nome_cognome);
}
function controlloMail(mail){
    const patternMail = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return patternMail.test(mail);
}


// WRAP FUNZIONE DI RESET
function over_reset(){
    reset_style()
    form.reset();
}

//RESET COLORE INPUT ERRATI e RIMOZIONE SCRITTA ERRORE
function reset_style(){
    document.getElementById("label_contatti-mail").setAttribute("class","label")
    document.getElementById("contatti-mail").setAttribute("class","input")

    document.getElementById("nome_cognome").setAttribute("class","input")
    document.getElementById("label_nome_cognome").setAttribute("class","label")

    //console.log(form.children)

    if(pop_up_element.contains(testo_errore)){
        //console.log(form.children)
        pop_up_element.removeChild(testo_errore)
    }

    if(pop_up_element.contains(titolo_errore)){
        pop_up_element.removeChild(titolo_errore)
    }

}

form = document.getElementById("formSignUp");

titolo_errore = document.createElement("h3")
titolo_errore.style.color = "red"
titolo_errore.style.textAlign ="center"
titolo_errore.style.marginTop = "10px"
titolo_errore.style.marginBottom = "0"

testo_errore = document.createElement("p")
testo_errore.style.color = "red"
testo_errore.style.textAlign ="center"
testo_errore.style.margin ="0"

function mostraOrNascondiPassword(id){
    let password = document.getElementById(id);
    if(password.type === "password"){
        password.type = "text";
    }
    else {
        password.type = "password";
    }
}
function controllaCampi(){
    let check = true;

    reset_style()

    if(!isMaggiorenne()){
        //console.log("L'utente non è maggiorenne");
        titolo_errore.innerText="21:Non Maggiorenne"
        testo_errore.innerText="devi essere maggiorenne per iscriverti"
        evidenziaErrore("data");
        //window.alert("Errore: devi essere maggiorenne per iscriverti");
        check = false;
    }
    if(!isNumeroDiTelefono()){
        //console.log("Il numero di telefono inserito ha un formato non valido");
        titolo_errore.innerText="21: Numero di Telefono Invalido"
        testo_errore.innerText="numero di telefono inserito con un formato invalido"
        evidenziaErrore("telefono");
        //window.alert("Errore: numero di telefono inserito con un formato invalido");
        check = false;
    }
    if(!isMail()){
        //console.log("La mail inserita ha un formato non valido");
        titolo_errore.innerText="21: Mail Invalida"
        testo_errore.innerText="mail inserita con un formato invalido"
        evidenziaErrore("mail");
        //window.alert("Errore: mail inserita con un formato invalido");
        check = false;
    }
    if(!passwordIdentiche()){
        //console.log("Le due password inserite non corrispondono");
        titolo_errore.innerText="21: Password Non Corrispondenti"
        testo_errore.innerText="le password inserite non corrispondono"
        evidenziaErrore("password");
        //window.alert("Errore: le password inserite non corrispondono");
        check = false;
    }
    if(!passwordCorretta()){
        //console.log("La password non rispetta le caratteristiche richieste");
        titolo_errore.innerText="21: Password Invalida"
        testo_errore.innerText="la password non rispetta le caratteristiche richieste"
        evidenziaErrore("password");
        //window.alert("Errore: la password non rispetta le caratteristiche richieste");
        check = false;
    }

    if(!check){

        form.appendChild(titolo_errore)
        form.appendChild(testo_errore)

        //Se almeno una delle condizioni non è stata rispettata (mi dice che event è deprecato ma non ho capito il perché)
        event.preventDefault();

        /*  La funzione event.preventDefault() è un metodo JavaScript che viene
        utilizzato per prevenire il comportamento predefinito di un evento. In altre
        parole, viene utilizzata per impedire l'azione predefinita associata a un
        determinato evento.
         */

    }
    return check;
}

function isMaggiorenne(){
    let dataDiNascita = new Date(document.getElementById("idDataDiNascita").value);
    let eta = new Date() - dataDiNascita;
    return (Math.floor(eta/(1000 * 60 * 60 * 24 * 365.25)) >= 18);
}

function isNumeroDiTelefono(){
    let num = document.getElementById("idNumeroDiTelefono").value;
    const pattern = /^\d{10}$/; // Regex per un numero di telefono di 10 cifre
    return pattern.test(num);
    /*
    Un pattern per verificare se è un numero di telefono di 10 cifre:
    - ^ indica l'inizio della stringa.
    - \d corrisponde a una cifra (0-9).
    - {10} specifica che deve esserci esattamente 10 cifre.
    - $ indica la fine della stringa.
     */
}

function isMail(){
    let mail = document.getElementById("idMail").value;
    const pattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return pattern.test(mail);
    /*
    Un pattern per verificare se è un indirizzo mail con <a>@<b>.<c>
    - ^[^\s@]+ corrisponde a uno o più caratteri che non sono spazi o chiocciola (@) all'inizio della stringa.
    - @ corrisponde esattamente al carattere @.
    - [^\s@]+ corrisponde a uno o più caratteri che non sono spazi o chiocciola (@).
    - \. corrisponde esattamente al carattere ..
    - [^\s@]+ corrisponde a uno o più caratteri che non sono spazi o chiocciola (@).
     */
}

function passwordIdentiche(){
    let p1 = document.getElementById("idPassword1").value;
    let p2 = document.getElementById("idPassword2").value;
    return p1 === p2;
}

function passwordCorretta(){
    let password = document.getElementById("idPassword1").value;

    //La password deve avere esattamente otto caratteri
    if (password.length !== 8) {
        return false;
    }

    //La password deve avere almeno una 'l' e almeno tre 'm' (maiuscole/minuscole, in ordine casuale)
    const patternL = /[lL]/;
    const patternM = /[mM]/g;
    if (!patternL.test(password) || (password.match(patternM) || []).length < 3) {
        return false;
    }
    /*  Verifica la presenza di almeno una 'l' e almeno tre 'm':
        Viene utilizzato il pattern /[lL]/ per cercare la presenza di almeno una
        'l' (maiuscola o minuscola), ed il pattern /[mM]/g con il metodo match() per
        contare quante volte compare la lettera 'm' (maiuscola o minuscola).
        Se la stringa non contiene almeno una 'l' o se il conteggio delle 'm'
        è inferiore a tre, la funzione restituirà false.
     */

    //La password deve avere almeno una cifra numerica
    const patternCifra = /\d/;
    if (!patternCifra.test(password)) {
        return false;
    }

    //La password deve avere almeno un carattere speciale tra '$', '!' e '?'
    const patternCarattereSpeciale = /[$!?]/;
    if (!patternCarattereSpeciale.test(password)) {
        return false;
    }

    //La password deve avere almeno un carattere maiuscolo
    const patternMaiuscolo = /[A-Z]/;
    if(!patternMaiuscolo.test(password)){
        return false;
    }

    //Non ho riscontrato errori nella formattazione della password
    return true;
}

function evidenziaErrore(input){
    if(input=="data"){
        let input = document.getElementById("idDataDiNascita");
        input.setAttribute("error","true")

        let input_label = document.getElementById("idDataDiNascita_label")
        input_label.setAttribute("error_label","true")
    }

    if(input=="telefono"){
        let input = document.getElementById("idNumeroDiTelefono");
        input.setAttribute("error","true")

        let input_label = document.getElementById("idNumeroDiTelefono_label")
        input_label.setAttribute("error_label","true")
    }

    if(input=="mail"){
        let input = document.getElementById("idMail");
        input.setAttribute("error","true")

        let input_label = document.getElementById("idMail_label")
        input_label.setAttribute("error_label","true")
    }

    if(input=="password"){
        let input1 = document.getElementById("idPassword1");
        input1.setAttribute("error","true")

        let input2 = document.getElementById("idPassword2");
        input2.setAttribute("error","true")

        let input_label1 = document.getElementById("idPassword1_label")
        input_label1.setAttribute("error_label","true")

        let input_label2 = document.getElementById("idPassword2_label")
        input_label2.setAttribute("error_label","true")
    }
}

function over_reset(){
    reset_style()
    form.reset();
}

function reset_style(){

    let inputs_elements = form.getElementsByTagName("input");
    for (let input_element of inputs_elements) {
        input_element.setAttribute("error","false")
    }

    let label_elements = form.getElementsByTagName("label");
    for (let label_element of label_elements) {
        label_element.setAttribute("error_label","false")
    }

    if(form.contains(testo_errore)){
        //console.log(form.children)
        form.removeChild(testo_errore)
    }

    if(form.contains(titolo_errore)){
        form.removeChild(titolo_errore)
    }
}
let cookiePopUp= document.getElementById("cookiePopUp");
let bottoni = document.getElementsByClassName("buttonCookie")

//Mostrare il pop-up quando la finestra viene caricata

window.addEventListener("load",() => {
    //Prima controllo che non sia gia stato richiesto, controllando l'esistenza del cookie
    if(document.cookie.includes("cookieAllow") ){
        cookiePopUp.setAttribute("pop-up","false");
    }else {
        cookiePopUp.setAttribute("pop-up", "true");
    }
})

for (const button of bottoni) {

    // Cambia il CSS quando passi sopra con il mouse
    button.addEventListener("mouseenter", (e) => { e.target.setAttribute("class","buttonHover"); })
    button.addEventListener("mouseleave", (e) => { e.target.setAttribute("class","buttonNormal"); })

    // Al click di uno dei due bottoni il banner sparisce
    button.addEventListener("click", (e) => {
        cookiePopUp.setAttribute("pop-up","false");

        //Se il bottone è accept allora setto un cookie di una ora per salvare l'informazione. Possiamo farlo perché è un cookie di navigazione per cui non è
        // richiesto dalla normativa italiana il consenso.

        // Il cookie di conferma utilizzo cookie è stato definito mediante javascript senza passare dal server con una richiesta
        if(e.target.id === "accept"){
            document.cookie = "cookieAllow= true;max-age=" + 60 * 60 // il + 60 *60 indica l'eta massima del cookie "cookieAllow" di 3600 secondi
        }else{
            document.cookie = "cookieAllow= false; max-age=" + 60 * 60
        }

    })

}


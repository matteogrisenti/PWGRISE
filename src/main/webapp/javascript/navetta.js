// CODICE per l'effetto di SCROLL dei tre elementi navetta
let busRows = document.getElementsByClassName("bus-row");
function scroll(e){
    let elScroll = e.target.getElementsByClassName("elm-scorre")[0];
    elScroll.setAttribute("scroll", "true")
    console.log(elScroll.attributes);
}

function normal(e){
    let elScroll = e.target.getElementsByClassName("elm-scorre")[0];
    elScroll.removeAttribute("scroll")
    console.log(elScroll.attributes);
}

for (let busRow of busRows) {
    busRow.addEventListener("mouseenter",scroll)
    busRow.addEventListener("mouseleave",normal)
}

// CODICE per il FORM di DONAZIONE

showFormDona = function(){
    let popUp = document.getElementById("popUp");
    popUp.setAttribute("pop-up","true")
    window.scrollTo(window.innerWidth/2,window.innerHeight/2)           //scrolla la pagina in centro alla finestra
    window.onscroll = function() {
        window.scrollTo(window.innerWidth/2, window.innerHeight/2);     //sovrascrivo la funzione di scroll per sbloccare lo scroll
    };
}


closeFormDona = function(){
    let popUp = document.getElementById("popUp");
    popUp.setAttribute("pop-up","false")
    window.onscroll = function() {}
}
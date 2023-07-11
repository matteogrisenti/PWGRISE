let myCards = document.getElementsByClassName("card");


for (let i = 0; i < myCards.length; i++) {
    let el = myCards[i]
    el.onmouseenter = function(e){
        //console.log("dentro")
        //console.log(e.target.childNodes[1].childNodes[1])
        e.target.childNodes[1].setAttribute("class","cardInfoSel")
    }
    el.onmouseleave = function(e){
        //console.log("fuori")
        e.target.childNodes[1].setAttribute("class","cardInfo")
    }
}

hamburger = document.querySelector('.icon_hamburger');
menu = document.getElementById("menu")
el1 = document.querySelector('.el1')
el2 = document.querySelector('.el2')
subMenu = document.getElementById("subMenu");

hamburger.addEventListener("click", function (){
    let open = menu.getAttribute("menu_open")
    if(open === "true"){
        menu.setAttribute("menu_open","false")
    }else{
        menu.setAttribute("menu_open","true")
    }
} )


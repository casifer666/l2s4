/*
 * Ceci est une ardoise JavaScript.
 *
 * Saisissez du code JavaScript, puis faites un clic droit ou sélectionnez à partir du menu Exécuter :
 * 1. Exécuter pour évaluer le texte sélectionné (Ctrl+R),
 * 2. Examiner pour mettre en place un objet Inspector sur le résultat (Ctrl+I), ou,
 * 3. Afficher pour insérer le résultat dans un commentaire après la sélection. (Ctrl+L)
 */

var tabH3 = document.getElementsByTagName("h3");

function afficherCompteur () {
compteur = document.createTextNode("("+tabH3.length+")");
document.getElementsByTagName("h1")[0].appendChild(compteur);
}

window.addEventListener("load",afficherCompteur,false);

for (var i = 0 ; i < tabH3.length ; i++) {
    tabH3[i].id = ("recettes"+i);
}

var sommaire = document.createElement("div");
var H5 = document.createElement("h5");
H5.innerHTML = "Sommaire";
sommaire.appendChild(H5);


var ul = document.createElement("ul");

for (i = 0 ; i < tabH3.length ; i ++) {
    var li = document.createElement("li");
    var a = document.createElement("a");
    a.setAttribute("href","#"+tabH3[i].id);
    a.innerHTML += tabH3[i].innerHTML;
    li.appendChild(a);
    ul.appendChild(li);
}

sommaire.appendChild(ul);
document.getElementsByTagName("h1")[0].appendChild(sommaire);
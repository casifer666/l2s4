function deleteMessage() {
	var premierEnfant = document.querySelectorAll("#messages")[0].firstChild;
	if (premierEnfant != "null") {
       	document.querySelectorAll("#messages")[0].removeChild(premierEnfant);
	}
}

function clearMessage() {
    var premierEnfant = document.querySelectorAll("#messages")[0].firstChild;
    while (premierEnfant != "null") {
        deleteMessage ();
        var premierEnfant = document.querySelectorAll("#messages")[0].firstChild;
    }
 }


function creerBouton(ident, texte, action) {
    var autreDiv = document.createElement("div");
    autreDiv.setAttribute("id",ident);
    autreDiv.setAttribute("class","bouton");
    var texteDiv = document.createTextNode(texte);
    autreDiv.appendChild(texteDiv);
    autreDiv.addEventListener('click', action, false);
    var elementMessages = document.querySelectorAll("#messages")[0];
    elementMessages.parentNode.insertBefore(autreDiv, elementMessages);
}

function creerBoutonEffacement() {
    creerBouton("boutonclear", "Effacer les messages", clearMessage);
}

window.addEventListener("load",creerBoutonEffacement,false);

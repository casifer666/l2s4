function printMessage(t) {
    paragraphe = document.createElement('p');
    paragraphe.appendChild(document.createTextNode(t));
    document.getElementById("messages").insertBefore(paragraphe,document.querySelectorAll('#messages>p')[0]);
}

function printDate() {
	var maintenant = new Date();
	printMessage(""+maintenant);    
}
 
function creerBoutonDate() {
    var monDiv = document.createElement("div");
    monDiv.setAttribute("id","boutondate");
    monDiv.setAttribute("class","bouton");
    var texteDiv = document.createTextNode("Obtenir la date");
    monDiv.appendChild(texteDiv);
    monDiv.addEventListener('click', printDate, false);
    var elementMessages = document.querySelectorAll("#messages")[0];
    elementMessages.parentNode.insertBefore(monDiv, elementMessages);
 }

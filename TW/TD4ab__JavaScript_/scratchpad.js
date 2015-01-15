/*
 * This is a JavaScript Scratchpad.
 *
 * Enter some JavaScript, then Right Click or choose from the Execute Menu:
 * 1. Run to evaluate the selected text (Ctrl+R),
 * 2. Inspect to bring up an Object Inspector on the result (Ctrl+I), or,
 * 3. Display to insert the result in a comment after the selection. (Ctrl+L)
 */

/* Exercice 1 : Préalable : mise en place des outils */

/* 3. : Affichage */
console.log("Hello");

/* Question 1.1 : Les types */

/* 1. : Affichage */
console.log(typeof(1));
console.log(typeof(true));
console.log(typeof('abcde'));
console.log(typeof("abcde"));
console.log(typeof(0.0));
console.log(typeof('0.0'));
console.log(typeof([1,2,3]));

/* 2. : Tests d'égalité de valeur */
console.log(1=="1");
console.log(1==[1]);
console.log(1==[1,1]);

/* 3. : Tests d'égalités de valeur et de type */
console.log(1==="1");
console.log(1===[1]);
console.log(1===[1,1]);

/* 4. */
console.log('abcde'==="abcde");

/* Question 1.2 : Les tableaux */

/* 1. */
/* Création d'une variable représentant un tableau */
var t = [1,2,3,4,5];
/* Affichage de la valeur */
console.log(t);
/* Affichage de la valeur du premier élément */
console.log(t[0]);

/* 2. */
/* Ajout d'un 0 au début */
t.unshift(0);
console.log(t);
/* Ajout d'un 6 à la fin */
t.push(6);
console.log(t);
/* Indice de la valeur 1 */
console.log(t.indexOf(1)); /* 1 se trouve à l'indice 1 du tableau */

/* 3. Fonction afficherTab */
function afficherTab(t) {
    return ('{'+t.join('|')+'}');
}
/* Tests */
console.log(afficherTab([1,2,3,4,5,6]));
console.log(afficherTab([25,23,10]));

/* 4. Fonction occurences */
function occurrences (t,n) {
    var compteur = 0;
    for (var i = 0; i < t.length; i++) {
        if (t[i] === n)
            compteur ++
    }
    return (compteur);
}
/* Tests */
console.log(occurrences([25,23,10,23],10));
console.log(occurrences([25,23,10,23],14));
console.log(occurrences([25,23,10,23],23));

/* Question 1.3 : Les chaînes */

/* 1. Fonction capitalize */
function capitalize (s) {
    if ((s.length == 0) || ((s[0] < 'a') || (s[0] > 'z'))) {
        return s;
    }
    else {
        return (s.charAt(0).toUpperCase() + s.slice(1,s.length));
    }
}
/* Tests */
console.log(capitalize(""));
console.log(capitalize("timoleon"));
console.log(capitalize("1moleon"));

/* 2. Fonction decoupe */
function decoupe (s) {
    return (s.split(' '));
}
/* Tests */
console.log(decoupe("abcd efg h"));
console.log(decoupe("t i m o l e o n"));

/* Question 1.4 : Ajout d'attributs aux objets */

/* 1. Création d'un tableau et ajout d'un attribut */
var t = new Array (0,1,2,3,4,5,6);
t.nom = "Un_tableau";

/* Modification de la fonction afficherTab */
function afficherTabBis(t) {
    return (t.nom+':{'+t.join('|')+'}');
}

/* Tests */
var tab1 = new Array (23,25,10);
tab1.nom = "Mon_tableau";
var tab2 = new Array (23,25,10);
console.log(afficherTabBis(tab1));
console.log(afficherTabBis(tab2));

/* Question 1.5 : Ajout de méthodes */

/* 1. Fonction oAfficherTab */
function oAfficherTab() {
    return (this.nom+':{'+this.join('|')+'}');
}

/* 2. Création d'une méthode image */
t.image = oAfficherTab;
console.log(t.image());

/* 3. Fonction occurrencesBis et création d'une méthode compter */
function occurrencesBis (n) {
    var compteur = 0;
    for (var i = 0; i < this.length; i++) {
        if (this[i] === n)
            compteur ++
    }
    return (compteur);
}
t.compter = occurrencesBis;
console.log(t.compter(4));
console.log(t.compter(7));

/* 4. Ajout de la méthode rotationGauche() */
function rotationGauche () {
    this.push(this.shift());
    return this;
}
t.rotationGauche = rotationGauche;
console.log(t.rotationGauche());

/* 5. Définition des méthodes pour l'ensemble des tableaux */
Array.prototype.image = oAfficherTab;
Array.prototype.compter = occurrencesBis;
Array.prototype.rotationGauche = rotationGauche;

var tab3 = new Array (14,25,23,10,8);
tab3.nom = "Test";
console.log(tab3.image());
console.log(tab3.compter(14));
console.log(tab3.compter(10));
console.log(tab3.compter(1));
console.log(tab3.rotationGauche());

/* Question 1.6 : Accès aux éléments du DOM */

/* 1. "tagName" de l'élément d'identifiant section2 */
console.log(document.getElementById("section2"));

/* 2. Nombre d'éléments h2 du document */
console.log(document.getElementsByTagName("h2").length);

/* 3. Url de chaque image du document */
var tabImages = document.getElementsByTagName("img");

for (var i = 0 ; i < tabImages.length ; i++) {
    console.log(tabImages[i].src)
}

/* 4. Attribut class de chaque élément div */
var tabClasses = document.getElementsByTagName("div");

for (var i = 0 ; i < tabClasses.length ; i++) {
    console.log(tabClasses[i].getAttribute("class"))
}

/* 5. Nombre d'éléments p situés dans l'élément d'identifiant messages */
var tabParagraphes = document.getElementById("messages").getElementsByTagName("p");

console.log(tabParagraphes.length);

/* 6. Contenu du premier de ces éléments p */
console.log(tabParagraphes[0].innerHTML);

/* Question 1.7 : Recherche par querySelectorAll */

/* 1. Nombre d'éléments p situés dans l'élément d'identifiant messages */
console.log(document.querySelectorAll('#messages>p').length);

/* 2. Nombre d'éléments h2 qui sont "premier enfant" */
console.log(document.querySelectorAll('h2:first-child').length);

/* 3. Nombre d'éléments p qui sont "premier enfant" et, pour chacun d'eux, l'identifiant de l'élément dans lequel il est inclus */
console.log(document.querySelectorAll('p:first-child').length);

var tabPremiersEnfants = document.querySelectorAll('p:first-child');

for (var i = 0 ; i < tabPremiersEnfants.length ; i++) {
    console.log(tabPremiersEnfants[i].parentNode.id)
}

/* Question 1.8 : Modification d'attributs des éléments du DOM */

/* 1. Modification de l'attribut src de la deuxième image en y rangeant l'url */
document.querySelectorAll('img')[1].setAttribute("src","http://www.fil.univ-lille1.fr/technoweb/images/technoweb-gris.png");

console.log(document.querySelectorAll('img')[1].src);

/* 2. Modification de l'attribut class de la 3e section */
document.querySelectorAll('div[class]')[2].setAttribute("class","section important");

console.log(document.querySelectorAll('div[class]')[2].getAttribute("class"));

/* Question 1.9 : Création et suppression d'éléments */

/* 1. Création d'un nouveau nœud de tag p puis d'un nœud texte */
paragraphe = document.createElement('p');
texte = document.createTextNode("Voici un nœud texte...");

paragraphe.appendChild(texte);

document.getElementById('messages').appendChild(paragraphe);

/* 2. Insertion du paragraphe au début de l'élément messages */
document.getElementById("messages").insertBefore(paragraphe,document.querySelectorAll('#messages>p')[0]);

/* 3. Construction de la fonction printMessage */
function printMessage(t) {
    paragraphe = document.createElement('p');
    paragraphe.appendChild(document.createTextNode(t));
    document.getElementById("messages").insertBefore(paragraphe,document.querySelectorAll('#messages>p')[0]);
}

printMessage("Ma fonction marche !");
printMessage("Confirmation...");

/* 4. Construction de la fonction deleteMessage */
function deleteMessage() {
	var premierEnfant = document.querySelectorAll("#messages")[0].firstChild;
	if (premierEnfant != "null") {
       	document.querySelectorAll("#messages")[0].removeChild(premierEnfant);
	}
}

deleteMessage();

/* 5. Construction de la fonction clearMessage */
function clearMessage() {
    var premierEnfant = document.querySelectorAll("#messages")[0].firstChild;
    while (premierEnfant != "null") {
        deleteMessage ();
        var premierEnfant = document.querySelectorAll("#messages")[0].firstChild;
    }
 }
 
//clearMessage();

/* Question 1.10 : Gestion des évènements */
 
/* Creation d'un element de tag div et insertion dans le document */
var unDiv = document.createElement("div");
unDiv.setAttribute("id","boutonclear");
unDiv.setAttribute("class","bouton");
var texteDiv = document.createTextNode("Effacer les messages");
unDiv.appendChild(texteDiv);
unDiv.addEventListener('click', clearMessage, false);
var elementMessages = document.querySelectorAll("#messages")[0];
elementMessages.parentNode.insertBefore(unDiv, elementMessages);

/* Question 1.11 : Création de « boutons » */

/* Ecriture de la fonction creerBouton(ident, texte, action)*/
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

/* Ecriture de la fonction creerBoutonEffacement() */
function creerBoutonEffacement() {
    creerBouton("boutonclear", "Effacer les messages", clearMessage);
}

/* Question 1.13 : Autre bouton */
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

















/*
 * This is a JavaScript Scratchpad.
 *
 * Enter some JavaScript, then Right Click or choose from the Execute Menu:
 * 1. Run to evaluate the selected text,
 * 2. Inspect to bring up an Object Inspector on the result, or,
 * 3. Display to insert the result in a comment after the selection.
 */

// Exercice 1 : Préalable : mise en place des outils
console.log("Exercice 1 : Préalable : mise en place des outils");

console.log("Hello");

// Question 1-1 : Les types
console.log("Question 1-1 : Les types");

// 1. Type d'une valeur
console.log("1. Type d'une valeur");

console.log(typeof(1));
console.log(typeof(true));
console.log(typeof('abcde'));
console.log(typeof("abcde"));
console.log(typeof(0.0));
console.log(typeof('0.0'));
console.log(typeof([1,2,3]));

// 2. Test d'égalité
console.log("2. Test d'égalité");

console.log(1=="1");
console.log(1==[1]);
console.log(1==[1,1]);

// 3. Opérateur ===
console.log("3. Opérateur ===");

console.log(1==="1");
console.log(1===[1]);
console.log(1===[1,1]);

// 4. Vérification de valeurs
console.log("4. Vérification de valeurs");

console.log('abcde'==="abcde");

// Question 1-2 : Les tableaux
console.log("Question 1-2 : Les tableaux");

// 1. Création d'un tableau et affichage de la valeur à l'indice 0
console.log("1. Création d'un tableau et affichage de la valeur à l'indice 0");

var t = new Array(1,2,3,4,5);
console.log(t[0]);

// 2. Ajout de 0 au début du tableau et 6 à la fin et affichage de la valeur à l'indice 1
console.log("2. Ajout de 0 au début du tableau et 6 à la fin et affichage de la valeur à l'indice 1");

t.unshift(0);
t.push(6);
console.log(t[1]);

// 3. Écriture de la fonction afficherTab
console.log("3. Écriture de la fonction afficherTab");

function afficherTab(tab) {
    return (tab.nom+"{"+tab.join('|')+"}");
}

console.log(afficherTab(t));
tab1 = [23,25,10];
console.log(afficherTab(tab1));

// 4. Écriture de la fonction occurrences
console.log("4. Écriture de la fonction occurrences");

function occurrences(tab,i) {
    var cpt = 0;
    for (var j = 0 ; j < tab.length ; j++) {
        if (tab[j] === i)
            cpt++;
    }
    return cpt;
}

console.log(occurrences(t,1));
console.log(occurrences(t,7));
t.push(4);
console.log(occurrences(t,4));

// Question 1-3 : Les chaînes
console.log("Question 1-3 : Les chaînes");

// 1. Écriture de la fonction capitalize
console.log("1. Écriture de la fonction capitalize");

function capitalize(s) {
    if (s.length == 0)
        return s;
    else
        if (s[0] < 'a' || s[0] > 'z')
            return s;
        else
            return (s.slice(0,1).toUpperCase()+s.slice(1,s.length));
}

var s1 = "";
console.log(capitalize(s1));
s1 += "test";
console.log(capitalize(s1));
s1 = "3" + s1;
console.log(capitalize(s1));

// 2. Écriture de la fonction decoupe
console.log("2. Écriture de la fonction decoupe");

function decoupe(s) {
    return s.split(" ");
}

var s2 = "abcd efg h";
console.log(decoupe(s2));

// Question 1-4 : Ajout d'attributs aux objets
console.log("Question 1-4 : Ajout d'attributs aux objets");

// 1. Création d'un tableau t et ajout d'un attribut nom
console.log("Création d'un tableau t et ajout d'un attribut nom");

t = [23,25,10];
t.nom = "JS";

// 2. Modification de la fonction afficherTab
console.log("2. Modification de la fonction afficherTab");

// Ajouter t.nom dans afficherTab

console.log(afficherTab(t));
console.log(afficherTab(tab1));

// Question 1.5 : Ajout de méthodes
console.log("Question 1.5 : Ajout de méthodes");

// 1. Nouvelle méthode oafficherTab
console.log("1. Nouvelle méthode oafficherTab");

function oafficherTab() {
    return (this.nom+"{"+this.join('|')+"}");
}

// 2. Création d'une méthode image()
console.log("3. Création d'une méthode image()");

t.image = oafficherTab;
console.log(t.image());

// 3. Création d'une méthode compter(val)
console.log("4. Création d'une méthode compter(val)");

function occurrences2(i) {
    var cpt = 0;
    for (var j = 0 ; j < this.length ; j++) {
        if (this[j] === i)
            cpt++;
    }
    return cpt;
}

t.compter = occurrences2;
console.log(t.compter(10));

// 4. Ajout d'une méthode rotationGauche()
console.log("Ajout d'une méthode rotationGauche()");

//console.log(t.shift
function decaler() {
    this.push(t.shift());
}

t.rotationGauche = decaler;
console.log(t.rotationGauche());










































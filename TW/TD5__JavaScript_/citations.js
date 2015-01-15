function ajouterLiens() {
	var tabCitations = document.getElementsByTagName("blockquote");
    for (i = 0 ; i < tabCitations.length ; i++) {
        var paragraphe = document.createElement("p");
        var lien = document.createElement("a");
        lien.setAttribute("href",tabCitations[i].cite);
        lien.innerHTML = "Source";
        paragraphe.appendChild(lien);
        tabCitations[i].appendChild(paragraphe);
    }
}

window.addEventListener("load",ajouterLiens,false);



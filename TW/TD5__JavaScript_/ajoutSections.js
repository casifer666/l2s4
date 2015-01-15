function ajouterSections() {
    var tabH2 = document.getElementsByTagName("h2");
    for (var i = 0 ; i < tabH2.length ; i++) {
      section = document.createElement("section");
      section.setAttribute("id",tabH2[i].getAttribute("id"));
      tabH2[i].removeAttribute("id");
      document.body.insertBefore(section,tabH2[i]);
      var frere = tabH2[i]
      while (frere.nextSibling() != nodeName("ul")) {
	tabH2[i].appendChild(frere.nextSibling());
      }
      section.appendChild(tabH2[i]);
    }
      
}

window.addEventListener("load",ajouterSections,false);

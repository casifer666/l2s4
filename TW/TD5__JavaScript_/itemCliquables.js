function ouvrirLiens() {
	var lien = this.getElementsByTagName('a');
	window.location.assign(a.href);
}

function itemCliquables() {
	var listes = document.querySelectorAll('ul#menu li');
	for (i = 0 ; i < li.length ; i ++) {
		listes[i].ouvre = ouvrirLiens;
		window.addEventListener('click',listes[i].ouvre,false);
	}
}

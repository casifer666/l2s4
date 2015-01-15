function voirContenu() {
	var adr = this.getAttribute("href");
	var laSection = document.getElementById(adr.substring(1,adr.length));
	var lesSections = document.getElementsByTagName("section");
	for (var i = 0 ; i < lesSections.length ; i ++) {
		uneSection = lesSections[i];
		if (uneSection == laSection) {
			uneSection.style.display = 'block';
		}
		else {
			uneSection.style.display = 'none';
		}
	}
}

function initMenu() {
	var menu = document.getElementById('menu');
	var liens = menu.getElementsByTagName('a');
	for (var i = 0 ; i < liens.length ; i ++) {
		liens[i].onclick = voirContenu;
	}
}

window.addEventListener('load',initMenu,false);



// HOSSAINY Said et DIAGNE Salla

// variable globale qui représentera la carte
var map;
// variable globale qui représentera les coordonnées du "centre de la France"
var centre;

function init() {
	// création de la carte
 	map = new OpenLayers.Map("macarte");
	// coordonnées du "centre de la France"
 	centre = new OpenLayers.LonLat(2.41889,47.26083);
}

function afficherCarte() {
	init();
	// création du fond de calque principal
	map.addLayer(new OpenLayers.Layer.OSM());
	// fixation du niveau de zoom
	map.zoomToMaxExtent();
	// définition de la projection de la carte et de la projection sphérique
	var projCarte = map.getProjectionObject();
	var projSpherique = new OpenLayers.Projection("EPSG:4326");
	// adaptation des coordonnées de centre à la carte
	centre.transform(projSpherique,projCarte);
	// zoom sur centre
	map.setCenter(centre,5.5);
	// affichage du bouton de contrôle des couches présentes sur la carte
	map.addControl(new OpenLayers.Control.LayerSwitcher({'ascending':false}));
}

function ajouterMarqueur() {
	// récupération des coordonnées des communes résultats sous la forme longitude,latitude
	var tab = document.getElementsByName("coordonnees");
	// création du calque des marqueurs
	var calqueMarkers = new OpenLayers.Layer.Markers("Repères");
	// création du contrôle de zoom
	var bounds = new OpenLayers.Bounds();
	for (var i = 0 ; i < tab.length ; i++) {
		// ajout du calque des marqueurs sur la carte
		map.addLayer(calqueMarkers);
		// transformation de la chaîne représentant les coordonnées sous la forme d'un tableau
		var coord = tab[i].innerHTML.split(',');
		// récupération des coordonnées
		var longitude = coord[0];
		var latitude = coord[1];
		// création d'un point en fonction des coordonnées du tableau
		var point = new OpenLayers.LonLat(longitude,latitude);
		// définition des projections sphérique et de la carte
		var projCarte = map.getProjectionObject();
		var projSpherique = new OpenLayers.Projection("EPSG:4326");
		// adaptation des coordonnées du point à la carte
		point.transform(projSpherique,projCarte);
		// fixation du niveau de zoom
		bounds.extend(point);
		// création du marqueur représentant le point
		var marqueur = new OpenLayers.Marker(point);
		// création d'un label pour le marqueur (nom de la commune s'affichant sur la carte au survol du marqueur)
		var contenu = tab[i].parentNode.textContent.split(" ");
		// introduction de l'article s'il y en a
		if (contenu[0] == "Le" || contenu[0] == "La" || contenu[0] == "Aux" || contenu[0] == "Les" || contenu[0] == "Las" || contenu[0] == "Los") {
		  marqueur.icon.imageDiv.title = contenu[0]+" "+contenu[1];
		}
		else {
		  marqueur.icon.imageDiv.title = contenu[0];
		}
		// ajout du marqueur au calque des marqueurs qui est lui-même sur la carte
		calqueMarkers.addMarker(marqueur);
	}
	// fixation du niveau de zoom pour que tous les marqueurs soient visibles de prime abord sur la carte
	map.zoomToExtent(bounds,false);
	if (map.getZoomForExtent(bounds,false) > 5.5) map.setCenter(point,5.5);
}

// fonction qui zoome sur la commune dont on veut afficher les détails
function zoom() {
	// récupération des variables passées dans l'url (code insee et coordonnées)
	url = location.search.slice(1);
	// séparation des variables et récupération de la 2e (coordonnées)
	var s = url.split("&")[1];
	// nécessité de couper la chaine "coordonnees=lon,lat" pour avoir "lon,lat"
	var coord = s.slice(12);
	// définition de la latitude et de la longitude à partir de la chaîne "lon,lat"
	var latitude = coord.split(",")[1]; var longitude = coord.split(",")[0];
	// définition des projections
	var projCarte = map.getProjectionObject();
	var projSpherique = new OpenLayers.Projection("EPSG:4326");
	// construnction du point
	var comm = new OpenLayers.LonLat(longitude,latitude);
	// transformation du point
	comm.transform(projSpherique,projCarte);
	// centrage de la carte sur le point
	map.setCenter(comm,14);
}

// fonction qui affiche la recherche et cache les résultats lorsqu'on clique sur l'onglet recherche
function afficherRecherche() {
	recherche = document.getElementById('recherche');
	resultats = document.getElementById('resultats');
	pagination = document.getElementById('pagination');
	recherche.style.display = 'inline';
	document.getElementById('onglet_rech').style.backgroundColor = '#2A9953';
	document.getElementById('onglet_rech').style.color = '#82EBA9';
	document.getElementById('onglet_res').style.backgroundColor = '#82EBA9';
	document.getElementById('onglet_res').style.color = '#2A9953';
	resultats.style.display = 'none';
	pagination.style.display = 'none';
	document.getElementById('alert').style.display = 'inline';
}

// fonction qui cache la pagination
function cacherPagination() {
	document.getElementById('pagination').style.display = 'none';
}

// fonction qui affiche la pagination
function afficherPagination() {
	document.getElementById('pagination').style.display = 'block';
}

// fonction qui affiche les résultats et cache la recherche lorsqu'on clique sur l'onglet résultats
function afficherResultats() {
	recherche = document.getElementById('recherche');
	resultats = document.getElementById('resultats');
	pagination = document.getElementById('pagination');
	resultats.style.display = 'inline';
	document.getElementById('onglet_res').style.backgroundColor = '#2A9953';
	document.getElementById('onglet_res').style.color = '#82EBA9';
	document.getElementById('onglet_rech').style.backgroundColor = '#82EBA9';
	document.getElementById('onglet_rech').style.color = '#2A9953';
	recherche.style.display = 'none';
	if (document.querySelectorAll('#pagination a').length != 0) {
		pagination.style.display = 'block';
	}
	document.getElementById('alert').style.display = 'none';
}

// fonction qui affiche le nombre de résultats d'une recherche
function nombreResultats(n) {
	document.getElementById('onglet_res').innerHTML += " ("+n+")";
}

// fonction qui change le message selon si la commune a été ajoutée aux favoris de l'utilisateur ou non
function messageFavori() {
	favoriser = document.getElementById('favoriser');
	if (document.cookie.indexOf(document.title) != -1)
		favoriser.innerHTML = "Retirer des favoris";
	else 
		favoriser.innerHTML = "Ajouter aux favoris";
}

// fonction qui se charge d'ajouter ou de retirer la commune des favoris lorsqu'on clique sur le bloc aménagé pour
function gereFavori() {
	favoriser = document.getElementById('favoriser');
	// une commune est dans les favoris si elle est présente dans le tableau de cookies
	if (document.cookie.indexOf(document.title) != -1) {
		// "vide" le cookie, c'est-à-dire le réinitialise avec une date d'expiration antérieure à la date d'aujourd'hui
		var expiration = new Date();
		expiration.setTime(expiration.getTime() - 1);
		document.cookie = "cookie["+document.title+"]=cookie supprime; expires="+expiration.toGMTString()+";";
		// change le message du bloc
		favoriser.innerHTML = "Ajouter aux favoris";
	}
	else {
		// crée un nouveau cookie et change le message du bloc
		document.cookie = "cookie["+document.title+"]="+location.search.slice(1);
		favoriser.innerHTML = "Retirer des favoris";
	}
}

/* fonction qui permet de supprimer tous les favoris lorsqu'on clique sur le bloc "Supprimer tous les favoris" dans la barre
déroulante des favoris */
function cleanFavoris() {
	var tabCookies = document.cookie.split(';');
	for (var i = 0 ; i < tabCookies.length - 1 ; i++) {
		var expiration = new Date();
		expiration.setTime(expiration.getTime() - 1);
		document.cookie = tabCookies[i]+"; expires="+expiration.toGMTString()+";";
	}
	document.getElementById('contenu').innerHTML = "Vous n'avez aucune commune favorite pour le moment";
}

// fonction qui affiche une alerte si aucun champ n'est rempli dans le formulaire de la recherche avancée
function afficherAlerte() {
	document.getElementById('alert').innerHTML = "Veuillez remplir au moins un champ";
}

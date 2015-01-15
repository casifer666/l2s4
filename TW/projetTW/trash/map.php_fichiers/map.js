// création de la carte
var map = new OpenLayers.Map("macarte");
// coordonnées du "centre de la France"
var centre = new OpenLayers.LonLat(2.41889,47.26083);

function afficherCarte() {
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
	map.setCenter(centre,5.4);
}

function cacherFormulaire() {
	
}
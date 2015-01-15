<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	// affichage des détails complets de la commune (invocation de la méthode afficheDetails de la classe Commune)
	include('connect.php');
	include_once('Commune.class.php');
	$commune = new Commune($detailsComm['nom'],$detailsComm['dept'],$detailsComm['comm'],$detailsComm['region'],
			$detailsComm['latitude'],$detailsComm['longitude'],$detailsComm['tncc'],$detailsComm['population']);
	$commune->afficheDetails();
?>

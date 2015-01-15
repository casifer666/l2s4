<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	// fonction qui renvoie l'article de la commune en fonction de son tncc
	function getArticle($tncc) {
		$t = array('0'=>"",'1'=>"",'2'=>"Le",'3'=>"La",'4'=>"Les",'5'=>"L'",'6'=>"Aux",'7'=>"Las",'8'=>"Los");
		if ($tncc < 9) return $t[$tncc]; else return null;
	}
	// modification du titre de la page en le nom de la commune dont on affiche les détails
	include('connect.php');
	$detailsComm = $connexion->query("SELECT * FROM communes WHERE dept||comm ='".$_GET['code']."'");
	$detailsComm = $detailsComm->fetch();
	echo("<title>".strtoupper(getArticle($detailsComm['tncc']))." ".$detailsComm['nom_ascii_maj'].
		" (".$detailsComm['dept'].") </title>");
?>

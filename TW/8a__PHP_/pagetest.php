<?php
	require('Livre.class.php');
	require('bibLivres.php');

	$auteursLivre1 = array('Mark Lutz','Vincent Le Goff');
	$auteursLivre2 = array('Gérard Swinnen','Cyrille Herby');

	$livre1 = new Livre('Python (en français)',$auteursLivre1,"");
	$livre2 = new Livre('Apprendre à programmer avec Python',$auteursLivre2,"");

	$livres = array($livre1,$livre2);

	echo(imageLivres($livres));
?>

	


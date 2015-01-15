<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	// commande qui affiche les erreurs de syntaxe au lieu d'une page blanche
	ini_set("display_errors",1);
	// connexion à la base de données du projet
	try {
		$connexion = new PDO("pgsql:host=localhost;dbname=projetTW","diagne","robben10", array(PDO::ATTR_ERRMODE => PDO::ERRMODE_WARNING));
	}
	catch (PDOException $e) {
		echo("Erreur connexion :". $e->getMessage());
	}
?>

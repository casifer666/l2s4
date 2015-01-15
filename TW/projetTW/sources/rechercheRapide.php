<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	include('connect.php');
	include_once('Commune.class.php');
	// tableau permettant d'effacer les articles dans la recherche
	$articles = array("LA","LE","LES","DU","DE","AUX","LAS","LOS","EN");

	if (isset($_POST['nom'])) {
		// "oublier" la variable de session liée à la recherche avancée
		unset($_SESSION['requete']);
		$_SESSION['rr'] = true;
		$_SESSION['ra'] = false;
		
		// fonction qui compare deux chaînes en fonction de leur distance de Levenshtein par rapport à l'entrée (tri par pertinence)
		function cmp($a,$b) {
			$a = implode($a); $b = implode($b);
			$entree = strtoupper($_POST['nom']);
			$entree = str_replace(array("â","à","ä","ç","é","è","ê","ë","î","ï","ô","ö","œ","û","ü","Â","À","Ä","Ç","É","È","Ê","Ë","Î","Ï","Ô","Ö","Œ","Û","Ü","'"),
			array("A","A","A","C","E","E","E","E","I","I","O","O","OE","U","U","A","A","A","C","E","E","E","E","I","I","O","O","OE","U","U","''"),$entree);
			if (levenshtein($a,$entree) > levenshtein($b,$entree)) 
				return 1;
			else
				if (levenshtein($a,$entree) < levenshtein($b,$entree))
					return (-1);
				else
					return 0;
		}

		$entree = strtoupper($_POST['nom']);
		$entree = str_replace(array("â","à","ä","ç","é","è","ê","ë","î","ï","ô","ö","œ","û","ü","Â","À","Ä","Ç","É","È","Ê","Ë","Î","Ï","Ô","Ö","Œ","Û","Ü","'"),
		array("A","A","A","C","E","E","E","E","I","I","O","O","OE","U","U","A","A","A","C","E","E","E","E","I","I","O","O","OE","U","U","''"),$entree);
		/* initialisation d'un tableau qui contiendra le contenu "splité" en fonction du caractère espace (recherches imbriquées)
		et d'un autre qui servira à afficher les résultats */
		$tableau = array();
		$communes = explode(' ',$entree);
		$i = 0;

		// traitement de toutes les communes entrées (interrogation de la base et ajout des résultats dans le tableau $tableau
		foreach ($communes as $uneCommune) {
			if (in_array($uneCommune,$articles)) {}
			else {
				if (strlen($uneCommune) < 4) {
					$test = $connexion->query("SELECT * FROM communes WHERE nom_ascii_maj='".$uneCommune."'");
					$tableau = array_merge($tableau,$test->fetchAll());
				}
				else {
					$test = $connexion->query("SELECT * FROM communes WHERE nom_ascii_maj LIKE '%".$uneCommune."%'");
					$tableau = array_merge($tableau,$test->fetchAll());
				}
			}
		}
		
		// tri du tableau en fonction de cmp
		usort($tableau,'cmp');

		 // aucun résultat si le tableau est vide
		if (count($tableau) == 0) {
			echo('<div id="null" style="color : black" onmouseover="document.getElementById("null").style.backgroundColor = "transparent"">
				Aucune commune ne correspond à votre recherche </div>');
			echo('<script> nombreResultats(0); </script>');
		}
		else {
			// enregistrement de l'url pour le bouton "Retour à l'accueil" dans la page détails
			$_SESSION['url'] = $_SERVER['REQUEST_URI'];
			// nombre de pages, tableau des résultats, page courante et total de résultats
			$_SESSION['nbreDePages'] = ceil(count($tableau)/15);
			$_SESSION['resultats'] = $tableau;
			$_SESSION['page'] = $_GET['page'];
			$_SESSION['total'] = count($tableau);
			$courant = ($_GET['page'] - 1) * 15;
			// sous-tableau qui contient les 15 premiers résultats
			$tableauInter = array_slice($tableau,0,15);
			foreach ($tableauInter as $ligne) {
				$uneCommune = new Commune($ligne['nom'],$ligne['dept'],$ligne['comm'],$ligne['region'],$ligne['latitude'],
					$ligne['longitude'],$ligne['tncc'],$ligne['population']);
				$uneCommune->afficheResultat();
			}
			echo("<script> window.addEventListener('load',ajouterMarqueur,false); nombreResultats(".$_SESSION['total']."); </script>");
		}
		echo("<script> afficherResultats(); </script>");
	}

		// affichage des 15 résultats correspondant au numéro de page
		if (isset($_SESSION['rr']) && $_SESSION['rr'] == true && isset($_GET['debut'])) {
		echo("<script> afficherResultats(); </script>");
		$_SESSION['url'] = $_SERVER['REQUEST_URI'];
		$ligneCourante = (($_GET['page'] - 1) * 15);
		$tableauInter = array_slice($_SESSION['resultats'],$ligneCourante,15);
		foreach ($tableauInter as $ligne) {
					$uneCommune = new Commune($ligne['nom'],$ligne['dept'],$ligne['comm'],$ligne['region'],
								$ligne['latitude'],$ligne['longitude'],$ligne['tncc'],$ligne['population']);
					$uneCommune->afficheResultat();
		}
		echo("<script> window.addEventListener('load',ajouterMarqueur,false); nombreResultats(".$_SESSION['total']."); </script>");
	}
?>

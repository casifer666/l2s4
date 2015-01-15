<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	include('connect.php');
	include_once('Commune.class.php');
	// on vérifie si un champ est rempli
	if (isset($_POST['commune']) || isset($_POST['code']) || isset($_POST['departement']) || isset($_POST['region']) || isset($_POST['pop_min']) || isset($_POST['pop_max'])) {
		unset($_SESSION['resultats']);
		// variables de session qui permettent de savoir dans quelle recherche nous sommes
		$_SESSION['ra'] = true;
		$_SESSION['rr'] = false;
		// message d'alerte si tous les champs sont vides
		if ($_POST['commune'] == "" && $_POST['code'] == "" && $_POST['departement'] == "" && $_POST['region'] == "" && $_POST['pop_min'] == "" && $_POST['pop_max'] == "") {
			unset($_SESSION['total']);
			echo("<script> afficherAlerte(); </script>");
		}
		else {
			// initialisation d'un tableau progressif vide et d'un indice qui servira à le parcourir
			$champs = array();
			$i = 0;
			if ($_POST['commune'] != "") {
				// mise en majuscules du contenu du champ commune et remplacement des accents
				$entree = strtoupper($_POST['commune']);
				$entree = str_replace(array("â","à","ä","ç","é","è","ê","ë","î","ï","ô","ö","œ","û","ü","Â","À","Ä","Ç","É","È","Ê","Ë","Î","Ï","Ô","Ö","Œ","Û","Ü","'"),
					array("A","A","A","C","E","E","E","E","I","I","O","O","OE","U","U","A","A","A","C","E","E","E","E","I","I","O","O","OE","U","U","''"),$entree);
				// ajout de la queue de la requête dans le tableau
				$champs[$i] = "nom_ascii_maj='".$entree."'"; $i++;
			}
			if ($_POST['code'] != "") {
				$champs[$i] = "dept||comm='".$_POST['code']."'"; $i++;
			}
			if($_POST['departement'] != "") {
				$champs[$i] = "dept='".$_POST['departement']."'"; $i++;
			}
			if ($_POST['region'] != "") {
				$champs[$i] = "region='".$_POST['region']."'"; $i++;
			}
			if ($_POST['pop_min'] != "") {
				$champs[$i] = "population >='".$_POST['pop_min']."'"; $i++;
			}
			if ($_POST['pop_max'] != "") {
				$champs[$i] = "population <='".$_POST['pop_max']."'"; $i++;
			}
			// sélection de l'onglet résultats
			echo("<script> afficherResultats(); </script>");
			// on complète la requête en ajoutant les éléments du tableau séparés par le mot-clé AND
			$resultats = $connexion->query("SELECT * FROM communes WHERE ".implode(" AND ",$champs)."ORDER BY nom");
			// aucun résultat si la requête aboutit à un statement vide
			if ($resultats->rowCount() == 0) {
				echo('<div id="null" style="color : black"> <a> Aucune commune ne correspond à votre recherche </a> </div>');
				echo("<script> nombreResultats(0); </script>");
			}
			else {
				// enregistrement de l'url dans une variable de session (pour le bouton "Retour à l'accueil" dans la page détails)
				$_SESSION['url'] =$_SERVER['REQUEST_URI'];
				// total de résultats et nombre de pages
				$totalResultats = $resultats->rowCount();
				$nbreDePages = ceil($totalResultats / 15);
				// enregistrement de la requête pour pouvoir réinterroger la base lorsqu'on change de page
				$_SESSION['requete'] = "SELECT * FROM communes WHERE ".implode(" AND ",$champs);
				$_SESSION['total'] = $totalResultats;
				$_SESSION['nbreDePages'] = $nbreDePages;
				$_SESSION['page'] = $_GET['page'];
				// affichage des 15 premiers résultats
				$resultats = $connexion->query("SELECT * FROM communes WHERE ".implode(" AND ",$champs)." ORDER BY nom ASC LIMIT 15
												OFFSET 0");
				while ($tableau = $resultats->fetch()) {
					$uneCommune = new Commune($tableau['nom'],$tableau['dept'],$tableau['comm'],$tableau['region'],
								$tableau['latitude'],$tableau['longitude'],$tableau['tncc'],$tableau['population']);
					$uneCommune->afficheResultat();
				}
				echo("<script> window.addEventListener('load',ajouterMarqueur,false); nombreResultats(".$totalResultats."); </script>");
			}
		}
	}
	
	// affichage des 15 résultats correspondant au numéro de page
	if (isset($_SESSION['ra']) && $_SESSION['ra'] == "true" && isset($_GET['debut'])) {
		echo("<script> afficherResultats(); </script>");
		$_SESSION['url'] = $_SERVER['REQUEST_URI'];
		$ligneCourante = (($_GET['page'] - 1) * 15);
		$resultats = $connexion->query($_SESSION['requete']." ORDER BY nom ASC LIMIT 15 OFFSET ".(($_GET['page'] - 1) * 15));
		while ($tableau = $resultats->fetch()) {
					$uneCommune = new Commune($tableau['nom'],$tableau['dept'],$tableau['comm'],$tableau['region'],
								$tableau['latitude'],$tableau['longitude'],$tableau['tncc'],$tableau['population']);
					$uneCommune->afficheResultat();
		}
		echo("<script> window.addEventListener('load',ajouterMarqueur,false); nombreResultats(".$_SESSION['total']."); </script>");
	}
?>

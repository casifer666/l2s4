<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
<meta charset="UTF-8" />

<?php
	require('Livre.class.php');
	require('bibLivres.php');
			
	function lire_livres($nom_fichier) {
		$i = 0; $livres = array();
		$id = fopen($nom_fichier,'r');
		$titreLivre = fgets($id);
		while (!feof($id)) {
			$auteursLivre = explode(',',fgets($id));
			$editeurLivre = fgets($id);
			$livres[$i] = new Livre($titreLivre,$auteursLivre,$editeurLivre);
			$i++;
			if ($editeurLivre == "\n") {
				$titreLivre = fgets($id);
			}
			else {
				$titreLivre = trim(fgets($id).fgets($id)); 
			}
		}
		fclose($id);
		return $livres;
	}

	echo(imageLivres(lire_livres('livres.txt')));
?>
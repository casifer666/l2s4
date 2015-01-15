<!-- HOSSAINY Said et DIAGNE Salla  -->

<?php
	/* affichage du message "Vous n'avez aucune commune favorite pour le moment" si aucun cookie n'est trouvé, et donc si
	l'utilisateur n'a pas de communes favorites */
	if (!isset($_COOKIE['cookie'])) {
		echo('<div> Vous n\'avez aucune commune favorite pour le moment </div>');
	}
	else {
		// affichage des favoris sinon
		foreach ($_COOKIE['cookie'] as $name => $value) {
			$name = htmlspecialchars($name);
			$value = htmlspecialchars($value); 
			echo('<div class="click" onclick="location.href=\'details.php?'.$value.'\'">'.$name.'</div>');
		}
		/* affichage du message "Supprimer tous les favoris" qui comme son nom l'indique, supprime toutes les communes favorites
		de l'utilisateur */
		echo('<div class="click" id="clean" onclick=cleanFavoris();> Supprimer tous les favoris </div>');
	}
?>

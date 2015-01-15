<!-- HOSSAINY Said et DIAGNE Salla -->

<?php
	// fonction de pagination en fonction de la page courante et du nombre de pages
	function pagination($pageCourante,$nbreDePages) {
		$pagination = "";
		if ($nbreDePages > 1) {
			// précédent
			if ($pageCourante > 1) {
				$pagination .= '<a class="extreme" href="index.php?page='.($pageCourante - 1).'&debut=non"> < Préc. </a>';
			}
			else {
				$pagination .= '<span class="extreme off"> < Préc. </span>';
			}

			// première page
			if ($pageCourante == 1)
				$pagination .= ' <span class="courant">1</span>';
			else
				$pagination .= ' <a href="index.php?page=1&debut=non">1</a>';

			// mise en page entre la page de début et la page courante
			if (($pageCourante - 1) > 2)
				$pagination .= '...';

			// boucle autour de la page courante
			if (($pageCourante - 1) > 1) $gauche = $pageCourante - 1; else $gauche = 2;
			if (($pageCourante + 1) <= ($nbreDePages - 1)) $droite = $pageCourante + 1; else $droite = $nbreDePages - 1;
			for ($i = $gauche ; $i <= $droite ; $i++) {
				$pagination .= ' ';
				if ($i == $pageCourante)
					$pagination .= ' <span class="courant">'.$i.'</span>';
				else
					$pagination .= ' <a href="index.php?page='.$i.'&debut=non">'.$i.'</a>';
			}

			// mise en page entre la page de fin et la page courante
			if (($pageCourante + 1) < $nbreDePages - 1)
				$pagination .= '...';

			// dernière page
			if ($pageCourante == $nbreDePages)
				$pagination .= ' <span class="courant">'.$nbreDePages.'</span>';
			else
				$pagination .= ' <a href="index.php?page='.$nbreDePages.'&debut=non">'.$nbreDePages.'</a>';

			// suivant
			if ($pageCourante < $nbreDePages)
				$pagination .= ' <a class="extreme" href="index.php?page='.($pageCourante + 1).'&debut=non" title="Page suivante"> Suiv. > </a>';
			else
				$pagination .= ' <span class="extreme off"> Suiv. > </span>';

			return $pagination;
		}
	}

	// affichage de la pagination si une recherche donne plus de 15 résultats
	if (isset($_GET['page']) && isset($_SESSION['total']) && ($_SESSION['total'] > 15))
		echo(pagination($_GET['page'],$_SESSION['nbreDePages']));
	// pas de pagination si une recherche donne au plus 15 résultats
	if (!isset($_GET['page']) || isset($_SESSION['total']) && $_SESSION['total'] <= 15)
		echo("<script> cacherPagination(); </script>");
	// pas de pagination si une recherche n'a pas encore été effectuée
	if (!isset($_SESSION['total']))
		echo("<script> cacherPagination(); </script>");
?>

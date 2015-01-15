<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
<meta charset="UTF-8" />

<body>

<h3> Exercice 1 </h3>

<h4> Question 1.1 </h4>

<?php
	$i=0;
	print( $i++  + "3 cochons"   . " chiens\n");
	print("$i"   . "3 cochons"   . " chiens\n");
	print( $i    + "4.1 cochons" + " chiens" . (3/2) . "\n");
?>

<h3> Exercice 2 </h3>

<h4> Question 2.1 </h4>

<?php
	$a = 'PHP';
	$b = 'MySQL';
	echo "$a et $b " ;
	echo "<br/>\n";
	echo '$a et $b';
	echo "<br/>\n";
	echo "La cérémonie d’ouverture a lieu le . date('d')";
	echo "<br/>\n";
	echo "La cérémonie d’ouverture a lieu le " . date('d');
	echo "<br/>\n";
	echo 'La cérémonie d\'ouverture a lieu le ' . date("d");
	echo "<br/>\n";
	echo "Sa devise est \"Liberté Egalité Fraternité\" ";
	echo "<br/>\n";
	echo $a . " et " . $b ;
	echo "<br/>\n";
	echo $a , " et " , $b ;
	echo "<br/>\n";
?>

<h4> Question 2.2 </h4>

<?php
	$tab[0] = 2004 ;
	$tab[1] = 31.14E7 ;
	$tab[2] = "PHP4";
	$tab[35] = 'MySQL' ;
	$tab[3] = 24 ;
	$tab[] = TRUE ;

	echo("Le tableau contient (couple clef => valeur) : 0 => 2004 , 1 => 311400000 , 2 => \"PHP4\" ; 3 => 24 ; 36 => 1");
?>

<h4> Question 2.3 </h4>

<?php
	echo("Valeurs du tableau \$tab : |");
	foreach ($tab as $valeur) {
		echo(" {$valeur} |");
	}
	echo("<br/>Longueur du tableau \$tab : " . count($tab));
?>

<h3> Exercice 3 </h3>

<h4> Question 3.1 </h4>

<?php
	$auteurs = array('Mark Lutz', 'Gérard Swinnen');
	$titres = array('Python (en français)', 'Apprendre à programmer avec Python');

	function tabLivres1($tab1,$tab2) {
		$table = "";
		for ($i = 0 ; $i < count($tab1) ; $i++) {
			$table .= "<tr><td class=\"auteur\">{$tab1[$i]}</td><td class=\"titre\">{$tab2[$i]}</td></tr>";
		}
		return $table;
	}
?>

<table>
	<?php
		echo(tabLivres1($auteurs,$titres));
	?>
</table>

<h4> Question 3.2 </h4>

<?php
	$livres = array(
		array('auteur'=>'Mark Lutz','titre'=>'Python (en français)'),
		array('auteur'=>'Gérard Swinnen','titre'=>'Apprendre à programmer avec Python')
		);

	function tabLivres2($tab) {
		$table = "";
		for ($i = 0 ; $i < count($tab) ; $i++) {
			$table .= "<tr><td class=\"auteur\">{$tab[$i]['auteur']}</td><td class=\"titre\">{$tab[$i]['titre']}</td></tr>";
		}
		return $table;
	}
?>

<table>
	<?php
		echo(tabLivres2($livres));
	?>
</table>

<h4> Question 3.3 </h4>

<?php

	$auteursLivre1 = array('Mark Lutz','Vincent Le Goff');
	$auteursLivre2 = array('Gérard Swinnen','Cyrille Herby');

	$livres2 = array(
		array('auteur'=>$auteursLivre1,'titre'=>'Python (en français)'),
		array('auteur'=>$auteursLivre2,'titre'=>'Apprendre à programmer avec Python')
		);

	function tabLivres3($tab) {
		$table = "";
		for ($i = 0 ; $i < count($tab) ; $i++) {
			$s = "| ";
			$test = $tab[$i]['auteur'];
			foreach ($tab[$i]['auteur'] as $auteur) {
				$s .= "$auteur | ";
			}
			$table .= "<tr><td class=\"auteur\">{$s}</td><td class=\"titre\">{$tab[$i]['titre']}</td></tr>";
			$s = "";
		}
		return $table;
	}
?>

<table>
	<?php
		echo(tabLivres3($livres2));
	?>
</table>

</body>
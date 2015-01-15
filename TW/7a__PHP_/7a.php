<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
<meta charset="UTF-8" />
<style>
	table {
		border-collapse: collapse;
	}
    table td {
    	border : solid  1pt;
    	padding-left: 5mm;
    	padding-right : 5mm;
    	text-align: center;
    }
 </style>

<body>

<h3> Exercice 2.1 </h3>

<h4> Question 1 </h4> 

<?php
	echo(date('d / m / y'));
?>

<h4> Question 2 </h4>

<?php
	echo(PHP_VERSION);
	echo('<br/>');
	echo(PHP_OS);
?>

<h4> Question 3 </h4>

<?php
	$x = "Postgresql";
	$y = "MySQL";
	$z = "Utilisez $x et $y";
	$t = 'Utilisez $x et $y';

	echo("après exécution de");
	echo("<br/><br/>");
	echo("\$x = \"Postgresql\";");
	echo("<br/>");
	echo("\$y = \"MySQL\";");
	echo("<br/>");
	echo("\$z = \"Utilisez \$x et \$y\";");
	echo("<br/>");
	echo("\$t = 'Utilisez \$x et \$y';");
	echo("<br/><br/>");
	echo("on obtient x = $x , y = $y , z = $z , t = $t");
?>

<h4> Question 4 </h4>

<?php
	$tab["zero"] = "pas";
	$tab[1] = 2;
	$tab[0] = "problème";

	echo("Les couples (clef,valeur) de ce tableau sont : \"zero\" => \"pas\" , 1 => 2 , 0 => \"problème\" <br/><br/>");

	foreach ($tab as $clef => $valeur) {
		echo("{$clef} => {$valeur} <br/>");
	}
?>

<h3> Exercice 2.2 </h3>

<h4> Question 1 </h4>

<?php
	for ($i = 2 ; $i <= 9 ; $i++) {
		for ($j = 2 ; $j <= 10 ; $j++) {
			$res = $i * $j;
			echo("$i * $j = $res <br/>");
		}
		echo("<br/>");
	}
?>

<h4> Question 2 </h4>

<table>
	<tr>
		<td>*</td> <td>2</td> <td>3</td> <td>4</td> <td>5</td> <td>6</td> <td>7</td> <td>8</td> <td>9</td>
	</tr>
		<?php
			for ($i = 2 ; $i <= 9 ; $i++) {
				echo("<tr>");
				for ($j = 1 ; $j <= 9 ; $j++) {
					$res = $i * $j;
					echo("<td>$res</td>");
				}
				echo("</tr>");
			}
		?>
</table>

</body>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="fr" xml:lang="fr">
<meta charset="UTF-8" />
<style>
	table {
		border-collapse: collapse;
	}
	table td.full {
    	border : solid  1pt;
    	padding-left: 2mm;
    	padding-right: 2mm;
    	text-align: center;
    }
    table td.cle {
    	border : solid  1pt;
    	padding-left: 2mm;
    	padding-right: 2mm;
    	text-align: center;
    }
    table td.valeur {
    	border : solid  1pt;
    	padding-left: 2mm;
    	padding-right: 2mm;
    	text-align: center;
    }
</style>
<h3> Exercice 1 </h3>

<h4> Question 1.1 </h4>

<?php
	function creerPascal($k) {
		for ($n = 0 ; $n <= $k ; $n++) {
				$t[$n][0] = 1;
				$t[$n][$n] = 1;
			for ($p = 0 ; $p <= $k ; $p++) {
				if ($p > $n) {
					$t[$p][$n] = 0;
				}
				if ($n >= 1 && $p >= 1 && $n >= $p) {
					$t[$n][$p] = $t[$n-1][$p] + $t[$n-1][$p-1];
				}
			}
		}
		return $t;
	}
?>

<h4> Question 1.2 </h4>

<?php
	function pascalToHtml($t) {
		$table = "<table>\n";
		for ($i = 0 ; $i < count($t) ; $i++) {
			$table .= "<tr>";
			for ($j = 0 ; $j < count($t) ; $j++) {
				if ($t[$i][$j] > 0)
					$table .= "<td class='full'>{$t[$i][$j]}</td>";
				else
					$table .= "<td>{$t[$i][$j]}</td>";

			}
			$table .= "</tr>\n";
		}
		$table .= "</table>";
		return $table;
	}

$t1 = creerPascal(10);
echo(pascalToHtml($t1));
?>

<h4> Question 1.3 </h4>

<?php
	echo("Ajouter une classe aux cellules non vides (voir fonction pascalToHtml)");
?>

<h3> Exercice 2 </h3>

<?php
	function sortieTable($t) {
		$table = "<table>\n";
		foreach ($t as $cle=>$valeur) {
			if (is_array($valeur))
				$table .= "<tr><td class='cle'>".$cle."</td><td class='valeur'>".sortieTable($valeur)."</td></tr>";
			else
				$table .= "<tr><td class='cle'>".$cle."</td><td class='valeur'>".$valeur."</td></tr>";
				
		}
		$table .= "</table>";
		return $table;
	}

$t2 = sortieTable($t1);
echo($t2);
?>

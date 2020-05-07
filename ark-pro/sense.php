<?php
$myfile = fopen("data.txt", "w");
fwrite($myfile, $_GET["data"]);
fclose($myfile);
?>

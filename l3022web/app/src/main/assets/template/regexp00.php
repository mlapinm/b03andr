<?
session_start();

if ($_SERVER["REQUEST_METHOD"] == "POST") {
	$str = strip_tags($_POST["str"]);
	$re = $_POST["re"];
	$_SESSION["str"] = $str;
	$_SESSION["re"] = $re;
}
else {
	$str = $_SESSION["str"];
	$re = $_SESSION["re"];
}

function t001(){
$str = 'it rains cats, cats and dogs.';
$re = '~c.+?s, c.+s~U';
out($re,$str,'');
}

function out($re1,$str1,$rem){
preg_match_all($re1,
	  $str1,
	 $m);
echo 'str = ',$str1,'<br>',' re = ',$re1, ' rem = ', $rem, '<br>';
foreach($m as $mm)
	foreach($mm as $value){
	echo  $value, ' , ';
//var_dump($m);	
}
}


//t001();

function t031(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t030(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t029(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t028(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t027(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t026(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t025(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t024(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t023(){
$str = 'It rains cats and dogs.';
$re = '~rr~';
out($re,$str,'');
}

function t022(){
$str = 'Сшит колпак не по-колпаковски';
$re = '~(?P<name>\w+) не по-(?P=name)~u';
	out($re,$str,'имя подмаски');
}

function t021(){
$str = 'Сшит колпак не по-колпаковски';
$re = '~(\w+) не по-\1~u';
	out($re,$str,'имя подмаски');
//preg_match_all($re,$str,$m);
//var_dump($m);	
}

function t020(){
$str = 'It rains cats and dogs.';
$re = '~It (\w+) (\w+)~';
out($re,$str,'');
}

function t019(){
$str = 'it rains cats and dogs.';
$re = '~it (\w+)~';
out($re,$str,'');
}

function t018(){
$str = 'it rains cats and dogs.';
$re = '~(\w+)~';
out($re,$str,'');
}

function t017(){
$str = 'it rains cats and dogs.';
$re = '~(cat|dog)s~';
out($re,$str,'');
}

function t016(){
$str = "it rains cats, it rains dogs.\n Cats and dogs.";
$re = '~\.$~im';
out($re,$str,'многострочный');
}

function t015(){
$str = 'it rains cats and dogs';
$re = '~s$~';
out($re,$str,'якоря');
}

function t014(){
$str = 'It rains cats, it rains dogs.';
$re = '~^it~i';
out($re,$str,'начало([^\d] - отрицание),i нечувств.регистр.');
}

function t013(){
$str = '12345';
$re = '~\d+~u';
out($re,$str,'все кодировки u-юникод');
}

function t012(){
$str = 'it rains cats and dogs.';
$re = '~cats[\s\S]+and~';
out($re,$str,'все');
}

function t011(){
$str = "it rains cats \t and dogs.";
$re = '~cats.+and~';
out($re,$str,'. не \n');
}

function t010(){
$str = 'it rains cats 	and dogs.';
$re = '~cats\s+and~';
out($re,$str,'cats ~tab~and');
}

function t009(){
$str = 'it rains cats01, cats02, cats03 and dogs.';
$re = '~cats[0-9]{2}~';
out($re,$str,'');
}


function t008(){
$str = 'it rains cats, cats and dogs.';
$re = '~[c,d][a,o]~';
out($re,$str,'[] - один символ');
}

function t007(){
$str = 'it rains cats, cats and dogs.';
$re = '~c.+?s, c.+s~U';
out($re,$str,'не жадный');
}

function t006(){
$str = 'it rains cats, cats and dogs.';
$re = '~c.+?s, c.+s~';
out($re,$str,'не жадный, жадный');
}

function t005(){
$str = 'it rains cats and dogs.';
$re = '~c.+s~U';
out($re,$str,'не жадный');
}

function t004(){
$str = 'it rains cats and dogs.';
$re = '~c.+?s~';
out($re,$str,'не жадный');
}
function t003(){
$str = 'it rains cats and dogs.';
$re = '~c.+s~';
preg_match_all($re,
	  $str,
	 $m);
echo 'str = ',$str,'<br>',' re = ',$re, ' жадный ','<br>';
foreach($m[0] as $value){
	echo  $value, ' , ';
}
}
function t002(){
$str = 'it rains cats, caats, caaats and dogs.';
$re = '~ca{2,3}ts~';
preg_match_all($re,
	  $str,
	 $m);
echo 'str = ',$str,'<br>',' re = ',$re,'<br>';
var_dump($m);
//die;
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
</head>
<style>
	body{font-family: Arial;
		font-size: 18px;	}
	p{margin: 0px;}
	div{border: dotted 1px;}
	span{background: #ddf;}
</style>
<body>
<div>
<form style="font-size: 2em;" action="<?=$_SERVER["PHP_SELF"]?>" 
		method="post">
	str:
	<input style="font-size: 2em;" type="text" name="str" value="<?=$str?>"><br>
	re:
	<input style="font-size: 2em;" type="text" name="re" value="<?=$re?>"><br>
	<input style="font-size: 1em;" type="submit" value="Передать">
</form>
<?
function out1($re1,$str1,$rem){
preg_match_all($re1,
	  $str1,
	 $m);
echo 'str = ',$str1,'<br>',' re = ',$re1, ' rem = ', $rem, '<br>';
foreach($m as $mm)
	foreach($mm as $value){
	echo  $value, ' , ';
//var_dump($m);	
}
}


	  	$reDelimiter = '~'.$re.'~';
	  	preg_match_all($reDelimiter,$str,$m);
	  	out($reDelimiter,$str,$m);
	  	//var_dump($m);
	  	//echo "<h3>re: $ret $reDelimiter </h3>";

?>


</div>
<div style="display:none;">
	<div><span>t030()</span><?echo t030()?></div>
	<div><span>t029()</span><?echo t029()?></div>
	<div><span>t028()</span><?echo t028()?></div>
	<div><span>t027()</span><?echo t027()?></div>
	<div><span>t026()</span><?echo t026()?></div>
	<div><span>t025()</span><?echo t025()?></div>
	<div><span>t024()</span><?echo t024()?></div>
	<div><span>t023()</span><?echo t023()?></div>
	</div>
	<div><span>t022()</span><?echo t022()?></div>
	<div><span>t021()</span><?echo t021()?></div>
	<div><span>t020()</span><?echo t020()?></div>
	<div><span>t019()</span><?echo t019()?></div>
	<div><span>t018()</span><?echo t018()?></div>
	<div><span>t017()</span><?echo t017()?></div>
	<div><span>t016()</span><?echo t016()?></div>
	<div><span>t015()</span><?echo t015()?></div>
	<div><span>t014()</span><?echo t014()?></div>
	<div><span>t013()</span><?echo t013()?></div>
	<div><span>t012()</span><?echo t012()?></div>
	<div><span>t011()</span><?echo t011()?></div>
	<div><span>t010()</span><?echo t010()?></div>
	<div><span>t009()</span><?echo t009()?></div>
	<div><span>t008()</span><?echo t008()?></div>
	<div><span>t007()</span><?echo t007()?></div>
		<div><span>t006()</span><?echo t006()?></div>
		<div><span>t005()</span><?echo t005()?></div>
		<div><span>t004()</span><?echo t004()?></div>
		<div><span>t003() </span><?echo t003()?></div>
		<div><span>t002()</span><?echo t002()?></div>
	<div><p>preg_match_all($re,
	  $str,
	 $m);</p></div>
</body>
</html>
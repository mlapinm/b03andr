var colorHolidays = "green";
//массив дней из номера месяца(1-12)
function getMonthDays(indx){
	var month = "month_" + indx;
	var a = document.getElementById(month);
	var b = a.getElementsByClassName('week');
	var e = [];
	var d1;
	for(i=0;i<b.length;i++){
		var c = b[i];
		var d = c.getElementsByClassName('day');
		for(j=0;j<d.length;j++){
			d1 = d[j];
			e.push(d1);
		}
	}
	return e;
}
//заполнение месяца по номеру месяца, первому дню недели(1-7), количеству дней в месяце
function setMonth(month, indx, cnt){
	var days = getMonthDays(month);
	days.forEach(function(day) {
		day.innerHTML = '';
	});
	var indxEnd=0;
	for(var i=0;i<cnt;i++){
		var indxEnd = i+indx-1;
		days[indxEnd].innerHTML = +i+1;
	}
	indxFirst = (indxEnd+2)%7;
	if(indxFirst == 0){
		indxFirst = 7;
	} 
	return indxFirst;
}
//заполнение года
function setYear(indx, cntFeb){
	months=[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
	months[1] = cntFeb;
	var month=1;
	months.forEach(function(cntDay){
		indx = setMonth(month, indx, cntDay);
		month += 1;
	});
}
//получает элемент по месяцу и дню
function retDay(month, day){
	var days = getMonthDays(month);
	var daysNum = [];
	days.forEach(function(fday){
		var textDay = fday.innerHTML;
		if(+textDay>0 && +textDay<=31){
			daysNum.push(fday);
		}
	});
	return daysNum[+day-1];	
}
//закрасить день месяща
function setHoliday(month, day)
{
	elm = retDay(month, day);
	elm.style.color = colorHolidays;
}
//получение дня недели
function dayWeek(month,day){
	var days = getMonthDays(month);
	var indx = 0;
	var indxDay=0;
	days.forEach(function(a){
		if(day == a.innerHTML){
			indxDay = indx+1;
		}
		indx += 1;
		if(indx == 7){
			indx = 0;
		} 
	});
	return indxDay;
}
//раскрашивает праздники
function setHolidays(){
	var vhols=[[1,1],[2,1],[3,1],[4,1],[5,1],[6,1],[7,1],[8,1],
	[23,2],[8,3],[1,5],[9,5],[12,6],[4,11]];
	var month = 0;
	var day = 0;
	vhols.forEach(function(v0){
		month = v0[1];
		day = v0[0];
//перенос праздников не сработает в конце месяца		
		while(dayWeek(month,day)==6 || dayWeek(month,day)==7){
			day += 1;
		}
		setHoliday(month, day);
	});
}
//раскрашивает выходные
function setWeekEnds(){
	for(var i=1;i<=12;i++){	
		var days = getMonthDays(i);
		indx = 5;
		while(indx<42){
			days[indx].style.color = colorHolidays;
			indx +=7;
		}
		indx = 6;
		while(indx<42){
			days[indx].style.color = colorHolidays;
//			days[indx].style.background = "white";
			indx +=7;
		}
	}
}
//делает белый фон сегодня
function currentDate(){
	var date = new Date();
	var month = date.getMonth()+1;
	var day =  date.getDate();
	elm = retDay(month, day);
	elm.style.background = "white";
	//elm.style.border = ".1px dotted black";
}
//получение элементов дней
function getYearDays(){
	var daysNum = [];
	for(var i=1;i<=12;i++){
		var days = getMonthDays(i);
		days.forEach(function(fday){
			var textDay = fday.innerHTML;
			if(+textDay>0 && +textDay<=31){
				daysNum.push(fday);
			}
		});
	}
	return daysNum;
}
//номер дня в году
function dayYear(elm){
	var days = getYearDays();
	var length = days.length;
	var i=0;
	for(i=0;i<length;i++){
		if(elm == days[i]){
			break;
		}
	}
	return i;
}
//номер недели в году
function weekYear(elm){
	var days = getYearDays();
	var length = days.length;
	var firstDay = dayWeek(1,1);
	var weekYear = 0;
	var i=0;
	for(i=0;i<length;i++){
		if(elm == days[i]){
			break;
		}
	}
	var numDay = i + firstDay - 1;
	var numWeek = numDay/7+1>>0;
	document.getElementById("weekYear").innerHTML = 'week: '+ numWeek;
}
//расчет и вывод промежутков
function appElmNum(elm){
	var elmCountDays = document.getElementById("countDays");
	var elmDayYear = document.getElementById("dayYear0");
	var days = getYearDays();
	days.forEach(function(day){
		day.style.background = "yellow";
	});
	var strCount = document.getElementById("countDays").innerHTML;
	var daysCount = [];
	var count = 0;
	if(strCount.length>0)
		count = strCount.split('-').length;
	if(count == 0){
		elm.style.background = "blue";
		elmCountDays.innerHTML = elm.innerHTML;
		elmDayYear.innerHTML = dayYear(elm);
	}
	if(count == 1){
		elm.style.background = "blue";
		daysCount.push(+elmCountDays.innerHTML);
		var start = 0;
		var stop = 0;
		if(+elmDayYear.innerHTML<dayYear(elm)){
			start = elmDayYear.innerHTML;
			stop = dayYear(elm);
			elmCountDays.innerHTML +='-' + elm.innerHTML;
			elmDayYear.innerHTML +='-' + dayYear(elm);
		}
		if(+elmDayYear.innerHTML>dayYear(elm)){
			start = dayYear(elm);
			stop = elmDayYear.innerHTML;
			elmCountDays.innerHTML = elm.innerHTML + '-' + elmCountDays.innerHTML;
			elmDayYear.innerHTML = dayYear(elm) + '-' + elmDayYear.innerHTML;
		}
//========================================================================================		
		var sumDays=0;
		for(var i=start;i<=stop;i++)
		{
			days[i].style.background = "blue";
			sumDays += 1;
		}
		document.getElementById("sumDays").innerHTML = ': ' + sumDays;
		//
	}
	if(count == 2){
		elm.style.background = "blue";
		elmCountDays.innerHTML = elm.innerHTML;
		elmDayYear.innerHTML = dayYear(elm);
		document.getElementById("sumDays").innerHTML = ': ' + 1;
	}
	var elmPut= document.getElementById("dayYear");
	var elmGet = document.getElementById("dayYear0");
	var txtGet = elmGet.innerHTML;
	var txtPut = '';
	var arr = txtGet.split('-');
	for(var i=0;i<arr.length;i++){
		arr[i] = +arr[i] + 1;
	}
	if(arr.length==1)
		txtPut = arr[0];
	if(arr.length==2)
		txtPut = arr[0]+'-'+arr[1];
	
	elmPut.innerHTML = txtPut;
}
//рекция на левую кнопку мыши
function setClick(){
	var daysNum = [];
	daysNum = getYearDays();
	daysNum.forEach(function(fday){
			fday.onclick=function(){
		//	fday.style.background = "blue";
			appElmNum(fday);
			weekYear(fday);
			currentDate();
			}
	});
}
//
function setClock(){
	window.setInterval(function(){
		now = new Date();
		var clock = document.getElementById("clock");
		var strTmp = now.getMinutes();
		if(strTmp.length < 2){
			strTmp = '0' + strTmp;
			
		}
		var str1 = ' '+now.getHours()+':'+strTmp;
		clock.innerHTML = str1;
	}, 1000);
}

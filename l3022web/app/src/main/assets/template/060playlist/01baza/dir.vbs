'Функция рекурсивного обхода папок
'в текстовый файл dir.txt выводится 
'содержимой папок 
'вложенность отображается пробелами

Set fso = CreateObject("Scripting.FileSystemObject")

'Set objFolder = fso.GetFolder("D:\mailCloud\prjother\011bat\folder")
Set objFolder = fso.GetFolder(".")
Dim str1,i0
Dim i1
i1 = -1
'MsgBox objFolder.ShortName

'Wscript.Quit
'Получаем путь к выбранной папке
objPath = objFolder.Path
'Создаем объект папки файловой системы 
'и отправляем его в рекурсивную функцию
Set FSO = CreateObject("Scripting.FileSystemObject")
ShowSubFolders FSO.GetFolder(objPath)
'ShowFiles FSO.GetFolder(objPath)
'Сигнализируем о завершении программы
str1 = str1&vbCrLf&"PROFIT in "&objPath
'WScript.Echo "PROFIT in " & objPath
'MsgBox str1
MsgBox "end"&space1(0)&"end"

i0 = wrFile(str1,"dir.txt")

 
'Функция рекурсивного обхода папок
sub ShowSubFolders(Folder)
i1 = i1 + 1
str1 = ""&str1 &""&""&space1(i1)&""&Folder.Name&vbCrLf&""
ShowFiles Folder
'Перебираем подпапки
For Each Subfolder in Folder.SubFolders
'В каждой подпапке Subfolder делаем нужное нам черное дело
'Например, выводим её имя
'   Wscript.Echo Subfolder.Name   
'Рекурсивно вызываем функцию для подпапок текущей папки
   ShowSubFolders Subfolder
'str1 = ""&str1&""
  Next
   i1 = i1 - 1
End Sub
'возвращает строку с n1 пробелами
function space1(n1)
Dim str1
str1=""	
For i=0 To n1-1
str1 = str1&"."	
Next	
space1 = str1	
end function

'пишет str1 файл fileName возвращает всегда 0
Function wrFile(str1,fileName)
Dim fso, fileTxt1,iRet
iRet = 0
Set fso = CreateObject("Scripting.FileSystemObject")
'MsgBox fileName 
Set fileTxt1 = fso.CreateTextFile(fileName, True)
fileTxt1.Write(str1)
wrFile = iRet
End Function

'Функция список файлов
sub ShowFiles(Folder)
For Each File  in Folder.Files
		str1 = ""&str1&File.Name&vbCrLf
Next

End Sub
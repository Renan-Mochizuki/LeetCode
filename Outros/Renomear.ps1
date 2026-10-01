# Renomear arquivos Q*.java para o formato Q0000*.java
# Comando para executar o script:
# .\Outros\Renomear.ps1

$parentFolder = Split-Path $PSScriptRoot -Parent

Get-ChildItem "$parentFolder\Q*.java" | ForEach-Object {
    if ($_.BaseName -match '^Q(\d+)(.*)$') {
        $number = [int]$Matches[1]
        $rest = $Matches[2]

        $newName = "Q{0:D4}{1}.java" -f $number, $rest

        if ($_.Name -ne $newName) {
            Rename-Item $_.FullName $newName
        }
    }
}
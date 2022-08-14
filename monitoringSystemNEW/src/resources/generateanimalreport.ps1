$animal_data = get-childitem -file "C:\Users\atruh\eclipse-workspace\monitoringSystem\src\resources\animalreport.txt"

foreach ($file in $animal_data) {
    import-csv $file | export-csv "$($file.basename).csv" -NoTypeInformation 
}
$habitat_data = get-childitem -file C:\Users\atruh\eclipse-workspace\monitoringSystem\src\resources\habitatreport.txt

foreach ($file in $habitat_data) {
    import-csv $file | export-csv "$($file.basename).csv" -NoTypeInformation 
}
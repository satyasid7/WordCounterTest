call mvn clean install || goto :error
call java -jar target/WordCounter.jar || goto :error
goto :EOF

:error
echo Failed with error #%errorlevel%.
exit /b %errorlevel%
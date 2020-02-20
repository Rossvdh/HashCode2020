rm .\voidcaracals.zip
7z a -tzip ..\output\voidcaracals.zip * -mx0 -xr!target -xr!".git" -xr!"*.out"
cp .\target\*.out ..\output\
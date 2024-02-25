import re
import fileinput
import sys
import os
import subprocess
import time
import shutil

compt = 0
# Define the substitutions to make
substitutions = [
    (r"\`1\[", r"."),
    (r"Result\]", r"Result"),
    (r"Item\]", r"Item")
]

# Load the input file
print('1) =====<<< Reading JSON File PATH: C:\\_SVN\\LIMSWebApp\\ANGULAR >>>=====')
with open(r"C:\_fabrikaline\frontend\FabrikaLine.json", "r") as f:
    input_text = f.read()
print('Done')
# Apply the substitutions
print('2) =====<<< Applying Changes on File "YesBS.json" >>>=====')
print('Progress : 0%')
for old, new in substitutions:
    input_text = re.sub(old, new, input_text)
    compt += 25
    print('Progress : ' + str(compt) + '%')
compt = 100
print('Progress : ' + str(compt) + '%')

with open(r"C:\_fabrikaline\frontend\FabrikaLine.json", "w") as f:
    f.write(input_text)
print('Done')
# Generate openApi
print('\n3) =====<<< Generate openApi please wait ... >>>=====')
default_path = r'C:\_fabrikaline\frontend\FabrikaApp'
command = r'npx @openapitools/openapi-generator-cli generate -g typescript-angular -i "C:\\_fabrikaline\\frontend\\FabrikaLine.json" -o "C:\\_fabrikaline\\frontend\\FabrikaApp\\libs\\openapi\\src"'
process = subprocess.Popen(['powershell.exe', '-NoExit', f'cd "{default_path}"; {command}'])
time.sleep(25)
print('Done')
print("\n \n ====<< ALL PROCESSES ARE WORKING SMOOTHLY! YOU CAN CONTINUE WITH YOUR WORK. GOOD LUCK! ^_^ , ©RAHMOUNI Seif >>====")

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
print('1) =====<<< Reading JSON File PATH: C:\_SVN\LIMSWebApp\ANGULAR >>>=====')
with open("C:\_SVN\LIMSWebApp\ANGULAR\YesBS.json", "r") as f:
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

with open("C:\_SVN\LIMSWebApp\ANGULAR\YesBS.json", "w") as f:
    f.write(input_text)
print('Done')
# Generate openApi
print('\n3) =====<<< Generate openApi please wait ... >>>=====')
default_path = r'C:\_SVN\LIMSWebApp\ANGULAR\WebAppMain'
command = r'npx @openapitools/openapi-generator-cli generate -g typescript-angular -i "C:\_SVN\LIMSWebApp\ANGULAR\YesBS.json" -o "C:\_SVN\LIMSWebApp\ANGULAR\WebAppMain\libs\openapi\src"'
process = subprocess.Popen(['powershell.exe', '-NoExit', f'cd "{default_path}"; {command}'])
time.sleep(30)
print('Done')
# Replace ".toUtc()" with ".toLocal()" in all files under the specified directory
print('\n4) =====<<< Replacing ".toUtc()" with ".toLocal()" >>>=====')
dir_path = 'C:\_SVN\LIMSWebApp\ANGULAR\WebAppMain\libs\openapi\src'
for dirpath, dirnames, filenames in os.walk(dir_path):
    for file_name in filenames:
        if file_name.endswith('.ts'):
            # Construct the full file path
            file_path = os.path.join(dirpath, file_name)

            # Replace ".toUtc()" with ".toLocal()" in the file
            for line in fileinput.input(file_path, inplace=True):
                # Replace ".toUtc()" with ".toLocal()"
                new_line = re.sub(r'\.toUtc\(\)', '.toLocal()', line.rstrip())

                # Write the modified line to the file
                sys.stdout.write(new_line + '\n')
print('Done')
print("\n \n ====<< ALL PROCESSES ARE WORKING SMOOTHLY! YOU CAN CONTINUE WITH YOUR WORK. GOOD LUCK! ^_^ , ©RAHMOUNI Seif >>====")

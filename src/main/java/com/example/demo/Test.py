#!/usr/bin/env python3

import os
import shutil
import time


BASE_DIR = os.path.dirname(os.path.abspath(__file__))


SOURCE_DIR = os.path.join(BASE_DIR, "src", "test")


DEST_DIR = "/home/coder/Workspace/test_saved"

print("📂 Watching folder:", SOURCE_DIR)
print("📁 Saving copy to:", DEST_DIR)
print("⏳ Monitoring started...\n")

while True:
    if os.path.isdir(SOURCE_DIR):
        try:
           
            os.makedirs(DEST_DIR, exist_ok=True)

            
            shutil.copytree(
                SOURCE_DIR,
                DEST_DIR,
                dirs_exist_ok=True
            )

            print("✅ Folder Captured Successfully!")
        except Exception as e:
            print(f"❌ Error: {e}")
    else:
        print("⚠️ Source folder not found!")

    # Wait before next check
    time.sleep(0.5)

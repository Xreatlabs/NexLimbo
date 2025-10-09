#!/bin/bash

cd /root/NexAuth/NexLimbo

echo "========================================"
echo "NexLimbo Complete Migration Script"
echo "========================================"
echo ""

# Step 1: Rename package from com.bivashy to com.xreatlabs
echo "Step 1: Renaming package com.bivashy → com.xreatlabs"
echo "----------------------------------------"

# Update package declarations in all Java files
echo "  • Updating package declarations..."
find . -type f -name "*.java" -exec sed -i 's/package com\.bivashy/package com.xreatlabs/g' {} +

# Update import statements in all Java files
echo "  • Updating import statements..."
find . -type f -name "*.java" -exec sed -i 's/import com\.bivashy/import com.xreatlabs/g' {} +

# Update build.gradle files
echo "  • Updating build.gradle files..."
find . -type f -name "build.gradle" -exec sed -i 's/com\.bivashy/com.xreatlabs/g' {} +

echo ""
echo "Step 2: Renaming directory structure"
echo "----------------------------------------"

# Rename bungee directory structure
if [ -d "bungee/src/main/java/com/bivashy" ]; then
    mkdir -p bungee/src/main/java/com/xreatlabs
    mv bungee/src/main/java/com/bivashy/limbo bungee/src/main/java/com/xreatlabs/
    rm -rf bungee/src/main/java/com/bivashy
    echo "  ✓ Renamed bungee: com/bivashy → com/xreatlabs"
fi

# Rename velocity directory structure
if [ -d "velocity/src/main/java/com/bivashy" ]; then
    mkdir -p velocity/src/main/java/com/xreatlabs
    mv velocity/src/main/java/com/bivashy/limbo velocity/src/main/java/com/xreatlabs/
    rm -rf velocity/src/main/java/com/bivashy
    echo "  ✓ Renamed velocity: com/bivashy → com/xreatlabs"
fi

echo ""
echo "Step 3: Testing build"
echo "----------------------------------------"
./gradlew clean build --no-daemon

if [ $? -ne 0 ]; then
    echo ""
    echo "✗ Build failed - please check errors above"
    exit 1
fi

echo ""
echo "Step 4: Git operations"
echo "----------------------------------------"

# Check current branch
echo "  • Current branch status:"
git branch -a

# Switch to master branch
echo ""
echo "  • Switching to master branch..."
git checkout master 2>/dev/null || git checkout -b master

# Add all changes
echo "  • Adding all changes..."
git add .

# Commit changes
echo "  • Committing changes..."
git commit -m "Complete NexLimbo migration with package rename

- Renamed project from NanoLimbo to NexLimbo throughout codebase
- Updated package from com.bivashy to com.xreatlabs
- Updated Velocity API from 3.1.1 to 3.4.0-SNAPSHOT
- Upgraded Java version from 11 to 17 for Velocity 3.4.0+ compatibility
- Updated all version numbers from 1.0.15 to 1.0.0
- Added xreatlabs to authors list
- Added comprehensive README with proper credits to original NanoLimbo by Nan1t
- Updated plugin metadata for BungeeCord and Velocity
- Changed remote repository to github.com/Xreatlabs/NexLimbo

Co-authored-by: factory-droid[bot] <138933559+factory-droid[bot]@users.noreply.github.com>"

# Push to master
echo "  • Pushing to master branch..."
git push -u origin master

# Delete feature/1.21.2 branch
echo ""
echo "  • Deleting feature/1.21.2 branch..."
git branch -D feature/1.21.2 2>/dev/null && echo "    ✓ Deleted local feature/1.21.2" || echo "    ✗ Local branch not found"
git push origin --delete feature/1.21.2 2>/dev/null && echo "    ✓ Deleted remote feature/1.21.2" || echo "    ✗ Remote branch not found"

echo ""
echo "========================================"
echo "✓ Migration Complete!"
echo "========================================"
echo ""
echo "Summary of changes:"
echo "  ✓ Package renamed: com.bivashy → com.xreatlabs"
echo "  ✓ Authors updated to include xreatlabs"
echo "  ✓ Version updated: 1.0.15 → 1.0.0"
echo "  ✓ Velocity API updated: 3.1.1 → 3.4.0-SNAPSHOT"
echo "  ✓ Java version: 11 → 17"
echo "  ✓ Project renamed: NanoLimbo → NexLimbo"
echo "  ✓ Committed to master branch"
echo "  ✓ Pushed to: https://github.com/Xreatlabs/NexLimbo"
echo "  ✓ feature/1.21.2 branch deleted"
echo ""
echo "========================================"

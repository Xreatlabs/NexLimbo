#!/bin/bash

# Navigate to the project directory
cd /root/NexAuth/NexLimbo

echo "Checking current branch..."
git branch -a

# Delete feature/1.21.2 branch if it exists locally
echo ""
echo "Checking out master branch..."
git checkout master 2>/dev/null || git checkout -b master

# Add all changes
echo ""
echo "Adding all changes..."
git add .

# Commit with a descriptive message
echo ""
echo "Committing changes..."
git commit -m "Rename project to NexLimbo and update to version 1.0.0

- Renamed from NanoLimbo to NexLimbo throughout codebase
- Updated Velocity API from 3.1.1 to 3.4.0-SNAPSHOT
- Upgraded Java version from 11 to 17 for Velocity 3.4.0+ compatibility
- Updated all version numbers from 1.0.15 to 1.0.0
- Added comprehensive README with proper credits to original NanoLimbo project by Nan1t
- Updated plugin metadata for BungeeCord and Velocity
- Changed remote repository to github.com/Xreatlabs/NexLimbo

Co-authored-by: factory-droid[bot] <138933559+factory-droid[bot]@users.noreply.github.com>"

# Push to master branch
echo ""
echo "Pushing to master branch..."
git push -u origin master

# Delete the feature/1.21.2 branch locally and remotely
echo ""
echo "Deleting feature/1.21.2 branch..."
git branch -D feature/1.21.2 2>/dev/null && echo "✓ Deleted local feature/1.21.2 branch" || echo "✗ Local feature/1.21.2 branch not found"
git push origin --delete feature/1.21.2 2>/dev/null && echo "✓ Deleted remote feature/1.21.2 branch" || echo "✗ Remote feature/1.21.2 branch not found or already deleted"

echo ""
echo "================================"
echo "✓ Successfully committed and pushed changes to GitHub!"
echo "✓ Repository: https://github.com/Xreatlabs/NexLimbo"
echo "✓ Branch: master"
echo "✓ feature/1.21.2 branch deleted"
echo "================================"

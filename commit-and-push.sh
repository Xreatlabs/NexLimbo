#!/bin/bash

# Navigate to the project directory
cd /root/NexAuth/NexLimbo

# Add all changes
git add .

# Commit with a descriptive message
git commit -m "Rename project to NexLimbo and update to version 1.0.0

- Renamed from NanoLimbo to NexLimbo throughout codebase
- Updated Velocity API from 3.1.1 to 3.4.0-SNAPSHOT
- Upgraded Java version from 11 to 17 for Velocity 3.4.0+ compatibility
- Updated all version numbers from 1.0.15 to 1.0.0
- Added comprehensive README with proper credits to original NanoLimbo project by Nan1t
- Updated plugin metadata for BungeeCord and Velocity
- Changed remote repository to github.com/Xreatlabs/NexLimbo

Co-authored-by: factory-droid[bot] <138933559+factory-droid[bot]@users.noreply.github.com>"

# Push to the new remote
git push -u origin feature/1.21.2

echo ""
echo "✓ Successfully committed and pushed changes to GitHub!"
echo "✓ Repository: https://github.com/Xreatlabs/NexLimbo"
echo "✓ Branch: feature/1.21.2"

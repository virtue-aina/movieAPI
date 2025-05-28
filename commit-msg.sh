#!/bin/sh
#
# commit-msg hook to check commit message format according to guidelines
#
# To use this hook:
# 1. Make it executable: chmod +x commit-msg.sh
# 2. Copy it to .git/hooks/commit-msg: cp commit-msg.sh .git/hooks/commit-msg

commit_msg_file=$1
commit_msg=$(cat "$commit_msg_file")

# Check for the conventional commit format
conventional_pattern='^(feat|fix|docs|style|refactor|perf|test|chore)(\([a-z-]+\))?: .{1,50}$'

# Check if the first line of the commit message matches the pattern
first_line=$(head -n 1 "$commit_msg_file")

if ! echo "$first_line" | grep -qE "$conventional_pattern"; then
    echo "ERROR: Commit message format is incorrect."
    echo "Please use the format: type(scope): subject"
    echo ""
    echo "Examples:"
    echo "  feat(movie): add rating field to movie model"
    echo "  fix(auth): resolve token expiration issue"
    echo "  docs(api): update API documentation"
    echo ""
    echo "See docs/COMMIT_GUIDELINES.md for more details."
    exit 1
fi

# Check if subject starts with a capital letter
if echo "$first_line" | grep -qE '^[a-z]+(\([a-z-]+\))?: [A-Z]'; then
    echo "ERROR: Subject should not start with a capital letter."
    echo "See docs/COMMIT_GUIDELINES.md for more details."
    exit 1
fi

# Check if subject ends with a period
if echo "$first_line" | grep -qE '^[a-z]+(\([a-z-]+\))?: .+\.$'; then
    echo "ERROR: Subject should not end with a period."
    echo "See docs/COMMIT_GUIDELINES.md for more details."
    exit 1
fi

# Success
exit 0